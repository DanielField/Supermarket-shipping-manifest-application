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
	 * 
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
	 * 
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
	 * @param name
	 * @param manufacturingCost
	 * @param sellPrice
	 * @param reorderPoint
	 * @param reorderAmount
	 * @param temperature
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

	public String getName() {
		return name;
	}
	
	public void setName(String name) throws InvalidItemException {
		if (name.isEmpty()) {
			throw new InvalidItemException();
		}
		this.name = name;
	}
	
	public double getManufacturingCost() {
		return manufacturingCost;
	}
	
	public void setManufacturingCost(double manufacturingCost) {
		this.manufacturingCost = manufacturingCost;
	}
	
	public double getSellPrice() {
		return sellPrice;
	}
	
	public void setSellPrice(double sellPrice) {
		this.sellPrice = sellPrice;
	}
	
	public int getReorderPoint() {
		return reorderPoint;
	}
	
	public void setReorderPoint(int reorderPoint) {
		this.reorderPoint = reorderPoint;
	}
	
	public int getReorderAmount() {
		return reorderAmount;
	}
	
	public void setReorderAmount(int reorderAmount) {
		this.reorderAmount = reorderAmount;
	}
	
	public double getTemperature() {
		return temperature;
	}
	
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
}
