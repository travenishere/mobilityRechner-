package javaFxGUI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFxGuiDemo extends Application {
	
	int width = 586;
	int height = 320;

	Button button;
	Scene inputScene;
	
	
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
		
		// start date and time
		Label startDateLabel = new Label("Startdatum");
		GridPane.setConstraints(startDateLabel, 0, 0);
		TextField startDateInput = new TextField("");
		GridPane.setConstraints(startDateInput, 1, 0);
		
		Label startTimeLabel = new Label("Startzeit");
		GridPane.setConstraints(startTimeLabel, 2, 0);
		TextField startTimeInput = new TextField("");
		GridPane.setConstraints(startTimeInput, 3, 0);
		
		// end date and time
		Label endDateLabel = new Label("Enddatum");
		GridPane.setConstraints(endDateLabel, 0, 1);
		TextField endDateInput = new TextField("");
		GridPane.setConstraints(endDateInput, 1, 1);
		
		Label endTimeLabel = new Label("Endzeit");
		GridPane.setConstraints(endTimeLabel, 2, 1);
		TextField endTimeInput = new TextField("");
		GridPane.setConstraints(endTimeInput, 3, 1);
		
		// distance
		Label distanceLabel = new Label("Anzahl Kilometer");
		GridPane.setConstraints(distanceLabel, 0, 2);
		TextField distanceInput = new TextField("");
		GridPane.setConstraints(distanceInput, 1, 2);
		
		// car type
		Label carTypeLabel = new Label("Fahrzeugtyp");
		GridPane.setConstraints(carTypeLabel, 2, 2);
		
		ChoiceBox<String> carTypeInput = new ChoiceBox<String>();
		String[] carTypes = {"Typ1", "Typ2", "Typ3"};
		carTypeInput.getItems().addAll(carTypes);
		GridPane.setConstraints(carTypeInput, 3, 2);
		
		// add to layout
		inputLayout.getChildren().addAll(
				startDateLabel, 
				startDateInput, 
				startTimeLabel, 
				startTimeInput, 
				endDateLabel,
				endDateInput,
				endTimeLabel,
				endTimeInput,
				carTypeLabel,
				carTypeInput,
				distanceLabel,
				distanceInput);		

		inputScene = new Scene(inputLayout, width, height);
		
		stage.setResizable(false);
		stage.setScene(inputScene);
		stage.show();
	}
}
