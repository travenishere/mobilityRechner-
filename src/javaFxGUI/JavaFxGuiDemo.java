package javaFxGUI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JavaFxGuiDemo extends Application {

	Button button;
	
	
	public static void main(String[] args) {
		
		launch(args);
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		primaryStage.setTitle("Mobility Rechner");
		
		button = new Button("Berechnen");
		button.setOnAction(e -> System.out.println("Hello World!"));
		
		StackPane layout = new StackPane();
		
		layout.getChildren().add(button);
		
		Scene scene = new Scene(layout, 300, 400);
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
