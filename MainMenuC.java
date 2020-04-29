package application;

import javafx.scene.Scene;
import javafx.stage.*;	
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.*;

public class MainMenuC extends Maindup {
	
static Stage window = new Stage();

public static void menuScreen() throws Exception {

window.initModality(Modality.APPLICATION_MODAL);
GridPane grid = new GridPane();
grid.setPadding(new Insets(10,10,10,10));
grid.setHgap(8);
grid.setVgap(10);
grid.setAlignment(Pos.CENTER);

//after login button click bookflight
Button bookflight = new Button("Book Flight");
GridPane.setConstraints(bookflight, 0, 0);
	
//available flights
Button availableflights = new Button("All Available Flights");
GridPane.setConstraints(availableflights, 0, 1);

//manage trips
Button managetrip = new Button("Manage Trip");
GridPane.setConstraints(managetrip, 0, 2);

//account information
Button accountInfo = new Button("Account Information");	
GridPane.setConstraints(accountInfo, 0, 3);

//logout
Button logout = new Button("Log Out");
GridPane.setConstraints(logout, 0, 4);

accountInfo.setOnAction(e -> {
	try {
		AccountInfoC.accountScreen();
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
});
logout.setOnAction(e -> {
	try {
		Maindup.restart();
	} catch (Exception e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
	});

grid.getChildren().addAll(bookflight, availableflights,managetrip, logout, accountInfo);

Scene scene = new Scene(grid, 550, 500);
scene.getStylesheets().add("Viper.css");
window.setScene(scene);
window.showAndWait();
}
}
