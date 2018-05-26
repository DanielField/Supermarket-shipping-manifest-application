/**
 * 
 */
package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

import exception.StockException;
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

	public Item perishable;
	public Item ordinary;
	
	@Before @Test
	public void testInitialize() {
		perishable = new PerishableItem(null, 0, 0, 0, 0, 0);
		ordinary = new OrdinaryItem(null, 0, 0, 0, 0);
	}
	
	//PerishableItem name tests
	@Test
	public void testPerishableName() throws StockException {
		perishable.setName("Chicken");
		String name = perishable.getName();
		
		assertEquals("Chicken", name);
	}
	
	@Test(expected=StockException.class)
	public void testPerishableNameEmpty() throws StockException {
		perishable.setName("");		
	}
	
	@Test
	public void testPerishableNameNumber() throws StockException {
		perishable.setName("42");
		String name = perishable.getName();
		
		assertEquals("42", name);
	}
	
	@Test
	public void testLongPerishableName() throws StockException {
		perishable.setName("Verylongcerealbrandwithaverylongname"); 
		String name = perishable.getName();
		
		assertEquals("Verylongcerealbrandwithaverylongname", name);
	}
	
	@Test
	public void testShortPerishableName() throws StockException {
		perishable.setName("x");
		String name = perishable.getName();
		
		assertEquals("x", name);
	}
	//end PerishableItem name tests
	
	//PerishableItem manufacturtingCost tests
	@Test
	public void testPerishableItemManufacturingCost() throws StockException {
		perishable.setManufacturingCost(54.85);
		double cost = perishable.getManufacturingCost();
		
		assertEquals(54.85, cost, 0.001);		
	}
	
	@Test
	public void testPerishableItemManufacturingCostWrong() throws StockException {
		perishable.setManufacturingCost(43);
		double cost = perishable.getManufacturingCost();
		
		assertNotEquals(22, cost);
	}
	
	@Test
	public void testPerishableItemManufacturingCostZero() throws StockException {
		perishable.setManufacturingCost(0);
		double cost = perishable.getManufacturingCost();
		
		assertEquals(0, cost, 0.000);
	}
	
	@Test(expected=StockException.class)
	public void testPerishableItemManufacturingCostNegative() throws StockException {
		perishable.setManufacturingCost(-42);		
	}
	
	@Test
	public void testPerishableItemManufacturingCostBig() throws StockException {
		perishable.setManufacturingCost(1000000);
		double cost = perishable.getManufacturingCost();
		
		assertEquals(1000000, cost, 0.001);
	}	
	//end PerishableItem manufacturtingCost tests
	
	
	//PerishableItem SellPrice tests
	@Test
	public void testPerishableItemSellPrice() throws StockException {
		perishable.setSellPrice(78.2);
		double price = perishable.getSellPrice();
		
		assertEquals(78.2, price, 0.001);							
	}
	
	@Test
	public void testPerishableItemSellPriceWrong() throws StockException {
		perishable.setSellPrice(3);
		double price = perishable.getSellPrice();
		
		assertNotEquals(1, price, 0.001);
	}
	
	@Test
	public void testPerishableItemSellPriceZero() throws StockException {
		perishable.setSellPrice(0);
		double price = perishable.getSellPrice();
		
		assertEquals(0, price, 0.000);	
	}
	
	@Test
	public void testPerishableItemSellPriceBig() throws StockException {
		perishable.setSellPrice(1000000);
		double price = perishable.getSellPrice();
		
		assertEquals(1000000, price, 0.001);
	}
	
	@Test(expected=StockException.class)
	public void testPerishableItemSellPriceNegative() throws StockException {
		perishable.setSellPrice(-87.22);
	}
	//end PerishableItem SellPrice tests
	
	//PerishableItem reorderPoint tests
	@Test
	public void testPerishableItemreorderPoint() throws StockException {
		perishable.setReorderPoint(20);
		int point = perishable.getReorderPoint();
		
		assertEquals(20, point);
	}
	
	@Test
	public void testPerishableItemreorderPointWrong() throws StockException {
		perishable.setReorderPoint(43);
		int point = perishable.getReorderPoint();
		
		assertNotEquals(44, point);
	}
	
	@Test(expected=StockException.class)
	public void testPerishableItemreorderPointNegative() throws StockException {
		perishable.setReorderPoint(-2);
	}
	
	@Test
	public void testPerishableItemreorderPointZero() throws StockException {
		perishable.setReorderPoint(0);
		int point = perishable.getReorderPoint();
		
		assertEquals(0, point, 0.000);
	}
	
	@Test
	public void testPerishableItemreorderPointBig() throws StockException {
		perishable.setReorderPoint(1000000);
		int point = perishable.getReorderPoint();
		
		assertEquals(1000000, point, 0.001);
	}
	//end PerishableItem reorderPoint tests
	
	//PerishableItem reorderAmount tests
	@Test
	public void testPerishableItemreorderAmount() throws StockException {
		perishable.setReorderAmount(400);
		int amount = perishable.getReorderAmount();
		
		assertEquals(400, amount);
	}
	
	@Test
	public void testPerishableItemreorderAmountWrong() throws StockException {
		perishable.setReorderAmount(523);
		int amount = perishable.getReorderAmount();
		
		assertNotEquals(323, amount);
	}
	
	@Test(expected=StockException.class)
	public void testPerishableItemreorderAmountNegative() throws StockException {
		perishable.setReorderAmount(-52);
	}
	
	@Test
	public void testPerishableItemreorderAmountZero() throws StockException {
		perishable.setReorderAmount(0);
		int amount = perishable.getReorderAmount();
		
		assertEquals(0, amount, 0.000);						
	}
	
	@Test
	public void testPerishableItemreorderAmountBig() throws StockException {
		perishable.setReorderAmount(1000000);
		int amount = perishable.getReorderAmount();
		
		assertEquals(1000000, amount, 0.001);
	}
	//end PerishableItem reorderAmount tests
	
	//PerishableItem Temperature Tests
	@Test
	public void testPerishableItemTemperature() throws StockException {	
		((PerishableItem) perishable).setTemperature(-14);
		double temp = ((PerishableItem) perishable).getTemperature();
		
		assertEquals(-14,temp, 0.000);		
	}
	
	@Test (expected=StockException.class)
	public void testPerishableItemTemperatureTooCold() throws StockException {
		((PerishableItem) perishable).setTemperature(-10000);
	}
	
	@Test (expected=StockException.class)
	public void testPerishableItemTemperatureTooHot() throws StockException {
		((PerishableItem) perishable).setTemperature(100);
	}	
	//End PerishableItem Temperature Tests
	
	//OrdinaryItem
	
	//OrdinaryItem name tests
		@Test
		public void testOrdinaryName() throws StockException {
			ordinary.setName("Chicken");
			String name = ordinary.getName();
			
			assertEquals("Chicken", name);
		}
		
		@Test(expected=StockException.class)
		public void testOrdinaryNameEmpty() throws StockException {
			ordinary.setName("");		
		}
		
		@Test
		public void testOrdinaryNameNumber() throws StockException {
			ordinary.setName("42");
			String name = ordinary.getName();
			
			assertEquals("42", name);
		}
		
		@Test
		public void testLongOrdinaryName() throws StockException {
			ordinary.setName("Verylongcerealbrandwithaverylongname"); 
			String name = ordinary.getName();
			
			assertEquals("Verylongcerealbrandwithaverylongname", name);
		}
		
		@Test
		public void testShortOrdinaryName() throws StockException {
			ordinary.setName("x");
			String name = ordinary.getName();
			
			assertEquals("x", name);
		}
		//end OrdinaryItem name tests
		
		//OrdinaryItem manufacturtingCost tests
		@Test
		public void testOrdinaryItemManufacturingCost() throws StockException {
			ordinary.setManufacturingCost(54.85);
			double cost = ordinary.getManufacturingCost();
			
			assertEquals(54.85, cost, 0.001);		
		}
		
		@Test
		public void testOrdinaryItemManufacturingCostWrong() throws StockException {
			ordinary.setManufacturingCost(43);
			double cost = ordinary.getManufacturingCost();
			
			assertNotEquals(22, cost);
		}
		
		@Test
		public void testOrdinaryItemManufacturingCostZero() throws StockException {
			ordinary.setManufacturingCost(0);
			double cost = ordinary.getManufacturingCost();
			
			assertEquals(0, cost, 0.000);
		}
		
		@Test(expected=StockException.class)
		public void testOrdinaryItemManufacturingCostNegative() throws StockException {
			ordinary.setManufacturingCost(-42);		
		}
		
		@Test
		public void testOrdinaryItemManufacturingCostBig() throws StockException {
			ordinary.setManufacturingCost(1000000);
			double cost = ordinary.getManufacturingCost();
			
			assertEquals(1000000, cost, 0.001);
		}	
		//end OrdinaryItem manufacturtingCost tests
		
		
		//OrdinaryItem SellPrice tests
		@Test
		public void testOrdinaryItemSellPrice() throws StockException {
			ordinary.setSellPrice(78.2);
			double price = ordinary.getSellPrice();
			
			assertEquals(78.2, price, 0.001);							
		}
		
		@Test
		public void testOrdinaryItemSellPriceWrong() throws StockException {
			ordinary.setSellPrice(3);
			double price = ordinary.getSellPrice();
			
			assertNotEquals(1, price, 0.001);
		}
		
		@Test
		public void testOrdinaryItemSellPriceZero() throws StockException {
			ordinary.setSellPrice(0);
			double price = ordinary.getSellPrice();
			
			assertEquals(0, price, 0.000);	
		}
		
		@Test
		public void testOrdinaryItemSellPriceBig() throws StockException {
			ordinary.setSellPrice(1000000);
			double price = ordinary.getSellPrice();
			
			assertEquals(1000000, price, 0.001);
		}
		
		@Test(expected=StockException.class)
		public void testOrdinaryItemSellPriceNegative() throws StockException {
			ordinary.setSellPrice(-87.22);
		}
		//end OrdinaryItem SellPrice tests
		
		//OrdinaryItem reorderPoint tests
		@Test
		public void testOrdinaryItemreorderPoint() throws StockException {
			ordinary.setReorderPoint(20);
			int point = ordinary.getReorderPoint();
			
			assertEquals(20, point);
		}
		
		@Test
		public void testOrdinaryItemreorderPointWrong() throws StockException {
			ordinary.setReorderPoint(43);
			int point = ordinary.getReorderPoint();
			
			assertNotEquals(44, point);
		}
		
		@Test(expected=StockException.class)
		public void testOrdinaryItemreorderPointNegative() throws StockException {
			ordinary.setReorderPoint(-2);
		}
		
		@Test
		public void testOrdinaryItemreorderPointZero() throws StockException {
			ordinary.setReorderPoint(0);
			int point = ordinary.getReorderPoint();
			
			assertEquals(0, point, 0.000);
		}
		
		@Test
		public void testOrdinaryItemreorderPointBig() throws StockException {
			ordinary.setReorderPoint(1000000);
			int point = ordinary.getReorderPoint();
			
			assertEquals(1000000, point, 0.001);
		}
		//end OrdinaryItem reorderPoint tests
		
		//OrdinaryItem reorderAmount tests
		@Test
		public void testOrdinaryItemreorderAmount() throws StockException {
			ordinary.setReorderAmount(400);
			int amount = ordinary.getReorderAmount();
			
			assertEquals(400, amount);
		}
		
		@Test
		public void testOrdinaryItemreorderAmountWrong() throws StockException {
			ordinary.setReorderAmount(523);
			int amount = ordinary.getReorderAmount();
			
			assertNotEquals(323, amount);
		}
		
		@Test(expected=StockException.class)
		public void testOrdinaryItemreorderAmountNegative() throws StockException {
			ordinary.setReorderAmount(-52);
		}
		
		@Test
		public void testOrdinaryItemreorderAmountZero() throws StockException {
			ordinary.setReorderAmount(0);
			int amount = ordinary.getReorderAmount();
			
			assertEquals(0, amount, 0.000);						
		}
		
		@Test
		public void testOrdinaryItemreorderAmountBig() throws StockException {
			ordinary.setReorderAmount(1000000);
			int amount = ordinary.getReorderAmount();
			
			assertEquals(1000000, amount, 0.001);
		}
		//end OrdinaryItem reorderAmount tests

	
	
	
	
	
}