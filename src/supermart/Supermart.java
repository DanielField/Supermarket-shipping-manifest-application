package supermart;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

import gui.MainPanel;

/**
 * The primary class for the application. This is responsible for setting everything up.
 * 
 * @author Daniel Field
 * @author Allen Basic
 */
public class Supermart {
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
				
				frame.setVisible(true);
				frame.setResizable(true);
				frame.setTitle("SuperMart - Store Information");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				// Centre the window.
				frame.setLocationRelativeTo(null);
				
				DisplayMenuBar(frame);
				
				frame.add(panel);
			}
		});
	}

	/**
	 * Displays the menu bar on the specified JFrame
	 * 
	 * @param frm JFrame that the menu bar will be displayed on.
	 */
	private static void DisplayMenuBar(JFrame frm) {
		JMenuBar menuBar = new JMenuBar();
		
		JMenu file = new JMenu("File");
		
		JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}}
		
		);
		file.add(exit);
		
		menuBar.add(file);
		
		frm.setJMenuBar(menuBar);
	}
}
