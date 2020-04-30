package GUI;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import Classes.Flight;
import Classes.Ticket;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.*;

public class CustomerAddedFlight {
	static Stage window = new Stage();
	static Scene scene1,scene2;
	static TableView<Ticket> table;

	

	public static void bookflight() {
	window.setTitle("Book a flight");
	
	 ////Creating table
	//flight Id column
	TableColumn< Ticket, Integer> ticketId = new TableColumn<>("Ticket Id");
	ticketId.setMinWidth(200);
	ticketId.setCellValueFactory(new PropertyValueFactory<>("idTicket"));
	
	
	////Date column
	TableColumn< Ticket,Integer> flightId = new TableColumn<>("Flight Id");
	flightId.setMinWidth(200);
	flightId.setCellValueFactory(new PropertyValueFactory<>("idFlight"));
	

	
	//origin city column
	TableColumn< Ticket, Integer> customerId = new TableColumn<>("Customer Id ");
	customerId.setMinWidth(200);
	customerId.setCellValueFactory(new PropertyValueFactory<>("idCustomer"));
	
	

	
   //delete Button
	Button deleteButton= new Button("Delete");
	deleteButton.setOnAction(e ->deleteClicked());
	
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
	hbox.getChildren().addAll(deleteButton , mainmenu );
	
	//table 1
	table = new TableView<>();
	table.setItems(getFlight());
	table.getColumns().addAll(ticketId,flightId, customerId);
	

	//book a flight
	VBox layout = new VBox(10);
	layout.getChildren().addAll(table, hbox);
			
	scene1 = new Scene(layout);
	
	window.setScene(scene1);
	window.show();
}


private static void deleteClicked() {
	ObservableList<Ticket> flightSelected, allflight;
	allflight = table.getItems();
	flightSelected = table.getSelectionModel().getSelectedItems();
	
	flightSelected.forEach(allflight::remove);
	
	
	}
//table1
public static ObservableList<Ticket> getFlight(){
	ObservableList<Ticket> ticket = FXCollections.observableArrayList();
	ticket.add(new Ticket(1000, 1234, 12345));
	ticket.add(new Ticket(1001, 1223, 3421));

	return ticket;
}



}