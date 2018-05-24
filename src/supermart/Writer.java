/**
 * 
 */
package supermart;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import delivery.Manifest;
import delivery.RefrigeratedTruck;
import delivery.Truck;
import stock.Item;
import stock.ItemStock;
import stock.OrdinaryItem;
import stock.PerishableItem;
import stock.Stock;

/**
 * Class that holds all of the methods for writing to files.
 * 
 * @author Daniel Field
 * @author Allen Basic
 */
public class Writer {
	/**
	 * Create a new file.
	 * 
	 * @param file File being created.
	 * @throws IOException Throws if the method fails to create the new file.
	 */
	public static void CreateNewFile(String file) throws IOException {
		File f = new File(file);
		
		if (!f.exists()) {
			f.createNewFile();
		}
	}
	
	/**
	 * Writes the specified manifest into a comma-delimited file.
	 * 
	 * @param file The CSV file.
	 * @param manifest The manifest being written.
	 * @throws IOException Throws when there is an error writing to the file.
	 */
	public static void WriteManifestToCSV(String file, Manifest manifest) throws IOException {
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		
		bw.write(""); // clear the file
		
		for (int i = 0; i < manifest.size(); i++) {
			Truck truck = manifest.get(i);
			
			if (truck.getClass() == RefrigeratedTruck.class) {
				bw.append(">Refrigerated");
			} else {
				bw.append(">Ordinary");
			}
			
			bw.newLine();
			
			for (ItemStock is : truck.getCargo()) {
				bw.append(String.format("%s,%d", is.getItem().getName(), is.getQuantity()));
				bw.newLine();
			}
		}
		
		bw.close();
	}
	
	/**
	 * Write the specified item properties to a comma-delimited file.
	 * 
	 * @param file File being written to.
	 * @param s The item properties.
	 * @throws IOException Throws if there is an error writing to the file.
	 */
	public static void WriteItemPropertiesToCSV(String file, Stock s) throws IOException {
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		
		bw.write(""); // clear the file
		
		for (int i = 0; i < s.size(); i++) {
			ItemStock is = s.get(i);
			Item item = is.getItem();
			
			if (item.getClass() == OrdinaryItem.class) {
				bw.append(String.format("%s,%f,%f,%d,%d", 
						item.getName(),
						item.getManufacturingCost(),
						item.getSellPrice(),
						item.getReorderPoint(),
						item.getReorderAmount()));
			} else {
				bw.append(String.format("%s,%f,%f,%d,%d,%f", 
						item.getName(),
						item.getManufacturingCost(),
						item.getSellPrice(),
						item.getReorderPoint(),
						item.getReorderAmount(), 
						((PerishableItem)item).getTemperature()));
			}
			
			bw.newLine();
		}
		
		bw.close();
	}
	
	/**
	 * Write a sales log to the specified comma-delimited file.
	 * 
	 * @param file The sales log file being written to.
	 * @param sales The sales being written.
	 * @throws IOException Throws if there is an error writing to the file.
	 */
	public static void WriteSalesLogToCSV(String file, SaleList sales) throws IOException {
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		
		bw.write(""); // clear the file
		
		for (int i = 0; i < sales.size(); i++) {
			Sale sale = sales.getSale(i);
			bw.append(String.format("%s,%d", sale.getItemName(), sale.getQuantity()));
			bw.newLine();
		}
		
		bw.close();
	}
}
