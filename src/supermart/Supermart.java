package supermart;

import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import delivery.Manifest;
import delivery.OrdinaryTruck;
import delivery.RefrigeratedTruck;
import exception.InvalidItemException;
import exception.StockException;
import gui.MainPanel;
import stock.Item;

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
		
//		Manifest m = new Manifest();
//		
//		OrdinaryTruck t1 = new OrdinaryTruck();
//		RefrigeratedTruck t2 = new RefrigeratedTruck();
//		
//		Item i = new Item("Apple", 0.1, 1, 50, 500);
//		Item i2 = new Item("Orange", 0.2, 7, 40, 502);
//		Item i3 = new Item("dacdsvdxzs", 0.15, 14, 540, 5400);
//		Item i4 = new Item("dghsgfvfg", 5, 1, 5, 50);
//		
//		try {
//			t2.addToCargo(i, 20);
//			t2.addToCargo(i2, 352);
//			t1.addToCargo(i3, 2);
//			t1.addToCargo(i4, 3252);
//		} catch (InvalidItemException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (StockException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		m.add(t1);
//		m.add(t2);
//		
//		try {
//			Writer.WriteManifestToCSV("H:\\test.csv", m);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
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
