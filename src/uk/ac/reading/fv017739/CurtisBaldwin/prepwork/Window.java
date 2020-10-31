package uk.ac.reading.fv017739.CurtisBaldwin.prepwork;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.Serializable;

/**
 * A class that is used to show how classes are created
 * using a window analogy from MS
 * @author sis05kol
 *
 */
class Window implements Serializable {
	private int width, height;
	private static int counter;
	
	/**
	 * Constructor that counts number of instantiations
	 */
	public Window ( ) {
		counter++;
	}
	
	/**
	 * Prints out number of instantiated objects (Windows) 
	 * @param s The PrintStream which should be used for printing
	 */
	public void printCounter(PrintStream s) {
		/* More correct to use a variable in a MVC "world"
		 * Because now printCounter doesn't specify that we use System.out
		 * it can now be used also for System.err and other PrintStreams
		 */
		if(s != null)
			s.println(counter);
	}
	
	/**
	 * Set the width of the window
	 * @param width
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int changeWindowsWidth(Window w, int width) {
		this.width = width;
		return width;
	}
	
	public static void main(String[] args) {
			//Instantiate a new window and print number of created windows
			Window aWindow = new Window();
			aWindow.printCounter(System.out);
			
			File f = new File("test.data");
			try {
				FileOutputStream fStream = new FileOutputStream(f);
				ObjectOutputStream oStream = new ObjectOutputStream(fStream);
				oStream.writeObject(aWindow);
				oStream.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//Instantiate another window and change the width
			Window anotherWindow = new Window();
			anotherWindow.changeWindowsWidth(aWindow, 500);	
			
			//Print the width
			System.out.println(aWindow.getWidth());
	}
}


