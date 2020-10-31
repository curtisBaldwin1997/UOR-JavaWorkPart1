/**
 * 
 */
package uk.ac.reading.fv017739.CurtisBaldwin;

import javax.swing.JOptionPane;

/**
 * @author Curtis Baldwin
 *
 */
public class Task2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String Word = JOptionPane.showInputDialog(null, "Please enter a word");
		int NumberOfS = 0;
		for (int i = 0; i < Word.length(); i++) {
			if (Word.charAt(i) == 's')
				NumberOfS++;
		}
		JOptionPane.showMessageDialog(null, "There are " + NumberOfS + "s's in " + Word);

	}

}
