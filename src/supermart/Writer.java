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
 * @author Daniel Field
 *
 */
public class Writer {
	public static void CreateNewFile(String file) throws IOException {
		File f = new File(file);
		
		if (!f.exists()) {
			f.createNewFile();
		}
	}
	
	public static void WriteManifestToCSV(String file, Manifest manifest) throws IOException {
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		
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
	
	public static void WriteItemPropertiesToCSV(String file, Stock s) throws IOException {
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		
		for (int i = 0; i < s.size(); i++) {
			ItemStock is = s.get(i);
			Item item = is.getItem();
			if (item.getClass() == OrdinaryItem.class) {
				bw.append(String.format("%s,%d,%d,%d,%d", 
						item.getName(),
						item.getManufacturingCost(),
						item.getSellPrice(),
						item.getReorderPoint(),
						item.getReorderAmount()));
			} else {
				bw.append(String.format("%s,%d,%d,%d,%d,%d", 
						item.getName(),
						item.getManufacturingCost(),
						item.getSellPrice(),
						item.getReorderPoint(),
						item.getReorderAmount(), 
						((PerishableItem)item).getTemperature()));
			}
		}
	}
	
	//public static void WriteSalesLogToCSV(String file, )
}
