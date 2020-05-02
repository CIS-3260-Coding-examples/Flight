package GUI;
import javafx.scene.Scene;
import javafx.stage.*;	
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import Classes.Account;
import Classes.Admin;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.*;

public class AdminMainMenu extends Maindup {
static Scene scene;
static Admin admin;
static Stage window = new Stage();

public static void AdminmenuScreen() throws Exception {

GridPane grid = new GridPane();
grid.setPadding(new Insets(10,10,10,10));
grid.setHgap(8);
grid.setVgap(10);
grid.setAlignment(Pos.CENTER);

//after login button click bookflight
Button editingflight = new Button("Manage Flight");
GridPane.setConstraints(editingflight, 0, 0);
	

//logout
Button logout = new Button("Log Out");
GridPane.setConstraints(logout, 0, 2);

editingflight.setOnAction(e -> {
	window.close();
	try {
		AdminFlightEdit.myFlightA();
		AdminTickets.manageTickets();	
	} catch (Exception e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
});

logout.setOnAction(e -> {
	window.close();
	try {
		window = LoginC.relog();
		window.show();
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}	
	
});

grid.getChildren().addAll(editingflight, logout);

scene = new Scene(grid, 550, 500);
scene.getStylesheets().add("Viper.css");
window.setScene(scene);
window.show();
}

}