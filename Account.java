package application;

import java.util.Date;	
import java.util.Random;
public class Account {
Random rand = new Random();
public Date dateCreated = new Date();
private String firstName = " N/a";
private String lastName = "N/a";
private String middleName = "N/a";
private String gender = "N/a";
private String DOB = "00/00/0000";
private String address = "N/a";
private String email = "N/a";
public String userName = "N/a";		// username made-up by user | Login info
private String password = "00000000"; //password initally 8 zeros  |  Login info
public int accountID; // 10-digit account number...... generated when creating an account
private String question1 = "N/a";
private String question2 = "N/a";
private String answer1 = "N/a";
private String answer2 = "N/a";


public Account() {
	this.dateCreated = new Date();
	this.accountID = rand.nextInt(100000);
	
	
}
public String getFullName() {
	String fullName = (firstName + " " + middleName + " " + lastName);
	return fullName;
}

public void setName(String fName, String mName, String lName) {
	this.firstName = fName;
	this.middleName  = mName;
	this.lastName  = lName;	
}

public String getGender() {
	return gender;
}
public void setGender(String userGender) {
	this.gender = userGender;
}

public String getDOB() {
	
	return DOB;
}
public void setDOB(int x, int y, int z) {
if(x < 10) {
	String s = "0";
	this.DOB = (s + x + "/" + y + "/" + z);
}
	else 
		this.DOB = (Integer.toString(0+x) + "/" + y + "/" + z);
}
public String getAddress() {
	return address;
}
public void setAddress(String newAddress) {
	this.address = newAddress;
}


public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}

public String getUserName() {
	return userName;
}
public void setUserName(String newUserName) {
	this.userName = newUserName;
}

public int getAccountID(){
	return accountID;
}
public void setAccountID(int x) {
	this.accountID = x;
}

public String getPassword() {
	return password;
}
public void setPassword(String newPassword) {
	this.password = newPassword;
}

public String getQuestion1() {
	return question1;
}
public void setQuestion1(String question) {
	this.question1 = question;
}

public String getAnswer1() {
	return answer1;
}
public void setAnswer1(String answer) {
	this.answer1 = answer;
}

public String getQuestion2() {
	return question2;
}
public void setQuestion2(String question) {
	this.question2 = question;
}

public String getAnswer2() {
	return answer2;
}
public void setAnswer2(String answer) {
	this.answer2 = answer;
}


}