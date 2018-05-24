/**
 * 
 */
package supermart;

/**
 * Sale class that stores a single store sale.
 * 
 * @author Allen Basic
 */
public class Sale {
	private String itemName;
	private int quantity;
	
	/**
	 * Gets the item name.
	 * 
	 * @return item name
	 */
	public String getItemName() {
		return itemName;
	}
	
	/**
	 * Set the item name.
	 * 
	 * @param item name
	 */
	public void setItemName(String item) {
		this.itemName = item;
	}
	
	/**
	 * Get the quantity.
	 * 
	 * @return quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	
	/**
	 * Set the quantity.
	 * 
	 * @param quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
