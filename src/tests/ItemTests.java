/**
 * 
 */
package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Stock.Item;
import Exception.InvalidItemException;

/**
 * Test cases for the item class.
 * 
 * @author Allen Basic
 *
 */
public class ItemTests {
	
//	  Item. An item, possessing at least the following properties:
//		� Name.
//		� Manufacturing cost in dollars.
//		� Sell price in dollars.
//		� Reorder point.
//		� Reorder amount.
//		� Temperature in �C that must be maintained for the item to not perish.
//		Not all items are temperature controlled, and so they will not
//		need a temperature.

	public Item item;
	
	@Before @Test
	public void testInitialize() {
		item = new Item(null, 0, 0, 0, 0, 0);
	}
	
	@Test
	public void testName() throws InvalidItemException {
		item.setName("Chicken");
		String name = item.getName();
		
		assertEquals("Chicken", name);
	}
	
	@Test(expected=InvalidItemException.class)
	public void testNameEmpty() throws InvalidItemException {
		item.setName("");
	}
}