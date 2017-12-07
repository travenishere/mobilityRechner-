package javaFxGUI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
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
		
		
		// layout
		GridPane inputLayout = new GridPane();
		inputLayout.setPadding(new Insets(10, 10, 10, 10));
		inputLayout.setVgap(8);
		inputLayout.setHgap(10);
		
		// labels
		Label startDateLabel = new Label("Startdatum");
		GridPane.setConstraints(startDateLabel, 0, 0);
		Label startTimeLabel = new Label("Startzeit");
		GridPane.setConstraints(startTimeLabel, 2, 0);
		Label endDateLabel = new Label("Enddatum");
		GridPane.setConstraints(endDateLabel, 0, 1);
		Label endTimeLabel = new Label("Endzeit");
		GridPane.setConstraints(endTimeLabel, 2, 1);
		
		// text inputs
		TextField startDateInput = new TextField("");
		GridPane.setConstraints(startDateInput, 1, 0);
		TextField startTimeInput = new TextField("");
		GridPane.setConstraints(startTimeInput, 3, 0);
		TextField endDateInput = new TextField("");
		GridPane.setConstraints(endDateInput, 1, 1);
		TextField endTimeInput = new TextField("");
		GridPane.setConstraints(endTimeInput, 3, 1);
		
		// buttons
		button = new Button("Berechnen");
		GridPane.setConstraints(button, 3, 2);
		button.setOnAction(e -> {
			stage.setScene(resultScene);
		});
		/* button.setOnAction(e -> System.out.println("Hello World!")}); */
		
		
		inputLayout.getChildren().addAll(
				startDateLabel, 
				startDateInput, 
				startTimeLabel, 
				startTimeInput, 
				endDateLabel,
				endDateInput,
				endTimeLabel,
				endTimeInput,
				button);
		

		inputScene = new Scene(inputLayout, 600, 300);
		
		
		Label label2 = new Label("Resultat");
		StackPane resultLayout = new StackPane();
		resultLayout.getChildren().add(label2);
		resultScene = new Scene(resultLayout, 600, 300);
		
		stage.setResizable(false);
		stage.setScene(inputScene);
		stage.show();
	}
}
