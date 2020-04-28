package application;
import javafx.geometry.Insets;	
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SignUpC {
	static Scene scene;
	static Stage window = new Stage();
	
public static void signupScreen() {
	window.initModality(Modality.APPLICATION_MODAL);
	GridPane grid = new GridPane();
	grid.setPadding(new Insets(10,10,10,10));
	grid.setHgap(8);
	grid.setVgap(10);

	//label firstname
	Label fName = new Label("First Name:");	
	GridPane.setConstraints(fName, 0, 0);
	
	//textField firstname
	TextField first = new TextField();
	GridPane.setConstraints(first, 1, 0);
			
	//label lastname
	Label lName = new Label("Last Name:");
	GridPane.setConstraints(lName, 3, 0);
	//textField lastname
	TextField last = new TextField();
	GridPane.setConstraints(last, 4, 0);
	grid.setAlignment(Pos.CENTER);
			
	//label Address
	Label address = new Label("Address:");
	GridPane.setConstraints(address, 0, 1);
			
	//textField firstname
	TextField address1 = new TextField();
	GridPane.setConstraints(address1, 1, 1);
			
	//label Address
	Label zipcode = new Label("ZipCode:");
	GridPane.setConstraints(zipcode, 0, 3);
			
	//textField firstname
	TextField zipcode1 = new TextField();
	GridPane.setConstraints(zipcode1, 1, 3);
			
	//label zipcode
	Label state = new Label("State:");
	GridPane.setConstraints(state, 3, 1);
			
	//textField zipcode
	TextField state1 = new TextField();
	GridPane.setConstraints(state1, 4, 1);
			
	//label ssn
	Label ssn = new Label("SSN:");
	GridPane.setConstraints(ssn, 3, 3);
			
	//textField ssn
	TextField ssn1 = new TextField();
	GridPane.setConstraints(ssn1, 4, 3);
			
	//label Question
	Label question = new Label("Question:");
	GridPane.setConstraints(question, 0, 4);
			
	//textField Question
	TextField question1 = new TextField();
	GridPane.setConstraints(question1, 1, 4);
			
	//label Answer
	Label answer = new Label("Answer:");
	GridPane.setConstraints(answer, 3, 4);
			
	//textField answer
	TextField answer1 = new TextField();
	GridPane.setConstraints(answer1, 4, 4);
			
	//label username
	Label Lusername = new Label("Username:");
	GridPane.setConstraints(Lusername, 0, 5);
			
	//textField username
	TextField Tusername = new TextField();
	GridPane.setConstraints(Tusername, 1, 5);
		
	////label password
	Label Lpassword = new Label("Password:");
	GridPane.setConstraints(Lpassword, 3, 5);
			
	//textField password
	TextField Tpassword = new TextField();
	GridPane.setConstraints(Tpassword, 4, 5);

	//button register
	Button cancelbutton = new Button("Main Menu");
	GridPane.setConstraints(cancelbutton, 0, 6);
	
	Button donebutton = new Button("Submit");
	GridPane.setConstraints(donebutton, 1, 6);
	
	donebutton.setOnAction(e -> window.close());
	//cancel button clicked
	
	grid.getChildren().addAll(fName, first, lName, last, address, address1, zipcode,zipcode1,state, state1,ssn, 
			ssn1, question, question1, answer, answer1, Lusername, Tusername,Lpassword, Tpassword,cancelbutton,donebutton);
	scene = new Scene(grid, 550, 500);
	window.setScene(scene);
	window.showAndWait();
	
}
}
