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
	
	@Test
	public void testAddOrdinaryToCargo() throws InvalidItemException, StockException {
		Stock cargo = new Stock();
		Item chicken = new OrdinaryItem(null, 0, 0, 0, 0);
		Item iceCream = new OrdinaryItem(null, 0, 0, 0, 0);
		
		cargo.addNewItem(chicken, 53);
		cargo.addNewItem(iceCream, 9);
		
		refrigeratedTruck.addToCargo(cargo);
		assertEquals(62, refrigeratedTruck.getTotalCargo());
	}
	
	@Test(expected = InvalidItemException.class)
	public void testAddInvalidTemperatureItemToCargo() throws InvalidItemException, StockException {
		Stock cargo = new Stock();
		Item liquidHelium = new PerishableItem("liquid Helium", 0, 0, 0, 0, -290);
		
		cargo.addNewItem(liquidHelium, 22);
		
		refrigeratedTruck.addToCargo(cargo);
	}
	
	@Test
	public void testRemoveOrdinaryFromCargo() throws InvalidItemException, StockException {
		Item item1 = new OrdinaryItem("item1",0,0,0,0);
		refrigeratedTruck.addToCargo(item1, 200);
		Item item2 = new OrdinaryItem("item2",0,0,0,0);
		refrigeratedTruck.addToCargo(item2, 400);
		
		refrigeratedTruck.removeFromCargo(item1, 200);
		refrigeratedTruck.removeFromCargo(item2, 50);
		assertEquals(350, refrigeratedTruck.getTotalCargo());
	}

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
}