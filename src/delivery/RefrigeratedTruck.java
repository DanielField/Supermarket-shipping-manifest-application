/**
 * 
 */
package delivery;

import exception.InvalidItemException;
import exception.StockException;
import stock.Item;
import stock.ItemStock;
import stock.Stock;

/**
 * @author Daniel Field
 *
 */
public class RefrigeratedTruck extends Truck {

	private double temperature; // TODO: Change temperature based on the item that requires the coldest temperature.
	private int capacity = 800;
	private Stock cargo = new Stock();
	
	public RefrigeratedTruck() {
		this.temperature = 0;
	}
	
	public RefrigeratedTruck(double temperature) {
		this.temperature = temperature;
	}
	
	public double getTemperature() {
		return temperature;
	}
	
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	/* (non-Javadoc)
	 * @see delivery.Truck#getCost()
	 */
	@Override
	public double getCost() {
		// 900 + 200 * 0.7^(T/5)
		return (900 + (200 * (Math.pow(0.7, temperature/5))));
	}

	/* (non-Javadoc)
	 * @see delivery.Truck#getCapacity()
	 */
	@Override
	public int getCapacity() {
		return capacity;
	}

	@Override
	public void addToCargo(Stock cargo) throws InvalidItemException, StockException {
		for (ItemStock is : cargo) {
			addToCargo(is.getItem(), is.getQuantity());
		}
	}

	@Override
	public void addToCargo(Item item, int quantity) throws InvalidItemException, StockException {
		if (item.getTemperature() >= -20 && item.getTemperature() <= 10) {
			if (cargo.containsItem(item)) {
				ItemStock is = cargo.getItemStock(item);
				cargo.increaseQuantity(is.getItemID(), quantity);
			}
			else cargo.addNewItem(item, quantity);
		} else throw new InvalidItemException("Item temperature is not valid for this truck.");
	}

	@Override
	public void removeFromCargo(Item item) {
		this.cargo.removeAll(cargo);
	}

	@Override
	public void removeFromCargo(Item item, int quantity) throws StockException, InvalidItemException {
		if (cargo.containsItem(item)) {
			ItemStock is = cargo.getItemStock(item);
			cargo.decreaseQuantity(is.getItemID(), quantity);
		}
		else throw new InvalidItemException("Item does not exist.");
	}

	@Override
	public void removeFromCargo(int itemID, int quantity) throws StockException, InvalidItemException {
		if (cargo.containsItem(itemID)) {
			cargo.decreaseQuantity(itemID, quantity);
		}
		else throw new InvalidItemException("Item does not exist.");
	}

	@Override
	public int getTotalCargo() {
		return cargo.stockTotal();
	}

}