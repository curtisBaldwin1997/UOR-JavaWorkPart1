/**
 * 
 */
package uk.ac.reading.fv017739.CurtisBaldwin.prepwork;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author Curtis Baldwin
 *
 */
public class HelloWorld extends Application {

	/* (non-Javadoc)
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		//set title of the window
		primaryStage.setTitle("Hellow World");
		
		//Create a scene for the window with the text inside 
		Scene scene = new Scene(new Group(new Text(25, 25, "Hellow World")));
		
		//Add scene to the window (underneath the window bar)
		primaryStage.setScene(scene);
		
		//change the width of the window
		primaryStage.setWidth(250);
		
		//change the height of the window
		primaryStage.setHeight(100);
		
		//show the window
		primaryStage.show();
	}
	public static void main(String[] args) {
	
	Application.launch(args);                      //launch the GUI
}
}
