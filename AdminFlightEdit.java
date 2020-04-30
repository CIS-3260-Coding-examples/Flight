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
	TableColumn< Flight, String> destinationCityColumn = new TableColumn<>("Destinantion");
	destinationCityColumn.setMinWidth(200);
	destinationCityColumn.setCellValueFactory(new PropertyValueFactory<>("destinantionCity"));
	
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
	deleteButton.setOnAction(e ->deleteClicked());

	
	
	//HBox
	HBox hbox = new HBox();
	hbox.setPadding(new Insets(5,5,5,5));
	hbox.setSpacing(1);
	hbox.getChildren().addAll(flightIdInput,dateInput, originCityInput,
			destinationCityInput, timeInInput, timeOutInput,addButton , deleteButton );
	
	
	table = new TableView<>();
	table.setItems(CustomerBookAFLight.getFlight());
	table.getColumns().addAll(flightIdColumn,dateColumn, originCityColumn, destinationCityColumn,timeInColumn, timeOutColumn);
	
	
	//book a flight
	VBox layout = new VBox(10);
	layout.getChildren().addAll(table, hbox);
			
	scene = new Scene(layout);
	window.setScene(scene);
	window.show();
}



private static void deleteClicked() {
	ObservableList<Flight> flightSelected, allflight;
	allflight = table.getItems();
	flightSelected = table.getSelectionModel().getSelectedItems();
	
	flightSelected.forEach(allflight::remove);
	
	}

public static void addbuttonClicked() throws Exception {
	Flight flight = new Flight();
	String date = dateInput.getText();
	String origincity = originCityInput.getText();
	String descity = destinationCityInput.getText();
	String timein = timeInInput.getText();
	String timeout = timeOutInput.getText();
	
	AdminFlightEdit.makeaflight(date,origincity,descity,timein,timeout);
	AdminFlightEdit.inputregister();
	
	
	/*String tempanswer = answer1.getText();
	while(set.next()) {
		flight.setFlightId(set.getInt("ID_flight"));
		flight.setDateCreated(set.getString("date"));
		flight.setCityName(set.getString("city_name"));
		flight.setDestinantionCity(set.getString("destination_city"));
		flight.setTimeIn(set.getString("arrival_time"));
		flight.setTimeOut(set.getString("departure_time"));
		
		list.add(flight);
	
	AdminFlightEdit.registerflight();*/
	
	flight.setFlightId(Integer.parseInt(flightIdInput.getText()));
	flight.setDateCreated(dateInput.getText());
	flight.setCityName(originCityInput.getText());
	flight.setDestinantionCity(destinationCityInput.getText());
	flight.setTimeIn(timeInInput.getText());
	flight.setTimeOut(timeOutInput.getText());
	table.getItems().add(flight);
	flightIdInput.clear();
	dateInput.clear();
	originCityInput.clear();
	destinationCityInput.clear();
	timeInInput.clear();
	timeOutInput.clear();
}
public static void registerflight(int flightIdnput, String dateinput, String origincitynput, String destinationitynput, String timeininput, String timeiutinput  ) throws Exception {
		try {
	Connection con = DatabaseMethods.getConnection();

PreparedStatement statement= con.prepareStatement("INSERT INTO Flight(ID_flight, date, city_name, destination_city, arrival_time,departure_time) Values "
		+ "('" + flightIdnput + "', '" + dateinput + "', '" + origincitynput + "', '" + destinationitynput + "', '" + timeininput + "', '" + timeiutinput + "');");
    statement.executeUpdate();
}
catch(Exception e) {
	System.out.println(e);}

}
//making account
	public static void makeaflight(String date, String city, String descity, String timein, String timeout) {
	flight = new Flight(date, city, descity, timein, timeout); 
	}
	public static void inputregister() throws NumberFormatException, Exception {
		AdminFlightEdit.registerflight(DatabaseMethods.idMaker(), flight.getDateCreated(), flight.getCityName(), flight.getDestinantionCity(), flight.getTimeIn() , flight.getTimeOut());
	}

}
