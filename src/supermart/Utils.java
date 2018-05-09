/**
 * 
 */
package supermart;

import java.awt.Component;
import java.awt.Container;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

/**
 * @author n9932496
 *
 */
public class Utils {
	
	public static Border getNewBorder() {
		return BorderFactory.createEmptyBorder(3, 3, 3, 3);
	}
	
	public static void addComponents(Container container, Component... components) {
		for (Component c : components) {
			container.add(c);
		}
	}
}
