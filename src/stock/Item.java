package stock;

import exception.StockException;

/** 
 * An abstract class which represents an item.
 *
 * @author Daniel Field
 */
public abstract class Item {		
	/**
	 * @return
	 */
	public abstract String getName();
	
	/**
	 * @param name
	 * @throws InvalidItemException
	 */
	public abstract void setName(String name) throws StockException;
	
	/**
	 * Get the manufacturing cost of the item.
	 * 
	 * @return Manufacturing cost
	 */
	public abstract double getManufacturingCost();
	
	/**
	 * Set the manufacturing cost of the item.
	 * 
	 * @param manufacturingCost How much the item costs to manufacture.
	 * @throws StockException Throws if cost is less than 0.
	 */
	public abstract void setManufacturingCost(double manufacturingCost) throws StockException;
	
	/**
	 * Get the sell price of the item.
	 * 
	 * @return Sell price
	 */
	public abstract double getSellPrice();
	
	/**
	 * Set the sell price of the item.
	 * 
	 * @param sellPrice
	 * @throws StockException Throws when the price is less than zero.
	 */
	public abstract void setSellPrice(double sellPrice) throws StockException;
	
	/**
	 * Get the reorder point of the item.
	 * 
	 * @return Reorder point
	 */
	public abstract int getReorderPoint();
	
	/**
	 * Set the reorder point of the item.
	 * 
	 * @param reorderPoint
	 * @throws StockException Throws if the reorder point is less than zero.
	 */
	public abstract void setReorderPoint(int reorderPoint) throws StockException;
	
	/**
	 * Get the reorder amount for the item.
	 * 
	 * @return Reorder amount
	 */
	public abstract int getReorderAmount();
	
	/**
	 * Set the reorder amount for the item.
	 * 
	 * @param reorderAmount
	 * @throws StockException Throws if the reorder amount is less than zero.
	 */
	public abstract void setReorderAmount(int reorderAmount) throws StockException;
}