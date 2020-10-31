/**
 * 
 */
package uk.ac.reading.fv017739.CurtisBaldwin;

/**
 * @author Curtis Baldwin
 *
 */

public class MultiplicationTable {

	/**
	 * @param args
	 */
	private int maxNum;				// up to maxNum*maxNum
	private int[][] TableData;			// 2D array to store these

	
	/**
	 * create table for 1*1 up to maxN*maxN
	 * @param maxN
	 */
	MultiplicationTable (int maxN) {	
		// create array of right size, then call makeTable to fill it
		
	}
	/**
	 * function to populate the table
	 */
	private void makeTable() {
	//write code to populate the table (hint nested for loops)
		for(int i = 1; i <= 10; i++) {

			{  for(int j = 1; j <= 10; j++);
			
	}}
	}
	/**
	 * return string with the table
	 */
	public String toString() {
	String res = "RJMs Multiplication Table"+"\n";	// title for string
		// write code to add data from 2D array to res
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MultiplicationTable mt = new MultiplicationTable(10);
		System.out.print(mt.toString());
	}

}


