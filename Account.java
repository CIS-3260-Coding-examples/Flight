package Classes;
import java.util.Date;	
import java.util.Random;
public class Account {
public Date dateCreated = new Date();
private String firstName = " N/a";
private String lastName = "N/a";
private String gender = "N/a";
private String DOB = "00/00/0000";
private String address = "N/a";
private String state = "N/a";
private String email = "N/a";
public String userName = "N/a";		// username made-up by user | Login info
private String password = "00000000"; //password initally 8 zeros  |  Login info
public int accountId; // 10-digit account number...... generated when creating an account
private String question1 = "N/a";
private String answer1 = "N/a";
private String zipcode = "000000";
private String ssn = "000-00-0000";
	
public Account(){
	
}
public Account(String firstname, String lastname, String address, String zipcode, String state, String username, String password, String securityquestion, String securityanswer, String ssn) {
	this.firstName = firstname;
	this.lastName = lastname;
	this.address = address;
	this.zipcode = zipcode;
	this.state = state;
	this.userName = username;
	this.password = password;
	this.question1 = securityquestion;
	this.answer1 = securityanswer;
	this.dateCreated = new Date();
	this.ssn = ssn;
}
public void setAccountId(int accountId) {
	this.accountId = accountId;
}
public int getAccountId() {
	return accountId;
}
public String getFullName() {
	String fullName = (firstName + " " + lastName);
	return fullName;
}

public void setName(String fName, String lName) {
	this.firstName = fName;
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

public String getZipcode() {
	return zipcode;
}
public void setZipcode(String zipcode) {
	this.zipcode = zipcode;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getSsn() {
	return ssn;
}
public void setSsn(String ssn) {
	this.ssn = ssn;
}

}