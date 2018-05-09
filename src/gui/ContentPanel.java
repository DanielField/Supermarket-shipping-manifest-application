/**
 * 
 */
package gui;

import java.awt.Color;
import java.awt.Container;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import javafx.scene.layout.Border;
import supermart.Supermart;
import supermart.Utils;

/**
 * @author n9932496
 *
 */
public class ContentPanel extends JPanel {
	public ContentPanel() {
		setLayout(null);
		setSize(Supermart.DEFAULT_W-120, 300);
		setLocation(121, 0);
		setBackground(Color.black);
	}
}
