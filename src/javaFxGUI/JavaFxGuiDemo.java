package javaFxGUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFxGuiDemo extends Application {

	Button button;
	Scene inputScene, resultScene;
	
	
	public static void main(String[] args) {
		
		launch(args);
		
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		stage.setTitle("Mobility Rechner");
		
		Label label1 = new Label("Mobility Fahrt berechnen");
		button = new Button("Berechnen");
		button.setOnAction(e -> {
			stage.setScene(resultScene);
		});
		
		/* button.setOnAction(e -> System.out.println("Hello World!")}); */
		
		
		
		
		VBox inputLayout = new VBox(20);
		
		inputLayout.getChildren().addAll(label1, button);
		
		inputScene = new Scene(inputLayout, 300, 400);
		
		
		Label label2 = new Label("Resultat");
		StackPane resultLayout = new StackPane();
		resultLayout.getChildren().add(label2);
		resultScene = new Scene(resultLayout, 300, 400);
		
		stage.setResizable(false);
		stage.setScene(inputScene);
		stage.show();
	}
}
