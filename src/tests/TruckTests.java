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
import exception.InvalidItemException;
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
	
	/*
	 * 
		� Truck. An abstract class for the two truck types.
		� Refrigerated Truck. A truck, possessing at least the following properties:
			� Cost in dollars equal to 900 + 200 � 0.7
			T/5 where T is the truck�s
			temperature in �C.
			� Cargo capacity of 800 items.
			� Cargo. All items can be stored in a refrigerated truck�s cargo, including
			dry goods (items that do not need to be temperature controlled).
			� Temperature in �C that maintains a safe temperature for the truck�s
			cargo. This is equal to the temperature of the item in the cargo with
			the coldest safe temperature. The allowed temperature range is from
			-20�C inclusive to 10�C inclusive.
		� Ordinary Truck. A truck, possessing at least the following properties:
			� Cost in dollars equal to 750 + 0.25q where q is the total quantity of
			items in the cargo.
			� Cargo capacity of 1000 items.
			� Cargo. Temperature controlled items cannot be stored in an ordinary
			truck�s cargo, only dry goods.
		� Manifest. A collection of trucks
	*/

	Truck refrigeratedTruck;
	Truck ordinaryTruck;
	
	@Before @Test
	public void testInit() {
		double temperature = -12.3;
		refrigeratedTruck = new RefrigeratedTruck(temperature);
		ordinaryTruck = new OrdinaryTruck();
	}
	
	/**
	 * tests to validate the correctness of the addToCargo and addNewItem Truck methods
	 * @throws InvalidItemException
	 * @throws StockException
	 */
	
	//OrdinaryTruck addNewItem, addToCargo tests
	@Test
	public void testAddOrdinaryToCargo() throws InvalidItemException, StockException {
		Stock cargo = new Stock();
		Item canOfSoup = new OrdinaryItem(null, 0, 0, 0, 0);
		Item cookie = new OrdinaryItem(null, 0, 0, 0, 0);
		
		cargo.addNewItem(canOfSoup, 53);
		cargo.addNewItem(cookie, 9);
		
		ordinaryTruck.addToCargo(cargo);
		assertEquals(62, ordinaryTruck.getTotalCargo());
	}
	
	public void testAddWrongOrdinaryToCargo() throws InvalidItemException, StockException {
		Stock cargo = new Stock();
		Item canOfSoup = new OrdinaryItem(null, 0, 0, 0, 0);
		Item cookie = new OrdinaryItem(null, 0, 0, 0, 0);
		
		cargo.addNewItem(canOfSoup, 53);
		cargo.addNewItem(cookie, 9);
		
		ordinaryTruck.addToCargo(cargo);
		assertNotEquals(89, ordinaryTruck.getTotalCargo());
	}
	
	@Test
	public void testAddZeroOrdinaryItemToCargo() throws InvalidItemException, StockException {
		Stock cargo = new Stock();
		Item canOfSoup = new OrdinaryItem(null, 0, 0, 0, 0);
		Item cookie = new OrdinaryItem(null, 0, 0, 0, 0);
		
		cargo.addNewItem(canOfSoup, 0);
		cargo.addNewItem(cookie, 0);
		
		ordinaryTruck.addToCargo(cargo);
		assertEquals(0, ordinaryTruck.getTotalCargo());
	}
	
	@Test (expected = StockException.class)
	public void testAddMillionOrdinaryItemToCargo() throws InvalidItemException, StockException {
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
	public void testAddPerishableToCargo() throws InvalidItemException, StockException {
		Stock cargo = new Stock();
		Item icecream = new PerishableItem(null, 0, 0, 0, 0, 0);
		Item FrozenPizza = new PerishableItem(null, 0, 0, 0, 0, 0);
		
		cargo.addNewItem(icecream, 53);
		cargo.addNewItem(FrozenPizza, 9);
		
		refrigeratedTruck.addToCargo(cargo);
		assertEquals(62, refrigeratedTruck.getTotalCargo());
	}
	
	@Test
	public void testAddWrongPerishableToCargo() throws InvalidItemException, StockException {
		Stock cargo = new Stock();
		Item icecream = new PerishableItem(null, 0, 0, 0, 0, 0);
		Item FrozenPizza = new PerishableItem(null, 0, 0, 0, 0, 0);
		
		cargo.addNewItem(icecream, 53);
		cargo.addNewItem(FrozenPizza, 9);
		
		refrigeratedTruck.addToCargo(cargo);
		assertNotEquals(89, refrigeratedTruck.getTotalCargo());
	}
	
	@Test
	public void testAddZeroPerishableItemToCargo() throws InvalidItemException, StockException {
		Stock cargo = new Stock();
		Item icecream = new PerishableItem(null, 0, 0, 0, 0, 0);
		Item FrozenPizza = new PerishableItem(null, 0, 0, 0, 0, 0);
		
		cargo.addNewItem(icecream, 0);
		cargo.addNewItem(FrozenPizza, 0);
		
		refrigeratedTruck.addToCargo(cargo);
		assertEquals(0, refrigeratedTruck.getTotalCargo());
	}
	
	@Test (expected = StockException.class)
	public void testAddMillionPerishableItemToCargo() throws InvalidItemException, StockException {
		Stock cargo = new Stock();
		Item icecream = new PerishableItem(null, 0, 0, 0, 0, 0);
		Item FrozenPizza = new PerishableItem(null, 0, 0, 0, 0, 0);
		
		cargo.addNewItem(icecream, 50000);
		cargo.addNewItem(FrozenPizza, 50000);
		
		refrigeratedTruck.addToCargo(cargo);
	}
		//END RefrigeratedTruck addNewItem, addToCargo tests

	
	@Test(expected = InvalidItemException.class)
	public void testAddInvalidTemperatureItemToCargo() throws InvalidItemException, StockException {
		Stock cargo = new Stock();
		Item liquidHelium = new PerishableItem("liquid Helium", 0, 0, 0, 0, -290);
		
		cargo.addNewItem(liquidHelium, 22);
		
		refrigeratedTruck.addToCargo(cargo);
	}
	
	//OrdinaryTruck RemoveFromCargo tests
	
	/**
	 * Test to remove ordinary Item from cargo by Object 
	 * @throws InvalidItemException
	 * @throws StockException
	 */
	@Test
	public void testRemoveOrdinaryFromCargo() throws InvalidItemException, StockException {
		Item cookie = new OrdinaryItem("cookie", 0, 0, 0 , 0);
		ordinaryTruck.addToCargo(cookie, 500);	
		ordinaryTruck.removeFromCargo(cookie);
	
		assertFalse(ordinaryTruck.getCargo().contains(cookie));	
	}
	
	/**
	 * Test to remove quantity of ordinary item from cargo
	 * @throws InvalidItemException
	 * @throws StockException
	 */
	@Test
	public void testRemoveOrdinaryAmountFromCargo() throws InvalidItemException, StockException {
		Item item1 = new OrdinaryItem("item1",0,0,0,0);
		ordinaryTruck.addToCargo(item1, 200);
		Item item2 = new OrdinaryItem("item2",0,0,0,0);
		ordinaryTruck.addToCargo(item2, 400);
		
		ordinaryTruck.removeFromCargo(item1, 200);
		ordinaryTruck.removeFromCargo(item2, 50);
		assertEquals(350, ordinaryTruck.getTotalCargo());
	}
	
	/**
	 * Test to remove item from cargo by ID
	 * @throws InvalidItemException
	 * @throws StockException
	 */
	@Test
	public void testRemoveOrdinaryFromCargoByID() throws InvalidItemException, StockException{
		Item cookie = new OrdinaryItem("cookie", 0, 0, 0 , 0);
		
		ordinaryTruck.addToCargo(cookie, 500);
		int id = ordinaryTruck.getCargo().getItemStock(cookie).getItemID();
		ordinaryTruck.removeFromCargo(id, 400);
	
		assertEquals(100, ordinaryTruck.getTotalCargo());
	}
	
	@Test
	public void testRemoveWrongOrdinaryFromCargo() throws InvalidItemException, StockException {
		Item item1 = new OrdinaryItem("item1",0,0,0,0);
		ordinaryTruck.addToCargo(item1, 200);
		Item item2 = new OrdinaryItem("item1",0,0,0,0);
		ordinaryTruck.addToCargo(item2, 400);
		
		ordinaryTruck.removeFromCargo(item1, 200);
		ordinaryTruck.removeFromCargo(item2, 50);
		assertNotEquals(72, refrigeratedTruck.getTotalCargo());
	}
	
	@Test
	public void testRemoveZeroOrdinaryFromCargo() throws InvalidItemException, StockException {
		Item item1 = new OrdinaryItem("item1",0,0,0,0);
		ordinaryTruck.addToCargo(item1, 200);
		Item item2 = new OrdinaryItem("item1",0,0,0,0);
		ordinaryTruck.addToCargo(item2, 400);
		
		ordinaryTruck.removeFromCargo(item1, 0);
		ordinaryTruck.removeFromCargo(item2, 0);
		assertEquals(600, refrigeratedTruck.getTotalCargo());
	}
	
	@Test (expected = StockException.class)
	public void testRemoveMillionOrdinaryFromCargo() throws InvalidItemException, StockException {
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
	public void testRemoveRefrigeratedFromCargo() throws InvalidItemException, StockException {
		Item icecream = new OrdinaryItem("cookie", 0, 0, 0 , 0);
		refrigeratedTruck.addToCargo(icecream, 500);	
		refrigeratedTruck.removeFromCargo(icecream);
	
		assertFalse(refrigeratedTruck.getCargo().contains(icecream));	
	}
	
	public void testRemoveRefridgeratedFromCargo() throws InvalidItemException, StockException {
		Item item1 = new PerishableItem("item1",0,0,0,0,0);
		refrigeratedTruck.addToCargo(item1, 200);
		Item item2 = new PerishableItem("item1",0,0,0,0,0);
		refrigeratedTruck.addToCargo(item2, 400);
		
		refrigeratedTruck.removeFromCargo(item1, 200);
		refrigeratedTruck.removeFromCargo(item2, 50);
		assertEquals(350, refrigeratedTruck.getTotalCargo());
	}
	
	@Test
	public void testRemoveRefrigeratedFromCargoByID() throws InvalidItemException, StockException{
		Item icecream = new PerishableItem("cookie", 0, 0, 0 , 0, 0);
		
		refrigeratedTruck.addToCargo(icecream, 40);
		int id = refrigeratedTruck.getCargo().getItemStock(icecream).getItemID();
		refrigeratedTruck.removeFromCargo(id, 20);
	
		assertEquals(20, refrigeratedTruck.getTotalCargo());
	}
	
	@Test
	public void testRemoveWrongRefrigeratedFromCargo() throws InvalidItemException, StockException {
		Item item1 = new PerishableItem("item1",0,0,0,0,0);
		refrigeratedTruck.addToCargo(item1, 200);
		Item item2 = new PerishableItem("item1",0,0,0,0,0);
		refrigeratedTruck.addToCargo(item2, 400);
		
		refrigeratedTruck.removeFromCargo(item1, 200);
		refrigeratedTruck.removeFromCargo(item2, 50);
		assertNotEquals(72, refrigeratedTruck.getTotalCargo());
	}
	
	@Test
	public void testRemoveZeroRefrigeratedFromCargo() throws InvalidItemException, StockException {
		Item item1 = new PerishableItem("item1",0,0,0,0,0);
		refrigeratedTruck.addToCargo(item1, 200);
		Item item2 = new PerishableItem("item1",0,0,0,0,0);
		refrigeratedTruck.addToCargo(item2, 400);
		
		refrigeratedTruck.removeFromCargo(item1, 0);
		refrigeratedTruck.removeFromCargo(item2, 0);
		assertEquals(600, refrigeratedTruck.getTotalCargo());
	}
	
	@Test (expected = StockException.class)
	public void testRemoveMillionRefrigeratedFromCargo() throws InvalidItemException, StockException {
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
	public void testGetCostOrdinary() throws InvalidItemException, StockException {
		Item cookie = new OrdinaryItem("Cookie", 0, 0, 0, 0);
		// Add 24 cookies to the cargo
		ordinaryTruck.addToCargo(cookie, 24);
		
		double cost = ordinaryTruck.getCost();
		assertEquals(756.0, cost, 0.00001);
	}
	
	@Test
	public void testRemoveThanGetCost() throws InvalidItemException, StockException {
		Item cookie = new OrdinaryItem("Cookie", 0, 0, 0, 0);
		// Add 24 cookies to the cargo
		ordinaryTruck.addToCargo(cookie, 24);
		// remove half the cookies from cargo
		ordinaryTruck.removeFromCargo(cookie, 12);
		
		double cost = ordinaryTruck.getCost();
		assertEquals(378.0, cost, 0.00001);
	}
	
	@Test
	public void testRemoveThanGetCostRefrigerated() throws InvalidItemException, StockException {
		Item icecream = new PerishableItem("icecream", 0, 0, 0, 0, -12);
		// Add 24 cookies to the cargo
		refrigeratedTruck.addToCargo(icecream, 40);
		// remove half the cookies from cargo
		refrigeratedTruck.removeFromCargo(icecream, 40);
		
		double cost = ordinaryTruck.getCost();
		assertEquals(0, cost, 0.00000);
	}
	
	//END test getCost Methods for both trucks
	
	//Ordinary and Refrigerated Truck getCapacity tests
	@Test (expected = StockException.class)
	public void testGetCapacityMillion() throws InvalidItemException, StockException {
		Item cookie = new OrdinaryItem(null, 0, 0, 0, 0);
		ordinaryTruck.addToCargo(cookie, 1000000);					
	}
	
	/**
	 * Tests to see if capacities of trucks are correct
	 * Ordinary truck : 1000 capacity, Refrigerated truck : 800 capacity
	 * @throws InvalidItemException
	 * @throws StockException
	 */
	@Test
	public void testGetCapacityBothTrucks() throws InvalidItemException, StockException {	
		int capacity = ordinaryTruck.getCapacity() + refrigeratedTruck.getCapacity();	
		assertEquals(1800, capacity);
	}
	
	@Test
	public void testGetCapacityOrdinaryTruck() throws InvalidItemException, StockException {
		int capacity = ordinaryTruck.getCapacity();
		assertEquals(1000, capacity);
	}
	
	@Test
	public void testGetWrongCapacityOrdinaryTruck() throws InvalidItemException, StockException {
		int capacity = ordinaryTruck.getCapacity();
		assertNotEquals(800, capacity);
	}
	
	@Test
	public void testGetCapacityRefrigeratedTruck() throws InvalidItemException, StockException {
		int capacity = refrigeratedTruck.getCapacity();
		assertEquals(800, capacity);
	}
	@Test
	public void testGetWrongCapacityRefrigeratedTruck() throws InvalidItemException, StockException {
		int capacity = refrigeratedTruck.getCapacity();
		assertNotEquals(1000, capacity);
	}
	
	//END Ordinary and Refrigerated Truck getCapacity tests

	
	/**
	 * Test to validate the correctness of the getTotalCargo Methods
	 * both refridgeratedtruck and ordinarytruck methods implemented
	 * @throws InvalidItemException
	 * @throws StockException
	 */
	@Test
	public void testGetTotalCargoBothTrucks() throws InvalidItemException, StockException {
		Item cookie = new OrdinaryItem("Cookie", 0, 0, 0, 0);
		Item icecream = new PerishableItem("Icecream", 0, 0, 0, 0, -12);		
		ordinaryTruck.addToCargo(cookie, 24);
		refrigeratedTruck.addToCargo(icecream, 40);
		
		int total = ordinaryTruck.getTotalCargo() + refrigeratedTruck.getTotalCargo();
		
		assertEquals(64, total);	
	}
	
	//GetTotalCargo OrdinaryTruck Tests
	@Test
	public void testGetTotalCargoOrdinaryTruck() throws InvalidItemException, StockException {
		Item cookie = new OrdinaryItem("Cookie", 0, 0, 0, 0);		
		ordinaryTruck.addToCargo(cookie, 24);
		
		int total = ordinaryTruck.getTotalCargo();		
		assertEquals(24, total);	
	}
	
	@Test
	public void testGetTotalCargoOrdinaryTruckWrong() throws InvalidItemException, StockException {
		Item cookie = new OrdinaryItem("Cookie", 0, 0, 0, 0);		
		ordinaryTruck.addToCargo(cookie, 12);
		
		int total = ordinaryTruck.getTotalCargo();		
		assertNotEquals(24, total);	
	}
			
	@Test
	public void testGetTotalCargoOrdinaryTruckZero() throws InvalidItemException, StockException {
		Item cookie = new OrdinaryItem(null, 0, 0, 0, 0);
		ordinaryTruck.addToCargo(cookie, 0);
	
		double capacity = ordinaryTruck.getTotalCargo();
		assertEquals(0, capacity, 0.001);
	}
	
	@Test (expected = StockException.class)
	public void testGetTotalCargoOrdinaryTruckMillion() throws InvalidItemException, StockException {
		Item cookie = new OrdinaryItem(null, 0, 0, 0, 0);
		ordinaryTruck.addToCargo(cookie, 50000);
	}
	
	@Test (expected = StockException.class)
	public void testGetTotalCargoOrdinaryTruckNegative() throws InvalidItemException, StockException {
		Item cookie = new OrdinaryItem(null, 0, 0, 0, 0);
		ordinaryTruck.addToCargo(cookie, -55);
	}
	//END GetTotalCargo ordinaryTruck Tests 
	
	
	//GetTotalCargo RefrigeratedTruck Tests
	@Test
	public void testGetTotalCargoRefrigeratedTruck() throws InvalidItemException, StockException {
		Item Icecream = new PerishableItem("Icecream", 0, 0, 0, 0, -12);		
		refrigeratedTruck.addToCargo(Icecream, 50);
		
		int total = refrigeratedTruck.getTotalCargo();		
		assertEquals(50, total);	
	}
	
	@Test
	public void testGetTotalCargoRefrigeratedTruckWrong() throws InvalidItemException, StockException {
		Item Icecream = new PerishableItem("Icecream", 0, 0, 0, 0, -12);	
		refrigeratedTruck.addToCargo(Icecream, 50);
		
		int total = refrigeratedTruck.getTotalCargo();		
		assertNotEquals(24, total);	
	}
			
	@Test
	public void testGetTotalCargoRefrigeratedTruckZero() throws InvalidItemException, StockException {
		Item Icecream = new PerishableItem("Icecream", 0, 0, 0, 0, -12);
		refrigeratedTruck.addToCargo(Icecream, 0);
	
		double capacity = refrigeratedTruck.getTotalCargo();
		assertEquals(0, capacity, 0.001);
	}
	
	@Test (expected = StockException.class)
	public void testGetTotalCargoRefrigeratedTruckMillion() throws InvalidItemException, StockException {
		Item Icecream = new PerishableItem("Icecream", 0, 0, 0, 0, -12);
		refrigeratedTruck.addToCargo(Icecream, 50000);
	}
	
	@Test (expected = StockException.class)
	public void testGetTotalCargoRefrigeratedTruckNegative() throws InvalidItemException, StockException {
		Item Icecream = new PerishableItem("Icecream", 0, 0, 0, 0, -12);
		refrigeratedTruck.addToCargo(Icecream, -55);
	}
	//END GetTotalCargo RefrigeratedTruck Tests

	
}