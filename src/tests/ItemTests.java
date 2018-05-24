/**
 * 
 */
package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

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
	
	//PerishableItem name tests
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
	
	@Test
	public void testPerishableNameNumber() throws InvalidItemException {
		perishable.setName("42");
		String name = perishable.getName();
		
		assertEquals("42", name);
	}
	
	@Test
	public void testLongPerishableName() throws InvalidItemException {
		perishable.setName("Verylongcerealbrandwithaverylongname"); 
		String name = perishable.getName();
		
		assertEquals("Verylongcerealbrandwithaverylongname", name);
	}
	
	@Test
	public void testShortPerishableName() throws InvalidItemException {
		perishable.setName("x");
		String name = perishable.getName();
		
		assertEquals("x", name);
	}
	//end PerishableItem name tests
	
	//PerishableItem manufacturtingCost tests
	@Test
	public void testPerishableItemManufacturingCost() throws InvalidItemException {
		perishable.setManufacturingCost(54.85);
		double cost = perishable.getManufacturingCost();
		
		assertEquals(54.85, cost, 0.001);		
	}
	
	@Test
	public void testPerishableItemManufacturingCostWrong() throws InvalidItemException {
		perishable.setManufacturingCost(43);
		double cost = perishable.getManufacturingCost();
		
		assertNotEquals(22, cost);
	}
	
	@Test
	public void testPerishableItemManufacturingCostZero() throws InvalidItemException {
		perishable.setManufacturingCost(0);
		double cost = perishable.getManufacturingCost();
		
		assertEquals(0, cost, 0.000);
	}
	
	@Test(expected=InvalidItemException.class)
	public void testPerishableItemManufacturingCostNegative() throws InvalidItemException {
		perishable.setManufacturingCost(-42);		
	}
	
	@Test
	public void testPerishableItemManufacturingCostBig() throws InvalidItemException {
		perishable.setManufacturingCost(1000000);
		double cost = perishable.getManufacturingCost();
		
		assertEquals(1000000, cost, 0.001);
	}	
	//end PerishableItem manufacturtingCost tests
	
	
	//PerishableItem SellPrice tests
	@Test
	public void testPerishableItemSellPrice() throws InvalidItemException {
		perishable.setSellPrice(78.2);
		double price = perishable.getSellPrice();
		
		assertEquals(78.2, price, 0.001);							
	}
	
	@Test
	public void testPerishableItemSellPriceWrong() throws InvalidItemException {
		perishable.setSellPrice(3);
		double price = perishable.getSellPrice();
		
		assertNotEquals(1, price, 0.001);
	}
	
	@Test
	public void testPerishableItemSellPriceZero() throws InvalidItemException {
		perishable.setSellPrice(0);
		double price = perishable.getSellPrice();
		
		assertEquals(0, price, 0.000);	
	}
	
	@Test
	public void testPerishableItemSellPriceBig() throws InvalidItemException {
		perishable.setSellPrice(1000000);
		double price = perishable.getSellPrice();
		
		assertEquals(1000000, price, 0.001);
	}
	
	@Test(expected=InvalidItemException.class)
	public void testPerishableItemSellPriceNegative() throws InvalidItemException {
		perishable.setSellPrice(-87.22);
	}
	//end PerishableItem SellPrice tests
	
	//PerishableItem reorderPoint tests
	@Test
	public void testPerishableItemreorderPoint() throws InvalidItemException {
		perishable.setReorderPoint(20);
		int point = perishable.getReorderPoint();
		
		assertEquals(20, point);
	}
	
	@Test
	public void testPerishableItemreorderPointWrong() throws InvalidItemException {
		perishable.setReorderPoint(43);
		int point = perishable.getReorderPoint();
		
		assertNotEquals(44, point);
	}
	
	@Test(expected=InvalidItemException.class)
	public void testPerishableItemreorderPointNegative() throws InvalidItemException {
		perishable.setReorderPoint(-2);
	}
	
	@Test
	public void testPerishableItemreorderPointZero() throws InvalidItemException {
		perishable.setReorderPoint(0);
		int point = perishable.getReorderPoint();
		
		assertEquals(0, point, 0.000);
	}
	
	@Test
	public void testPerishableItemreorderPointBig() throws InvalidItemException {
		perishable.setReorderPoint(1000000);
		int point = perishable.getReorderPoint();
		
		assertEquals(1000000, point, 0.001);
	}
	//end PerishableItem reorderPoint tests
	
	//PerishableItem reorderAmount tests
	@Test
	public void testPerishableItemreorderAmount() throws InvalidItemException {
		perishable.setReorderAmount(400);
		int amount = perishable.getReorderAmount();
		
		assertEquals(400, amount);
	}
	
	@Test
	public void testPerishableItemreorderAmountWrong() throws InvalidItemException {
		perishable.setReorderAmount(523);
		int amount = perishable.getReorderAmount();
		
		assertNotEquals(323, amount);
	}
	
	@Test(expected=InvalidItemException.class)
	public void testPerishableItemreorderAmountNegative() throws InvalidItemException {
		perishable.setReorderAmount(-52);
	}
	
	@Test
	public void testPerishableItemreorderAmountZero() throws InvalidItemException {
		perishable.setReorderAmount(0);
		int amount = perishable.getReorderAmount();
		
		assertEquals(0, amount, 0.000);						
	}
	
	@Test
	public void testPerishableItemreorderAmountBig() throws InvalidItemException {
		perishable.setReorderAmount(1000000);
		int amount = perishable.getReorderAmount();
		
		assertEquals(1000000, amount, 0.001);
	}
	//end PerishableItem reorderAmount tests
	
	//PerishableItem Temperature Tests
	@Test
	public void testPerishableItemTemperature() throws InvalidItemException {	
		((PerishableItem) perishable).setTemperature(-14);
		double temp = ((PerishableItem) perishable).getTemperature();
		
		assertEquals(-14,temp, 0.000);		
	}
	
	@Test (expected=InvalidItemException.class)
	public void testPerishableItemTemperatureTooCold() throws InvalidItemException {
		((PerishableItem) perishable).setTemperature(-10000);
	}
	
	@Test (expected=InvalidItemException.class)
	public void testPerishableItemTemperatureTooHot() throws InvalidItemException {
		((PerishableItem) perishable).setTemperature(100);
	}	
	//End PerishableItem Temperature Tests
	
	//OrdinaryItem
	
	//OrdinaryItem name tests
		@Test
		public void testOrdinaryName() throws InvalidItemException {
			ordinary.setName("Chicken");
			String name = ordinary.getName();
			
			assertEquals("Chicken", name);
		}
		
		@Test(expected=InvalidItemException.class)
		public void testOrdinaryNameEmpty() throws InvalidItemException {
			ordinary.setName("");		
		}
		
		@Test
		public void testOrdinaryNameNumber() throws InvalidItemException {
			ordinary.setName("42");
			String name = ordinary.getName();
			
			assertEquals("42", name);
		}
		
		@Test
		public void testLongOrdinaryName() throws InvalidItemException {
			ordinary.setName("Verylongcerealbrandwithaverylongname"); 
			String name = ordinary.getName();
			
			assertEquals("Verylongcerealbrandwithaverylongname", name);
		}
		
		@Test
		public void testShortOrdinaryName() throws InvalidItemException {
			ordinary.setName("x");
			String name = ordinary.getName();
			
			assertEquals("x", name);
		}
		//end OrdinaryItem name tests
		
		//OrdinaryItem manufacturtingCost tests
		@Test
		public void testOrdinaryItemManufacturingCost() throws InvalidItemException {
			ordinary.setManufacturingCost(54.85);
			double cost = ordinary.getManufacturingCost();
			
			assertEquals(54.85, cost, 0.001);		
		}
		
		@Test
		public void testOrdinaryItemManufacturingCostWrong() throws InvalidItemException {
			ordinary.setManufacturingCost(43);
			double cost = ordinary.getManufacturingCost();
			
			assertNotEquals(22, cost);
		}
		
		@Test
		public void testOrdinaryItemManufacturingCostZero() throws InvalidItemException {
			ordinary.setManufacturingCost(0);
			double cost = ordinary.getManufacturingCost();
			
			assertEquals(0, cost, 0.000);
		}
		
		@Test(expected=InvalidItemException.class)
		public void testOrdinaryItemManufacturingCostNegative() throws InvalidItemException {
			ordinary.setManufacturingCost(-42);		
		}
		
		@Test
		public void testOrdinaryItemManufacturingCostBig() throws InvalidItemException {
			ordinary.setManufacturingCost(1000000);
			double cost = ordinary.getManufacturingCost();
			
			assertEquals(1000000, cost, 0.001);
		}	
		//end OrdinaryItem manufacturtingCost tests
		
		
		//OrdinaryItem SellPrice tests
		@Test
		public void testOrdinaryItemSellPrice() throws InvalidItemException {
			ordinary.setSellPrice(78.2);
			double price = ordinary.getSellPrice();
			
			assertEquals(78.2, price, 0.001);							
		}
		
		@Test
		public void testOrdinaryItemSellPriceWrong() throws InvalidItemException {
			ordinary.setSellPrice(3);
			double price = ordinary.getSellPrice();
			
			assertNotEquals(1, price, 0.001);
		}
		
		@Test
		public void testOrdinaryItemSellPriceZero() throws InvalidItemException {
			ordinary.setSellPrice(0);
			double price = ordinary.getSellPrice();
			
			assertEquals(0, price, 0.000);	
		}
		
		@Test
		public void testOrdinaryItemSellPriceBig() throws InvalidItemException {
			ordinary.setSellPrice(1000000);
			double price = ordinary.getSellPrice();
			
			assertEquals(1000000, price, 0.001);
		}
		
		@Test(expected=InvalidItemException.class)
		public void testOrdinaryItemSellPriceNegative() throws InvalidItemException {
			ordinary.setSellPrice(-87.22);
		}
		//end OrdinaryItem SellPrice tests
		
		//OrdinaryItem reorderPoint tests
		@Test
		public void testOrdinaryItemreorderPoint() throws InvalidItemException {
			ordinary.setReorderPoint(20);
			int point = ordinary.getReorderPoint();
			
			assertEquals(20, point);
		}
		
		@Test
		public void testOrdinaryItemreorderPointWrong() throws InvalidItemException {
			ordinary.setReorderPoint(43);
			int point = ordinary.getReorderPoint();
			
			assertNotEquals(44, point);
		}
		
		@Test(expected=InvalidItemException.class)
		public void testOrdinaryItemreorderPointNegative() throws InvalidItemException {
			ordinary.setReorderPoint(-2);
		}
		
		@Test
		public void testOrdinaryItemreorderPointZero() throws InvalidItemException {
			ordinary.setReorderPoint(0);
			int point = ordinary.getReorderPoint();
			
			assertEquals(0, point, 0.000);
		}
		
		@Test
		public void testOrdinaryItemreorderPointBig() throws InvalidItemException {
			ordinary.setReorderPoint(1000000);
			int point = ordinary.getReorderPoint();
			
			assertEquals(1000000, point, 0.001);
		}
		//end OrdinaryItem reorderPoint tests
		
		//OrdinaryItem reorderAmount tests
		@Test
		public void testOrdinaryItemreorderAmount() throws InvalidItemException {
			ordinary.setReorderAmount(400);
			int amount = ordinary.getReorderAmount();
			
			assertEquals(400, amount);
		}
		
		@Test
		public void testOrdinaryItemreorderAmountWrong() throws InvalidItemException {
			ordinary.setReorderAmount(523);
			int amount = ordinary.getReorderAmount();
			
			assertNotEquals(323, amount);
		}
		
		@Test(expected=InvalidItemException.class)
		public void testOrdinaryItemreorderAmountNegative() throws InvalidItemException {
			ordinary.setReorderAmount(-52);
		}
		
		@Test
		public void testOrdinaryItemreorderAmountZero() throws InvalidItemException {
			ordinary.setReorderAmount(0);
			int amount = ordinary.getReorderAmount();
			
			assertEquals(0, amount, 0.000);						
		}
		
		@Test
		public void testOrdinaryItemreorderAmountBig() throws InvalidItemException {
			ordinary.setReorderAmount(1000000);
			int amount = ordinary.getReorderAmount();
			
			assertEquals(1000000, amount, 0.001);
		}
		//end OrdinaryItem reorderAmount tests

	
	
	
	
	
}