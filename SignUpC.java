package GUI;
import DataBase.DatabaseMethods;
import javafx.geometry.Insets;	
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SignUpC {
	public static void main(String[] args) {
}
	static Scene scene;
	static Stage window = new Stage();
	static boolean answer;
	static TextField first;
	static TextField last;
	static TextField address1;
	static TextField zipcode1;
	static TextField state1;
	static TextField ssn1;
	static TextField question1;
	static TextField answer1;
	static TextField tusername;
	static TextField tpassword;
	static TextField middle;
public static void signupScreen() throws Exception {
	window.setTitle("Registration");
	GridPane grid = new GridPane();
	grid.setPadding(new Insets(10,10,10,10));
	grid.setHgap(8);
	grid.setVgap(10);

	//label firstname
	Label fName = new Label("First Name:");	
	GridPane.setConstraints(fName, 0, 0);
	
	//textField firstname
	first = new TextField();
	GridPane.setConstraints(first, 1, 0);
			
	//label lastname
	Label lName = new Label("Last Name:");
	GridPane.setConstraints(lName, 3, 0);
	//textField lastname
	last = new TextField();
	GridPane.setConstraints(last, 4, 0);
	grid.setAlignment(Pos.CENTER);
			
	//label Address
	Label address = new Label("Address:");
	GridPane.setConstraints(address, 0, 1);
			
	//textField firstname
	address1 = new TextField();
	GridPane.setConstraints(address1, 1, 1);
			
	//label Address
	Label zipcode = new Label("ZipCode:");
	GridPane.setConstraints(zipcode, 0, 3);
			
	//textField firstname
	zipcode1 = new TextField();
	GridPane.setConstraints(zipcode1, 1, 3);
			
	//label zipcode
	Label state = new Label("State:");
	GridPane.setConstraints(state, 3, 1);
			
	//textField zipcode
	state1 = new TextField();
	GridPane.setConstraints(state1, 4, 1);
			
	//label ssn
	Label ssn = new Label("SSN:");
	GridPane.setConstraints(ssn, 3, 3);
			
	//textField ssn
	ssn1 = new TextField();
	GridPane.setConstraints(ssn1, 4, 3);
			
	//label Question
	Label question = new Label("Question:");
	GridPane.setConstraints(question, 0, 4);
			
	//textField Question
	question1 = new TextField();
	GridPane.setConstraints(question1, 1, 4);
			
	//label Answer
	Label answer = new Label("Answer:");
	GridPane.setConstraints(answer, 3, 4);
			
	//textField answer
	answer1 = new TextField();
	GridPane.setConstraints(answer1, 4, 4);
			
	//label username
	Label Lusername = new Label("Username:");
	GridPane.setConstraints(Lusername, 0, 5);
			
	//textField username
	tusername = new TextField();
	GridPane.setConstraints(tusername, 1, 5);
		
	////label password
	Label Lpassword = new Label("Password:");
	GridPane.setConstraints(Lpassword, 3, 5);
			
	//textField password
	tpassword = new TextField();
	GridPane.setConstraints(tpassword, 4, 5);

	//button register
	Button cancelbutton = new Button("Back");
	GridPane.setConstraints(cancelbutton, 0, 6);
	
	Button donebutton = new Button("Submit");
	GridPane.setConstraints(donebutton, 1, 6);

	window.setOnCloseRequest(e -> {
	e.consume();
	closeProgram();
	});
	cancelbutton.setOnAction(e -> {
		e.consume();
		closeProgram();
		});
	donebutton.setOnAction(e -> {
		String firstname = first.getText();
		String lastname = last.getText();
		String tempaddress = address1.getText();
		String tempzipcode = zipcode1.getText();
		String tempstate = state1.getText();
		String tempusername = tusername.getText();
		String temppassword = tpassword.getText();
		String tempquestion = question1.getText();
		String tempanswer = answer1.getText();
	DatabaseMethods.makeaccount(firstname, lastname, tempaddress, tempzipcode, tempstate, tempusername, temppassword, tempquestion, tempanswer);
		//DatabaseMethods.register(DatabaseMethods.idMaker(), account.getFirstName(), account.getMiddleName(), account.getLastName(), account.getAddress(), Integer.parseInt(account.getZipcode()), account.getState(), account.getUserName(), account.getPassword(), account.getQuestion1(), account.getAnswer1());
	try {
		DatabaseMethods.inputregister();
		window.close();
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}}	
	);
	
	grid.getChildren().addAll(fName, first, lName, last, address, address1, zipcode,zipcode1,state, state1,ssn, 
			ssn1, question, question1, answer, answer1, Lusername, tusername,Lpassword, tpassword,cancelbutton,donebutton);
	scene = new Scene(grid, 550, 500);
	window.setScene(scene);
	window.showAndWait();
	
}
public static boolean confirmBox(String title, String message) {
	
	Stage window = new Stage();
	window.initModality(Modality.APPLICATION_MODAL);
	window.setTitle(title);
	window.setMinWidth(250);
	Label label = new Label(message);
	
	Button yesB = new Button("Yes");
	yesB.setOnAction(e -> {
		answer = true;
		window.close();
	});
	Button noB = new Button("No");
	noB.setOnAction(e -> {
	answer = false;
	window.close();
	});
	VBox layout = new VBox();
	layout.getChildren().addAll(label, yesB, noB);
	layout.setAlignment(Pos.CENTER);
	Scene scene = new Scene(layout);
	window.setScene(scene);
	window.showAndWait();
	return answer;
}
public static void closeProgram() {
	boolean answer = SignUpC.confirmBox("Are you sure?", "Are you sure you want to exit the registration?");
	if(answer)
		window.close();
}
}