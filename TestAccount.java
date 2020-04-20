package database;
import java.util.Scanner;
public class TestAccount {
public static void main(String[] args) {
	
	UserAccount user1 = new UserAccount();
	
	System.out.println(user1.dateCreated);
	System.out.println("Account ID: " + user1.accountID);
	
	System.out.println(" ");
	
	user1.setName("Jay", "Application", "App");
	user1.setGender("Male");
	user1.setDOB(4, 23, 2000);
	user1.setAddress("1124 Southland Bluff, Stone Mountain Ga, 30087");

	user1.setEmail("newemail@gmail.com");
	user1.setUserName("firstaccount");
	user1.setPassword("Make up Password");
	user1.setQuestion1("What Makes you Happy?");
	user1.setAnswer1("IDK");
	user1.setQuestion2("What college did you attend in 2019?");
	user1.setAnswer2("GSU");
	System.out.println(user1.getFullName());
	System.out.println(user1.getGender());
	System.out.println(user1.getDOB());
	System.out.println(user1.getAddress());
	System.out.println();
	System.out.println(user1.getEmail());
	System.out.println(user1.getUserName());
	System.out.println(user1.getPassword());
	System.out.println("");
	System.out.println(user1.getQuestion1());
	System.out.println(user1.getAnswer1());
	System.out.println("");
	System.out.println(user1.getQuestion2());
	System.out.println(user1.getAnswer2());
	
	
	
}
}
