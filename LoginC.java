package application;

import javafx.geometry.Insets;	
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoginC extends Account{
	static boolean isCorrect;
	static Scene scene;
	static Stage window;
	static TextField name;
	static Account account = new Account();
	public static Stage loginScreen() throws Exception {
	window = new Stage();
	window.setTitle("QuickFly");
	//panel 1
	GridPane grid = new GridPane();
	grid.setPadding(new Insets(10,10,10,10));
	grid.setHgap(8);
	grid.setVgap(10);
	
	//label username
	Label username = new Label("Username");
	GridPane.setConstraints(username, 0, 0);
	
	//textField
	name = new TextField();
	name.setPromptText("username");
	GridPane.setConstraints(name, 1, 0);
	
	//label password
	Label password = new Label("password");
	GridPane.setConstraints(password, 0, 1);
	
	TextField p = new TextField();
	p.setPromptText("password");
	GridPane.setConstraints(p, 1, 1);
	grid.setAlignment(Pos.CENTER);
	
	//Button login
	Button logInbutton = new Button("Log In");
	GridPane.setConstraints(logInbutton, 1, 2);
	
	// Button sign up
	Button signupbutton =new Button("Sign Up");
	GridPane.setConstraints(signupbutton, 1, 3);
	// Connection Label
	Label connectionStatus = new Label("Status: " + DatabaseMethods.isConnected());
	GridPane.setConstraints(connectionStatus, 1, 10);
	logInbutton.setOnAction(e -> {
		try {
			isCorrect = Methods.loginChecker(name.getText(), p.getText());
			Methods.loginVerified(isCorrect);
			MainMenuC.menuScreen();
		} catch (Exception e1) {
			Methods.popup("Error", "Invalid Username/Password");
		}			
	});
	signupbutton.setOnAction(e -> SignUpC.signupScreen());
	
	grid.getChildren().addAll(username, name, password, p , logInbutton, signupbutton, connectionStatus);
	scene = new Scene(grid, 550, 500);
	window.setScene(scene);
	return window;
	}
	public static Scene getLoginScene() {
		return scene;
	}
	public static void gotToMain() {
		window.setScene(LoginC.getLoginScene());
	}
	public static Account getAccount() {
		return account;
	}
	public static String getuser() {
		return name.getText();
	}
}
