/**
 * 
 */
package uk.ac.reading.fv017739.CurtisBaldwin;

import javax.swing.JOptionPane;

/**
 * @author Curtis Baldwin
 *
 */
public class Task3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String First = JOptionPane.showInputDialog(null, "Please enter your first name");

		String Middle = JOptionPane.showInputDialog(null, "Please enter your middle name");

		String Last = JOptionPane.showInputDialog(null, "Please enter your last name");

		JOptionPane.showMessageDialog(null, First.substring(0, 1) + Middle.substring(0, 1) + Last.substring(0, 1));

	}

}
