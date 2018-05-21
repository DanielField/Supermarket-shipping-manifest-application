/**
 * 
 */
package supermart;

import stock.Item;

/**
 * @author Daniel Field
 *
 */
public class Sale {
	private String itemName;
	private int quantity;
	
	public String getItemName() {
		return itemName;
	}
	
	public void setItemName(String item) {
		this.itemName = item;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
