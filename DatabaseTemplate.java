package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class DatabaseTemplate {

	public static void main(String[] args) throws Exception {
		ArrayList<String> list = new ArrayList<String>();
		System.out.println(getuserList().contains("Falcon34"));
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
	public static Connection getConnection() throws Exception	{
	try {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://34.71.71.129:3306/Airbeam";
		String username = "Alex";
		String password = "lemon10";
		Class.forName(driver);
	Connection conn = DriverManager.getConnection(url, username, password);
	System.out.println("Connected");
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
	public static ArrayList<String> getuserList() throws Exception {
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT username FROM Customer");
			ResultSet result = statement.executeQuery();
			
			ArrayList<String> array = new ArrayList<String>();
			while(result.next()) {
				System.out.print(result.getString("username"));
				array.add(result.getString("username"));
				System.out.println(" ");
			}
			System.out.println("All records have been selected!");
			return array;
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
}
