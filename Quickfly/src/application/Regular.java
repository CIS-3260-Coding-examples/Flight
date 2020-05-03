package application;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.application.Preloader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Regular extends Preloader{

public static void main(String[] args) {
	System.out.println(nameChecker("Alex"));
	System.out.println(addressChecker("1132 Midsummer Ct."));
	System.out.println(ssnChecker("135-12-1232"));
	System.out.println(zipcodeChecker("30411"));
	usernameChecker("Lumon34");
	System.out.println(registerChecker("Alex", "Hansen", "1645 Midsummer Ct.", "36432", "132-16-2312", "Lumon34"));
}
public static boolean nameChecker(String name) {
	return name.matches("[a-zA-Z]+");
}
public static boolean addressChecker(String address) {
	return address.matches("[A-Za-z0-9'\\.\\-\\s]+");
}
public static boolean ssnChecker(String ssn) {
	return ssn.matches("[0-9]{3}-[0-9]{2}-[0-9]{4}");
}
public static boolean zipcodeChecker(String zipcode) {
	return zipcode.matches("^[0-9]{5}(?:-[0-9]{4})?$");
}
public static boolean usernameChecker(String username) {
	return username.matches("^[a-zA-Z0-9]+([._]?[a-zA-Z0-9]+)*$");
}
public static boolean registerChecker(String firstName, String lastName, String address, String zipcode, String ssn, String username) {
	if(nameChecker(firstName) == true && 
			nameChecker(lastName) == true && 
			addressChecker(address) == true && 
			zipcodeChecker(zipcode) == true && 
			ssnChecker(ssn) == true && 
			usernameChecker(username) == true) {  
		return true;
	}
		return false;
	}
@Override
public void start(Stage arg0) throws Exception {
	StackPane layout = new StackPane();
	Scene scene = new Scene(layout, 400, 500);
	scene.getStylesheets().add("splash.css.txt");
	notifyPreloader(new Preloader.StateChangeNotification(Preloader.StateChangeNotification.Type.BEFORE_START)); 
	arg0.setTitle("loading");
	arg0.setScene(scene);
	arg0.setResizable(true);
	arg0.centerOnScreen();
	arg0.show();
	
}
}