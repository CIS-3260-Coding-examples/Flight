package application;

import java.util.ArrayList;

import DataBase.DatabaseMethods;

public class Regular{

public static void main(String[] args) throws Exception {
	ArrayList<String> a = DatabaseMethods.getCustomerUsernameList();

	System.out.println(DatabaseMethods.returnAdminCustomerIdFormat(0));
	
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
}