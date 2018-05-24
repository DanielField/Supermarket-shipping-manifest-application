package stock;

import java.util.ArrayList;

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
	
	/**
	 * Check whether the specified item ID is already in use.
	 * 
	 * @param id Specified ID.
	 * @param stock The stock to searth through.
	 * @return True if the ID is taken, else false.
	 */
	public static boolean IDTaken(int id, ArrayList<ItemStock> stock) {
		for (ItemStock itemStock : stock)
			if (itemStock.getItemID() == id) return true;
		return false;
	}
	
	/**
	 * Randomly generate a unique item ID.
	 * 
	 * @param stock The stock to search through to determine that the ID is unique.
	 * @return Unique item ID.
	 */
	public static int generateID(ArrayList<ItemStock> stock) {
		int id;
		do {
			id = (int) (Math.random() * 100000);
		}
		while(IDTaken(id, stock) == true);
		
		return id;
	}
}