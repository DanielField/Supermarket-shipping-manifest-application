package gui;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

/**
 * This is the main panel. All of the other panels go inside this panel.
 * 
 * @author Daniel Field
 * @author Allen Basic
 *
 */
public class MainPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private SpringLayout layout;
	
	public MainPanel() {
		layout = new SpringLayout();
		setLayout(layout);

		InitialiseButtons();
		InitialiseLabels();
	}
	
//	private void initialisePanels() {
//		MenuPanel menu = new MenuPanel();
//		ContentPanel content = new ContentPanel();
//		InfoPanel info = new InfoPanel();
//		
//		setLayout(null);
//		setBackground(Color.BLACK);
//		
//		Components.addComponents(this, menu, content, info);
//	}
	
	private void InitialiseButtons() {
		JButton btnStoreInfo, btnInventory, btnManifest, btnSalesLog;
		
		btnStoreInfo = Components.CreateButton(this, layout, "Store Info", 10, 10);
		btnInventory = Components.CreateButton(this, layout, "Inventory", 10, 40);
		btnManifest = Components.CreateButton(this, layout, "Manifest", 10, 70);
		btnSalesLog = Components.CreateButton(this, layout, "Sales Log", 10, 100);
		
		Components.addComponents(this, btnStoreInfo, btnInventory, btnManifest, btnSalesLog);
	}
	
	private void InitialiseLabels() {
		JLabel lblName = Components.CreateLabel(this, layout, "Store name: Supermart", 150, 10);
		JLabel lblCapital = Components.CreateLabel(this, layout, "Store capital: $0", 150, 40);
		
		Components.addComponents(this, lblName, lblCapital);
	}
}
