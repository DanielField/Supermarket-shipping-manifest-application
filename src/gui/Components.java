/**
 * 
 */
package gui;

import java.awt.Component;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;

/**
 * Class than contains methods for creating various Swing components.
 * 
 * @author Daniel Field
 * @author Allen Basic
 */
public class Components {
	/**
	 * Add the specified components to the specified container. This reduces the number of lines required just for adding all the different components.
	 * 
	 * @param container The container to which the components are added.
	 * @param components The components that are getting added to the container.
	 */
	public static void addComponents(Container container, Component... components) {
		for (Component c : components) {
			container.add(c);
		}
	}
	
	/**
	 * Construct and return a JButton.
	 * 
	 * @param anchor Component to which the JButton is anchored.
	 * @param layout The SpringLayout to which the constraints are applied. (anchors to the anchor component)
	 * @param text The text to be displayed on the JButton.
	 * @param x The west padding of JButton and the anchor.
	 * @param y The north padding of the JButton and the anchor
	 * @return Constructed JButton
	 */
	public static JButton CreateButton(Component anchor, SpringLayout layout, String text, int x, int y) {
		JButton btn = new JButton(text);

		btn.setVisible(true);
		
		layout.putConstraint(SpringLayout.WEST, btn, x, SpringLayout.WEST, anchor);
		layout.putConstraint(SpringLayout.NORTH, btn, y, SpringLayout.NORTH, anchor);
		
		return btn;
	}
	
	/**
	 * Construct and return a JLabel.
	 * 
	 * @param anchor Component to which the JLabel is anchored.
	 * @param layout The SpringLayout to which the constraints are applied. (anchors to the anchor component)
	 * @param text The text to be displayed on the JLabel.
	 * @param x The west padding of JLabel and the anchor.
	 * @param y The north padding of the JLabel and the anchor
	 * @return Constructed JLabel
	 */
	public static JLabel CreateLabel(Component anchor, SpringLayout layout, String text, int x, int y) {
		JLabel lbl = new JLabel(text);
		
		layout.putConstraint(SpringLayout.WEST, lbl, x, SpringLayout.WEST, anchor);
		layout.putConstraint(SpringLayout.NORTH, lbl, y, SpringLayout.NORTH, anchor);
		
		return lbl;
	}

	/**
	 * Construct and return a JTextArea.
	 * 
	 * @param anchor Component to which the JTextArea is anchored.
	 * @param layout The SpringLayout to which the constraints are applied. (anchors to the anchor component)
	 * @param text The text to be displayed on the JTextArea.
	 * @param x The west padding of JTextArea and the anchor.
	 * @param y The north padding of the JTextArea and the anchor
	 * @return Constructed JTextArea
	 */
	public static JTextArea CreateTextArea(Component anchor, SpringLayout layout, String text, int x, int y) {
		JTextArea txt = new JTextArea(text);
		
		layout.putConstraint(SpringLayout.WEST, txt, x, SpringLayout.WEST, anchor);
		layout.putConstraint(SpringLayout.NORTH, txt, y, SpringLayout.NORTH, anchor);
		
		return txt;
	}
}
