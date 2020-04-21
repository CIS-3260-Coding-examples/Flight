package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;


public class Main extends Application implements EventHandler<ActionEvent> {
	public static void main(String[] args) {
	launch(args);
	}
	//Scene1
	private TextField usernameTxt = new TextField();
	Label userLabel = new Label("Username:");
	private TextField passwordTxt = new TextField();
	Label passLabel = new Label("Password:");
	Button loginB; 
	Button registerB;
	

	//Scene2
	Button doneB;
	Button cancelB;
	Button logoffB;
	Label firstnameLabel = new Label("First Name:");
	private TextField firstnameTxt = new TextField();
	Label lastnameLabel = new Label("Last Name:");
	private TextField lastnameTxt = new TextField();
	Label addressLabel = new Label("Address:");
	private TextField addressTxt = new TextField();
	Label stateLabel = new Label("State:");
	private TextField stateTxt = new TextField();
	Label zipLabel = new Label("Zip Code:");
	private TextField zipTxt = new TextField();
	Label ssnLabel = new Label("SSN:");
	private TextField ssnTxt = new TextField();
	Label usernameLabel = new Label("Username:");
	private TextField newUserTxt = new TextField();
	Label passwordLabel = new Label("Password:");
	private TextField newPassTxt = new TextField();
	Scene scene1, scene2, scene3;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
	
		//Scene 1: Login/Register Screen
		loginB = new Button(); //login button
		loginB.setText("Login");
		loginB.setOnAction(e -> primaryStage.setScene(scene3)); 
		
		registerB = new Button();
		registerB.setText("Register");
		registerB.setOnAction(e -> primaryStage.setScene(scene2));
		
		GridPane layout1 = new GridPane();
		layout1.setHgap(3);
		layout1.setVgap(3);
		layout1.add(userLabel, 0, 0);
		layout1.add(usernameTxt, 1, 0);
		layout1.add(passLabel, 0, 1);
		layout1.add(passwordTxt, 1, 1);
		layout1.add(loginB, 1, 2);
		layout1.add(registerB, 0, 2);
		layout1.setAlignment(Pos.CENTER);
		
		scene1 = new Scene(layout1, 400, 400);
		
		//Scene 2: Register Screen
		doneB = new Button();
		doneB.setText("Done");
		doneB.setOnAction(e -> primaryStage.setScene(scene3));
		
		cancelB = new Button();
		cancelB.setText("Cancel");
		cancelB.setOnAction(e -> primaryStage.setScene(scene1));
		
		GridPane layout2 = new GridPane();
		layout2.setHgap(4);
		layout2.setVgap(5);
		layout2.add(firstnameLabel, 0, 0);
		layout2.add(addressLabel, 0, 1);
		layout2.add(zipLabel, 0, 3);
		layout2.add(usernameLabel, 0, 4);
		layout2.add(cancelB, 0, 5);
		layout2.add(firstnameTxt, 1, 0);
		layout2.add(addressTxt, 1, 1);
		layout2.add(zipTxt, 1, 3);
		layout2.add(newUserTxt, 1, 4);
		
		layout2.add(lastnameLabel, 3, 0);
		layout2.add(stateLabel, 3, 1);
		layout2.add(ssnLabel, 3, 3);
		layout2.add(passwordLabel, 3, 4);
		layout2.add(lastnameTxt, 4, 0);
		layout2.add(stateTxt, 4, 1);
		layout2.add(ssnTxt, 4, 3);
		layout2.add(newPassTxt, 4, 4);
		layout2.add(doneB, 4, 5);
		
		
		
		layout2.setAlignment(Pos.CENTER);
		scene2 = new Scene(layout2, 500,400);

		// Scene 3: Main Menu
		logoffB = new Button();
		logoffB.setText("Logoff");
		logoffB.setOnAction(e -> primaryStage.setScene(scene1));		

		StackPane layout3 = new StackPane();
		layout3.getChildren().addAll(logoffB);
		scene3 = new Scene(layout3, 400, 400);
		
		primaryStage.setTitle("Quickflight");
		primaryStage.setScene(scene1);
		primaryStage.show();
		
					}

	@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}

