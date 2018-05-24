/**
 * 
 */
package stock;

import exception.InvalidItemException;

/** 
 * This class extends Item, and defines all of the abstract methods in terms of an ordinary non-perishable item.
 *
 * @author Daniel Field
 * @author Allen Basic
 */
public class OrdinaryItem extends Item {
	
	private String name;
	private double manufacturingCost;
	private double sellPrice;
	private int reorderPoint;
	private int reorderAmount;
	
	/**
	 * Construct an OrdinaryItem with default properties.
	 */
	public OrdinaryItem() {
		name = "";
		manufacturingCost = 0;
		sellPrice = 0;
		reorderAmount = 0;
		reorderPoint = 0;
	}
	
	/**
	 * Construct an OrdinaryItem with the specified name, and other properties set to default.
	 * 
	 * @param name
	 */
	public OrdinaryItem(String name) {
		this.name = name;
		manufacturingCost = 0;
		sellPrice = 0;
		reorderAmount = 0;
		reorderPoint = 0;
	}
	
	/**
	 * Construct an OrdinaryIterm with the specified properties.
	 * 
	 * @param name
	 * @param manufacturingCost
	 * @param sellPrice
	 * @param reorderPoint
	 * @param reorderAmount
	 */
	public OrdinaryItem(String name, double manufacturingCost, double sellPrice, int reorderPoint, int reorderAmount) {
		this.name = name;
		this.manufacturingCost = manufacturingCost;
		this.sellPrice = sellPrice;
		this.reorderPoint = reorderPoint;
		this.reorderAmount = reorderAmount;
	}

	/* (non-Javadoc)
	 * @see stock.Item#getName()
	 */
	public String getName() {
		return name;
	}
	
	/* (non-Javadoc)
	 * @see stock.Item#setName(java.lang.String)
	 */
	public void setName(String name) throws InvalidItemException {
		if (name.isEmpty()) {
			throw new InvalidItemException();
		}
		this.name = name;
	}
	
	/* (non-Javadoc)
	 * @see stock.Item#getManufacturingCost()
	 */
	public double getManufacturingCost() {
		return manufacturingCost;
	}
	
	/* (non-Javadoc)
	 * @see stock.Item#setManufacturingCost(double)
	 */
	public void setManufacturingCost(double manufacturingCost) {
		this.manufacturingCost = manufacturingCost;
	}
	
	/* (non-Javadoc)
	 * @see stock.Item#getSellPrice()
	 */
	public double getSellPrice() {
		return sellPrice;
	}
	
	/* (non-Javadoc)
	 * @see stock.Item#setSellPrice(double)
	 */
	public void setSellPrice(double sellPrice) {
		this.sellPrice = sellPrice;
	}
	
	/* (non-Javadoc)
	 * @see stock.Item#getReorderPoint()
	 */
	public int getReorderPoint() {
		return reorderPoint;
	}
	
	/* (non-Javadoc)
	 * @see stock.Item#setReorderPoint(int)
	 */
	public void setReorderPoint(int reorderPoint) {
		this.reorderPoint = reorderPoint;
	}
	
	/* (non-Javadoc)
	 * @see stock.Item#getReorderAmount()
	 */
	public int getReorderAmount() {
		return reorderAmount;
	}
	
	/* (non-Javadoc)
	 * @see stock.Item#setReorderAmount(int)
	 */
	public void setReorderAmount(int reorderAmount) {
		this.reorderAmount = reorderAmount;
	}
}
