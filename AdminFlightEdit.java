package GUI;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.sql.Connection;	
import java.sql.PreparedStatement;

import Classes.Account;
import Classes.Flight;
import DataBase.DatabaseMethods;
import DataBase.Methods;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.*;

public class AdminFlightEdit {
	static Stage window = new Stage();
	static Scene scene;
	static Flight flight;
	static TableView<Flight> table;
	static TextField flightIdInput,dateInput, originCityInput,
	destinationCityInput, timeInInput, timeOutInput;
	
	public static void myFlightA() throws Exception {

	window.setTitle("");
	
	 ////Creating table
	//flight Id column
	TableColumn< Flight, Integer> flightIdColumn = new TableColumn<>("Flight Id");
	flightIdColumn.setMinWidth(200);
	flightIdColumn.setCellValueFactory(new PropertyValueFactory<>("flightId"));
	
	
	////Date column
	TableColumn< Flight, String> dateColumn = new TableColumn<>("Date");
	dateColumn.setMinWidth(200);
	dateColumn.setCellValueFactory(new PropertyValueFactory<>("dateCreated"));
	

	
	//origin city column
	TableColumn< Flight, String> originCityColumn = new TableColumn<>("City Name");
	originCityColumn.setMinWidth(200);
	originCityColumn.setCellValueFactory(new PropertyValueFactory<>("cityName"));
	
	
	//Destinantion city column
	TableColumn< Flight, String> destinationCityColumn = new TableColumn<>("Destination");
	destinationCityColumn.setMinWidth(200);
	destinationCityColumn.setCellValueFactory(new PropertyValueFactory<>("destinationCity"));
	
    //limit column
	TableColumn< Flight, String> timeInColumn = new TableColumn<>("Time In");
	timeInColumn.setMinWidth(150);
	timeInColumn.setCellValueFactory(new PropertyValueFactory<>("timeIn"));
	
	//paasenger column
	TableColumn< Flight, String> timeOutColumn = new TableColumn<>("Time Out");
	timeOutColumn.setMinWidth(150);
	timeOutColumn.setCellValueFactory(new PropertyValueFactory<>("timeOut"));
	
	//flightid input 
	flightIdInput = new TextField();
	flightIdInput.setPromptText("flightId");
	flightIdInput.setMinWidth(15);
	
	
	////date input 
	dateInput = new TextField();
	dateInput.setPromptText("date");
	dateInput.setMinWidth(15);


	
	//origin city  input 
	originCityInput = new TextField();
	originCityInput.setPromptText("city name");
	originCityInput.setMinWidth(15);


	
	//destination city input 
	destinationCityInput = new TextField();
	destinationCityInput.setPromptText("dest city");
	destinationCityInput.setMinWidth(15);

	
	//limit input 
	timeInInput = new TextField();
	timeInInput.setPromptText("time in");
	timeInInput.setMinWidth(15);

	
	//passanger input 
	timeOutInput = new TextField();
	timeOutInput.setPromptText("time out");
	timeOutInput.setMinWidth(15);
	
   //add Button
	Button addButton= new Button("Add");
	addButton.setOnAction(e -> {
		try {
			addbuttonClicked();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	});
	
	//delete button
	Button deleteButton = new Button("Delete");
	deleteButton.setOnAction(e ->{
		try {
			deleteClicked();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	});

	
	
	//HBox
	HBox hbox = new HBox();
	hbox.setPadding(new Insets(5,5,5,5));
	hbox.setSpacing(1);
	hbox.getChildren().addAll(flightIdInput,dateInput, originCityInput,
			destinationCityInput, timeInInput, timeOutInput,addButton , deleteButton );
	
	
	table = new TableView<>();
	table.setItems(CustomerBookAFlight.getFlight());
	table.getColumns().addAll(flightIdColumn,dateColumn, originCityColumn, destinationCityColumn,timeInColumn, timeOutColumn);
	
	
	//book a flight
	VBox layout = new VBox(10);
	layout.getChildren().addAll(table, hbox);
			
	scene = new Scene(layout);
	window.setScene(scene);
	window.show();
}



private static void deleteClicked() throws Exception {
	ObservableList<Flight> flightSelected, allflight;
	allflight = table.getItems();
	flightSelected = table.getSelectionModel().getSelectedItems();
	
	if (flightSelected.isEmpty()) {
		Methods.popup("ERROR", "WRONG INFO");

	}
	else {
	Flight flight = table.getSelectionModel().getSelectedItem();
	int id =Integer.parseInt(flight.getFlightId());
	String date =flight.getDateCreated();
	String origin =flight.getCityName();
	String des =flight.getDestinationCity();
	String timein =flight.getTimeIn();
	String timeout =flight.getTimeOut();
	
	DatabaseMethods.deleteCustomerFlight(Integer.toString(Integer.parseInt(flight.getFlightId())));
	DatabaseMethods.removeid(id);
	DatabaseMethods.removefdate(date);
	DatabaseMethods.removefiorigincity(origin);
	DatabaseMethods.removedes(des);
	DatabaseMethods.removetimein(timein);
	DatabaseMethods.removetimeout(timeout);
	DatabaseMethods.removeflight(id, date, origin, des, timein, timeout);
	flightSelected.forEach(allflight::remove);}
	
	}

public static void addbuttonClicked() throws Exception {
	Flight flight = new Flight();
	String id = flightIdInput.getText();
	String date = dateInput.getText();
	String origincity = originCityInput.getText();
	String descity = destinationCityInput.getText();
	String timein = timeInInput.getText();
	String timeout = timeOutInput.getText();
	
	if((id.length() == 0 || date.length() == 0 || origincity.length() ==0 || descity.length() == 0||
			timein.length() ==0 || timeout.length() == 0)){
		Methods.popup("ERROR", "WRONG INFO");
	}
	else {
	table.getItems().add(flight);
	DatabaseMethods.makeFlight(id, date, origincity, descity, timein, timeout);
	DatabaseMethods.inputflightregister();
	flightIdInput.clear();
	dateInput.clear();
	originCityInput.clear();
	destinationCityInput.clear();
	timeInInput.clear();
	timeOutInput.clear();}
	
}

/*public static int makeint(int i) {
	Flight flight = table.getSelectionModel().getSelectedItem();
	i =Integer.parseInt(flight.getFlightId());
	try {
		
		Connection con = DatabaseMethods.getConnection();
		PreparedStatement statement= con.prepareStatement("SELECT ID_flight FROM Flight WHERE ID_flight = '" + i + "'");
			statement.executeQuery();
			}
	
				catch(Exception e) {
			System.out.println(e);}
	
	return i;
}*/

}
