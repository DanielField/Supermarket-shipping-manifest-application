package stock;

/**
 * Store a single item along with it's ID and quantity.
 * 
 * @author Daniel Field
 *
 */
public class ItemStock {

	private int itemID;
	private Item item;
	private int quantity;
	
	/**
	 * Construct an ItemStock instance.
	 * 
	 * @param itemID Specify the item ID.
	 * @param item Specify the item object.
	 * @param quantity Specify the quantity for the item.
	 */
	public ItemStock(int itemID, Item item, int quantity) {
		this.itemID = itemID;
		this.item = item;
		this.quantity = quantity;
	}
	
	/**
	 * @return The item ID.
	 */
	public int getItemID() {
		return itemID;
	}
	
	/**
	 * Set the item ID.
	 * 
	 * @param itemID value to set the item ID.
	 */
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
	
	/**
	 * @return The Item object.
	 */
	public Item getItem() {
		return item;
	}
	
	/**
	 * Set the Item object.
	 * 
	 * @param Item Object to set as the ItemStock object's Item object.
	 */
	public void setItem(Item item) {
		this.item = item;
	}
	
	/**
	 * 
	 * @return The amount of stock for the item.
	 */
	public int getQuantity() {
		return quantity;
	}
	
	/**
	 * Set the amount of stock.
	 * 
	 * @param quantity The amount of stock.
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}