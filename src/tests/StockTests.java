/**
 * 
 */
package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

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

	@Test
	public void testAddOrdinary() throws StockException {
		assertEquals(0, stock.stockTotal());
		
		Item apple = new OrdinaryItem(null, 0, 0, 0, 0);
		stock.addNewItem(apple, 300);
		
		assertEquals(300, stock.stockTotal());
	}

	@Test
	public void testAddPerishable() throws StockException {
		assertEquals(0, stock.stockTotal());
		
		Item icecream = new PerishableItem(null, 0, 0, 0, 0, -12);
		stock.addNewItem(icecream, 40);
		
		assertEquals(40, stock.stockTotal());
	}
	
	@Test
	public void testRemoveOrdinary() throws StockException {
		Item apple = new OrdinaryItem(null, 0, 0, 0, 0);
		ItemStock is = stock.addNewItem(apple, 300);
		
		assertTrue(stock.contains(is));
		
		stock.removeItem(is.getItemID());	
		
		assertFalse(stock.contains(is));			
	}

	@Test
	public void testRemovePerishable() throws StockException {
		Item icecream = new PerishableItem(null, 0, 0, 0, 0, -12);
		ItemStock is = stock.addNewItem(icecream, 300);
		
		assertTrue(stock.contains(is));
		
		stock.removeItem(is.getItemID());	
		
		assertFalse(stock.contains(is));			
	}

	@Test
	public void testOrdinaryQuantity() throws StockException {
		Item apple = new OrdinaryItem(null, 0, 0, 0, 0);
		ItemStock is = stock.addNewItem(apple, 300);		
		int stock = is.getQuantity();
		
		assertEquals(300, stock);
	}

	@Test
	public void testPerishableQuantity() throws StockException {
		Item icecream = new PerishableItem(null, 0, 0, 0, 0, -12);
		ItemStock is = stock.addNewItem(icecream, 40);		
		int quantity = is.getQuantity();
		
		assertEquals(40, quantity);
	}	

	@Test
	public void testUniqueItemCount() throws StockException {
		Item icecream = new PerishableItem(null, 0, 0, 0, 0, -12);
		Item apple = new OrdinaryItem(null, 0, 0, 0, 0);
		
		stock.addNewItem(icecream, 40);
		stock.addNewItem(apple, 300);
		
		int count  = stock.uniqueItemCount();
		
		assertEquals(2, count);	
	}

	@Test
	public void testStockTotal() throws StockException {
		Item icecream = new PerishableItem(null, 0, 0, 0, 0, -12);
		Item apple = new OrdinaryItem(null, 0, 0, 0, 0);
		
		stock.addNewItem(icecream, 40);
		stock.addNewItem(apple, 300);
		
		int count = stock.stockTotal();
		
		assertEquals(340, count);
	}

	@Test
	public void testGetOrdinaryItemByID() throws StockException {
		Item apple = new OrdinaryItem(null, 0, 0, 0, 0);
		ItemStock is = stock.addNewItem(apple, 300);	
		
		int id = is.getItemID();
		ItemStock itemstock = stock.getItemStock(id);
		
		assertEquals(is, itemstock);
	}

	@Test
	public void testGetOrdinaryItemByObject() throws StockException {
		Item apple = new OrdinaryItem(null, 0, 0, 0, 0);
		ItemStock is = stock.addNewItem(apple, 300);	
		
		Item item = is.getItem();
		ItemStock itemstock = stock.getItemStock(item);
		
		assertEquals(is, itemstock);
	}

	@Test
	public void testGetOrdinaryItemByName() throws StockException {
		Item apple = new OrdinaryItem("icecream", 0, 0, 0, 0);
		ItemStock is = stock.addNewItem(apple, 300);	
		
		String item = is.getItem().getName();
		
		assertEquals(item, "icecream");
	}	
	
	//PerishableItem getItembyId, name and object tests
	@Test
	public void testGetPerishableItemByID() throws StockException {
		Item icecream = new PerishableItem(null, 0, 0, 0, 0, -12);
		ItemStock is = stock.addNewItem(icecream, 40);	
		
		int id = is.getItemID();
		ItemStock itemstock = stock.getItemStock(id);
		
		assertEquals(is, itemstock);
	}

	@Test
	public void testGetPerishableItemByObject() throws StockException {
		Item icecream = new PerishableItem(null, 0, 0, 0, 0, -12);
		ItemStock is = stock.addNewItem(icecream, 40);	
		
		Item item = is.getItem();
		ItemStock itemstock = stock.getItemStock(item);
		
		assertEquals(is, itemstock);
	}

	@Test
	public void testGetPerishableItemByName() throws StockException {
		Item icecream = new PerishableItem("icecream", 0, 0, 0, 0, -12);
		ItemStock is = stock.addNewItem(icecream, 40);	
		
		String item = is.getItem().getName() ;
		
		assertEquals(item, "icecream");
	}	
	//end PerishableItem getItembyId, name and object tests
	
	@Test (expected = StockException.class)
	public void testAddNullOrdinary() throws StockException {
		stock.addNewItem(null, 0);
	}

	@Test (expected = StockException.class)
	public void testAddNullPerishable() throws StockException {
		stock.addNewItem(null, 0);
	}

	@Test(expected = StockException.class)
	public void testAddTwoOfTheSameOrdinaryItem() throws StockException {
		Item apple = new OrdinaryItem(null, 0, 0, 0, 0);
		stock.addNewItem(apple, 300);
		stock.addNewItem(apple, 300);
	}
	
	@Test(expected = StockException.class)
	public void testAddTwoOfTheSamePerishableItem() throws StockException {
		Item icecream = new PerishableItem(null, 0, 0, 0, 0, -12);
		stock.addNewItem(icecream, 40);
		stock.addNewItem(icecream, 40);
	}
	
	//OrdinaryItem increaseQuantity tests
	@Test
	public void testOrdinaryIncreaseQuantity() throws StockException {
		Item apple = new OrdinaryItem(null, 0, 0, 0, 0);
		ItemStock is = stock.addNewItem(apple, 300);
		
		stock.increaseQuantity(is.getItemID(), 20);
		assertEquals(320, stock.stockTotal());
	}
	
	@Test
	public void testOrdinaryIncreaseQuantityWrong() throws StockException {
		Item apple = new OrdinaryItem(null, 0, 0, 0, 0);
		ItemStock is = stock.addNewItem(apple, 300);
		
		stock.increaseQuantity(is.getItemID(), 20);
		assertNotEquals(20, stock.stockTotal());
	}
	
	@Test
	public void testOrdinaryIncreaseQuantityNegative() throws StockException {
		Item apple = new OrdinaryItem(null, 0, 0, 0, 0);
		ItemStock is = stock.addNewItem(apple, 300);		
		stock.increaseQuantity(is.getItemID(), -20);
		
		assertEquals(280, stock.getItemStock(is.getItemID()).getQuantity());
	}
	
	@Test
	public void testOrdinaryIncreaseQuantityZero() throws StockException {
		Item apple = new OrdinaryItem(null, 0, 0, 0, 0);
		ItemStock is = stock.addNewItem(apple, 300);
		
		stock.increaseQuantity(is.getItemID(), 0);
		assertEquals(300, stock.stockTotal());
	}
	
	public void testOrdinaryIncreaseQuantityBig() throws StockException {
		Item apple = new OrdinaryItem(null, 0, 0, 0, 0);
		ItemStock is = stock.addNewItem(apple, 300);
		
		stock.increaseQuantity(is.getItemID(), 1000000);
		assertEquals(1000300, stock.stockTotal());
	}
	
	//end OrdinaryItem increaseQuantity tests
		
	//PerishableItem increaseQuantity tests

	@Test
	public void testPerishableIncreaseQuantity() throws StockException {
		Item icecream = new PerishableItem(null, 0, 0, 0, 0, -12);
		ItemStock is = stock.addNewItem(icecream, 40);
		
		stock.increaseQuantity(is.getItemID(), 200);
		assertEquals(240, stock.stockTotal());
	}
	
	@Test
	public void testPerishableIncreaseQuantityWrong() throws StockException {
		Item icecream = new PerishableItem(null, 0, 0, 0, 0, -12);
		ItemStock is = stock.addNewItem(icecream, 40);
		
		stock.increaseQuantity(is.getItemID(), 20);
		assertNotEquals(20, stock.stockTotal());
	}
	
	@Test
	public void testPerishableIncreaseQuantityNegative() throws StockException {
		Item icecream = new PerishableItem(null, 0, 0, 0, 0, -12);
		ItemStock is = stock.addNewItem(icecream, 40);		
		stock.increaseQuantity(is.getItemID(), -20);
		
		assertEquals(20, stock.getItemStock(is.getItemID()).getQuantity());
	}
	
	@Test
	public void testPerishableIncreaseQuantityZero() throws StockException {
		Item icecream = new PerishableItem(null, 0, 0, 0, 0, -12);
		ItemStock is = stock.addNewItem(icecream, 40);
		
		stock.increaseQuantity(is.getItemID(), 0);
		assertEquals(40, stock.stockTotal());
	}
	
	public void testPerishableIncreaseQuantityBig() throws StockException {
		Item icecream = new PerishableItem(null, 0, 0, 0, 0, -12);
		ItemStock is = stock.addNewItem(icecream, 40);
		
		stock.increaseQuantity(is.getItemID(), 1000000);
		assertEquals(1000040, stock.stockTotal());
	}
	
	//end perishableItem increaseQuantity tests
	
	//OrdinaryItem decreaseQuantity tests

	@Test
	public void testOrdinaryDecreaseQuantity() throws StockException {
		Item apple = new OrdinaryItem(null, 0, 0, 0, 0);
		ItemStock is = stock.addNewItem(apple, 300);
		
		stock.decreaseQuantity(is.getItemID(), 200);
		assertEquals(100, stock.stockTotal());
	}
		
	@Test
	public void testOrdinaryDecreaseQuantityWrong() throws StockException {
		Item apple = new OrdinaryItem(null, 0, 0, 0, 0);
		ItemStock is = stock.addNewItem(apple, 300);
		
		stock.decreaseQuantity(is.getItemID(), 20);
		assertNotEquals(180, stock.stockTotal());
	}
	
	@Test
	public void testOrdinaryDecreaseQuantityNegative() throws StockException {
		Item apple = new OrdinaryItem(null, 0, 0, 0, 0);
		ItemStock is = stock.addNewItem(apple, 300);		
		stock.decreaseQuantity(is.getItemID(), -20);
		
		assertEquals(320, stock.getItemStock(is.getItemID()).getQuantity());
	}
	
	@Test
	public void testOrdinaryDecreaseQuantityZero() throws StockException {
		Item apple = new OrdinaryItem(null, 0, 0, 0, 0);
		ItemStock is = stock.addNewItem(apple, 300);
		
		stock.decreaseQuantity(is.getItemID(), 0);
		assertEquals(300, stock.stockTotal());
	}
	
	@Test (expected = StockException.class)
	public void testOrdinaryDecreaseQuantityBig() throws StockException {
		Item apple = new OrdinaryItem(null, 0, 0, 0, 0);
		ItemStock is = stock.addNewItem(apple, 300);	
		stock.decreaseQuantity(is.getItemID(), 1000000);		
	}
	
	//end OrdinaryItem decreaseQuantity tests

	//PerishableItem decreaseQuantity tests

	@Test
	public void testPerishableDecreaseQuantity() throws StockException {
		Item icecream = new PerishableItem(null, 0, 0, 0, 0, -12);
		ItemStock is = stock.addNewItem(icecream, 40);
		
		stock.decreaseQuantity(is.getItemID(), 22);
		assertEquals(18, stock.stockTotal());
	}
		
	@Test
	public void testPerishableDecreaseQuantityWrong() throws StockException {
		Item icecream = new PerishableItem(null, 0, 0, 0, 0, -12);
		ItemStock is = stock.addNewItem(icecream, 40);
		
		stock.decreaseQuantity(is.getItemID(), 20);
		assertNotEquals(180, stock.stockTotal());
	}
	
	@Test
	public void testPerishableDecreaseQuantityNegative() throws StockException {
		Item icecream = new PerishableItem(null, 0, 0, 0, 0, -12);
		ItemStock is = stock.addNewItem(icecream, 40);		
		stock.decreaseQuantity(is.getItemID(), -20);

		assertEquals(60, stock.getItemStock(is.getItemID()).getQuantity());
	}
	
	@Test
	public void testPerishableDecreaseQuantityZero() throws StockException {
		Item icecream = new PerishableItem(null, 0, 0, 0, 0, -12);
		ItemStock is = stock.addNewItem(icecream, 40);
		
		stock.decreaseQuantity(is.getItemID(), 0);
		assertEquals(40, stock.stockTotal());
	}
	
	@Test (expected = StockException.class)
	public void testPerishableDecreaseQuantityBig() throws StockException {
		Item icecream = new PerishableItem(null, 0, 0, 0, 0, -12);
		ItemStock is = stock.addNewItem(icecream, 40);	
		stock.decreaseQuantity(is.getItemID(), 1000000);		
	}

}