package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpringLayout;

import exception.InvalidItemException;
import stock.Item;
import stock.ItemStock;
import stock.PerishableItem;
import stock.Stock;
import supermart.Reader;
import supermart.Store;
import supermart.Strings;

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
	
	private static Store store = null;
	private static Stock inventory = null;
	
	JLabel lblName, lblCapital;
	JButton btnStoreInfo, btnInventory, btnManifest, btnSalesLog;
	
	JScrollPane spInventory = null;
	JTable tblInventory = null;
	
	public MainPanel() {
		layout = new SpringLayout();
		setLayout(layout);
		
		store = Store.getInstance();
		
		try {
			LoadStoreInformation(Strings.STORE_INFO_CSV);
		} catch (IOException e) {
			DisplayErrorMessage("Unable to load the store information file. Setting the information to default.");
		}
		
		try {
			LoadInventory(Strings.ITEM_PROPERTIES_CSV);
		} catch (IOException ioe) {
			DisplayErrorMessage("Unable to load the inventory.");
		} catch (InvalidItemException iie) {
			DisplayErrorMessage("One or more items in the inventory file are invalid.");
		}

		InitialiseButtons();
		InitialiseLabels();
		InitialiseTables();
		
		// This is the default display when the programme is loaded.
		DisplayStoreInformation();
	}
	
	private void LoadStoreInformation(String file) throws IOException {
		String[] info = Reader.ReadStoreInfoFromCSV(file);
		store.setName(info[0]);
		store.setCapital(Double.parseDouble(info[1]));
	}
	
	private void LoadInventory(String file) throws IOException, InvalidItemException {
		inventory = Reader.ReadItemPropertiesFromCSV(file);
	}
	
	private void InitialiseButtons() {
		btnStoreInfo = Components.CreateButton(this, layout, "Store Info", 10, 10);
		btnStoreInfo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ClearScreen();
				DisplayStoreInformation();
			}
		});
		
		btnInventory = Components.CreateButton(this, layout, "Inventory", 10, 40);
		btnInventory.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ClearScreen();
				DisplayInventory();
			}
		});
		
		btnManifest = Components.CreateButton(this, layout, "Manifest", 10, 70);
		btnManifest.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ClearScreen();
			}
		});
		
		btnSalesLog = Components.CreateButton(this, layout, "Sales Log", 10, 100);
		btnSalesLog.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ClearScreen();
			}
		});
		
		// Add the components to this JPanel
		Components.addComponents(this, btnStoreInfo, btnInventory, btnManifest, btnSalesLog);
	}
	
	/**
	 * Clear the content from the JPanel such as the inventory table, sales log, manifest, or store info.
	 */
	private void ClearScreen() {
		HideInventory();
		HideStoreInformation();
	}
	
	private void InitialiseTables() {
		String[] headings = {"Name", "Quantity", "Manufacturing Cost ($)", "Sell Price ($)", "Reorder Point", "Reorder Amount", "Temperature"};
		
		String[][] inventoryArray = new String[inventory.size()][7];
		
		for (int i = 0; i < inventory.size(); i++) {
			ItemStock is = inventory.get(i);
			Item item = is.getItem();
			int quantity = is.getQuantity();
			
			inventoryArray[i][0] = item.getName();
			inventoryArray[i][1] = Integer.toString(quantity);
			inventoryArray[i][2] = Double.toString( item.getManufacturingCost() );
			inventoryArray[i][3] = Double.toString( item.getSellPrice() );
			inventoryArray[i][4] = Integer.toString( item.getReorderPoint() );
			inventoryArray[i][5] = Integer.toString( item.getReorderAmount() );
			
			if (item.getClass() == PerishableItem.class)
				inventoryArray[i][6] = Double.toString( ((PerishableItem)item).getTemperature() );
		}
		
		tblInventory = new JTable(inventoryArray, headings);
		
		spInventory = new JScrollPane(tblInventory);
		spInventory.setBounds(150, 10, 450, 400);
		spInventory.setVisible(false);
		
		layout.putConstraint(SpringLayout.NORTH, spInventory, 10, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, spInventory, 150, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, spInventory, -10, SpringLayout.EAST, this);
		layout.putConstraint(SpringLayout.SOUTH, spInventory, -150, SpringLayout.SOUTH, this);
		
		add(spInventory);
	}
	
	private void InitialiseLabels() {
		// Initialise labels with default text
		lblName = Components.CreateLabel(this, layout, "Store name: Supermart", 150, 10);
		lblCapital = Components.CreateLabel(this, layout, "Store capital: $100,000.00", 150, 40);
		
		// Add the components to this JPanel
		Components.addComponents(this, lblName, lblCapital);
	}
	
	private void DisplayStoreInformation() {
		lblName.setText(String.format("Store name: %s", store.getName()));
		String capital = FormatDollars(store.getCapital());
		lblCapital.setText(String.format("Store capital: %s", capital));

		lblName.setVisible(true);
		lblCapital.setVisible(true);
	}
	
	private void HideStoreInformation() {
		lblName.setVisible(false);
		lblCapital.setVisible(false);
	}
	
	private void DisplayInventory() {	
		spInventory.setVisible(true);
	}
	
	private void HideInventory() {
		spInventory.setVisible(false);
	}
	
	private void DisplayErrorMessage(String message) {
		JOptionPane.showMessageDialog(this, message, "Application Error", JOptionPane.ERROR_MESSAGE);
	}
	
	private String FormatDollars(double dollars) {
		// Only using two decimal places to match the requirements.
		String strDollars = String.format("%.02f", dollars);
		
		// Loop through every 3rd digit (right to left), inserting a comma.
		// Loop starts at the first spot where a comma will be necessary.
		for (int i = strDollars.length()-6; i > 0; i-= 3) {
			// Split the string in two
			String leftPartition = strDollars.substring(0,i);
			String rightPartition = strDollars.substring(i, strDollars.length());
			
			// re-combine the strings, but with a comma in between.
			strDollars = String.format("%s,%s", leftPartition, rightPartition);
		}
		
		strDollars = "$" + strDollars;
		return strDollars;
	}
}
