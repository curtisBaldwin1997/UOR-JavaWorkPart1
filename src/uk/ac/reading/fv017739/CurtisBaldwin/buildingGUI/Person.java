package uk.ac.reading.fv017739.CurtisBaldwin.buildingGUI;

import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;

import uk.ac.reading.fv017739.CurtisBaldwin.buildingGUI.Things;

public class Person extends Things implements Serializable {

	/**
	 * Unique serial number when implements Serializable
	 */
	private static final long serialVersionUID = 1L;
	private int check = 0; // setting the variable check to 0
	static int thingsID = 1; // Setting things ID to 1

	/**
	 * create person at the given xy position
	 * 
	 * @param xys
	 *            position
	 * @param is
	 */
	Person(Point xys) {
		super(xys);
		xy = xys; // defining that xy equals xys
		size = 3; // size of person is equal 3
		stopped = true; // by default not moving

	}

	/**
	 * get String info about person from class things
	 * 
	 * @return "Person "
	 */
	protected String getStrType() {
		return "Person "; // returning the info about person
	}

	/**
	 * is person at the specified position?
	 * 
	 * @param pathXY
	 * @return
	 */
	private boolean equalXY(Point pathXY) {
		return ((int) pathXY.getX() == (int) xy.getX()) && ((int) pathXY.getY() == (int) xy.getY()); // checking to see
																										// if person is
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