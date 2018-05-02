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
public class OrdinaryTruck extends Truck {

	private int capacity = 1000;
	private Stock cargo = new Stock();
	
	/* (non-Javadoc)
	 * @see delivery.Truck#getCost()
	 */
	@Override
	public double getCost() {
		// 750 + 0.25q
		return (750 + (0.25 * cargo.stockTotal()));
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
		if (cargo.containsItem(item)) {
			ItemStock is = cargo.getItemStock(item);
			cargo.increaseQuantity(is.getItemID(), quantity);
		}
		else cargo.addNewItem(item, quantity);
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