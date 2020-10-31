/**
 * 
 */
package uk.ac.reading.fv017739.CurtisBaldwin.buildingconsole;

import java.awt.Point;
import javax.swing.JOptionPane;
import java.util.Random;

/**
 * @author Curtis Baldwin
 *
 */
public class Room {

	
	public static String[] num; //defining num
	public static String A; //defining A
	public static String B; // defining B
	private static int a; // defining a
	private static int b; // defining
	private static Point P; // defining P
	private int[] coords; //defining the coordinates 
	

	public Room(String rstr) {
		StringSplitter S = new StringSplitter(rstr, " "); //Calling the string splitter which splits the string that gets run through it
		coords = S.getIntegers(); //defing coords = S which then uses the string splitter to split up the coordinates 
	}

	public Point getRandomPoint (Random ranGen){ // Method for creating random point within in the room
		return new Point(coords[0] +1 + ranGen.nextInt(coords[2] - coords[0] -2), (coords[1] +1 + ranGen.nextInt(coords[3] - coords[1] -2))); // Doing calculation of X1 +1 + randGen.nextInt X2 - X1 - 2 then repeating this for the Y coordinate 
			                                            
		}
	

	public String toString() { 
		return "Room " + coords[0] + ", " + coords[1] + ", " + coords[2] + ", " + coords[3] + " Door " + coords[4] + ", " + coords[5]; //Displaying the location of the room with the coordinates and the room with its coordinates 
		}

	 private static void getPoint(String instr) { //Method for get point of converting the users input int integer
		 num = instr.split(" "); //splitting by space so when the user enters an input it looks to see if there is a space
		 A = num[0]; //defining B as integer
		 B = num[1]; //defining B as integer
		 a = Integer.parseInt(A); //coverting a into integer
		 b = Integer.parseInt(B); //converting b into integer
	 }

	public boolean isInRoom(Point A) { //method for isInRoom
		P = new Point(a,b); //declaring P = new point which is a and b
		int X = (coords[2]); //int x = coordinate x2
		int Y = ((coords[3])); //int y = coordinate y3
		if ((int) P.getX() < X && (int) P.getY() < Y) { //this is saying that is p.getX is less than X or if P.getY is less than Y
			System.out.println( (int) P.getX() + "," + (int) P.getY() + " is in the room"); // it will then display is in the room adding in the users coordinates 
		}
		else {
			System.out.println( (int) P.getX() + "," + (int) P.getY() + " is not in the room"); //else it will print the users coordinates then say is not in room  
		}
		return true; // Returning a true value
	} 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Room r = new Room("0 0 5 5 0 2"); // create room
		System.out.println(r.toString()); // and print it

		String userIn = JOptionPane.showInputDialog //This is used by saying that string userIn which is the name of the string = JOptionPane.showInputDialog so then a user can input
		(null, "please enter two coordinates one X and one Y separated by a space");	// Returning a null value and displayig the appropriate text
		
		getPoint(userIn); //calling the getPoint function adding in the userIns input
		r.isInRoom(P); //Checking to see if P is in room r
		
				}
		
	}
		
	

	
