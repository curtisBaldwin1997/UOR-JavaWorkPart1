package uk.ac.reading.fv017739.CurtisBaldwin.buildingconsole;

/**
 * 
 */

import java.util.Random; 
import java.awt.Point;
import java.util.ArrayList;

/**
 * @author Curtis Baldwin
 *
 */
public class Building {
    private int xSize = 10;	// Setting the size of X to 10
	private int ySize = 10;	// Setting the size of Y to 10
	private ArrayList<Room> allRooms;// array of rooms
	private Person person; //Defining person
	private Random ranGen; //Defining random as ranGen
	private int whichRoom; //Defining whichRoom as inty 
	
Building (String first){
	allRooms = new ArrayList<Room>(); // array list created 
	setBuilding(first); 
	}
	
	public void setBuilding(String bS) {
		String[] Space;	
		allRooms.clear(); //array list is emptied
	    Space = bS.split(";"); // splitting the string "bs" by a semi colon ; 
	    String[] buildingSize = Space[0].split(" "); //Splitting the two integers for "11,11" or the x and y coordinate
	    xSize = Integer.parseInt(buildingSize[0]); //transforming the string to int
	    ySize =Integer.parseInt(buildingSize[1]); //transforming the string to int
	    allRooms.add(new Room(Space[1])); //a new room is added
		allRooms.add(new Room(Space[2])); //a new room is added
		allRooms.add(new Room(Space[3])); //a new riim is added
		ranGen = new Random(); 
		person = new Person (getRandomPoint()); //Making the Person be in a random point
		}
	
	public Point getRandomPoint() { //Get random point method
		int randRoom= ranGen.nextInt(allRooms.size()); //Defining randRoom by calling ranGen and selecting all the rooms 
			return allRooms.get(randRoom).getRandomPoint(ranGen); //Returning, Get randRoom and getrandompooint
		}
	
	/* public int whichRoom (Person P) {
		 int ans =  -1;
		    for  ( int roomct = 0; roomct<allRooms.size(); roomct++)                              //each room (use count roomct)
			if  (allRooms.get(roomct).isInRoom(P.getX())) ans = roomct;
		    return ans;
	**/

	
	public String toString()
	{
		String s = "Building size " + xSize +","+ySize + "\n"; //adding the words building size then displaying displaying the x and y coordinate then line break
			for (Room r : allRooms)  //for loop  for all rooms and calling r all rooms
				s=s+r.toString()+ "\n";  //adding r which is allrooms to a tostring function
					s=s+person.toString() + " In Room " + whichRoom + "\n"; //displaying the person with its location, and the room its in
						return s; //returning string s
				}

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Building b = new Building("11 11;0 0 5 5 3 5;6 0 10 10 6 6;0 5 5 10 2 5");  // create 
		System.out.println(b.toString());				// and print

	}

}

