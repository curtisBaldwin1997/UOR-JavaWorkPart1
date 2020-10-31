package uk.ac.reading.fv017739.CurtisBaldwin.buildingGUI;

import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;

public abstract class Things implements Serializable {
	/**
	 * Unique serial number when implements Serializable
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Variables in class Things
	 */
	protected Point xy; // Defining point as xy
	protected char col; // Defing colour at char
	protected static int thingsCounter = 0; // Giving things a static counter
	protected int thingsID; // Declaring thingsID as an integer
	protected int size; // Giving things a size to enable extending classes to choose its size.
	protected boolean stopped; // Boolean stopped to set person as moving or not
	protected ArrayList<Point> path; // path it follows .. a series of xy points moves between

	/**
	 * 
	 * @param ip
	 */
	protected Things(Point ip) {
		xy = ip; // Declaring point xy = point ip
		size = 3; // Declaing things size
		col = 'r'; // Declaring colour
		thingsID = thingsCounter++; // Incrementing things ID
		path = new ArrayList<Point>(); // Creating a new path of arraylist point
	}

	/**
	 * set person as being stopped or not
	 * 
	 * @param isStopped
	 */
	public void setStopped(boolean isStopped) {
		stopped = isStopped; // Setting Things as stopped
	}

	/**
	 * Is person stopped
	 * 
	 * @return if so
	 */
	public boolean getStopped() {
		return stopped; // If person is stopped return stopped
	}

	/**
	 * clear the path the person has to follow
	 */
	public void clearPath() {
		path.clear(); // Clear the persons path
	}

	/**
	 * add new xy to path
	 * 
	 * @param xyp
	 *            new position
	 */
	public void setPath(Point xyp) {
		path.add(xyp); // Adding a new path
	}

	/**
	 * get the person's position
	 * 
	 * @return the position
	 */
	public Point getXY() {
		return xy; // Reaturning xy which is the person position
	}

	/**
	 * get x coordinate of person
	 * 
	 * @return x
	 */
	public int getX() {
		return (int) xy.getX(); // decaling the x of xy
	}

	/**
	 * get y coordinate of person
	 * 
	 * @return y
	 */
	public int getY() {
		return (int) xy.getY(); // declaring the y of xy
	}

	/**
	 * set the person's position
	 * 
	 * @param pxy
	 *            new position
	 */
	public void setXY(Point pxy) {
		xy = pxy; // saying xy = pxy
	}

	/**
	 * return the identity of things
	 * 
	 * @return
	 */
	public int getID() {
		return thingsID; // Returning thingsID which is all of the things ID
	}

	/**
	 * shows Things in the given building interface
	 * 
	 * @param bi
	 */
	public void showThings(BuildingGUI bi) {
		bi.showItem((int) xy.getX(), (int) xy.getY(), size, col); // Shows things in the GUI
	}

	/**
	 * 
	 * @return
	 */
	protected String getStrType() {
		return "Things"; // Return string of type things
	}

	/**
	 * Method to show multiple classes position
	 */
	public String toString() {
		return getStrType() + (int) xy.getX() + ", " + (int) xy.getY(); // Getting the available strings such as person
																		// and giving its coordinates to display
	}

	/**
	 * Update method for updating clas things
	 */
	public void update() {

	}

}
