/**
 * 
 */
package supermart;

import stock.Stock;

/**
 * Store class which uses the singleton pattern.
 * 
 * @author Daniel Field
 *
 */
public class Store {
	
	private static String name = "";
	private static double capital = 100000;
	private static Stock inventory = new Stock();
	
	protected Store() {}

	private static class StoreHolder {
		private final static Store INSTANCE = new Store();
	}
	
	public static Store getInstance() {
		return StoreHolder.INSTANCE;
	}
	
	public static void setName(String name) {
		Store.name = name;
	}
	
	public static String getName() {
		return name;
	}
	
	public static void setCapital(double capital) {
		Store.capital = capital;
	}
	
	public static double getCapital() {
		return capital;
	}
	
	public static void setInventory(Stock inventory) {
		Store.inventory = inventory;
	}
	
	public static Stock getInventory() {
		return inventory;
	}
}
