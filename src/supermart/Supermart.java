package supermart;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import gui.MainPanel;

/**
 * The primary class for the application. This is responsible for setting everything up.
 * 
 * @author Daniel Field
 * @author Allen Basic
 */
public class Supermart {

	public static final String APP_NAME = "Supermart";
	public static final int DEFAULT_W = 640, DEFAULT_H = 480;
	
	/**
	 * Programme's entry point.
	 * 
	 * @param args Command line arguments.
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame frame = new JFrame();
				MainPanel panel = new MainPanel();
				
				frame.setSize(DEFAULT_W, DEFAULT_H);
				frame.setContentPane(panel);
				
				frame.setVisible(true);
				frame.setResizable(false);
				frame.setTitle(APP_NAME);
				
				// Centre the window.
				frame.setLocationRelativeTo(null);
			}
		});
	}

}
