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
public class Item {	
	private String name;
	private double manufacturingCost;
	private double sellPrice;
	private int reorderPoint;
	private int reorderAmount;
	private double temperature;
	
	public Item(String name, double manufacturingCost, double sellPrice, int reorderPoint, int reorderAmount) {
		this.name = name;
		this.manufacturingCost = manufacturingCost;
		this.sellPrice = sellPrice;
		this.reorderAmount = reorderAmount;
		this.reorderPoint = reorderPoint;
	}
	
	public Item(String name, double manufacturingCost, double sellPrice, int reorderPoint, int reorderAmount, int temperature) {
		this.name = name;
		this.manufacturingCost = manufacturingCost;
		this.sellPrice = sellPrice;
		this.reorderAmount = reorderAmount;
		this.reorderPoint = reorderPoint;
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