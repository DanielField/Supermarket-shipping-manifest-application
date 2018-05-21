package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

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
	
	String status = "";
	JTextArea txtStatus;
	
	JScrollPane spInventory = null;
	JTable tblInventory = null;
	
	public MainPanel() {
		layout = new SpringLayout();
		setLayout(layout);
		
		store = Store.getInstance();
		
		try {
			LoadStoreInformation(Strings.STORE_INFO_CSV);
			status += "Store information loaded into memory.\r\n";
		} catch (IOException e) {
			status += "Unable to load the store information file. Setting the information to default.\\r\\n";
			
		}
		
		try {
			LoadInventory(Strings.ITEM_PROPERTIES_CSV);
			status += "Inventory loaded into memory.\r\n";
		} catch (IOException ioe) {
			status += "Unable to load the inventory.\r\n";
		} catch (InvalidItemException iie) {
			status += "One or more items in the inventory file are invalid.\\r\\n";
		}

		InitialiseLabels();
		InitialiseTables();
		InitialiseButtons();
		InitialiseStatusField();
		
		// This is the default display when the programme is loaded.
		DisplayStoreInformation();
		txtStatus.append("GUI loaded.\r\nDisplaying store information.\r\n");
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
		layout.putConstraint(SpringLayout.EAST, btnStoreInfo, -10, SpringLayout.WEST, spInventory);
		btnStoreInfo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ClearScreen();
				DisplayStoreInformation();
				txtStatus.append("Displaying store information.\r\n");
			}
		});
		
		btnInventory = Components.CreateButton(this, layout, "Inventory", 10, 40);
		layout.putConstraint(SpringLayout.EAST, btnInventory, -10, SpringLayout.WEST, spInventory);
		btnInventory.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ClearScreen();
				DisplayInventory();
				txtStatus.append("Displaying store inventory.\r\n");
			}
		});
		
		btnManifest = Components.CreateButton(this, layout, "Manifest", 10, 70);
		layout.putConstraint(SpringLayout.EAST, btnManifest, -10, SpringLayout.WEST, spInventory);
		btnManifest.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ClearScreen();
				txtStatus.append("Displaying truck manifest.\r\n");
			}
		});
		
		btnSalesLog = Components.CreateButton(this, layout, "Sales Log", 10, 100);
		layout.putConstraint(SpringLayout.EAST, btnSalesLog, -10, SpringLayout.WEST, spInventory);
		btnSalesLog.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ClearScreen();
				txtStatus.append("Displaying store sales logs.\r\n");
			}
		});
		
		// Add the components to this JPanel
		Components.addComponents(this, btnStoreInfo, btnInventory, btnManifest, btnSalesLog);
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
	
	private void InitialiseStatusField() {
		txtStatus = Components.CreateTextArea(this, layout, status, 150, 0);
		txtStatus.setEditable(false);
		
		JScrollPane spStatus = new JScrollPane(txtStatus);
		spStatus.setVisible(true);
		
		txtStatus.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				JScrollBar v = spStatus.getVerticalScrollBar();
				v.setValue(v.getMaximum());
			}
			@Override
			public void removeUpdate(DocumentEvent e) {}
			@Override
			public void changedUpdate(DocumentEvent e) {}
		});
		
		layout.putConstraint(SpringLayout.NORTH, spStatus, 10, SpringLayout.SOUTH, spInventory);
		layout.putConstraint(SpringLayout.WEST, spStatus, 0, SpringLayout.WEST, spInventory);
		layout.putConstraint(SpringLayout.SOUTH, spStatus, -10, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.EAST, spStatus, -10, SpringLayout.EAST, this);
	
		add(spStatus);
	}
	
	/**
	 * Clear the content from the JPanel such as the inventory table, sales log, manifest, or store info.
	 */
	private void ClearScreen() {
		HideInventory();
		HideStoreInformation();
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
