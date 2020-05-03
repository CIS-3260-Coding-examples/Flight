package GUI;

import javafx.stage.*;	
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.Date;

import DataBase.DatabaseMethods;
import DataBase.Methods;
import javafx.application.Application;
import javafx.application.Preloader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.*;

public class Maindup extends Application {
	static Stage window;
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage window) throws Exception {
		Methods.startApp(LoginC.loginScreen());
	}	
	public static void restart() throws Exception {
		Methods.startApp(LoginC.loginScreen());
	}
	
}