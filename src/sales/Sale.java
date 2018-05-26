/**
 * 
 */
package sales;

import exception.StockException;

/**
 * Sale class that stores a single store sale.
 * 
 * @author Daniel Field
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
	 * @throws StockException Throws if the string length is zero.
	 */
	public void setItemName(String item) throws StockException {
		if (item.length() == 0)
			throw new StockException();
		
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
	 * @throws StockException Throws if the quantity is below one.
	 */
	public void setQuantity(int quantity) throws StockException {
		if (quantity <= 0)
			throw new StockException();
		
		this.quantity = quantity;
	}
}
