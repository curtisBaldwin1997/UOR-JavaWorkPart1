/**
 * 
 */
package uk.ac.reading.fv017739.CurtisBaldwin;

import javax.swing.JOptionPane;

/**
 * @author Curtis Baldwin
 *
 */
public class Task4 {

	/**
	 * @param args
	 */
	static int countNames(String names) {
		
		int countNames = 1;
	
				  for (int i = 0; i < names.length(); i++) {
						if (names.charAt(i) == ' ')
							countNames++; }
				return countNames;
				  
		
	} 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
			String names = JOptionPane.showInputDialog
					(null, "Please enter list of names with spaces in between");
		int numPeople = countNames(names);
		
		System.out.println("Number of names is " + numPeople);
	}

}
