/**
 * 
 */
package gui;

import java.awt.Component;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SpringLayout;

/**
 * @author Daniel Field
 *
 */
public class Components {
	public static void addComponents(Container container, Component... components) {
		for (Component c : components) {
			container.add(c);
		}
	}
	
	public static JButton CreateButton(Component anchor, SpringLayout layout, String text, int x, int y) {
		JButton btn = new JButton(text);

		btn.setVisible(true);
		
		layout.putConstraint(SpringLayout.WEST, btn, x, SpringLayout.WEST, anchor);
		layout.putConstraint(SpringLayout.NORTH, btn, y, SpringLayout.NORTH, anchor);
		
		return btn;
	}
	
	public static JLabel CreateLabel(Component contentPane, SpringLayout layout, String text, int x, int y) {
		JLabel lbl = new JLabel(text);
		
		layout.putConstraint(SpringLayout.WEST, lbl, x, SpringLayout.WEST, contentPane);
		layout.putConstraint(SpringLayout.NORTH, lbl, y, SpringLayout.NORTH, contentPane);
		
		return lbl;
	}
}
