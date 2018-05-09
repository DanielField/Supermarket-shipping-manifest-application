package gui;

import javax.swing.JPanel;

import supermart.Utils;

/**
 * This is the main panel. All of the other panels go inside this panel.
 * 
 * @author Daniel Field
 * @author Allen Basic
 *
 */
public class MainPanel extends JPanel {
	public MainPanel() {
		initialisePanels();
	}
	
	private void initialisePanels() {
		MenuPanel menu = new MenuPanel();
		ContentPanel content = new ContentPanel();
		InfoPanel info = new InfoPanel();
		
		setLayout(null);
		
		Utils.addComponents(this, menu, content, info);
	}
}
