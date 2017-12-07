package javaFxGUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JavaFxGuiDemo extends Application{

	
	
	
	public static void main(String[] args) {
		
		System.out.println("Hello World!");
		
		launch(args);
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		primaryStage.setTitle("Mobility Rechner");
		
		Button button = new Button("Berechnen");
		
		StackPane layout = new StackPane();
		
		layout.getChildren().add(button);
		
		Scene scene = new Scene(layout, 300, 400);
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
