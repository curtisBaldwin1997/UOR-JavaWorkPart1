
package uk.ac.reading.fv017739.CurtisBaldwin.prepwork;


import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Animation2 extends Application {
	int canvasSize = 512;				// constants for relevant sizes
	double earthOrbitSize = canvasSize / 4;
	double marsOrbitSize = earthOrbitSize * 1.5;
	double sunSize = 80;
	double earthSize = 30;
	double marsSize = 15;
	private VBox rtPane;
	private AnimationTimer timer;
    GraphicsContext gc; 
    Image earth = new Image(getClass().getResourceAsStream("earth.png"));
    Image sun = new Image(getClass().getResourceAsStream("sun.png"));
    Image mars = new Image(getClass().getResourceAsStream("mars.png"));

	 /**
	  * Function to show a message, 
	  * @param TStr		title of message block
	  * @param CStr		content of message
	  */
	private void showMessage(String TStr, String CStr) {
		    Alert alert = new Alert(AlertType.INFORMATION);
		    alert.setTitle(TStr);
		    alert.setHeaderText(null);
		    alert.setContentText(CStr);

		    alert.showAndWait();
	}
   /**
	 * function to show in a box ABout the programme
	 */
	 private void showAbout() {
		 showMessage("About", "Solar System with earth and mars");
	 }
	    /**
		 * function to show in a box ABout the programme
		 */
		 private void showHelp() {
			 showMessage("Help", "You don't need any help");
		 }
	 
	/**
	 * Function to set up the menu
	 */
	MenuBar setMenu() {
		MenuBar menuBar = new MenuBar();		// create menu

		Menu mHelp = new Menu("Help");			// have entry for help
				// then add sub menus for About and Help
				// add the item and then the action to perform
		MenuItem mAbout = new MenuItem("About");
		mAbout.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent actionEvent) {
           	showAbout();				// show the about message
           }	
		});
		MenuItem miHelp = new MenuItem("Help");
		miHelp.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent actionEvent) {
           	showHelp();
           }	
		});
		mHelp.getItems().addAll(mAbout, miHelp); 	// add submenus to Help
		
				// now add File menu, which here only has Exit
		Menu mFile = new Menu("File");
		MenuItem mExit = new MenuItem("Exit");
		mExit.setOnAction(new EventHandler<ActionEvent>() {
		    public void handle(ActionEvent t) {
		        System.exit(0);						// quit program
		    }
		});
		mFile.getItems().addAll(mExit);
		
		menuBar.getMenus().addAll(mFile, mHelp);	// menu has File and Help
		
		return menuBar;					// return the menu, so can be added
	}
	
	public void drawStatus(double x, double y) {
		rtPane.getChildren().clear();					// clear rtpane
				// now create label
		Label l = new Label("Earth at " + String.format("%.1f", x) + ", " + String.format("%.1f", y));
		rtPane.getChildren().add(l);				// add label to pane	
	}
	
	public void drawStatusOfMars(double a, double b) {
		rtPane.getChildren().clear();					// clear rtpane
					// now create label
		Label label2 = new Label("Mars at " + String.format("%.1f", a) + ", " + String.format("%.1f", b));
		rtPane.getChildren().add(label2);				// add label to pane	
	}
    
    /**
     * drawIt ... draws object defined by given image at position and size
     * @param i
     * @param x
     * @param y
     * @param sz
     */
	public void drawIt (Image i, double x, double y, double sz) {
		gc.drawImage(i, x - sz/2, y - sz/2, sz, sz );
	}
	public void draw (Image i, double a, double b, double sz) {
		gc.drawImage(i, a - sz/2, b - sz/2, sz, sz );
	}
	
	/**
	 * calculate position of Earth at specified angle and then draw system
	 * @param t		angle (time dependent) of Earth
	 */
	private void drawSystem (double x, double y) {
	//	double x = canvasSize/2 + earthOrbitSize * Math.cos(t);	// calculate coordinates of earth
	//	double y = canvasSize/2 + earthOrbitSize * Math.sin(t);
	//	//double a = canvasSize/2 + marsOrbitSize * Math.cos(t);	// calculate coordinates of earth
	//	double b = canvasSize/2 + marsOrbitSize * Math.sin(t);	
			// now clear canvas and draw earth and sun
		gc.clearRect(0,  0,  canvasSize,  canvasSize);
		drawIt( earth, x, y, earthSize );
	//	drawIt( mars, a, b, marsSize);
		drawIt( sun, canvasSize/2, canvasSize/2, sunSize );
		drawStatus(x,y);
	}
	
	/**
	 * calculate position of Earth at specified angle and then draw system
	 * @param t		angle (time dependent) of Earth
	 */
	private void drawSystem(double t) {
		double x = canvasSize/2 + earthOrbitSize * Math.cos(t);	// calc x coord
		double y = canvasSize/2 + earthOrbitSize * Math.sin(t);	// and y
		drawSystem(x,y);									// and draw system
	}
	
	private void drawMars (double m) {
		double a = canvasSize/2 + marsOrbitSize * Math.cos(m);	// calculate coordinates of mars
		double b = canvasSize/2 + marsOrbitSize * Math.sin(m);
		drawIt( mars, a, b, marsSize);
		drawStatusOfMars(a,b);
	}
	
	/**
	 * set up the mouse event handler, so when click on canvas, draw Earth there
	 * @param canvas
	 */
	private void setMouseEvents (Canvas canvas) {
	       canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, 
	    	       new EventHandler<MouseEvent>() {
	    	           @Override
	    	           public void handle(MouseEvent e) {
	    	        	   drawSystem(e.getX(), e.getY());	
	    	        	   		// draw system where mouse clicked
	    	           }
	    	       });
	}
	
	

	private HBox setButtons() {
		
		 Button btnStart = new Button("Start");
		    btnStart.setOnAction(new EventHandler<ActionEvent>() {
		        @Override
		        public void handle(ActionEvent event) {
		        	timer.start();								// whose action is to start the timer
		       }
		    });

		    Button btnStop = new Button("Pause");
		    btnStop.setOnAction(new EventHandler<ActionEvent>() {
		        @Override
		        public void handle(ActionEvent event) {
		           	timer.stop();								// and its action to stop the timer
		       }
		    });
		    HBox hbox = new HBox(new Label("Run: "), btnStart, btnStop);
		             
		    
		    return hbox;
	}
	
	/**
	 * main function ... sets up canvas, menu, buttons and timer
	 */
	@Override
	public void start(Stage stagePrimary) throws Exception {
		stagePrimary.setTitle("Solar System");
		
		 BorderPane bp = new BorderPane(); 			// create border pane
		 
		 bp.setTop(setMenu());						// create menu, add to top
		
	    Group root = new Group();					// for group of what is shown
	//   Scene scene = new Scene( root );			// put it in a scene
	//    stagePrimary.setScene( scene );				// apply the scene to the stage
	 
	    Canvas canvas = new Canvas( canvasSize, canvasSize );
	    							// create canvas onto which animation shown
	    root.getChildren().add( canvas );
	    gc = canvas.getGraphicsContext2D();// add to root and hence stage
	    setMouseEvents(canvas);
	    bp.setCenter(root);
	    
	    rtPane = new VBox();						// set vBox for listing data
	    bp.setRight(rtPane);
	    
	    
	    Scene scene1 = new Scene(bp, canvasSize*1.4, canvasSize*1.2);
	    
	    								// get context on canvas onto which images put
		// now load images of earth, mars and sun
		// note these should be in package
		
	    final long startNanoTime = System.nanoTime();
		// for animation, note start time

	    new AnimationTimer()	{		// create timer
	    		public void handle(long currentNanoTime) {
	    				// define handle for what do at this time
	    			double t = (currentNanoTime - startNanoTime) / 1000000000.0; 	// calculate time
	    			
	    			drawSystem(t);
	    		}
	    	}.start();					// start it
	    
	    	new AnimationTimer()			// create timer
	    	{
	    		public void handle(long currentNanoTime) {
	    				// define handle for what do at this time
	    			double m = (currentNanoTime - startNanoTime) / 2000000000.0; 	// calculate time
	    			
	    			drawMars(m);
	    		}
	    	}.start();		// start it
	    	
	    	 bp.setBottom(setButtons());
	    stagePrimary.setScene(scene1);
		stagePrimary.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);			// launch the GUI
	}

}