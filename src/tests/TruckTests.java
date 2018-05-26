/**
 * 
 */
package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import delivery.OrdinaryTruck;
import delivery.RefrigeratedTruck;
import delivery.Truck;
import exception.DeliveryException;
import exception.StockException;
import stock.Item;
import stock.ItemStock;
import stock.OrdinaryItem;
import stock.PerishableItem;
import stock.Stock;

/**
 * @author Allen Basic
 *
 */
public class TruckTests {

	Truck refrigeratedTruck;
	Truck ordinaryTruck;
	
	@Before @Test
	public void testInit() {
		refrigeratedTruck = new RefrigeratedTruck(-12.3);
		ordinaryTruck = new OrdinaryTruck();
	}

	//OrdinaryTruck addNewItem, addToCargo tests
	@Test
	public void testAddOrdinaryToCargo() throws DeliveryException, StockException {
		Stock cargo = new Stock();
		Item canOfSoup = new OrdinaryItem(null, 0, 0, 0, 0);
		Item cookie = new OrdinaryItem(null, 0, 0, 0, 0);
		
		cargo.addNewItem(canOfSoup, 53);
		cargo.addNewItem(cookie, 9);
		
		ordinaryTruck.addToCargo(cargo);
		assertEquals(62, ordinaryTruck.getTotalCargo());
	}
	
	public void testAddWrongOrdinaryToCargo() throws DeliveryException, StockException {
		Stock cargo = new Stock();
		Item canOfSoup = new OrdinaryItem(null, 0, 0, 0, 0);
		Item cookie = new OrdinaryItem(null, 0, 0, 0, 0);
		
		cargo.addNewItem(canOfSoup, 53);
		cargo.addNewItem(cookie, 9);
		
		ordinaryTruck.addToCargo(cargo);
		assertNotEquals(89, ordinaryTruck.getTotalCargo());
	}
	
	@Test (expected = DeliveryException.class)
	public void testAddZeroOrdinaryItemToCargo() throws DeliveryException, StockException {
		Stock cargo = new Stock();
		Item canOfSoup = new OrdinaryItem(null, 0, 0, 0, 0);
		Item cookie = new OrdinaryItem(null, 0, 0, 0, 0);
		
		cargo.addNewItem(canOfSoup, 0);
		cargo.addNewItem(cookie, 0);
		
		ordinaryTruck.addToCargo(cargo);
	}
	
	@Test (expected = DeliveryException.class)
	public void testAddMillionOrdinaryItemToCargo() throws DeliveryException, StockException {
		Stock cargo = new Stock();
		Item canOfSoup = new OrdinaryItem(null, 0, 0, 0, 0);
		Item cookie = new OrdinaryItem(null, 0, 0, 0, 0);
		
		cargo.addNewItem(canOfSoup, 50000);
		cargo.addNewItem(cookie, 50000);
		
		ordinaryTruck.addToCargo(cargo);
	}
	//END OrdinaryTruck addNewItem, addToCargo tests
	
	
	//RefrigeratedTruck addNewItem, addToCargo tests
	@Test
	public void testAddPerishableToCargo() throws DeliveryException, StockException {
		Stock cargo = new Stock();
		Item icecream = new PerishableItem(null, 0, 0, 0, 0, 0);
		Item FrozenPizza = new PerishableItem(null, 0, 0, 0, 0, 0);
		
		cargo.addNewItem(icecream, 53);
		cargo.addNewItem(FrozenPizza, 9);
		
		refrigeratedTruck.addToCargo(cargo);
		assertEquals(62, refrigeratedTruck.getTotalCargo());
	}
	
	@Test
	public void testAddWrongPerishableToCargo() throws DeliveryException, StockException {
		Stock cargo = new Stock();
		Item icecream = new PerishableItem(null, 0, 0, 0, 0, 0);
		Item FrozenPizza = new PerishableItem(null, 0, 0, 0, 0, 0);
		
		cargo.addNewItem(icecream, 53);
		cargo.addNewItem(FrozenPizza, 9);
		
		refrigeratedTruck.addToCargo(cargo);
		assertNotEquals(89, refrigeratedTruck.getTotalCargo());
	}
	
	@Test (expected = DeliveryException.class)
	public void testAddZeroPerishableItemToCargo() throws DeliveryException, StockException {
		Stock cargo = new Stock();
		Item icecream = new PerishableItem(null, 0, 0, 0, 0, 0);
		Item FrozenPizza = new PerishableItem(null, 0, 0, 0, 0, 0);
		
		cargo.addNewItem(icecream, 0);
		cargo.addNewItem(FrozenPizza, 0);
		
		refrigeratedTruck.addToCargo(cargo);
	}
	
	@Test (expected = DeliveryException.class)
	public void testAddMillionPerishableItemToCargo() throws DeliveryException, StockException {
		Stock cargo = new Stock();
		Item icecream = new PerishableItem(null, 0, 0, 0, 0, 0);
		Item FrozenPizza = new PerishableItem(null, 0, 0, 0, 0, 0);
		
		cargo.addNewItem(icecream, 50000);
		cargo.addNewItem(FrozenPizza, 50000);
		
		refrigeratedTruck.addToCargo(cargo);
	}
		//END RefrigeratedTruck addNewItem, addToCargo tests

	
	@Test(expected = DeliveryException.class)
	public void testAddInvalidTemperatureItemToCargo() throws DeliveryException, StockException {
		Stock cargo = new Stock();
		Item liquidHelium = new PerishableItem("liquid Helium", 0, 0, 0, 0, -290);
		
		cargo.addNewItem(liquidHelium, 22);
		
		refrigeratedTruck.addToCargo(cargo);
	}
	
	//OrdinaryTruck RemoveFromCargo tests
	@Test
	public void testRemoveOrdinaryFromCargo() throws DeliveryException, StockException {
		Item cookie = new OrdinaryItem("cookie", 0, 0, 0 , 0);
		ordinaryTruck.addToCargo(cookie, 500);	
		ordinaryTruck.removeFromCargo(cookie);
	
		assertFalse(ordinaryTruck.getCargo().contains(cookie));	
	}
	
	@Test
	public void testRemoveOrdinaryAmountFromCargo() throws DeliveryException, StockException {
		Item item1 = new OrdinaryItem("item1",0,0,0,0);
		ordinaryTruck.addToCargo(item1, 200);
		Item item2 = new OrdinaryItem("item2",0,0,0,0);
		ordinaryTruck.addToCargo(item2, 400);
		
		ordinaryTruck.removeFromCargo(item1, 200);
		ordinaryTruck.removeFromCargo(item2, 50);
		assertEquals(350, ordinaryTruck.getTotalCargo());
	}

	@Test
	public void testRemoveOrdinaryFromCargoByID() throws DeliveryException, StockException{
		Item cookie = new OrdinaryItem("cookie", 0, 0, 0 , 0);
		
		ordinaryTruck.addToCargo(cookie, 500);
		int id = ordinaryTruck.getCargo().getItemStock(cookie).getItemID();
		ordinaryTruck.removeFromCargo(id, 400);
	
		assertEquals(100, ordinaryTruck.getTotalCargo());
	}
	
	@Test
	public void testRemoveWrongOrdinaryFromCargo() throws DeliveryException, StockException {
		Item item1 = new OrdinaryItem("item1",0,0,0,0);
		ordinaryTruck.addToCargo(item1, 200);
		Item item2 = new OrdinaryItem("item1",0,0,0,0);
		ordinaryTruck.addToCargo(item2, 400);
		
		ordinaryTruck.removeFromCargo(item1, 200);
		ordinaryTruck.removeFromCargo(item2, 50);
		assertNotEquals(72, refrigeratedTruck.getTotalCargo());
	}
	
	@Test
	public void testRemoveZeroOrdinaryFromCargo() throws DeliveryException, StockException {
		Item item1 = new OrdinaryItem("item1",0,0,0,0);
		ordinaryTruck.addToCargo(item1, 200);
		Item item2 = new OrdinaryItem("item1",0,0,0,0);
		ordinaryTruck.addToCargo(item2, 400);
		
		ordinaryTruck.removeFromCargo(item1, 0);
		ordinaryTruck.removeFromCargo(item2, 0);
		assertEquals(600, ordinaryTruck.getTotalCargo());
	}
	
	@Test (expected = StockException.class)
	public void testRemoveMillionOrdinaryFromCargo() throws DeliveryException, StockException {
		Item item1 = new OrdinaryItem("item1",0,0,0,0);
		ordinaryTruck.addToCargo(item1, 200);
		Item item2 = new OrdinaryItem("item1",0,0,0,0);
		ordinaryTruck.addToCargo(item2, 400);
		
		ordinaryTruck.removeFromCargo(item1, 50000);
		ordinaryTruck.removeFromCargo(item2, 50000);
	}
	//END OrdinaryTruck RemoveFromCargo tests
	
	
	//RefrigeratedTruck RemoveFromCargo tests	
	@Test
	public void testRemoveRefrigeratedFromCargo() throws DeliveryException, StockException {
		Item icecream = new OrdinaryItem("cookie", 0, 0, 0 , 0);
		refrigeratedTruck.addToCargo(icecream, 500);	
		refrigeratedTruck.removeFromCargo(icecream);
	
		assertFalse(refrigeratedTruck.getCargo().contains(icecream));	
	}
	
	public void testRemoveRefridgeratedFromCargo() throws DeliveryException, StockException {
		Item item1 = new PerishableItem("item1",0,0,0,0,0);
		refrigeratedTruck.addToCargo(item1, 200);
		Item item2 = new PerishableItem("item1",0,0,0,0,0);
		refrigeratedTruck.addToCargo(item2, 400);
		
		refrigeratedTruck.removeFromCargo(item1, 200);
		refrigeratedTruck.removeFromCargo(item2, 50);
		assertEquals(350, refrigeratedTruck.getTotalCargo());
	}
	
	@Test
	public void testRemoveRefrigeratedFromCargoByID() throws DeliveryException, StockException{
		Item icecream = new PerishableItem("cookie", 0, 0, 0 , 0, 0);
		
		refrigeratedTruck.addToCargo(icecream, 40);
		int id = refrigeratedTruck.getCargo().getItemStock(icecream).getItemID();
		refrigeratedTruck.removeFromCargo(id, 20);
	
		assertEquals(20, refrigeratedTruck.getTotalCargo());
	}
	
	@Test
	public void testRemoveWrongRefrigeratedFromCargo() throws DeliveryException, StockException {
		Item item1 = new PerishableItem("item1",0,0,0,0,0);
		refrigeratedTruck.addToCargo(item1, 200);
		Item item2 = new PerishableItem("item1",0,0,0,0,0);
		refrigeratedTruck.addToCargo(item2, 400);
		
		refrigeratedTruck.removeFromCargo(item1, 200);
		refrigeratedTruck.removeFromCargo(item2, 50);
		assertNotEquals(72, refrigeratedTruck.getTotalCargo());
	}
	
	@Test
	public void testRemoveZeroRefrigeratedFromCargo() throws DeliveryException, StockException {
		Item item1 = new PerishableItem("item1",0,0,0,0,0);
		refrigeratedTruck.addToCargo(item1, 200);
		Item item2 = new PerishableItem("item1",0,0,0,0,0);
		refrigeratedTruck.addToCargo(item2, 400);
		
		refrigeratedTruck.removeFromCargo(item1, 0);
		refrigeratedTruck.removeFromCargo(item2, 0);
		assertEquals(600, refrigeratedTruck.getTotalCargo());
	}
	
	@Test (expected = StockException.class)
	public void testRemoveMillionRefrigeratedFromCargo() throws DeliveryException, StockException {
		Item item1 = new PerishableItem("item1",0,0,0,0,0);
		refrigeratedTruck.addToCargo(item1, 200);
		Item item2 = new PerishableItem("item1",0,0,0,0,0);
		refrigeratedTruck.addToCargo(item2, 400);
		
		refrigeratedTruck.removeFromCargo(item1, 50000);
		refrigeratedTruck.removeFromCargo(item2, 50000);
	}
	//END RefrigeratedTruck RemoveFromCargo tests

	//Test getCost Methods for both trucks
	@Test
	public void testGetCostRefrigerated() {
		// 900 + 200 * 0.7^(T/5)
		double cost = refrigeratedTruck.getCost();
		assertEquals(1380.93769, cost, 0.00001);
	}
	
	@Test
	public void testGetCostOrdinary() throws DeliveryException, StockException {
		Item cookie = new OrdinaryItem("Cookie", 0, 0, 0, 0);
		// Add 24 cookies to the cargo
		ordinaryTruck.addToCargo(cookie, 24);
		
		double cost = ordinaryTruck.getCost();
		assertEquals(756.0, cost, 0.00001);
	}
	
	@Test
	public void testRemoveThenGetCost() throws DeliveryException, StockException {
		Item cookie = new OrdinaryItem("Cookie", 0, 0, 0, 0);
		// Add 24 cookies to the cargo
		ordinaryTruck.addToCargo(cookie, 24);
		// remove half the cookies from cargo
		ordinaryTruck.removeFromCargo(cookie, 12);
		
		double cost = ordinaryTruck.getCost();
		assertEquals(753.0, cost, 0);
	}
	
	@Test
	public void testRemoveThenGetCostRefrigerated() throws DeliveryException, StockException {
		Item icecream = new PerishableItem("icecream", 0, 0, 0, 0, -12);
		refrigeratedTruck.addToCargo(icecream, 40);
		refrigeratedTruck.removeFromCargo(icecream, 40);
		
		double cost = refrigeratedTruck.getCost();
		// 900 + 200 * 0.7^(T/5)
		assertEquals(1380.9376945893334, cost, 0.00000);
	}
	
	//END test getCost Methods for both trucks
	
	//Ordinary and Refrigerated Truck getCapacity tests
	@Test (expected = DeliveryException.class)
	public void testGetCapacityMillion() throws DeliveryException, StockException {
		Item cookie = new OrdinaryItem(null, 0, 0, 0, 0);
		ordinaryTruck.addToCargo(cookie, 1000000);					
	}

	@Test
	public void testGetCapacityBothTrucks() throws DeliveryException, StockException {	
		int capacity = ordinaryTruck.getCapacity() + refrigeratedTruck.getCapacity();	
		assertEquals(1800, capacity);
	}
	
	@Test
	public void testGetCapacityOrdinaryTruck() throws DeliveryException, StockException {
		int capacity = ordinaryTruck.getCapacity();
		assertEquals(1000, capacity);
	}
	
	@Test
	public void testGetWrongCapacityOrdinaryTruck() throws DeliveryException, StockException {
		int capacity = ordinaryTruck.getCapacity();
		assertNotEquals(800, capacity);
	}
	
	@Test
	public void testGetCapacityRefrigeratedTruck() throws DeliveryException, StockException {
		int capacity = refrigeratedTruck.getCapacity();
		assertEquals(800, capacity);
	}
	@Test
	public void testGetWrongCapacityRefrigeratedTruck() throws DeliveryException, StockException {
		int capacity = refrigeratedTruck.getCapacity();
		assertNotEquals(1000, capacity);
	}
	
	//END Ordinary and Refrigerated Truck getCapacity tests
	@Test
	public void testGetTotalCargoBothTrucks() throws DeliveryException, StockException {
		Item cookie = new OrdinaryItem("Cookie", 0, 0, 0, 0);
		Item icecream = new PerishableItem("Icecream", 0, 0, 0, 0, -12);		
		ordinaryTruck.addToCargo(cookie, 24);
		refrigeratedTruck.addToCargo(icecream, 40);
		
		int total = ordinaryTruck.getTotalCargo() + refrigeratedTruck.getTotalCargo();
		
		assertEquals(64, total);	
	}
	
	//GetTotalCargo OrdinaryTruck Tests
	@Test
	public void testGetTotalCargoOrdinaryTruck() throws DeliveryException, StockException {
		Item cookie = new OrdinaryItem("Cookie", 0, 0, 0, 0);		
		ordinaryTruck.addToCargo(cookie, 24);
		
		int total = ordinaryTruck.getTotalCargo();		
		assertEquals(24, total);	
	}
	
	@Test
	public void testGetTotalCargoOrdinaryTruckWrong() throws DeliveryException, StockException {
		Item cookie = new OrdinaryItem("Cookie", 0, 0, 0, 0);		
		ordinaryTruck.addToCargo(cookie, 12);
		
		int total = ordinaryTruck.getTotalCargo();		
		assertNotEquals(24, total);	
	}
	
	@Test (expected = DeliveryException.class)
	public void testGetTotalCargoOrdinaryTruckMillion() throws DeliveryException, StockException {
		Item cookie = new OrdinaryItem(null, 0, 0, 0, 0);
		ordinaryTruck.addToCargo(cookie, 50000);
	}
	
	@Test (expected = DeliveryException.class)
	public void testGetTotalCargoOrdinaryTruckNegative() throws DeliveryException, StockException {
		Item cookie = new OrdinaryItem(null, 0, 0, 0, 0);
		ordinaryTruck.addToCargo(cookie, -55);
	}
	//END GetTotalCargo ordinaryTruck Tests 
	
	
	//GetTotalCargo RefrigeratedTruck Tests
	@Test
	public void testGetTotalCargoRefrigeratedTruck() throws DeliveryException, StockException {
		Item Icecream = new PerishableItem("Icecream", 0, 0, 0, 0, -12);		
		refrigeratedTruck.addToCargo(Icecream, 50);
		
		int total = refrigeratedTruck.getTotalCargo();		
		assertEquals(50, total);	
	}
	
	@Test
	public void testGetTotalCargoRefrigeratedTruckWrong() throws DeliveryException, StockException {
		Item Icecream = new PerishableItem("Icecream", 0, 0, 0, 0, -12);	
		refrigeratedTruck.addToCargo(Icecream, 50);
		
		int total = refrigeratedTruck.getTotalCargo();		
		assertNotEquals(24, total);	
	}
			
	@Test (expected = DeliveryException.class)
	public void testGetTotalCargoRefrigeratedTruckZero() throws DeliveryException, StockException {
		Item Icecream = new PerishableItem("Icecream", 0, 0, 0, 0, -12);
		refrigeratedTruck.addToCargo(Icecream, 0);
	
		double capacity = refrigeratedTruck.getTotalCargo();
	}
	
	@Test (expected = DeliveryException.class)
	public void testGetTotalCargoRefrigeratedTruckMillion() throws DeliveryException, StockException {
		Item Icecream = new PerishableItem("Icecream", 0, 0, 0, 0, -12);
		refrigeratedTruck.addToCargo(Icecream, 50000);
	}
	
	@Test (expected = DeliveryException.class)
	public void testGetTotalCargoRefrigeratedTruckNegative() throws DeliveryException, StockException {
		Item Icecream = new PerishableItem("Icecream", 0, 0, 0, 0, -12);
		refrigeratedTruck.addToCargo(Icecream, -55);
	}
	//END GetTotalCargo RefrigeratedTruck Tests

	
}