package application.Gui;
	
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.*;


public class LoginC extends Application {

	
	private TextField usernameTxt = new TextField();
	Label userLabel = new Label("Username:");
	private TextField passwordTxt = new TextField();
	Label passLabel = new Label("Password:");
	Button loginB; 
	Button registerB;
	Scene scene1;

	@Override
	public void start(Stage primaryStage) {
	//Scene 1: Login/Register Screen
		loginB = new Button(); //login button
		loginB.setText("Login");
		
		registerB = new Button();
		registerB.setText("Register");
		
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
		
		layout1.setStyle("-fx-background-image: url('')");
	
		scene1 = new Scene(layout1, 900, 900);
		primaryStage.setTitle("Quickflight");
		primaryStage.setScene(scene1);
		primaryStage.show();
	}
		public static void main(String[] args) {
			launch(args);
			}
	}

