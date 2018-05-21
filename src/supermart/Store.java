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
	
	private static String name = "Supermart";
	private static double capital = 100000;
	private static Stock inventory = new Stock();
	
	protected Store() {}

	private static class StoreHolder {
		private final static Store INSTANCE = new Store();
	}
	
	public static Store getInstance() {
		return StoreHolder.INSTANCE;
	}
	
	public void setName(String name) {
		Store.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setCapital(double capital) {
		Store.capital = capital;
	}
	
	public double getCapital() {
		return capital;
	}
	
	public void setInventory(Stock inventory) {
		Store.inventory = inventory;
	}
	
	public Stock getInventory() {
		return inventory;
	}
}
