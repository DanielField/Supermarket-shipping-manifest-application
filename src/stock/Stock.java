package stock;

import java.util.ArrayList;
import java.util.Iterator;

import exception.InvalidItemException;
import exception.StockException;

/**
 * A collection of items. Can be used for representing store inventory,
 * stock orders, sales logs, and truck cargo
 * 
 * @author Daniel Field 
 */
public class Stock extends ArrayList<ItemStock> {

	// List containing all of the items and their quantities.
	// The arrays are of size 3, containing an item ID, item, and quantity.
	private ArrayList<ItemStock> stock;
	
	/**
	 * Construct the stock class.
	 */
	public Stock() {
		stock = new ArrayList<>();
	}
	
	/**
	 * Check whether the specified item ID is already in use.
	 * 
	 * @param id Specified ID.
	 * @return True if the ID is taken, else false.
	 */
	private boolean IDTaken(int id) {
		for (ItemStock itemStock : stock)
			if (itemStock.getItemID() == id) return true;
		return false;
	}
	
	/**
	 * Check whether the specified item is already in the collection.
	 * 
	 * @param i Specified Item.
	 * @return True if the Item exists, else false.
	 */
	private boolean ItemExists(Item i) {
		for (ItemStock itemStock : stock)
			if (itemStock.getItem() == i) return true;
		return false;
	}
	
	/**
	 * Randomly generate a unique item ID.
	 * 
	 * @return Unique item ID.
	 */
	private int generateID() {
		int id;
		do {
			id = (int) (Math.random() * 100000);
		}
		while(IDTaken(id) == true);
		
		return id;
	}
	
	/**
	 * Add a new item to the collection. This will only work if the item does not exist yet.
	 * This is not to be used for increasing the quantity (increaseQuantity does that).
	 * 
	 * @param i Item to be added.
	 * @param initialQuantity Initial quantity for the item.
	 * @return The newly created ItemStock object.
	 * @throws InvalidItemException Throws when the item already exists.
	 */
	public ItemStock addNewItem(Item i, int initialQuantity) throws InvalidItemException {
		if (ItemExists(i)) {
			throw new InvalidItemException("Item already exists");
		}
		ItemStock is = new ItemStock(generateID(), i, initialQuantity);
		stock.add(is);
		return is;
	}
	
	/**
	 * Remove an item from the collection. This will remove ALL of the stock for this 
	 * item, including the item object itself. Do not use this for decreasing the 
	 * quantity (decreaseQuantity does that).
	 * 
	 * @param itemID ID of the item to be removed.
	 * @return Boolean representing whether the item has been removed.
	 */
	public boolean removeItem(int itemID) {
		for (ItemStock itemStock : stock)
			if (itemStock.getItemID() == itemID)
				return stock.remove(itemStock);
		return false;
	}
	
	/**
	 * Increase the quantity of the specified item.
	 * 
	 * @param itemID ID of the item.
	 * @param amount How much to increase the quantity by.
	 * @return Boolean representing whether the quantity was increased.
	 * @throws StockException Throws if stock is less than zero.
	 */
	public boolean increaseQuantity(int itemID, int amount) throws StockException {
		for (ItemStock itemStock : stock) {
			if (itemStock.getItemID() == itemID) {
				int quantity = itemStock.getQuantity();
				quantity += amount;
				if (quantity >= 0) {
					itemStock.setQuantity(quantity);
					return true;
				} else {
					throw new StockException("Stock cannot be less than zero.");
				}
			}
		}
		return false;
	}
	
	/**
	 * Decrease the quantity of the specified item.
	 * 
	 * @param itemID ID of the item.
	 * @param amount How much to decrease the quantity by.
	 * @return Boolean representing whether the quantity was decreased.
	 * @throws StockException Throws if stock is less than zero.
	 */
	public boolean decreaseQuantity(int itemID, int amount) throws StockException {
		// Add a negative in order to subtract.
		return increaseQuantity(itemID, -amount); 
	}
	
	/**
	 * Get an ItemStock by it's item ID.
	 * 
	 * @param itemID ID of the item.
	 * @return The ItemStock object.
	 * @throws InvalidItemException Throw if the item does not exist.
	 */
	public ItemStock getItemStock(int itemID) throws InvalidItemException {
		for (ItemStock itemStock : stock) {
			if (itemStock.getItemID() == itemID) {
				return itemStock;
			}
		}
		throw new InvalidItemException("Item does not exist.");
	}
	
	/**
	 * Get an ItemStock by it's item object.
	 * 
	 * @param itemID ID of the item.
	 * @return The ItemStock object.
	 * @throws InvalidItemException Throw if the item does not exist.
	 */
	public ItemStock getItemStock(Item item) throws InvalidItemException {
		for (ItemStock itemStock : stock) {
			if (itemStock.getItem() == item) {
				return itemStock;
			}
		}
		throw new InvalidItemException("Item does not exist.");
	}

	/**
	 * Get the number of unique items in the collection.
	 * This does not account for the quantity of each item.
	 * 
	 * @return Returns the number of unique items.
	 */
	public int uniqueItemCount() {
		return stock.size();
	}
	
	/**
	 * Total number of items in stock.
	 * 
	 * @return The sum of the quantities of all of the items.
	 */
	public int stockTotal() {
		int size = 0;
		for (ItemStock itemStock : stock) {
			size += itemStock.getQuantity();
		}
		return size;
	}
	
	/**
	 * Check whether an item is in the stock collection. 
	 * This ignores quantity, so it will return true even if the quantity is zero.
	 * 
	 * @param i Item for which to search.
	 * @return Returns a boolean value.
	 */
	public boolean containsItem(Item i) {
		for (ItemStock is : stock) {
			if (is.getItem() == i)
				return true;
		}
		return false;
	}
	
	/**
	 * Check whether an item is in the stock collection by checking the ID. 
	 * This ignores quantity, so it will return true even if the quantity is zero.
	 * 
	 * @param itemID The ID of the item.
	 * @return Returns a boolean value.
	 */
	public boolean containsItem(int itemID) {
		for (ItemStock is : stock) {
			if (is.getItemID() == itemID)
				return true;
		}
		return false;
	}

	@Override
	public Iterator<ItemStock> iterator() {
		return stock.iterator();
	}

	@Override
	public int size() {
		return stock.size();
	}
}