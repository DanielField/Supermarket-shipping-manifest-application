/**
 * 
 */
package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import exception.InvalidItemException;
import stock.Item;
import stock.OrdinaryItem;
import stock.PerishableItem;

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

	public Item perishable;
	public Item ordinary;
	
	@Before @Test
	public void testInitialize() {
		perishable = new PerishableItem(null, 0, 0, 0, 0, 0);
		ordinary = new OrdinaryItem(null, 0, 0, 0, 0);
	}
	
	@Test
	public void testPerishableName() throws InvalidItemException {
		perishable.setName("Chicken");
		String name = perishable.getName();
		
		assertEquals("Chicken", name);
	}
	
	@Test(expected=InvalidItemException.class)
	public void testPerishableNameEmpty() throws InvalidItemException {
		perishable.setName("");
	}
}