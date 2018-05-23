/**
 * 
 */
package supermart;

import java.awt.Component;

import javax.swing.JOptionPane;

/**
 * Class for some helpful methods.
 * 
 * @author Daniel Field
 */
public class Utils {
	/**
	 * Takes a double and formats it in dollars and cents.
	 * 
	 * For example, 1000000.000000, would be converted to $1,000,000.00
	 * 
	 * @param dollars The amount of dollars and cents in double format.
	 * @return A string representing the value in dollars and cents.
	 */
	public static String FormatDollars(double dollars) {
		// Only using two decimal places to match the requirements.
		String strDollars = String.format("%.02f", dollars);
		
		// Loop through every 3rd digit (right to left), inserting a comma.
		// Loop starts at the first spot where a comma will be necessary.
		for (int i = strDollars.length()-6; i > 0; i-= 3) {
			// Split the string in two
			String leftPartition = strDollars.substring(0,i);
			String rightPartition = strDollars.substring(i, strDollars.length());
			
			// re-combine the strings, but with a comma in between.
			strDollars = String.format("%s,%s", leftPartition, rightPartition);
		}
		
		strDollars = "$" + strDollars;
		return strDollars;
	}
	
	/**
	 * Useful method for displaying a pop-up error message.
	 * 
	 * @param parent Determines the frame in which the dialog is displayed.
	 * @param message Text to be displayed.
	 */
	public static void DisplayErrorMessage(Component parent, String message) {
		JOptionPane.showMessageDialog(parent, message, "Application Error", JOptionPane.ERROR_MESSAGE);
	}
	
	/**
	 * Useful method for displaying a general pop-up message.
	 * 
	 * @param parent Determines the frame in which the dialog is displayed.
	 * @param message Text to be displayed.
	 */
	public static void DisplayMessage(Component parent, String message, String caption) {
		JOptionPane.showMessageDialog(parent, message, caption, JOptionPane.INFORMATION_MESSAGE);
	}
}
