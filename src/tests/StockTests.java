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
import stock.PerishableItem;
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
	public void testAddOrdinary() throws StockException, InvalidItemException {
		assertEquals(0, stock.stockTotal());
		
		Item apple = new OrdinaryItem(null, 0, 0, 0, 0);
		stock.addNewItem(apple, 300);
		
		assertEquals(300, stock.stockTotal());
	}
	
	/**
	 * Expected result: The icecream object will be added, with a quantity of 300.
	 * @throws InvalidItemException 
	 */
	@Test
	public void testAddPerishable() throws StockException, InvalidItemException {
		assertEquals(0, stock.stockTotal());
		
		Item icecream = new PerishableItem(null, 0, 0, 0, 0, -12);
		stock.addNewItem(icecream, 40);
		
		assertEquals(40, stock.stockTotal());
	}
	
	/**
	 * Expected result: The apple object will be removed from the stock
	 * @throws StockException
	 * @throws InvalidItemException
	 */
	@Test
	public void testRemoveOrdinary() throws StockException, InvalidItemException {
		Item apple = new OrdinaryItem(null, 0, 0, 0, 0);
		ItemStock is = stock.addNewItem(apple, 300);
		
		assertTrue(stock.contains(is));
		
		stock.removeItem(is.getItemID());	
		
		assertFalse(stock.contains(is));			
	}
	
	/**
	 * Expected result: The ice cream object will be removed from the stock
	 * @throws StockException
	 * @throws InvalidItemException
	 */
	@Test
	public void testRemovePerishable() throws StockException, InvalidItemException {
		Item icecream = new PerishableItem(null, 0, 0, 0, 0, -12);
		ItemStock is = stock.addNewItem(icecream, 300);
		
		assertTrue(stock.contains(is));
		
		stock.removeItem(is.getItemID());	
		
		assertFalse(stock.contains(is));			
	}
	
	/**
	 * Check the quantity of the item to make sure getQuantity method is correct
	 * @throws StockException
	 * @throws InvalidItemException
	 */
	@Test
	public void testOrdinaryQuantity() throws StockException, InvalidItemException {
		Item apple = new OrdinaryItem(null, 0, 0, 0, 0);
		ItemStock is = stock.addNewItem(apple, 300);		
		int stock = is.getQuantity();
		
		assertEquals(300, stock);
	}
	
	/**
	 * Check the quantity of the item to make sure getQuantity method is correct
	 * @throws StockException
	 * @throws InvalidItemException
	 */
	@Test
	public void testPerishableQuantity() throws StockException, InvalidItemException {
		Item icecream = new PerishableItem(null, 0, 0, 0, 0, -12);
		ItemStock is = stock.addNewItem(icecream, 40);		
		int quantity = is.getQuantity();
		
		assertEquals(40, quantity);
	}	
	
	/**
	 * Testing to see if uniqueItemCount Method works
	 * Expected Result: Return two unique items
	 * @throws StockException
	 * @throws InvalidItemException
	 */
	@Test
	public void testUniqueItemCount() throws StockException, InvalidItemException {
		Item icecream = new PerishableItem(null, 0, 0, 0, 0, -12);
		Item apple = new OrdinaryItem(null, 0, 0, 0, 0);
		
		stock.addNewItem(icecream, 40);
		stock.addNewItem(apple, 300);
		
		int count  = stock.uniqueItemCount();
		
		assertEquals(2, count);	
	}
	
	/**
	 * test to see if the sum of all quantities is as expected
	 * by doing this test we see that the stockTotal method in Stock.java is working
	 * @throws StockException
	 * @throws InvalidItemException
	 */
	@Test
	public void testStockTotal() throws StockException, InvalidItemException {
		Item icecream = new PerishableItem(null, 0, 0, 0, 0, -12);
		Item apple = new OrdinaryItem(null, 0, 0, 0, 0);
		
		stock.addNewItem(icecream, 40);
		stock.addNewItem(apple, 300);
		
		int count = stock.stockTotal();
		
		assertEquals(340, count);
	}
	
	/**
	 * Testing the method of retrieving an item through ID
	 * @throws StockException
	 * @throws InvalidItemException
	 */
	@Test
	public void testGetOrdinaryItemByID() throws StockException, InvalidItemException {
		Item apple = new OrdinaryItem(null, 0, 0, 0, 0);
		ItemStock is = stock.addNewItem(apple, 300);	
		
		int id = is.getItemID();
		ItemStock itemstock = stock.getItemStock(id);
		
		assertEquals(is, itemstock);
	}
	/**
	 * Testing the method of retrieving an item by its object
	 * @throws StockException
	 * @throws InvalidItemException
	 */
	@Test
	public void testGetOrdinaryItemByObject() throws StockException, InvalidItemException {
		Item apple = new OrdinaryItem(null, 0, 0, 0, 0);
		ItemStock is = stock.addNewItem(apple, 300);	
		
		Item item = is.getItem();
		ItemStock itemstock = stock.getItemStock(item);
		
		assertEquals(is, itemstock);
	}
	
	/**
	 * Testing the method of retrieving an item by its item name
	 * @throws StockException
	 * @throws InvalidItemException
	 */
	@Test
	public void testGetOrdinaryItemByName() throws StockException, InvalidItemException {
		Item apple = new OrdinaryItem(null, 0, 0, 0, 0);
		ItemStock is = stock.addNewItem(apple, 300);	
		
		String item = is.getItem().getName() ;
		
		assertEquals(item, "icecream");
	}	
	
	//PerishableItem getItembyId, name and object tests
	/**
	 * Testing the method of retrieving an item through ID
	 * @throws StockException
	 * @throws InvalidItemException
	 */
	@Test
	public void testGetPerishableItemByID() throws StockException, InvalidItemException {
		Item icecream = new PerishableItem(null, 0, 0, 0, 0, -12);
		ItemStock is = stock.addNewItem(icecream, 40);	
		
		int id = is.getItemID();
		ItemStock itemstock = stock.getItemStock(id);
		
		assertEquals(is, itemstock);
	}
	/**
	 * Testing the method of retrieving an item by its object
	 * @throws StockException
	 * @throws InvalidItemException
	 */
	@Test
	public void testGetPerishableItemByObject() throws StockException, InvalidItemException {
		Item icecream = new PerishableItem(null, 0, 0, 0, 0, -12);
		ItemStock is = stock.addNewItem(icecream, 40);	
		
		Item item = is.getItem();
		ItemStock itemstock = stock.getItemStock(item);
		
		assertEquals(is, itemstock);
	}
	
	/**
	 * Testing the method of retrieving an item by its item name
	 * @throws StockException
	 * @throws InvalidItemException
	 */
	@Test
	public void testGetPerishableItemByName() throws StockException, InvalidItemException {
		Item icecream = new PerishableItem("icecream", 0, 0, 0, 0, -12);
		ItemStock is = stock.addNewItem(icecream, 40);	
		
		String item = is.getItem().getName() ;
		
		assertEquals(item, "icecream");
	}	
	//end PerishableItem getItembyId, name and object tests
	
	
	/**
	 * Expected result: Throw an exception since the object we are trying to add is null
	 * @throws StockException
	 * @throws InvalidItemException
	 */
	@Test (expected = StockException.class)
	public void testAddNullOrdinary() throws StockException, InvalidItemException {
		stock.addNewItem(null, 0);
	}
	
	/**
	 * Expected result: Throw an exception since the object we are trying to add is null
	 * @throws StockException
	 * @throws InvalidItemException
	 */
	@Test (expected = StockException.class)
	public void testAddNullPerishable() throws StockException, InvalidItemException {
		stock.addNewItem(null, 0);
	}
	
	/**
	 * Expected Result: Throw an exception for trying to add two of same objects
	 * Increase Quantity method should be used to add more of an item
	 * Add method used to add a new item to Stock
	 * @throws StockException
	 * @throws InvalidItemException 
	 */
	@Test(expected = InvalidItemException.class)
	public void testAddTwoOfTheSameOrdinaryItem() throws StockException, InvalidItemException {
		Item apple = new OrdinaryItem(null, 0, 0, 0, 0);
		stock.addNewItem(apple, 300);
		stock.addNewItem(apple, 300);
	}
	
	/**
	 * Expected Result: Throw an exception for trying to add two of same objects
	 * Increase Quantity method should be used to add more of an item
	 * Add method used to add a new item to Stock
	 * @throws StockException
	 * @throws InvalidItemException 
	 */
	@Test(expected = InvalidItemException.class)
	public void testAddTwoOfTheSamePerishableItem() throws StockException, InvalidItemException {
		Item icecream = new PerishableItem(null, 0, 0, 0, 0, -12);
		stock.addNewItem(icecream, 40);
		stock.addNewItem(icecream, 40);
	}
	
	//OrdinaryItem increaseQuantity tests
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
	
	@Test
	public void testOrdinaryIncreaseQuantityWrong() throws StockException, InvalidItemException {
		Item apple = new OrdinaryItem(null, 0, 0, 0, 0);
		ItemStock is = stock.addNewItem(apple, 300);
		
		stock.increaseQuantity(is.getItemID(), 20);
		assertNotEquals(20, stock.stockTotal());
	}
	
	@Test (expected = InvalidItemException.class)
	public void testOrdinaryIncreaseQuantityNegative() throws StockException, InvalidItemException {
		Item apple = new OrdinaryItem(null, 0, 0, 0, 0);
		ItemStock is = stock.addNewItem(apple, 300);		
		stock.increaseQuantity(is.getItemID(), -20);
	}
	
	@Test
	public void testOrdinaryIncreaseQuantityZero() throws StockException, InvalidItemException {
		Item apple = new OrdinaryItem(null, 0, 0, 0, 0);
		ItemStock is = stock.addNewItem(apple, 300);
		
		stock.increaseQuantity(is.getItemID(), 0);
		assertEquals(300, stock.stockTotal());
	}
	
	public void testOrdinaryIncreaseQuantityBig() throws StockException, InvalidItemException {
		Item apple = new OrdinaryItem(null, 0, 0, 0, 0);
		ItemStock is = stock.addNewItem(apple, 300);
		
		stock.increaseQuantity(is.getItemID(), 1000000);
		assertEquals(1000300, stock.stockTotal());
	}
	
	//end OrdinaryItem increaseQuantity tests
		
	//PerishableItem increaseQuantity tests
	
	/**
	 * Retrieves the ItemStock object in order to use the ID to check whether increaseQuantity works correctly.
	 * 
	 * @throws StockException Throws exception if the test causes the quantity to be negative.
	 * @throws InvalidItemException Throws if the item already exists.
	 */
	@Test
	public void testPerishableIncreaseQuantity() throws StockException, InvalidItemException {
		Item icecream = new PerishableItem(null, 0, 0, 0, 0, -12);
		ItemStock is = stock.addNewItem(icecream, 40);
		
		stock.increaseQuantity(is.getItemID(), 200);
		assertEquals(240, stock.stockTotal());
	}
	
	@Test
	public void testPerishableIncreaseQuantityWrong() throws StockException, InvalidItemException {
		Item icecream = new PerishableItem(null, 0, 0, 0, 0, -12);
		ItemStock is = stock.addNewItem(icecream, 40);
		
		stock.increaseQuantity(is.getItemID(), 20);
		assertNotEquals(20, stock.stockTotal());
	}
	
	@Test (expected = StockException.class)
	public void testPerishableIncreaseQuantityNegative() throws StockException, InvalidItemException {
		Item icecream = new PerishableItem(null, 0, 0, 0, 0, -12);
		ItemStock is = stock.addNewItem(icecream, 40);		
		stock.increaseQuantity(is.getItemID(), -20);
	}
	
	@Test
	public void testPerishableIncreaseQuantityZero() throws StockException, InvalidItemException {
		Item icecream = new PerishableItem(null, 0, 0, 0, 0, -12);
		ItemStock is = stock.addNewItem(icecream, 40);
		
		stock.increaseQuantity(is.getItemID(), 0);
		assertEquals(40, stock.stockTotal());
	}
	
	public void testPerishableIncreaseQuantityBig() throws StockException, InvalidItemException {
		Item icecream = new PerishableItem(null, 0, 0, 0, 0, -12);
		ItemStock is = stock.addNewItem(icecream, 40);
		
		stock.increaseQuantity(is.getItemID(), 1000000);
		assertEquals(1000040, stock.stockTotal());
	}
	
	//end perishableItem increaseQuantity tests
	
	//OrdinaryItem decreaseQuantity tests
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
		
	@Test
	public void testOrdinaryDecreaseQuantityWrong() throws StockException, InvalidItemException {
		Item apple = new OrdinaryItem(null, 0, 0, 0, 0);
		ItemStock is = stock.addNewItem(apple, 300);
		
		stock.decreaseQuantity(is.getItemID(), 20);
		assertNotEquals(180, stock.stockTotal());
	}
	
	@Test (expected = StockException.class)
	public void testOrdinaryDecreaseQuantityNegative() throws StockException, InvalidItemException {
		Item apple = new OrdinaryItem(null, 0, 0, 0, 0);
		ItemStock is = stock.addNewItem(apple, 300);		
		stock.decreaseQuantity(is.getItemID(), -20);
	}
	
	@Test
	public void testOrdinaryDecreaseQuantityZero() throws StockException, InvalidItemException {
		Item apple = new OrdinaryItem(null, 0, 0, 0, 0);
		ItemStock is = stock.addNewItem(apple, 300);
		
		stock.decreaseQuantity(is.getItemID(), 0);
		assertEquals(300, stock.stockTotal());
	}
	
	@Test (expected = StockException.class)
	public void testOrdinaryDecreaseQuantityBig() throws StockException, InvalidItemException {
		Item apple = new OrdinaryItem(null, 0, 0, 0, 0);
		ItemStock is = stock.addNewItem(apple, 300);	
		stock.decreaseQuantity(is.getItemID(), 1000000);		
	}
	
	//end OrdinaryItem decreaseQuantity tests

	//PerishableItem decreaseQuantity tests
	
	/**
	 * @throws StockException
	 * @throws InvalidItemException
	 */
	@Test
	public void testPerishableDecreaseQuantity() throws StockException, InvalidItemException {
		Item icecream = new PerishableItem(null, 0, 0, 0, 0, -12);
		ItemStock is = stock.addNewItem(icecream, 40);
		
		stock.decreaseQuantity(is.getItemID(), 22);
		assertEquals(18, stock.stockTotal());
	}
		
	@Test
	public void testPerishableDecreaseQuantityWrong() throws StockException, InvalidItemException {
		Item icecream = new PerishableItem(null, 0, 0, 0, 0, -12);
		ItemStock is = stock.addNewItem(icecream, 40);
		
		stock.decreaseQuantity(is.getItemID(), 20);
		assertNotEquals(180, stock.stockTotal());
	}
	
	@Test (expected = StockException.class)
	public void testPerishableDecreaseQuantityNegative() throws StockException, InvalidItemException {
		Item icecream = new PerishableItem(null, 0, 0, 0, 0, -12);
		ItemStock is = stock.addNewItem(icecream, 40);		
		stock.decreaseQuantity(is.getItemID(), -20);
	}
	
	@Test
	public void testPerishableDecreaseQuantityZero() throws StockException, InvalidItemException {
		Item icecream = new PerishableItem(null, 0, 0, 0, 0, -12);
		ItemStock is = stock.addNewItem(icecream, 40);
		
		stock.decreaseQuantity(is.getItemID(), 0);
		assertEquals(40, stock.stockTotal());
	}
	
	@Test (expected = StockException.class)
	public void testPerishableDecreaseQuantityBig() throws StockException, InvalidItemException {
		Item icecream = new PerishableItem(null, 0, 0, 0, 0, -12);
		ItemStock is = stock.addNewItem(icecream, 40);	
		stock.decreaseQuantity(is.getItemID(), 1000000);		
	}

}