package javaFxGUI;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Class that will display a window with an Option to choose for a User. It will
 * then return the selected option. 
 * @author Michael Yoseph
 *
 */
public class ConfirmBox {
	
	static boolean answer = false;
	
	public static boolean display(String title, String message){ //
		Stage window = new Stage();
		
		//prevents that User can interact with any background Window while this window is being displayed
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(250);
		
		Label label = new Label();
		label.setText(message); 	
		
		Button yesButton = new Button("Yes");
		Button noButton = new Button("No");
		
		yesButton.setOnAction(e->{
			answer = true;
			window.close();
		});
		
		noButton.setOnAction(e->{
			answer = false;
			window.close();
		});
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, yesButton, noButton);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait(); //display window s and before it returns it needs to be closed
		
		return answer;
	}

}
