package GUI;

import DataBase.DatabaseMethods;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PasswordRecoveryC {
static TextField usernameTxt;
public static void passwordRecovery() {
	Stage window = new Stage();
	window.setTitle("Password Recovery");
	window.initModality(Modality.APPLICATION_MODAL);
	GridPane grid = new GridPane();
	grid.setPadding(new Insets(10,10,10,10));
	grid.setHgap(8);
	grid.setVgap(10);
	Label label = new Label("Enter your username:");
	GridPane.setConstraints(label, 0, 0);
	
	usernameTxt = new TextField();
	GridPane.setConstraints(usernameTxt, 1, 0);
	
	Button button = new Button("Enter");
	GridPane.setConstraints(button, 0, 1);
	button.setOnAction(e -> {
		window.close();
		try {
		SecurityQuestionC.securityPopup();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	});
	grid.getChildren().addAll(label, usernameTxt,button);
	Scene scene = new Scene(grid, 350, 90);
	window.setResizable(false);;
	window.setScene(scene);
	window.showAndWait();
}
public static String getlogin() {
	return usernameTxt.getText();
}
}
