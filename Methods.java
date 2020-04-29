package DataBase;

import java.awt.Button;

import Classes.Flight;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Methods {	
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
			flight.add(new Flight(1000,"04/16/2020","Atlanta","New York","9:50 am","12:30 pm"));
			flight.add(new Flight(1002,"04/17/2020","New York","Atlanta","9:50 am","12:30 pm"));

			return flight;
		}
		public static void startApp(Stage stage) {
			stage.show();
		}
	}