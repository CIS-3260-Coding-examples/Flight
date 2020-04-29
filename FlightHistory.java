package application;


import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Insets;


public class FlightHistory extends Application{
	
	Stage window, window1;
	Scene scene;
	Button button, button1;
	boolean isCorrect;
	static TableView<Flight> table;
	TextField flightIdInput, dateInput;
	

	
	public static void main(String[] args) {
			launch(args);		//Starts program
			
	}	
			@Override
			public void start(Stage primaryStage) throws Exception {
				window = primaryStage;		// sets primaryStage to window
				window.setTitle("FLIGHT HISTORY");
				window.setOnCloseRequest(e -> {
				e.consume();		//Consumes the close request so computer ignore the request and does what the closeProgram says
				closeProgram();		//Method that closes program 
				});					//Makes window close on method closeProgram
			

	
			
					
			
			AnchorPane topMenu = new AnchorPane();
			

			Button buttonA = new Button("Home");
		//buttonA.setOnAction(e -> window.setScene(MainMenuC.menuScreen());
		
			Button buttonB = new Button("About Us");
			Button buttonC = new Button("Log Out");
		//buttonC.setOnAction(e -> window.setScene(MainMenuC.menuScreen());
			Label label1 = new Label("Flight");
			
			
		
			AnchorPane.setTopAnchor(buttonC, 40.0);
			AnchorPane.setRightAnchor(buttonC, 10.0);
			
			AnchorPane.setTopAnchor(buttonB, 40.0);
			AnchorPane.setRightAnchor(buttonB, 80.0);
			
			AnchorPane.setTopAnchor(buttonA, 40.0);
			AnchorPane.setRightAnchor(buttonA, 155.0);
			
			topMenu.getChildren().addAll(label1, buttonB, buttonC, buttonA);
			topMenu.setStyle("-fx-background-color: #8B0000;");	
		
			
			
			
			
		
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			BorderPane borderPane = new BorderPane();
			borderPane.setTop(topMenu);
			
			
						
			Scene scene = new Scene(borderPane, 550, 500);
			
						
						
						
						
			window.setScene(scene);	
			window.show();
			
			}
	

			private void deleteClicked() {
				ObservableList<Flight> flightSelected, allflight;
				allflight = table.getItems();
				flightSelected = table.getSelectionModel().getSelectedItems();
				
				flightSelected.forEach(allflight::remove);
			}
			
			private void closeProgram() {
				
				Boolean answer = ConfirmBox.display("Title", "Are you sure you want to exit");
				if(answer)
					window.close();
				System.out.print("File Saved");
		}						
		/*		
			public void addbuttonClicked() {
				Flight flight = new Flight();
				flight.setFlightId(Integer.parseInt(flightIdInput.getText()));
				flight.setDateCreated(dateInput.getText());
				flight.setCityPrefix(originPrefixInput.getText());
				flight.setCityName(originCityInput.getText());
				flight.setDestinantionPrefix(destinationPrefixInput.getText());
				flight.setDestinantionCity(destinationCityInput.getText());
				flight.setTimeIn(timeInInput.getText());
				flight.setTimeOut(timeOutInput.getText());
				table.getItems().add(flight);
				flightIdInput.clear();
				dateInput.clear();
				originPrefixInput.clear();
				originCityInput.clear();
				destinationPrefixInput.clear();
				destinationCityInput.clear();
				timeInInput.clear();
				timeOutInput.clear();
			}
		
			*/	
	}
			
		
		

