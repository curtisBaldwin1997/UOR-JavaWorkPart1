/**
 * 
 */
package uk.ac.reading.fv017739.CurtisBaldwin.buildingGUI;

/**
 * @author Curtis Baldwin
 *
 */
import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Building implements Serializable {
	/**
	 * Unique serial number when implements Serializable
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The building in which there are various rooms and objects Its size is defined
	 * by xSize,ySize Variables are used for actual rooms
	 */
	private int xSize = 10; // size of building
	private int ySize = 10;
	private ArrayList<Room> allRooms; // array of rooms
	private Random ranGen; // for generating random numbers
	private ArrayList<Things> allThings; // Array of things
	private ArrayList<Person> people;    //Array of people
	private Point finalXY;				//declaring final xy as a point to call in later methods
	private Hoover hoover;				//calling class hoover
	private int occupantsInRoom = 0;	//setting occupant is in room to 0

	/**
	 * Construct a building
	 */
	public Building(String bs) {
		allThings = new ArrayList<Things>(); // creates space for things
		allRooms = new ArrayList<Room>(); // create space for rooms
		people = new ArrayList<Person>();
		ranGen = new Random(); // create object for generating random numbers
		setBuilding(bs); // now set building using string bs
	}

	/**
	 * set up the building, as defined in string
	 * 
	 * @param bS
	 *            of form xS,yS;x1 y1 x2 y2 xd yd ds; etc xS,yS define size, and for
	 *            each room have locations of opposite corners, door and door size
	 */
	public void setBuilding(String bS) {
		allRooms.clear();
		StringSplitter bSME = new StringSplitter(bS, ";"); // split strings by ;
		StringSplitter bSz = new StringSplitter(bSME.getNth(0, "5 5"), " "); // split first by space
		xSize = bSz.getNthInt(0, 5); // get first of the first string, being xsize
		ySize = bSz.getNthInt(1, 5);
		for (int ct = 1; ct < bSME.numElement(); ct++) // remaining strings define rooms
			allRooms.add(new Room(bSME.getNth(ct, ""))); // add each in turn
		allThings.add(new Light(allRooms.get(0).locationLight())); // adding a Light to the arraylist of things
		addPerson(); // add a person to the arraylist things
		addHoover(); // adding hoover to building
	}

	/**
	 * On Building size
	 * 
	 * @return size in x direction of Building
	 */
	public int getXSize() {
		return xSize; // Returning size x of the building
	}

	/**
	 * On Building size
	 * 
	 * @return size in y direction of Building
	 */
	public int getYSize() {
		return ySize; // Returning size y of the building
	}

	/**
	 * set new destination for person and path to it In this version puts person in
	 * random room and sets path from there to room's door
	 * 
	 * @param occupant
	 */
	void setNewRoom(Things occupant) {
		int cRoom = whichRoom(occupant.getXY()); // getting which room the occupant is in
		int dRoom = cRoom; // Declaring desired room equals the current room
		while (dRoom == cRoom)
			dRoom = ranGen.nextInt(allRooms.size()); // get another room randomlt

		occupant.clearPath();
		occupant.setPath(allRooms.get(cRoom).getByDoor(+15)); // position by door
		occupant.setPath(allRooms.get(cRoom).getByDoor(-15)); // moving the person along its path
		occupant.setPath(allRooms.get(cRoom).getByDoor(0)); // moving the person along its path
		occupant.setPath(allRooms.get(dRoom).getByDoor(+15)); // moving the person along its path
		occupant.setPath(allRooms.get(dRoom).getByDoor(-15)); // moving the person along its path
		occupant.setPath(allRooms.get(dRoom).getByDoor(0)); // moving the person along its path
		// occupant.setPath(finalXY);
		occupant.setStopped(false); // say person can move
	}
	
	/**
	 * Method to give the object hoover a path
	 * @param Hoover
	 */
	void setNewRoomHoover(Hoover Hoover) {
		int cRoom = whichRoom(Hoover.getXY()); // getting which room the occupant is in
		int dRoom = cRoom; // Declaring desired room equals the current room

		while (dRoom == cRoom)
			dRoom = ranGen.nextInt(allRooms.size()); // get another room randomlt
		finalXY = allRooms.get(dRoom).getRandom(ranGen);
		Hoover.clearPath();
		Hoover.setPath(allRooms.get(cRoom).getByDoor(+20)); // position by door
		Hoover.setPath(allRooms.get(cRoom).getByDoor(-20)); // moving the person along its path
		Hoover.setPath(allRooms.get(cRoom).getByDoor(0)); // moving the person along its path
		Hoover.setPath(allRooms.get(dRoom).getByDoor(+20)); // moving the person along its path
		Hoover.setPath(allRooms.get(dRoom).getByDoor(-20)); // moving the person along its path
		Hoover.setPath(allRooms.get(dRoom).getByDoor(0)); // moving the person along its path
		Hoover.setPath(finalXY);
		Hoover.setPath(allRooms.get(dRoom).getByDoor(0)); // moving the person along its path
		Hoover.setStopped(false); // say person can move
	}

	public void InRoom() {
		if (personCounter(allRooms.get(0)) > 0) {
			on();
		} else {
			off();
		}
	}

	/**
	 * calculate a random room number
	 * 
	 * @return number in range 0.. number of rooms
	 */
	public int randRoom() {
		return ranGen.nextInt(allRooms.size()); // method to calculate a random room
	}

	/**
	 * create new person and set path for it to follow
	 */
	public void addPerson() {
		Person mike = new Person(allRooms.get(0).locationPerson());
		people.add(mike);
		allThings.add(mike); // Function to use button new person adding

		// unlimited people to array list
	}

	/**
	 * method to remove items from the arraylist
	 */
	public void removePerson() {
		allThings.remove(2); // removing object on the arraylist
	}

	/**
	 * Method to add hoover to building
	 */
	private void addHoover() {
		hoover = new Hoover(allRooms.get(0).getRandom(ranGen)); // create hoover in first room
		setNewRoomHoover(hoover);
	}

	/**
	 * Method to turn light on
	 */

	void on() {
		for (int i = 0; i < allThings.size(); i++) { // For loop to run through array of allThings
			if (allThings.get(i).thingsID == 1000) { // Getting the light of ID 1000
				allThings.get(i).col = 'y'; // if getting the light set colour to yellow
			}
		}
	}

	/**
	 * Method to turn light off
	 */
	void off() {
		for (int i = 0; i < allThings.size(); i++) { // For loop to run through array of allThings
			if (allThings.get(i).thingsID == 1000) { // getting the ID of the light
				allThings.get(i).col = 'k'; // getting the colour in this case black
			}
		}
	}

	private double temp(Room t) {
		int personCounter = personCounter(t);
		double temp = 18 + (personCounter * 0.2);
		return temp;
	}

	/**
	 * Method to count people in room
	 * 
	 * @param r
	 * @return
	 */
	int personCounter(Room r) {
		occupantsInRoom = 0;
		for (int i = 0; i < people.size(); i++) { // for loop to check the amount of people
			Point a = people.get(i).getXY();
			if (r.isInRoom(a) == true) { // checking to see if person is in the room
				occupantsInRoom++;
			}
		}
		return occupantsInRoom; // Returning the occupant in the room
	}

	/**
	 * show all the building's rooms and person in the interface
	 * 
	 * @param bi
	 *            the interface
	 */
	public void showBuilding(BuildingGUI bi) {
		for (Room r : allRooms)
			r.showRoom(bi);
		{ // loop through array of all rooms, displaying each
			for (Things t : allThings)
				t.showThings(bi); // lopp through array of all things, displaying each
			hoover.showHoover(bi);
			InRoom();
		}
	}

	/**
	 * method to update the building Here it just deals with the occupant
	 */
	public void update() {
		for (Things t : allThings) { // For loop of array list of allThins
			if (t.getStopped())
				setNewRoom(t); // if person stops moving then setting it a new room
			// if (t.getStopped()) setNewRoomHoover(t);
			else {
				t.update(); // else update the building
			}
		}
	}

	/**
	 * Method to update the hoover and make it move
	 */
	public void updateHoover() {
		if (hoover.getStopped())
			setNewRoomHoover(hoover); // If hoover gets stopped give it a new room
		else
			hoover.update(); // else update the hoover

	}

	/**
	 * method to determine which room position x,y is in
	 * 
	 * @param xy
	 * @return n, the number of the room or -1 if in corridor
	 */
	public int whichRoom(Point xy) {
		int ans = -1; // defining ans -1
		for (int ct = 0; ct < allRooms.size(); ct++) // initiation for loop retrieving allrooms size
			if (allRooms.get(ct).isInRoom(xy))
				ans = ct; // saying if in room ans = ct
		return ans; // returning ans
	}

	/**
	 * method to return information bout the building as a string
	 */
	public String toString() {
		String s = "Building size " + getXSize() + "," + getYSize() + "\n"; // Displaying the building size
		for (Room r : allRooms) {
			s = s + r.toString() + "\nNumber of people in the room - " + personCounter(r) + "\nTemp of room - "
					+ temp(r) + "\n\n"; // for loop
			// displaying
			// all rooms
		}
		for (Things t : allThings)
			s = s + t.toString() + "\n"; // for loop displaying allThings
		s = s + hoover.toString();
		return s; // Returning s
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Building b = new Building(
				"420 400;10 10 140 60 60 60 10;140 10 240 60 180 60 10;240 10 400 60 320 60 20 ;10 90 120 180 40 90 15;120 90 280 180 160 90 10;280 90 400 180 340 90 10"); // create
																																											// building
		System.out.println(b.toString()); // and print it
	}

}
