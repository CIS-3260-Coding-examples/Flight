package application;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.geometry.*;
public class AlertBox {
	
	public static void display(String title, String message) {
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Try Again");
		window.setMinWidth(250);
		
		Label label = new Label();
		label.setText("Username taken. Please try again.");
		
		Button closeB = new Button("Close");
		closeB.setOnAction(e -> window.close());
		
		StackPane layout = new StackPane();
		layout.getChildren().addAll(label, closeB);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout, 70, 70);
		window.setScene(scene);
		window.showAndWait();
		
	}
	
}
