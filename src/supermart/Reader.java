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
import exception.InvalidItemException;
import exception.StockException;
import stock.Item;
import stock.OrdinaryItem;
import stock.PerishableItem;
import stock.Stock;

/**
 * @author Daniel Field
 *
 */
public class Reader {
	/**
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static String[] ReadStoreInfoFromCSV(String file) throws IOException {
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		String[] info = new String[2];
		String line = br.readLine();
		
		if (line != null) {
			info = line.split(",");
		}
		
		br.close();
		return info;
	}
	
	/**
	 * @param file
	 * @return
	 * @throws IOException
	 * @throws InvalidItemException
	 */
	public static Stock ReadItemPropertiesFromCSV(String file) throws IOException, InvalidItemException {
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
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static SaleList ReadSalesFromCSV(String file) throws IOException {
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
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 * @throws NumberFormatException
	 * @throws InvalidItemException
	 * @throws StockException
	 */
	public static Manifest ReadManifestFromCSV(String file) throws IOException, NumberFormatException, InvalidItemException, StockException {
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
			}
		}
		
		br.close();
		return manifest;
	}
}
