package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AccountInfoC {

public static void accountScreen() throws Exception {
	Stage window = new Stage();
	window.initModality(Modality.APPLICATION_MODAL);
	GridPane grid = new GridPane();
	grid.setPadding(new Insets(10,10,10,10));
	grid.setHgap(8);
	grid.setVgap(10);
	grid.setAlignment(Pos.CENTER);

	Label firstname = new Label("Name: ");
	GridPane.setConstraints(firstname, 0, 0);
	Label firstname1 = new Label(DatabaseMethods.extractor(LoginC.getlogin()).getFullName());
	GridPane.setConstraints(firstname1, 1, 0);	

	Label address = new Label("Address: ");
	GridPane.setConstraints(address, 0, 1);
	Label address1 = new Label(DatabaseMethods.extractor(LoginC.getlogin()).getAddress());
	GridPane.setConstraints(address1, 1, 1);
	
	Label zip = new Label("Zip Code: ");
	GridPane.setConstraints(zip, 0, 2);
	Label zip1 = new Label(DatabaseMethods.extractor(LoginC.getlogin()).getZipcode());
	GridPane.setConstraints(zip1, 1, 2);
	
	Label state = new Label("State: ");
	GridPane.setConstraints(state, 0, 3);
	Label state1 = new Label(DatabaseMethods.extractor(LoginC.getlogin()).getState());
	GridPane.setConstraints(state1, 1, 3);
		
	grid.getChildren().addAll(firstname, firstname1, address, address1, zip, zip1, state, state1);
	Scene scene = new Scene(grid, 500, 500);
	window.setScene(scene);
	window.showAndWait();
}
}