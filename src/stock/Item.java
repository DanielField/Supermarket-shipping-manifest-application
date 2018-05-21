package stock;

import exception.InvalidItemException;

/** 
 * An item, possessing the following properties:
 *	- Name.
 *	- Manufacturing cost in dollars.
 *	- Sell price in dollars.
 *	- Reorder point.
 *	- Reorder amount.
 *	- Temperature in �C that must be maintained for the item to not perish.
 *
 * @author Daniel Field
 */
public abstract class Item {		
	public abstract String getName();
	
	public abstract void setName(String name) throws InvalidItemException;
	
	public abstract double getManufacturingCost();
	
	public abstract void setManufacturingCost(double manufacturingCost);
	
	public abstract double getSellPrice();
	
	public abstract void setSellPrice(double sellPrice);
	
	public abstract int getReorderPoint();
	
	public abstract void setReorderPoint(int reorderPoint);
	
	public abstract int getReorderAmount();
	
	public abstract void setReorderAmount(int reorderAmount);
}