/**
 * 
 */
package stock;

import exception.InvalidItemException;

/** 
 * This class extends Item, and defines all of the abstract methods in terms of a perishable item. 
 * This differs from OrdinaryItem because it includes temperature.
 *
 * @author Daniel Field
 * @author Allen Basic
 */
public class PerishableItem extends Item {
	private String name;
	private double manufacturingCost;
	private double sellPrice;
	private int reorderPoint;
	private int reorderAmount;
	private double temperature;
	
	/**
	 * Construct a PerishableItem with default properties.
	 */
	public PerishableItem() {
		name = "";
		manufacturingCost = 0;
		sellPrice = 0;
		reorderAmount = 0;
		reorderPoint = 0;
		temperature = 0;
	}
	
	/**
	 * Construct a PerishableItem with the specified name and the rest of the properties set to default.
	 * 
	 * @param name Name of the item
	 */
	public PerishableItem(String name) {
		this.name = name;
		manufacturingCost = 0;
		sellPrice = 0;
		reorderAmount = 0;
		reorderPoint = 0;
		temperature = 0;
	}
	
	/**
	 * Construct a PerishableItem with the specified properties.
	 * 
	 * @param name Name of the item.
	 * @param manufacturingCost The cost of manufacturing the item.
	 * @param sellPrice The sell price of the item.
	 * @param reorderPoint The reorder point of the item.
	 * @param reorderAmount The amount to reorder when the quantity is below the reorder point.
	 * @param temperature The temperature of the item.
	 */
	public PerishableItem(String name, double manufacturingCost, double sellPrice, int reorderPoint, int reorderAmount,
			int temperature) {
		this.name = name;
		this.manufacturingCost = manufacturingCost;
		this.sellPrice = sellPrice;
		this.reorderPoint = reorderPoint;
		this.reorderAmount = reorderAmount;
		this.temperature = temperature;
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
	
	/**
	 * Get the temperature of the item.
	 * 
	 * @return Temperature of the item.
	 */
	public double getTemperature() {
		return temperature;
	}
	
	/**
	 * Set the safe temperature of the item.
	 * 
	 * @param temperature The specified temperature to set.
	 */
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
}
