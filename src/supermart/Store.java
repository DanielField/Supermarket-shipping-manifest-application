/**
 * 
 */
package supermart;

import stock.Item;
import stock.ItemStock;
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
	private static Object[][] inventory = null;
	
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
	public void setInventory(Object[][] inventory) {
		Store.inventory = inventory;
	}
	
	/**
	 * @return
	 */
	public Object[][] getInventory() {
		return inventory;
	}
	
	public Object[] getInventoryRow(int i) {
		return inventory[i];
	}
	
	public int inventorySize() {
		return inventory.length;
	}
	
	public void incrementInventoryQuantity(int row, int quantity) {
		inventory[row][1] = (int)inventory[row][1] + quantity;
	}
}
