package uk.ac.reading.fv017739.CurtisBaldwin.prepwork;


import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Annimation extends Application {
	int canvasSize = 512;				// constants for relevant sizes
	double earthOrbitSize = canvasSize / 4;
	double marsOrbitSize = earthOrbitSize * 1.5;
	double sunSize = 80;
	double earthSize = 30;
	double marsSize = 15;
    GraphicsContext gc; 
    Image earth = new Image(getClass().getResourceAsStream("earth.png"));
    Image sun = new Image(getClass().getResourceAsStream("sun.png"));
    Image mars = new Image(getClass().getResourceAsStream("mars.png"));

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
	private void drawSystem (double t) {
		double x = canvasSize/2 + earthOrbitSize * Math.cos(t);	// calculate coordinates of earth
		double y = canvasSize/2 + earthOrbitSize * Math.sin(t);
		double a = canvasSize/2 + marsOrbitSize * Math.cos(t);	// calculate coordinates of earth
		double b = canvasSize/2 + marsOrbitSize * Math.sin(t);	
			// now clear canvas and draw earth and sun
		gc.clearRect(0,  0,  canvasSize,  canvasSize);
		drawIt( earth, x, y, earthSize );
		drawIt( mars, a, b, marsSize);
		drawIt( sun, canvasSize/2, canvasSize/2, sunSize );
		
	}
	
	
	/**
	 * main function ... sets up canvas, menu, buttons and timer
	 */
	@Override
	public void start(Stage stagePrimary) throws Exception {
		stagePrimary.setTitle("Solar System");
		
	    Group root = new Group();					// for group of what is shown
	    Scene scene = new Scene( root );			// put it in a scene
	    stagePrimary.setScene( scene );				// apply the scene to the stage
	 
	    Canvas canvas = new Canvas( canvasSize, canvasSize );
	    							// create canvas onto which animation shown
	    root.getChildren().add( canvas );			// add to root and hence stage
	 
	    gc = canvas.getGraphicsContext2D();
	    								// get context on canvas onto which images put
		// now load images of earth, mars and sun
		// note these should be in package
		
	    final long startNanoTime = System.nanoTime();
		// for animation, note start time

	    new AnimationTimer()			// create timer
	    	{
	    		public void handle(long currentNanoTime) {
	    				// define handle for what do at this time
	    			double t = (currentNanoTime - startNanoTime) / 1000000000.0; 			// calculate time
	    			drawSystem(t);
	    		}
	    	}.start();					// start it
	    
		stagePrimary.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);			// launch the GUI
	}

}