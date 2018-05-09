/**
 * 
 */
package gui;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JPanel;

import supermart.Supermart;

/**
 * @author n9932496
 *
 */
public class InfoPanel extends JPanel {
	public InfoPanel() {
		setLayout(null);
		setSize(Supermart.DEFAULT_W-120, 151);
		setLocation(121, Supermart.DEFAULT_H-179);
		setBackground(Color.red);
	}
}
