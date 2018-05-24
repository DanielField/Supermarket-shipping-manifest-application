/**
 * 
 */
package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import exception.InvalidItemException;
import exception.StockException;
import stock.Item;
import stock.ItemStock;
import stock.OrdinaryItem;
import stock.Stock;

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
	public void testAddOrdinary() throws InvalidItemException {
		assertEquals(0, stock.stockTotal());
		
		Item apple = new OrdinaryItem(null, 0, 0, 0, 0);
		stock.addNewItem(apple, 300);
		
		assertEquals(300, stock.stockTotal());
	}
	
	/**
	 * Retrieves the ItemStock object in order to use the ID to check whether increaseQuantity works correctly.
	 * 
	 * @throws InvalidItemException 
	 */
	@Test(expected = InvalidItemException.class)
	public void testAddTwoOfTheSameOrdinaryItem() throws InvalidItemException {
		Item apple = new OrdinaryItem(null, 0, 0, 0, 0);
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
	public void testOrdinaryIncreaseQuantity() throws StockException, InvalidItemException {
		Item apple = new OrdinaryItem(null, 0, 0, 0, 0);
		ItemStock is = stock.addNewItem(apple, 300);
		
		stock.increaseQuantity(is.getItemID(), 20);
		assertEquals(320, stock.stockTotal());
	}
	
	/**
	 * @throws StockException
	 * @throws InvalidItemException
	 */
	@Test
	public void testOrdinaryDecreaseQuantity() throws StockException, InvalidItemException {
		Item apple = new OrdinaryItem(null, 0, 0, 0, 0);
		ItemStock is = stock.addNewItem(apple, 300);
		
		stock.decreaseQuantity(is.getItemID(), 200);
		assertEquals(100, stock.stockTotal());
	}
}