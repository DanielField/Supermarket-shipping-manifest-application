package delivery;

import exception.InvalidItemException;
import exception.StockException;
import stock.Item;
import stock.ItemStock;
import stock.PerishableItem;
import stock.Stock;

/**
 * Class which extends Truck to create a specific truck for ordinary items.
 * 
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

	/* (non-Javadoc)
	 * @see delivery.Truck#addToCargo(stock.Stock)
	 */
	@Override
	public void addToCargo(Stock cargo) throws InvalidItemException, StockException {
		for (ItemStock is : cargo) {
			addToCargo(is.getItem(), is.getQuantity());
		}
	}

	/* (non-Javadoc)
	 * @see delivery.Truck#addToCargo(stock.Item, int)
	 */
	@Override
	public void addToCargo(Item item, int quantity) throws InvalidItemException, StockException {
		if (item.getClass() == PerishableItem.class)
			throw new InvalidItemException("Perishable goods must not go in a non-refrigerated truck.");
		
		if (cargo.containsItem(item)) {
			ItemStock is = cargo.getItemStock(item);
			cargo.increaseQuantity(is.getItemID(), quantity);
		}
		else cargo.addNewItem(item, quantity);
	}

	/* (non-Javadoc)
	 * @see delivery.Truck#removeFromCargo(stock.Item)
	 */
	@Override
	public void removeFromCargo(Item item) throws InvalidItemException {
		if (cargo.containsItem(item)) {
			cargo.remove(cargo.getItemStock(item));
		}
		else throw new InvalidItemException("Item does not exist.");
	}

	/* (non-Javadoc)
	 * @see delivery.Truck#removeFromCargo(stock.Item, int)
	 */
	@Override
	public void removeFromCargo(Item item, int quantity) throws StockException, InvalidItemException {
		if (cargo.containsItem(item)) {
			ItemStock is = cargo.getItemStock(item);
			cargo.decreaseQuantity(is.getItemID(), quantity);
		}
		else throw new InvalidItemException("Item does not exist.");
	}

	/* (non-Javadoc)
	 * @see delivery.Truck#removeFromCargo(int, int)
	 */
	@Override
	public void removeFromCargo(int itemID, int quantity) throws StockException, InvalidItemException {
		if (cargo.containsItem(itemID)) {
			cargo.decreaseQuantity(itemID, quantity);
		}
		else throw new InvalidItemException("Item does not exist.");
	}

	/* (non-Javadoc)
	 * @see delivery.Truck#getTotalCargo()
	 */
	@Override
	public int getTotalCargo() {
		return cargo.stockTotal();
	}

	/* (non-Javadoc)
	 * @see delivery.Truck#getCargo()
	 */
	@Override
	public Stock getCargo() {
		return cargo;
	}

}