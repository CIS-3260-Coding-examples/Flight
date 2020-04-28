package application;

import javafx.stage.*;	
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.*;

public class Maindup extends Application {
	static Stage window;
	public static void main(String[] args) throws Exception {
		launch(args);
		
	}

	@Override
	public void start(Stage window) throws Exception {
		window = LoginC.loginScreen();
		window.show();
	
	}
	
}