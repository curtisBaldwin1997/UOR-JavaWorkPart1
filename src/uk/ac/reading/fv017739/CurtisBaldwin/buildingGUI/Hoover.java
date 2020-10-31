package uk.ac.reading.fv017739.CurtisBaldwin.buildingGUI;

import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;

public class Hoover implements Serializable {
	private static final long serialVersionUID = 1L;
	private int check = 0; // setting the variable check to 0
	private Point xy; // Defining point as xy
	private char col; // Defing colour at char
	private int size; // Giving things a size to enable extending classes to choose its size.
	private boolean stopped; // Boolean stopped to set person as moving or not
	private ArrayList<Point> path; // path it follows .. a series of xy points moves between

	Hoover(Point xys) {
		xy = xys; // defining that xy equals xys
		size = 5; // size of person is equal 3
		col = 'g';
		stopped = true; // by default not moving
		path = new ArrayList<Point>(); // Creating a new arraylist for path
	}

	/**
	 * set Hoover as being stopped or not
	 * 
	 * @param isStopped
	 */
	public void setStopped(boolean isStopped) {
		stopped = isStopped; // Setting hoover as stopped
	}

	/**
	 * Is Hoover stopped
	 * 
	 * @return if so
	 */
	public boolean getStopped() {
		return stopped; // If hoover is stopped return stopped
	}

	/**
	 * clear the path the hoover has to follow
	 */
	public void clearPath() {
		path.clear(); // Clear the hoovers path
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
	 * get the hoover's position
	 * 
	 * @return the position
	 */
	public Point getXY() {
		return xy; // Reaturning xy which is the hoover position
	}

	/**
	 * get x coordinate of hoover
	 * 
	 * @return x
	 */
	public int getX() {
		return (int) xy.getX(); // decaling the x of xy
	}

	/**
	 * get y coordinate of hoover
	 * 
	 * @return y
	 */
	public int getY() {
		return (int) xy.getY(); // declaring the y of xy
	}

	/**
	 * set the hoover's position
	 * 
	 * @param pxy
	 *            new position
	 */
	public void setXY(Point pxy) {
		xy = pxy; // saying xy = pxy
	}

	/**
	 * 
	 * @param bi
	 */
	public void showHoover(BuildingGUI bi) {
		bi.showItem2((int) xy.getX(), (int) xy.getY(), size, col); // Shows Item2 in the GUI
	}

	/**
	 * Method to show multiple classes position
	 */
	public String toString() {
		return getStrType() + (int) xy.getX() + ", " + (int) xy.getY(); // Getting the available strings such as person
																		// and giving its coordinates to display
	}

	/**
	 * get String info about hoover
	 * 
	 * @return "Hoover "
	 */
	protected String getStrType() {
		return "Hoover "; // returning the info about hoover
	}

	/**
	 * 
	 * @param pathXY
	 * @return
	 */
	private boolean equalXY(Point pathXY) {
		return ((int) pathXY.getX() == (int) xy.getX()) && ((int) pathXY.getY() == (int) xy.getY()); // checking to see
																										// if hoover is
																										// at the
																										// correct
																										// position
																										// along the
																										// path
	}

	/**
	 * move one step towards the given position
	 * 
	 * @param pathXY
	 */
	private void moveTowards(Point pathXY) {
		int dx = 0; // amount by which it will move in x .. and y, set to -1, 0 or 1
		int dy = 0;
		if (xy.getX() < pathXY.getX())
			dx = 1;
		else if (xy.getX() > pathXY.getX())
			dx = -1;
		if (xy.getY() < pathXY.getY())
			dy = 1;
		else if (xy.getY() > pathXY.getY())
			dy = -1;
		xy.translate(dx, dy); // now move
	}

	/**
	 * Check the path size, then get the path, then move along the path
	 */
	public void update() {
		if (check == path.size()) {
			check = 0; // check to see if path size is equal to 0 if so do nothing
		} else if (equalXY(path.get(check))) { // get the path then increment check to move through all the paths
			check++;
		} else
			moveTowards(path.get(check)); // loop back around to repeat the paths
	}
}
