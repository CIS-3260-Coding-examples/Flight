package application;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.*;
public class MyFlightC {
	
	static Scene scene;
	static TableView<Flight> table;
	static TextField flightIdInput,dateInput,originPrefixInput, originCityInput,destinationPrefixInput,
	destinationCityInput, timeInInput, timeOutInput;

@SuppressWarnings("unchecked")
public static Scene flightScreen() {
	//flight Id column
	TableColumn< Flight, Integer> flightIdColumn = new TableColumn("Flight Id");
	flightIdColumn.setMinWidth(200);
	flightIdColumn.setCellValueFactory(new PropertyValueFactory<>("flightId"));
	
	
	////Date column
	TableColumn< Flight, String> dateColumn = new TableColumn("Date");
	dateColumn.setMinWidth(200);
	dateColumn.setCellValueFactory(new PropertyValueFactory<>("dateCreated"));
	
	//origin prefix column
			TableColumn< Flight, String> originCityPrefix = new TableColumn("City Prefix");
			originCityPrefix.setMinWidth(150);
			originCityPrefix.setCellValueFactory(new PropertyValueFactory<>("cityPrefix"));
			
			//origin city column
			TableColumn< Flight, String> originCityColumn = new TableColumn("City Name");
			originCityColumn.setMinWidth(200);
			originCityColumn.setCellValueFactory(new PropertyValueFactory<>("cityName"));
			
			////Destinantion prefix column
			TableColumn< Flight, String> destinationPrefix = new TableColumn("Destinantion");
			destinationPrefix.setMinWidth(150);
			destinationPrefix.setCellValueFactory(new PropertyValueFactory<>("destinantionPrefix"));
			
			//Destinantion city column
			TableColumn< Flight, String> destinationCityColumn = new TableColumn("Destinantion");
			destinationCityColumn.setMinWidth(200);
			destinationCityColumn.setCellValueFactory(new PropertyValueFactory<>("destinantionCity"));
			
	        //limit column
			TableColumn< Flight, String> timeInColumn = new TableColumn("Time In");
			timeInColumn.setMinWidth(150);
			timeInColumn.setCellValueFactory(new PropertyValueFactory<>("timeIn"));
			
			//paasenger column
			TableColumn< Flight, String> timeOutColumn = new TableColumn("Time Out");
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

			
			////origin prefix  input 
			originPrefixInput = new TextField();
			originPrefixInput.setPromptText("city pre");
			originPrefixInput.setMinWidth(15);

			
			//origin city  input 
			originCityInput = new TextField();
			originCityInput.setPromptText("city name");
			originCityInput.setMinWidth(15);

					
			////destination prefix input 
			destinationPrefixInput = new TextField();
			destinationPrefixInput.setPromptText("dest pre");
			destinationPrefixInput.setMinWidth(15);

			
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
			////add Button
			
			Button addButton= new Button("Add");
			addButton.setOnAction(e -> addbuttonClicked());
			
			//delete button
			Button deleteButton = new Button("Delete");
			deleteButton.setOnAction(e -> deleteClicked());
		
			table = new TableView<>();
			table.setItems(Methods.getFlight());
			table.getColumns().addAll(flightIdColumn,dateColumn,originCityPrefix, originCityColumn, destinationPrefix,
					destinationCityColumn,timeInColumn, timeOutColumn);
			
			//available flight 
			VBox layout1 = new VBox(10);
			layout1.getChildren().addAll(table);
			
			scene = new Scene(layout1);
			return scene;
}


private static void deleteClicked() {
	ObservableList<Flight> flightSelected, allflight;
	allflight = table.getItems();
	flightSelected = table.getSelectionModel().getSelectedItems();
	
	flightSelected.forEach(allflight::remove);
	}

public static void addbuttonClicked() {
	Flight flight = new Flight();
	flight.setFlightId(Integer.parseInt(flightIdInput.getText()));
	flight.setDateCreated(dateInput.getText());
	flight.setCityPrefix(originPrefixInput.getText());
	flight.setCityName(originCityInput.getText());
	flight.setDestinantionPrefix(destinationPrefixInput.getText());
	flight.setDestinantionCity(destinationCityInput.getText());
	flight.setTimeIn(timeInInput.getText());
	flight.setTimeOut(timeOutInput.getText());
	table.getItems().add(flight);
	flightIdInput.clear();
	dateInput.clear();
	originPrefixInput.clear();
	originCityInput.clear();
	destinationPrefixInput.clear();
	destinationCityInput.clear();
	timeInInput.clear();
	timeOutInput.clear();
}
}
