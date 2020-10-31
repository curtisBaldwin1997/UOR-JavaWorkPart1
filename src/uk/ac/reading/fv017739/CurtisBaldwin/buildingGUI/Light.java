package uk.ac.reading.fv017739.CurtisBaldwin.buildingGUI;

import java.awt.Point;
import java.io.Serializable;

public class Light extends Things implements Serializable {
	/**
	 * Unique serial number when implements Serializable
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param ip
	 */
	public Light(Point ip) {
		super(ip);
		size = 5; // Defining the size of the light as 5
		col = 'k'; // Defining colour as Yellow
		thingsID = 1000; // Giving the light an ID of 1000
		// TODO Auto-generated constructor stub
	}

	/**
	 * Returning the light and its information in the building
	 */
	protected String getStrType() {
		return "Light "; // Returning the info about Light
	}

	/**
	 * Update method to update light
	 */

	public void update() {

	}

}
