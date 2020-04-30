package GUI;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Classes.Flight;
import DataBase.DatabaseMethods;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.geometry.*;

public class CustomerBookAFLight{
	static Stage window = new Stage();
	static Scene scene1,scene2;
	static TableView<Flight> table;
	private static ObservableList<Flight> list;

	

	public static void bookflight() {
	window.setTitle("Book a flight");
	
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

	
   //add Button
	Button addButton= new Button("Add");
	addButton.setOnAction(e -> {
		
	});
	
	//Check your flight
	Button checkButton = new Button("Check Your Flight");
	checkButton.setOnAction(e ->{
		window.close();
		CustomerAddedFlight.bookflight();
	});
	
	//Main menu button
	Button mainmenu = new Button("MainMenu");
	mainmenu.setOnAction(e ->{
		try {
			MainMenuC.menuScreen();
			window.close();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	});

	
	
	//HBox
	HBox hbox = new HBox();
	hbox.setPadding(new Insets(5,5,5,5));
	hbox.setSpacing(1);
	hbox.getChildren().addAll(addButton , checkButton,mainmenu );
	
	//table 1
	table = new TableView<>();
	try {
		table.setItems(getFlight());
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	table.getColumns().addAll(flightIdColumn,dateColumn, originCityColumn, destinationCityColumn,timeInColumn, timeOutColumn);
	

	//book a flight
	VBox layout = new VBox(10);
	layout.getChildren().addAll(table, hbox);
			
	scene1 = new Scene(layout);
	
	window.setScene(scene1);
	window.show();
}


//table1
public static ObservableList<Flight> getFlight() throws Exception{
	Flight tempflight = new Flight();

	ObservableList<Flight> list = FXCollections.observableArrayList();
	
	String query = "SELECT * FROM Flight";
	
	Connection con = DatabaseMethods.getConnection();

	ResultSet  set= con.createStatement().executeQuery(query);
	
	while(set.next()) {
		for (int i =0; i<DatabaseMethods.pullflight().size(); i++) {
		tempflight.setFlightId(set.getInt(DatabaseMethods.pullflight().get(i)));}
		
		list.add(tempflight);
		
	}
	return list;

}



}
