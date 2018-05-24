/**
 * 
 */
package supermart;

/**
 * Store class which uses the singleton pattern.
 * 
 * @author Daniel Field
 * @author Allen Basic
 */
public class Store {
	
	private static String name = "Supermart";
	private static double capital = 100000;
	private static Object[][] inventory = null;
	
	/**
	 * Construct a store.
	 */
	protected Store() {}

	/**
	 * Private class which holds the store instance.
	 * 
	 * @author Allen Basic
	 *
	 */
	private static class StoreHolder {
		/**
		 * Constant object which holds the only instance of Store.
		 */
		private final static Store INSTANCE = new Store();
	}
	
	/**
	 * Get the instance of Store.
	 * 
	 * @return Instance.
	 */
	public static Store getInstance() {
		return StoreHolder.INSTANCE;
	}
	
	/**
	 * Set the name of the store.
	 * 
	 * @param name
	 */
	public void setName(String name) {
		Store.name = name;
	}
	
	/**
	 * Get the name of the store.
	 * 
	 * @return Store name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Set the capital for the store.
	 * 
	 * @param capital
	 */
	public void setCapital(double capital) {
		Store.capital = capital;
	}
	
	/**
	 * Get the capital for the store.
	 * 
	 * @return Capital
	 */
	public double getCapital() {
		return capital;
	}
	
	/**
	 * Set the inventory for the store.
	 * 
	 * @param inventory
	 */
	public void setInventory(Object[][] inventory) {
		Store.inventory = inventory;
	}
	
	/**
	 * Get the inventory for the store.
	 * 
	 * @return
	 */
	public Object[][] getInventory() {
		return inventory;
	}
	
	/**
	 * Get a specific row from the inventory.
	 * 
	 * @param i Row number
	 * @return Row
	 */
	public Object[] getInventoryRow(int i) {
		return inventory[i];
	}
	
	/**
	 * Get the size of the inventory.
	 * 
	 * @return Inventory row count.
	 */
	public int inventorySize() {
		return inventory.length;
	}
	
	/**
	 * Increments the quantity of the specified row in the inventory.
	 * 
	 * @param row
	 * @param quantity
	 */
	public void incrementInventoryQuantity(int row, int quantity) {
		inventory[row][1] = (int)inventory[row][1] + quantity;
	}
}
