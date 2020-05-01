package DataBase;

import java.util.Scanner;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class NewMethods{
	
	//needs to delete
	public static void main(String[] args) {
		String tpassword = "aaaaaaaaaaaaaaaaaaaaaaaaa";
		System.out.print(checkPassword(tpassword));
		
	}
	
	
	
	
	public static void popup(String message) {
		//Displays Error Page for invalid 
		Stage invalidError = new Stage();
		invalidError.setTitle("Error");
		Label errorType = new Label(message);
		
		StackPane layout = new StackPane();
		layout.getChildren().addAll(errorType);
		Scene scene = new Scene(layout, 200, 200);
		invalidError.setScene(scene);		

		invalidError.show();
	
	}
	
	
	
	
	
	public static boolean checkPassword(String password) {
		final int LENGTH_OF_VALID_PASSWORD = 30;	// Valid length of password
		final int MINIMUM_NUMBER_OF_DIGITS = 5;	// Minimum digits it must contain
			if((isLengthValid(password, LENGTH_OF_VALID_PASSWORD) == false || (isOnlyLettersAndDigits(password)) == false))
			return true;
			
		return false;
	}
	public static boolean isLengthValid(String password, int validLength) {
		return password.length() >= validLength;
	}
	public static boolean isOnlyLettersAndDigits(String password) {
		for (int i = 0; i < password.length(); i++) {
			if (!Character.isLetterOrDigit(password.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public static  Boolean checkZipCode(String zipCode) {
		
		String zipCodeC = zipCode;
		if(zipCodeC.length() != 5) 
			return false;
		else if ((Character.isDigit(zipCodeC.charAt(0))) &&
				 (Character.isDigit(zipCodeC.charAt(1))) &&
				 (Character.isDigit(zipCodeC.charAt(2))) &&
				 (Character.isDigit(zipCodeC.charAt(3))) &&
				 (Character.isDigit(zipCode.charAt(4))))
			return true;
		else
		
	return false;
	
	
	}

	public static boolean SSNisValid(String ssn) {
		String ssnC = ssn;
		if(ssnC.length() != 11) {
				return false;
		}else if( (ssn.length() == 11) && 
				(Character.isDigit(ssn.charAt(0))) &&
				(Character.isDigit(ssn.charAt(1))) &&
				(Character.isDigit(ssn.charAt(2))) &&
				(ssn.charAt(3) == '-') &&
				(Character.isDigit(ssn.charAt(4))) &&
				(Character.isDigit(ssn.charAt(5))) &&
				(Character.isDigit(ssn.charAt(7))) &&
				(ssn.charAt(6) == '-') &&
				(Character.isDigit(ssn.charAt(8))) &&
				(Character.isDigit(ssn.charAt(9))) &&
				(Character.isDigit(ssn.charAt(10)))) {
			return true;	
		}
		else
		return false;
	}
	


public static void startApp(Stage stage) {
	stage.show();
	}
	
}
