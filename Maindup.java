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

public class Maindup extends Application {
	Stage window;
	Button button;
	Label label;
	Scene scene1 , scene2, scene3, scene4,scene5;
	boolean isCorrect;	
	TableView<Flight> table;
	TextField flightIdInput,dateInput,originPrefixInput, originCityInput,destinationPrefixInput,
	destinationCityInput, timeInInput, timeOutInput;
	
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage window) throws Exception {
		
		window.setTitle("QuickFlight");
		
		//pane 1
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10,10,10,10));
		grid.setHgap(8);
		grid.setVgap(10);
		
		
		//pane2
		GridPane grid1 = new GridPane();
		grid1.setPadding(new Insets(10,10,10,10));
		grid1.setHgap(8);
		grid1.setVgap(10);
		
		//pane3
		GridPane grid2 = new GridPane();
		grid2.setPadding(new Insets(10,10,10,10));
		grid2.setHgap(8);
		grid2.setVgap(10);
		grid2.setAlignment(Pos.CENTER);
		
		
		
		//label username
		Label username = new Label("Username");
		grid.setConstraints(username, 0, 0);
		//textField
		TextField name = new TextField();
		name.setPromptText("username");
		grid.setConstraints(name, 1, 0);
		
		//label password
		Label password = new Label("password");
		grid.setConstraints(password, 0, 1);
		
		TextField p = new TextField();
		p.setPromptText("password");
		grid.setConstraints(p, 1, 1);
		grid.setAlignment(Pos.CENTER);
		
		//label firstname
		Label fName = new Label("First Name:");
		grid1.setConstraints(fName, 0, 0);
		//textField firstname
		TextField first = new TextField();
		grid1.setConstraints(first, 1, 0);
		
		//label lastname
		Label lName = new Label("Last Name:");
		grid1.setConstraints(lName, 3, 0);
		//textField lastname
		TextField last = new TextField();
		grid1.setConstraints(last, 4, 0);
		grid1.setAlignment(Pos.CENTER);
		
		//label Address
		Label address = new Label("Address:");
		grid1.setConstraints(address, 0, 1);
		//textField firstname
		TextField address1 = new TextField();
		grid1.setConstraints(address1, 1, 1);
		
		//label Address
		Label zipcode = new Label("ZipCode:");
		grid1.setConstraints(zipcode, 0, 3);
		//textField firstname
		TextField zipcode1 = new TextField();
		grid1.setConstraints(zipcode1, 1, 3);
		
		//label zipcode
		Label state = new Label("State:");
		grid1.setConstraints(state, 3, 1);
		//textField zipcode
		TextField state1 = new TextField();
		grid1.setConstraints(state1, 4, 1);
		
        //label ssn
		Label ssn = new Label("SSN:");
		grid1.setConstraints(ssn, 3, 3);
		//textField ssn
		TextField ssn1 = new TextField();
		grid1.setConstraints(ssn1, 4, 3);
		
		
		//label Question
		Label question = new Label("Question:");
		grid1.setConstraints(question, 0, 4);
		//textField Question
		TextField question1 = new TextField();
		grid1.setConstraints(question1, 1, 4);
		
		//label Answer
		Label answer = new Label("Answer:");
		grid1.setConstraints(answer, 3, 4);
		//textField answer
		TextField answer1 = new TextField();
		grid1.setConstraints(answer1, 4, 4);
		
		//label username
		Label Lusername = new Label("Username:");
		grid1.setConstraints(Lusername, 0, 5);
		//textField username
		TextField Tusername = new TextField();
		grid1.setConstraints(Tusername, 1, 5);
		
		////label password
		Label Lpassword = new Label("Password:");
		grid1.setConstraints(Lpassword, 3, 5);
		//textField password
		TextField Tpassword = new TextField();
		grid1.setConstraints(Tpassword, 4, 5);
		
		//Button login
		Button logInbutton = new Button("Log In");
		grid.setConstraints(logInbutton, 1, 2);
		
		// Button sign up
		Button signupbutton =new Button("Sign Up");
		grid.setConstraints(signupbutton, 1, 3);
		
		//button register
		Button cancelbutton = new Button("Main Menu");
		grid1.setConstraints(cancelbutton, 0, 6);
		
		Button donebutton = new Button("Submit");
		grid1.setConstraints(donebutton, 1, 6);
		
		//after login button click bookflight
		Button bookflight = new Button("Book Flight");
		grid2.setConstraints(bookflight, 0, 0);
		
		//available flights
		Button availableflights = new Button("All Available Flights");
		grid2.setConstraints(availableflights, 0, 1);
		
		//manage trips
		Button managetrip = new Button("Manage Trip");
		grid2.setConstraints(managetrip, 0, 2);
		
		//logout
		Button logout = new Button("Log Out");
		grid2.setConstraints(logout, 0, 3);
		
		////add Button
		Button addButton= new Button("Add");
		addButton.setOnAction(e -> addbuttonClicked());
		
		//delete button
		Button deleteButton = new Button("Delete");
		deleteButton.setOnAction(e ->deleteClicked());
		
		
		//Creating table
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

		
		
		//HBox
		HBox hbox = new HBox();
		hbox.setPadding(new Insets(5,5,5,5));
		hbox.setSpacing(1);
		hbox.getChildren().addAll(flightIdInput,dateInput,originPrefixInput, originCityInput,destinationPrefixInput,
				destinationCityInput, timeInInput, timeOutInput,addButton , deleteButton ,cancelbutton );
		
		
		table = new TableView<>();
		table.setItems(Methods.getFlight());
		table.getColumns().addAll(flightIdColumn,dateColumn,originCityPrefix, originCityColumn, destinationPrefix,
				destinationCityColumn,timeInColumn, timeOutColumn);
		
		//available flight 
		VBox layout1 = new VBox(10);
		layout1.getChildren().addAll(table);
		
		//book a flight
		VBox layout2 = new VBox(10);
		layout2.getChildren().addAll(table, hbox);
		
		
		
		
		//sign up button clicked
		signupbutton.setOnAction(e -> window.setScene(scene2));
		//cancel button clicked
		cancelbutton.setOnAction(e -> window.setScene(scene1));
		
		//login button click
		logInbutton.setOnAction(e -> {
			try {
				isCorrect = Methods.loginChecker(name.getText(), p.getText());
				Methods.loginVerified(isCorrect);
				window.setScene(scene3);
			} catch (Exception e1) {
				Methods.popup("Error", "Invalid Username/Password");
			}			
	});
		//logout button click
		logout.setOnAction(e -> window.setScene(scene1));
		
		//book flight button clicked
		bookflight.setOnAction(e -> window.setScene(scene5));
		
		//availableflights flight clicked
		availableflights.setOnAction(e -> window.setScene(scene4));
		
		
		//set grid
		grid.getChildren().addAll(username, name, password, p , logInbutton, signupbutton );
		//set grid2
		grid1.getChildren().addAll(fName, first, lName, last, address, address1, zipcode,zipcode1,state, state1,ssn, 
				ssn1, question, question1, answer, answer1, Lusername, Tusername,Lpassword, Tpassword,cancelbutton,donebutton);

		grid2.getChildren().addAll(bookflight, availableflights,managetrip, logout);
	
		//Scene1
		 scene1 = new Scene(grid, 550, 500);
		 scene1.getStylesheets().add("Viper.css");
		
		//Scene2
		 scene2 = new Scene(grid1, 550, 500);
		 scene2.getStylesheets().add("Viper.css");
		 
		 //scene3
		 scene3 = new Scene(grid2, 550, 500);
		 scene3.getStylesheets().add("Viper.css");
		 
		 //scene4 avilable flight
		 
		 scene4 = new Scene(layout1);
		 
		 
		 //scene5 book a flight
		 scene5 = new Scene(layout2);
		 

		 

		 //window setup
		 window.setScene(scene1);
		 window.show();
	}
	
	private void deleteClicked() {
		ObservableList<Flight> flightSelected, allflight;
		allflight = table.getItems();
		flightSelected = table.getSelectionModel().getSelectedItems();
		
		flightSelected.forEach(allflight::remove);
		
		}

	public void addbuttonClicked() {
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
