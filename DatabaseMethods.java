package DataBase;
import java.sql.Connection;	
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Classes.Account;
import GUI.PasswordRecoveryC;

public class DatabaseMethods {
static Account account;
	public static void main(String[] args) throws Exception {
		DatabaseMethods.extractor("FloridaMon").getLastName();
	}
	public static boolean userExists(String user) throws Exception {
		boolean exists = false;
		ArrayList<String> userlist = getUserList();
		for(int i = 0; i < userlist.size(); i++) {
			if(userlist.get(i).compareTo(user) == 0)
			exists = true;
		}
		return exists;
	}
	public static void makeFlight(String ID_flight, String date, String city_name, String tempzipcode, String tempstate, String tempusername, String temppassword, String tempquestion, String tempanswer, String ssn) {
		account = new Account(firstname, lastname, tempaddress, tempzipcode, tempstate, tempusername, temppassword,tempquestion, tempanswer, ssn); 
	}
	public static void makeaccount(String firstname, String lastname, String tempaddress, String tempzipcode, String tempstate, String tempusername, String temppassword, String tempquestion, String tempanswer, String ssn) {
	account = new Account(firstname, lastname, tempaddress, tempzipcode, tempstate, tempusername, temppassword,tempquestion, tempanswer, ssn); 
	}
	public static int idMaker() {
		int id = (int)(Math.random() * 999999) + 800000;
		return id;
	}
	public static void createTable() throws Exception {
		try {
		Connection con = getConnection();
		PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS tablename(id int NOT NULL AUTO_INCREMENT, first varchar(255), last varchar(255), PRIMARY KEY(id))");
		create.executeUpdate();
		}
		catch(Exception e) {
		System.out.println(e);
		}
		finally{
		System.out.println("Function complete.");	
		};
	}
	public static Connection getConnection() throws Exception {
	try {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://34.71.71.129:3306/Airbeam";
		String username = "Alex";
		String password = "lemon10";
		Class.forName(driver);
	Connection conn = DriverManager.getConnection(url, username, password);
	return conn;
	} 
	catch(Exception e) {
	System.out.println(e);
	}
	return null;
	}
	public static void post() throws Exception {
		final String var1 = "John";
		final String var2 = "Miller";
		try {
			Connection con = getConnection();
			PreparedStatement posted = con.prepareStatement("INSERT INTO Account(first, last) VALUES ('"+var1+"', '"+var2+"')");
			posted.executeUpdate();
		}
		catch(Exception e) {
		System.out.println(e);
		}
		finally {
		System.out.println("Insert Completed.");
		}
	}
	// gets an arrayList of usernames
	public static ArrayList<String> getUserList() throws Exception {
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT username, password FROM Customer");
			ResultSet result = statement.executeQuery();
			
			ArrayList<String> array = new ArrayList<String>();
			while(result.next()) {
				array.add(result.getString("username"));
			}
			return array;
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	// gets an arrayList of passwords
	public static ArrayList<String> getPasswordList() throws Exception {
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT password FROM Customer");
			ResultSet result = statement.executeQuery();
			
			ArrayList<String> array = new ArrayList<String>();
			while(result.next()) {
				array.add(result.getString("password"));
			}
			return array;
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	
	// returns index of the username
	public static int findUserIndex(String username) throws Exception {
		ArrayList<String> userList = getUserList();
		int index = userList.indexOf(username);
		return index;
	}
	// returns the password of an index
	public static String getPassword(int index) throws Exception {
		ArrayList<String> passList = getPasswordList();
		return passList.get(index);	
	}
	public static ArrayList<String> getFlightNumber() throws Exception {
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT ID_flight FROM Flight");
			ResultSet result = statement.executeQuery();
			
			ArrayList<String> array = new ArrayList<String>();
			while(result.next()) {
				array.add(result.getString("password"));
			}
			return array;
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	public static String isConnected() throws Exception	{
	try {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://34.71.71.129:3306/Airbeam";
		String username = "Alex";
		String password = "lemon10";
		Class.forName(driver);
	Connection conn = DriverManager.getConnection(url, username, password);
	return "Connected";
	} 
	catch(Exception e) {
	System.out.println(e);
	}
	return "Not Connected";
	}
	public static String getAccount() throws Exception	{
	try {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://34.71.71.129:3306/Airbeam";
		String username = "Alex";
		String password = "lemon10";
		Class.forName(driver);
	Connection conn = DriverManager.getConnection(url, username, password);
	return "Connected";
	} 
	catch(Exception e) {
	System.out.println(e);
	}
	return "Not Connected";
	}
	public static String pullAddress(String user) throws Exception {
	String address;
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT address FROM Customer WHERE username = '" + user + "'");
			ResultSet result = statement.executeQuery();
			ArrayList<String> array = new ArrayList<String>();
			while(result.next()) {
				array.add(result.getString("address"));
			}
			address = array.get(0);
			return address;
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	public static String pullZipCode(String user) throws Exception {
		String zipcode;
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT zip_code FROM Customer WHERE username = '" + user + "'");
			ResultSet result = statement.executeQuery();
			ArrayList<String> array = new ArrayList<String>();
			while(result.next()) {
				array.add(result.getString("zip_code"));
			}
			zipcode = array.get(0);
			return zipcode;
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	public static String pullFirstName(String user) throws Exception {
		String firstname;
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT first_name FROM Customer WHERE username = '" + user + "'");
			ResultSet result = statement.executeQuery();
			ArrayList<String> array = new ArrayList<String>();
			while(result.next()) {
				array.add(result.getString("first_name"));
			}
			firstname = array.get(0);
			return firstname;
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	public static String pullMiddleName(String user) throws Exception {
		String middlename;
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT middle_name FROM Customer WHERE username = '" + user + "'");
			ResultSet result = statement.executeQuery();
			ArrayList<String> array = new ArrayList<String>();
			while(result.next()) {
				array.add(result.getString("middle_name"));
			}
			middlename = array.get(0);
			return middlename;
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	public static String pullLastName(String user) throws Exception {
		String lastname;
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT last_name FROM Customer " + user);
			ResultSet result = statement.executeQuery();
			ArrayList<String> array = new ArrayList<String>();
			while(result.next()) {
				array.add(result.getString("last_name"));
			}
			lastname = array.get(0);
			return lastname;
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	public static String pullPassword(String user) throws Exception {
		String password;
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT password FROM Customer WHERE username = '" + user + "'");
			ResultSet result = statement.executeQuery();
			ArrayList<String> array = new ArrayList<String>();
			while(result.next()) {
				array.add(result.getString("password"));
			}
			password = array.get(0);
			return password;
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	public static String pullState(String user) throws Exception {
		String state;
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT state FROM Customer WHERE username = '" + user + "'");
			ResultSet result = statement.executeQuery();
			ArrayList<String> array = new ArrayList<String>();
			while(result.next()) {
				array.add(result.getString("state"));
			}
			state = array.get(0);
			return state;
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	public static int pullCustomerId(String user) throws Exception {
		int id;
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT ID_customer FROM Customer WHERE username = '" + user + "'");
			ResultSet result = statement.executeQuery();
			ArrayList<Integer> array = new ArrayList<Integer>();
			while(result.next()) {
				array.add(result.getInt("ID_customer"));
			}
			id = array.get(0);
			return id;
		}
		catch(Exception e) {
			System.out.println(e);
			return (Integer) null;
		}
	}
	public static String pullQuestion(String user) throws Exception {
		String question;
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT security_question FROM Customer WHERE username = '" + user + "'");
			ResultSet result = statement.executeQuery();
			ArrayList<String> array = new ArrayList<String>();
			while(result.next()) {
				array.add(result.getString("security_question"));
			}
			question = array.get(0);
			return question;
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	public static String pullAnswer(String user) throws Exception {
		String answer;
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT security_answer FROM Customer WHERE username = '" + user + "'");
			ResultSet result = statement.executeQuery();
			ArrayList<String> array = new ArrayList<String>();
			while(result.next()) {
				array.add(result.getString("security_answer"));
			}
			answer = array.get(0);
			return answer;
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	public static String pullSsn(String user) throws Exception {
		String ssn;
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT ssn FROM Customer WHERE username = '" + user + "'");
			ResultSet result = statement.executeQuery();
			ArrayList<String> array = new ArrayList<String>();
			while(result.next()) {
				array.add(result.getString("security_answer"));
			}
			ssn = array.get(0);
			return ssn;
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	public static ArrayList<String> getFlightIdList() throws Exception {
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT ID_flight FROM Flight");
			ResultSet result = statement.executeQuery();
			
			ArrayList<String> array = new ArrayList<String>();
			while(result.next()) {
				array.add(result.getString("ID_flight"));
			}
			return array;
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	//extracts customer's data and displays it in the customer info screen
	public static Account extractor(String user) throws Exception {
		Account account = new Account();	
		account.setName(pullFirstName(user), pullLastName(user));
		account.setAddress(pullAddress(user));
		account.setZipcode(pullZipCode(user));
		account.setState(pullState(user));
		account.setAccountId(pullCustomerId(user));
		account.setQuestion(pullQuestion(user));
		account.setAnswer(pullAnswer(user));
		account.setSsn(pullSsn(user));
		return account;
}
	public static void extractorLocal(String user) throws Exception {	
		account.setName(pullFirstName(user), pullLastName(user));
		account.setAddress(pullAddress(user));
		account.setZipcode(pullZipCode(user));
		account.setState(pullState(user));
		account.setAccountId(pullCustomerId(user));
		account.setQuestion(pullQuestion(user));
		account.setAnswer(pullAnswer(user));
		account.setSsn(pullSsn(user));
}
	public static void setLocal() throws Exception {
		extractorLocal(PasswordRecoveryC.getlogin());
	}
	
	public static void register(int customerid, String firstname, String lastname, String address, int zipcode, String state, String username, String password, String security_question, String security_answer, String ssn) throws Exception {
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("INSERT INTO Customer(ID_customer, first_name, last_name, address, zip_code, state, username, password, security_question, security_answer, ssn) Values "
					+ "('" + customerid + "', '" + firstname + "', '" + lastname + "', '" + address + "', '" + zipcode + "', '" + state + "', '" + username + "', '" + password + "', '" + security_question + "', '" + security_answer + "', '" + ssn + "');");
			statement.executeUpdate();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	public static void inputregister() throws NumberFormatException, Exception {
		register(idMaker(), account.getFirstName(), account.getLastName(), account.getAddress(), Integer.parseInt(account.getZipcode()), account.getState(), account.getUserName(), account.getPassword(), account.getQuestion(), account.getAnswer(), account.getSsn());
	}
}
