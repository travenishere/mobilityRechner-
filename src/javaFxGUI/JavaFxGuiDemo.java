package javaFxGUI;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import main.Car;

public class JavaFxGuiDemo extends Application {
	
	private Image icon;
	
	int width = 615;
	int height = 320;

	Button button;
	Scene inputScene;

	public JavaFxGuiDemo() {
		
		icon = new Image("file:resources/car.png");
		
	}
	
	public static void main(String[] args) {
		
		launch(args);
		
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		stage.setTitle("Mobility Rechner");
		stage.getIcons().add(icon);
		
		// menu bar
		MenuBar menuBar = new MenuBar();
		Menu fileMenu = new Menu("File");
		MenuItem newItem = new MenuItem("New");
		fileMenu.getItems().addAll(newItem);
		menuBar.getMenus().addAll(fileMenu);
		 
		BorderPane root = new BorderPane();
	    root.setTop(menuBar);
		
		// layout
		GridPane inputLayout = new GridPane();
		root.setCenter(inputLayout);
		
		
		inputLayout.setPadding(new Insets(10, 10, 10, 10));
		inputLayout.setVgap(8);
		inputLayout.setHgap(10);
		
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		
		// start date and time
		Label startDateLabel = new Label("Startdatum");
		GridPane.setConstraints(startDateLabel, 0, 0);
		DatePicker startDatePicker = new DatePicker();
		DatePicker endDatePicker = new DatePicker();
		startDatePicker.setOnAction(e -> {
			LocalDate startDate = startDatePicker.getValue();
			
			LocalDate endDate = endDatePicker.getValue();
			if(endDate == null || endDate.isBefore(startDate)) {
				endDatePicker.setValue(startDate);
			}
			
			System.err.println("Selected date: " + startDate);
		});
		GridPane.setConstraints(startDatePicker, 1, 0);
		
		Label startTimeLabel = new Label("Startzeit");
		GridPane.setConstraints(startTimeLabel, 2, 0);
		TextField startTimeInput = new TextField("");
		GridPane.setConstraints(startTimeInput, 3, 0);
		
		// end date and time
		Label endDateLabel = new Label("Enddatum");
		GridPane.setConstraints(endDateLabel, 0, 1);
		
		endDatePicker.setOnAction(e -> {
			LocalDate date = endDatePicker.getValue();
			System.err.println("Selected date: " + date);
		});
		GridPane.setConstraints(endDatePicker, 1, 1);
		
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
		String[] carTypes = Car.getCategoryNames();
		carTypeInput.getItems().addAll(carTypes);
		GridPane.setConstraints(carTypeInput, 3, 2);
		
		// add to layout
		inputLayout.getChildren().addAll(
				startDateLabel, 
				startDatePicker, 
				startTimeLabel, 
				startTimeInput, 
				endDateLabel,
				endDatePicker,
				endTimeLabel,
				endTimeInput,
				carTypeLabel,
				carTypeInput,
				distanceLabel,
				distanceInput);		

		inputScene = new Scene(root, width, height);
		
		stage.setResizable(false);
		inputScene.getStylesheets().add
		 (JavaFxGuiDemo.class.getResource("style.css").toExternalForm());
		
		stage.setScene(inputScene);
		
		stage.show();
	}
}
