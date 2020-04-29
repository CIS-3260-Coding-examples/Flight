package GUI;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import Classes.Flight;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.*;

public class CustomerBookAFLight{
	static Stage window = new Stage();
	static Scene scene1,scene2;
	static TableView<Flight> table;

	

	public static void bookflight() {
	window.setTitle("Book a flight");
	
	 ////Creating table
	//flight Id column
	TableColumn< Flight, Integer> flightIdColumn = new TableColumn<>("Flight Id");
	flightIdColumn.setMinWidth(200);
	flightIdColumn.setCellValueFactory(new PropertyValueFactory<>("flightId"));
	
	
	////Date column
	TableColumn< Flight, String> dateColumn = new TableColumn<>("Date");
	dateColumn.setMinWidth(200);
	dateColumn.setCellValueFactory(new PropertyValueFactory<>("dateCreated"));
	

	
	//origin city column
	TableColumn< Flight, String> originCityColumn = new TableColumn<>("City Name");
	originCityColumn.setMinWidth(200);
	originCityColumn.setCellValueFactory(new PropertyValueFactory<>("cityName"));
	
	
	//Destinantion city column
	TableColumn< Flight, String> destinationCityColumn = new TableColumn<>("Destinantion");
	destinationCityColumn.setMinWidth(200);
	destinationCityColumn.setCellValueFactory(new PropertyValueFactory<>("destinantionCity"));
	
    //limit column
	TableColumn< Flight, String> timeInColumn = new TableColumn<>("Time In");
	timeInColumn.setMinWidth(150);
	timeInColumn.setCellValueFactory(new PropertyValueFactory<>("timeIn"));
	
	//paasenger column
	TableColumn< Flight, String> timeOutColumn = new TableColumn<>("Time Out");
	timeOutColumn.setMinWidth(150);
	timeOutColumn.setCellValueFactory(new PropertyValueFactory<>("timeOut"));

	
   //add Button
	Button addButton= new Button("Add");
	addButton.setOnAction(e -> {
		
	});
	
	//Check your flight
	Button checkButton = new Button("Check Your Flight");
	checkButton.setOnAction(e ->{
		window.close();
		CustomerAddedFlight.bookflight();
	});
	
	//Main menu button
	Button mainmenu = new Button("MainMenu");
	mainmenu.setOnAction(e ->{
		try {
			MainMenuC.menuScreen();
			window.close();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	});

	
	
	//HBox
	HBox hbox = new HBox();
	hbox.setPadding(new Insets(5,5,5,5));
	hbox.setSpacing(1);
	hbox.getChildren().addAll(addButton , checkButton,mainmenu );
	
	//table 1
	table = new TableView<>();
	table.setItems(getFlight());
	table.getColumns().addAll(flightIdColumn,dateColumn, originCityColumn, destinationCityColumn,timeInColumn, timeOutColumn);
	

	//book a flight
	VBox layout = new VBox(10);
	layout.getChildren().addAll(table, hbox);
			
	scene1 = new Scene(layout);
	
	window.setScene(scene1);
	window.show();
}


//table1
public static ObservableList<Flight> getFlight(){
	ObservableList<Flight> flight = FXCollections.observableArrayList();
	flight.add(new Flight(1000,"04/16/2020","Atlanta","New York","9:50 am","12:30 pm"));
	flight.add(new Flight(1002,"04/17/2020","New York","Atlanta","9:50 am","12:30 pm"));

	return flight;
}

}
