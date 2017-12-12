package javaFxGUI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Class for a application GUI
 * Terminology
 * stage = window 
 * @author Michael Yoseph
 *
 */

public class MobilityRechnerGUI extends Application { //implements EventHandler<ActionEvent> { //not needed when anonymus Interclass used
	Stage window;
	Button b1berechne;
	Button b2goScene2;
	Button b3goScene1;
	Button b4alertUser;
	Button b5monthCalc;
	Button b6saveClose;
	Scene scene1, scene2; 
	
	public static void main (String[]args){
		launch(args);
	}
		
	@Override
	public void start(Stage window) throws Exception{
		window.setTitle("Mobility Rechner");
		
		window.setOnCloseRequest(e-> {
			e.consume(); //consuming means, that we going to take over the close request, so we can handle it manually 
			saveClose();	
		});
		
		b1berechne = new Button("Berechne Fahrt");
		b2goScene2 = new Button("Übersicht anzeigen"); 		
		b2goScene2.setOnAction(e -> window.setScene(scene2));
		Label label1 = new Label("Welcome to the first scene"); //Label = static text 
		b3goScene1 = new Button("Zurück"); 		
		b3goScene1.setOnAction(e -> window.setScene(scene1));
		Label label2 = new Label("Übersicht der Kategorien und Preise"); //Label = static text 
		b4alertUser = new Button("Abonnementtyp wählen");
		b4alertUser.setOnAction(e-> AlertBox.display("Abonnementtyp wählen!", "Aktuell noch nicht implementiert"));
		b5monthCalc = new Button("Monatsbrechnung durchführen");
		b5monthCalc.setOnAction(e-> { 
			boolean multCalc = ConfirmBox.display("Monatsrechner", "Monatrechnung erstellen");
			if (multCalc){
				System.out.println("Monatberechnung durchführen");				
			} else {
				System.out.println("Einzelberechnung durchführen");				
			}
		});
		b6saveClose = new Button("Save and exit");
		b6saveClose.setOnAction(e->saveClose());

		
		/////////////////
		// Layouthandling
		/////////////////
		
		// Layout1: Children are laid out in vertical column  
		VBox layout1 = new VBox(20); //20=> 20px being spaced out between children
		layout1.getChildren().addAll(label1, b2goScene2, b4alertUser, b5monthCalc, b6saveClose); //when more than 1 element to add to layout
		scene1 = new Scene( layout1,400,400);
		
		StackPane layout2 = new StackPane(); //doesn't need any parameters 
		layout2.getChildren().addAll(label2, b3goScene1);
		scene2 = new Scene(layout2,300,300); 
		
		/////////////////
		// Buttonhandling 
		/////////////////
		
		//b1berechne.setOnAction(this); //only neede with EventHandler Interface
		
		/** Buttonhandling with anonymus inner class
		//This class will handle the button events 
		b1berechne.setOnAction(new EventHandler<ActionEvent>(){ //anonymus inner class - Advantage, action is defined right next to the button itself
			@Override
			public void handle(ActionEvent event) {
				System.out.println("TEST");
			}
		});
		// Only needed with EventHandler Interface
		*/
		/*
		@Override
		public void handle(ActionEvent event){
			if(event.getSource()==b1berechne){
				System.out.println("Klick");
			}
		}
		*/						
		//Buttonhanlding with Lambdas expression?
		// Only one code line
		//b1berechne.setOnAction(e -> System.out.println("Even simpler that way!")); //e will be treated as an the EvenHandler which only has the handle method
		b1berechne.setOnAction(e -> {
			System.out.println("Codeline1");
			System.out.println("Codeline2");
		}); 		
		window.setScene(scene1); //default Scene that will 
		window.setTitle("Mobilty Rechner");
		window.show();
	}
	
	private void saveClose(){
		boolean answer = ConfirmBox.display("Warnung","Wirklich abbrechen");
		if (answer){
			window.close(); //TODO FIX NULLPOINTER!!!!!!!!!!!!
		}

	}
	

}

	