/**
 * 
 */
package stock;

import exception.InvalidItemException;

/**
 * @author Daniel Field
 *
 */
public class OrdinaryItem extends Item {
	
	private String name;
	private double manufacturingCost;
	private double sellPrice;
	private int reorderPoint;
	private int reorderAmount;
	
	public OrdinaryItem() {
		name = "";
		manufacturingCost = 0;
		sellPrice = 0;
		reorderAmount = 0;
		reorderPoint = 0;
	}
	
	/**
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
}
