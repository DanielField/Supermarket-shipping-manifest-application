package stock;

import exception.InvalidItemException;

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
	public abstract void setName(String name) throws InvalidItemException;
	
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
	 */
	public abstract void setManufacturingCost(double manufacturingCost);
	
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
	 */
	public abstract void setSellPrice(double sellPrice);
	
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
	 */
	public abstract void setReorderPoint(int reorderPoint);
	
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
	 */
	public abstract void setReorderAmount(int reorderAmount);
}