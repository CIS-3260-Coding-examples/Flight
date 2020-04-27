package application;

import java.awt.Button;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Methods {
	
	//login verify method
		public static void loginVerified(boolean loginChecker){
			if(loginChecker == false)
			System.out.println("Logging in");	
		}
		// returns false if login works, false if login does not work
		public static boolean loginChecker(String username, String pass) throws Exception {
			int userIndex = DatabaseMethods.findUserIndex(username);
			String password = DatabaseMethods.getPassword(userIndex);
			if(pass == password)
				return true;
			else
				return false;
		}
		
		//using wrong username/password method
		public static void popup(String title, String message) {
			Stage popup = new Stage();
			popup.setTitle(title);
			Label label = new Label(message);
			
			StackPane layout = new StackPane();
			layout.getChildren().add(label);
			Scene scene = new Scene(layout, 200, 200);
			popup.setScene(scene);		

			popup.show();
		}
		
		

		public static ObservableList<Flight> getFlight(){
			ObservableList<Flight> flight = FXCollections.observableArrayList();
			flight.add(new Flight(1000,"04/16/2020","Atl","Atlanta","NY","New York","9:50 am","12:30 pm"));
			flight.add(new Flight(1002,"04/17/2020","NY","New York","ATL","Atlanta","9:50 am","12:30 pm"));

			return flight;
		}

	}


