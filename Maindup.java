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
	Scene scene1 , scene2, scene3;
	boolean isCorrect;
	
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
		

		
		
		
		
		//sign up button clicked
		signupbutton.setOnAction(e -> window.setScene(scene2));
		//cancel button clicked
		cancelbutton.setOnAction(e -> window.setScene(scene1));
		
		//login button click
		logInbutton.setOnAction(e -> {
			try {
				isCorrect = DatabaseMethods.loginChecker(name.getText(), p.getText());
				loginVerified(isCorrect);
				window.setScene(scene3);
			} catch (Exception e1) {
				popup("Error", "Invalid Username/Password");
			}			
	});
		//logout button click
		logout.setOnAction(e -> window.setScene(scene1));
		
		//set grid
		grid.getChildren().addAll(username, name, password, p , logInbutton, signupbutton );
		//set grid2
		grid1.getChildren().addAll(fName, first, lName, last, address, address1, zipcode,zipcode1,state, state1,ssn, 
				ssn1, question, question1, answer, answer1, Lusername, Tusername,Lpassword, Tpassword, cancelbutton, donebutton);

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

		 

		 //window setup
		 window.setScene(scene1);
		 window.show();
	}
	public void loginVerified(boolean loginChecker){
		if(loginChecker == false)
		System.out.println("Logging in");	
	}
	public static void popup(String title, String message) {
		Stage popup = new Stage();
		popup.setTitle(title);
		Label label = new Label(message);
		
		StackPane layout = new StackPane();
		layout.getChildren().add(label);
		Scene scene = new Scene(layout, 200, 200);
		popup.setScene(scene);
		popup.show();
	}
}
