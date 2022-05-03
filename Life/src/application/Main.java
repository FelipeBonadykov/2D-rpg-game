package application;

import game.Screen;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
	static Stage primaryStage;
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/gui/start.fxml"));
			this.primaryStage=primaryStage;
			primaryStage.setTitle("START");
			primaryStage.getIcons().add(new Image("file:files/icon.png"));
			primaryStage.setScene(new Scene(root));
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void handleAction(ActionEvent e) {
		Screen sc = new Screen();
		sc.start(new Stage());// call another window
		primaryStage.close();//closing window
	}
	public static void main(String[] args) {
		launch(args);
	}	
}