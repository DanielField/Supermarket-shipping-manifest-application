/**
 * 
 */
package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Exception.InvalidItemException;
import Exception.StockException;
import Stock.Item;
import Stock.ItemStock;
import Stock.Stock;

/**
 * Test cases for the Stock collection.
 * 
 * @author Allen Basic
 *
 */
public class StockTests {

	Stock stock;
	
	/**
	 * Before each test, instantiate the stock class and store it in the stock object.
	 */
	@Before @Test
	public void testInitialize() {
		stock = new Stock();
	}

	/**
	 * Expected result: The apple object will be added, with a quantity of 300.
	 * @throws InvalidItemException 
	 */
	@Test
	public void testAdd() throws InvalidItemException {
		assertEquals(0, stock.stockTotal());
		
		Item apple = new Item(null, 0, 0, 0, 0);
		stock.addNewItem(apple, 300);
		
		assertEquals(300, stock.stockTotal());
	}
	
	/**
	 * Retrieves the ItemStock object in order to use the ID to check whether increaseQuantity works correctly.
	 * 
	 * @throws InvalidItemException 
	 */
	@Test(expected = InvalidItemException.class)
	public void testAddTwoOfTheSameItem() throws InvalidItemException {
		Item apple = new Item(null, 0, 0, 0, 0);
		stock.addNewItem(apple, 300);
		stock.addNewItem(apple, 300);
	}
	
	/**
	 * Retrieves the ItemStock object in order to use the ID to check whether increaseQuantity works correctly.
	 * 
	 * @throws StockException Throws exception if the test causes the quantity to be negative.
	 * @throws InvalidItemException Throws if the item already exists.
	 */
	@Test
	public void testIncreaseQuantity() throws StockException, InvalidItemException {
		Item apple = new Item(null, 0, 0, 0, 0);
		ItemStock is = stock.addNewItem(apple, 300);
		
		stock.increaseQuantity(is.getItemID(), 20);
		assertEquals(320, stock.stockTotal());
	}
	
	/**
	 * @throws StockException
	 * @throws InvalidItemException
	 */
	@Test
	public void testDecreaseQuantity() throws StockException, InvalidItemException {
		Item apple = new Item(null, 0, 0, 0, 0);
		ItemStock is = stock.addNewItem(apple, 300);
		
		stock.decreaseQuantity(is.getItemID(), 200);
		assertEquals(100, stock.stockTotal());
	}
}