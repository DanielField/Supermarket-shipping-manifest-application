package delivery;

import exception.DeliveryException;
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
	 * @throws DeliveryException Throws if the cargo is invalid.
	 * @throws StockException 
	 */
	public abstract void addToCargo(Stock cargo) throws DeliveryException, StockException;
	/**
	 * Add the specified item to the cargo with the specified quantity.
	 * 
	 * @param item Item to be added.
	 * @param quantity The quantity of the item.
	 * @throws DeliveryException Throws if the cargo is invalid.
	 * @throws StockException 
	 */
	public abstract void addToCargo(Item item, int quantity) throws DeliveryException, StockException;
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
	 * @throws DeliveryException Thorws if the cargo is invalid.
	 * @throws StockException 
	 */
	public abstract void removeFromCargo(Item item) throws DeliveryException, StockException;
	/**
	 * Remove the specified quantity of an item.
	 * 
	 * @param item Item being removed.
	 * @param quantity Quantity of the item.
	 * @throws DeliveryException Throws if the cargo is invalid.
	 * @throws StockException 
	 */
	public abstract void removeFromCargo(Item item, int quantity) throws DeliveryException, StockException;
	/**
	 * Remove the specified quantity of an item.
	 * 
	 * @param itemID ID of the item being removed.
	 * @param quantity Quantity of the item.
	 * @throws DeliveryException Throws if the cargo is invalid.
	 * @throws StockException 
	 */
	public abstract void removeFromCargo(int itemID, int quantity) throws DeliveryException, StockException;
	
	/**
	 * Get the total amount of cargo on the truck.
	 * 
	 * @return total cargo.
	 */
	public abstract int getTotalCargo();
}