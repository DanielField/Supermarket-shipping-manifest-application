/**
 * 
 */
package supermart;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import delivery.Manifest;
import delivery.OrdinaryTruck;
import delivery.RefrigeratedTruck;
import delivery.Truck;
import exception.CSVFormatException;
import exception.DeliveryException;
import exception.StockException;
import sales.Sale;
import sales.SaleList;
import stock.Item;
import stock.OrdinaryItem;
import stock.PerishableItem;
import stock.Stock;

/**
 * This holds all of the methods for reading from a file.
 * 
 * @author Daniel Field
 * @author Allen Basic
 */
public class Reader {
	/**
	 * Reads the store information from the specified file.
	 * 
	 * @param file The file being read.
	 * @return The store information. Array element zero is the name, array element one is the capital.
	 * @throws IOException Throws if there is an issue reading the file.
	 * @throws CSVFormatException Throws when the store information file contains not enough values or too many values.
	 */
	public static String[] ReadStoreInfoFromCSV(String file) throws IOException, CSVFormatException {
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		String[] info = new String[2];
		String line = br.readLine();
		
		if (line != null) {
			info = line.split(",");
			
			if (info.length != 2) {
				br.close();
				throw new CSVFormatException("Expected two values, but got " + line.length());
			}
		}
		
		br.close();
		return info;
	}
	
	/**
	 * Read the specified item properties file.
	 * 
	 * @param file The item properties file.
	 * @return Stock object representing every item in the file.
	 * @throws IOException Throws if there is an error reading the file.
	 */
	public static Stock ReadItemPropertiesFromCSV(String file) throws IOException, StockException {
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		Stock stock = new Stock();
		String line;
		String[] splitLine;
		Item item = null;
		
		while ((line = br.readLine()) != null) {
			splitLine = line.split(",");

			if (splitLine.length == 6) {
				item = new PerishableItem();
				
				item.setName(splitLine[0]);
				item.setManufacturingCost( Double.parseDouble(splitLine[1]) );
				item.setSellPrice( Double.parseDouble(splitLine[2]) );
				item.setReorderPoint( Integer.parseInt(splitLine[3]) );
				item.setReorderAmount( Integer.parseInt(splitLine[4]) );
				
				// Cast item as a perishable item to access temperature setter.
				((PerishableItem)item).setTemperature( Double.parseDouble(splitLine[5]) );
			} else {
				item = new OrdinaryItem();
				
				item.setName(splitLine[0]);
				item.setManufacturingCost( Double.parseDouble(splitLine[1]) );
				item.setSellPrice( Double.parseDouble(splitLine[2]) );
				item.setReorderPoint( Integer.parseInt(splitLine[3]) );
				item.setReorderAmount( Integer.parseInt(splitLine[4]) );
			}
			
			// Initially there will be zero quantity
			stock.addNewItem(item, 0);
		}
		
		br.close();
		return stock;
	}
	
	/**
	 * Reads a sales log from the specified file.
	 * 
	 * @param file The sales log file.
	 * @return SaleList containing the data from the sales log.
	 * @throws IOException Throws if there is an error reading the file.
	 * @throws StockException Throws if the quantity is below zero for an item.
	 * @throws NumberFormatException Throws if the numbers are formatted incorrectly.
	 */
	public static SaleList ReadSalesFromCSV(String file) throws IOException, NumberFormatException, StockException {
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		SaleList list = new SaleList();
		String line;
		String[] splitLine;
		
		while ((line = br.readLine()) != null) {
			splitLine = line.split(",");
			
			Sale sale = new Sale();
			
			sale.setItemName(splitLine[0]);
			sale.setQuantity(Integer.parseInt(splitLine[1]));
			
			list.add(sale);
		}
		
		br.close();
		return list;
	}
	
	/**
	 * Reads the manifest from the specified file.
	 * 
	 * @param file The manifest file.
	 * @return Manifest object representing all of the trucks and their cargo.
	 * @throws IOException Throws if there is an error reading from the file.
	 * @throws NumberFormatException Throws if a number is formated incorrectly.
	 * @throws StockException Throws if there is an issue adding cargo to the truck.
	 * @throws CSVFormatException Throws if the CSV is formatted incorrectly.
	 * @throws DeliveryException Throws if there is an invalid item in the file.
	 */
	public static Manifest ReadManifestFromCSV(String file) throws IOException, NumberFormatException, StockException, CSVFormatException, DeliveryException {
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		Manifest manifest = new Manifest();
		String line;
		String[] splitLine;
		
		// Loop through every line
		while ((line = br.readLine()) != null) {
			if (line.toLowerCase().startsWith(">ordinary")) {
				Truck truck = new OrdinaryTruck();

				// Loop through all of the lines related to this truck
				while ((line = br.readLine()) != null) {
					if (line.startsWith(">") == false) {
						splitLine = line.split(",");
						truck.addToCargo(new OrdinaryItem(splitLine[0]), Integer.parseInt(splitLine[1]));
					}
				}
				manifest.add(truck);
			} else if (line.toLowerCase().startsWith(">refrigerated")){
				Truck truck = new RefrigeratedTruck();

				// Loop through all of the lines related to this truck
				while ((line = br.readLine()) != null) {
					if (line.startsWith(">") == false) {
						splitLine = line.split(",");
						truck.addToCargo(new PerishableItem(splitLine[0]), Integer.parseInt(splitLine[1]));
					}
				}
				manifest.add(truck);
			} else {
				// The CSV has items that do not belong to any trucks.
				br.close();
				throw new CSVFormatException("The CSV has items that do not belong to any trucks.");
			}
		}
		
		br.close();
		return manifest;
	}
}
