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
	
	/**
	 * 
	 */
	protected Store() {}

	/**
	 * @author Daniel Field
	 *
	 */
	private static class StoreHolder {
		/**
		 * 
		 */
		private final static Store INSTANCE = new Store();
	}
	
	/**
	 * @return
	 */
	public static Store getInstance() {
		return StoreHolder.INSTANCE;
	}
	
	/**
	 * @param name
	 */
	public void setName(String name) {
		Store.name = name;
	}
	
	/**
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param capital
	 */
	public void setCapital(double capital) {
		Store.capital = capital;
	}
	
	/**
	 * @return
	 */
	public double getCapital() {
		return capital;
	}
	
	/**
	 * @param inventory
	 */
	public void setInventory(Stock inventory) {
		Store.inventory = inventory;
	}
	
	/**
	 * @return
	 */
	public Stock getInventory() {
		return inventory;
	}
}
