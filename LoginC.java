package application;

import javafx.geometry.Insets;	
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class LoginC {
	static boolean isCorrect;
	private static PasswordField p;
	private static TextField name;
	static Account account;
	static Stage window;
	public static void main(String[] args) throws Exception{

	}
	
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
	
	p = new PasswordField();
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
			int test = DatabaseMethods.pullPassword(name.getText()).compareTo(p.getText());
			if(test == 0) {
			window.close();
			MainMenuC.menuScreen();
			name.clear();
			p.clear();
			}
		} catch (Exception e1) {
			Methods.popup("Error", "Invalid Username/Password");
		}	
	});
	signupbutton.setOnAction(e -> {
		try {
			SignUpC.signupScreen();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	});
	
	grid.getChildren().addAll(username, name, password, p , logInbutton, signupbutton, connectionStatus);
	Scene scene = new Scene(grid, 550, 500);
	window.setScene(scene);
	return window;
	}
	public static String getlogin() {
		return name.getText();
	}
}
