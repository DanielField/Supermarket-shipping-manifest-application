package delivery;

import exception.InvalidItemException;
import exception.StockException;
import stock.Item;
import stock.Stock;

/**
 * An abstract class for the two truck types.
 * 
 * @author Daniel Field
 * @author Allen Basic
 */
public abstract class Truck {
	
	/**
	 * Get the cost.
	 * 
	 * @return Truck cost in dollars.
	 */
	public abstract double getCost();
	
	/**
	 * Get the maximum capacity.
	 * 
	 * @return Truck cargo capacity.
	 */
	public abstract int getCapacity();

	/**
	 * Add the specified stock to the cargo.
	 * 
	 * @param cargo Items to be added.
	 * @throws InvalidItemException Throws if an item is invalid.
	 * @throws StockException Throws if the cargo is invalid.
	 */
	public abstract void addToCargo(Stock cargo) throws InvalidItemException, StockException;
	/**
	 * Add the specified item to the cargo with the specified quantity.
	 * 
	 * @param item Item to be added.
	 * @param quantity The quantity of the item.
	 * @throws InvalidItemException Throws if the item is invalid.
	 * @throws StockException Throws if the cargo is invalid.
	 */
	public abstract void addToCargo(Item item, int quantity) throws InvalidItemException, StockException;
	/**
	 * Get the cargo as a Stock object.
	 * 
	 * @return Cargo
	 */
	public abstract Stock getCargo();

	/**
	 * Remove the specified item from the cargo.
	 * 
	 * @param item item to be removed.
	 */
	public abstract void removeFromCargo(Item item) throws InvalidItemException;
	/**
	 * Remove the specified quantity of an item.
	 * 
	 * @param item Item being removed.
	 * @param quantity Quantity of the item.
	 * @throws StockException Throws if the cargo is invalid.
	 * @throws InvalidItemException Throws if the item is invalid
	 */
	public abstract void removeFromCargo(Item item, int quantity) throws StockException, InvalidItemException;
	/**
	 * Remove the specified quantity of an item.
	 * 
	 * @param itemID ID of the item being removed.
	 * @param quantity Quantity of the item.
	 * @throws StockException Throws if the cargo is invalid.
	 * @throws InvalidItemException Throws if the item is invalid
	 */
	public abstract void removeFromCargo(int itemID, int quantity) throws StockException, InvalidItemException;
	
	/**
	 * Get the total amount of cargo on the truck.
	 * 
	 * @return total cargo.
	 */
	public abstract int getTotalCargo();
}