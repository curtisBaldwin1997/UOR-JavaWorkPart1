/**
 * 
 */
package uk.ac.reading.fv017739.CurtisBaldwin.buildingconsole;

import java.awt.Point;

/**
 * @author Curtis Baldwin
 *
 */
	public class Person {
//private Point Person;  //location of the person 

	
		private Point P; //defining point P
		Person(Point np) {  
			P = np;      // saying point equals n
		}

		public String toString() { //to string for displaying where the person is at with its coordinates 
			return "Person at " + P.getX() + " , " + P.getY(); //getter methods to set the persons location
		}

		public static void main(String[] args) { //no need for testing this in main as simple
		// TODO Auto-generated method stub

		}

	}
