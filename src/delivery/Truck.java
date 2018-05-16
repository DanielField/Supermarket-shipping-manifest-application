package delivery;

import exception.InvalidItemException;
import exception.StockException;
import stock.Item;
import stock.Stock;

/**
 * An abstract class for the two truck types.
 * 
 * @author Daniel Field
 *
 */
public abstract class Truck {
	
	/**
	 * @return Truck cost in dollars.
	 */
	public abstract double getCost();
	
	/**
	 * @return Truck cargo capacity.
	 */
	public abstract int getCapacity();

	public abstract void addToCargo(Stock cargo) throws InvalidItemException, StockException;
	public abstract void addToCargo(Item item, int quantity) throws InvalidItemException, StockException;
	public abstract Stock getCargo();

	public abstract void removeFromCargo(Item item);
	public abstract void removeFromCargo(Item item, int quantity) throws StockException, InvalidItemException;
	public abstract void removeFromCargo(int itemID, int quantity) throws StockException, InvalidItemException;
	
	public abstract int getTotalCargo();
}