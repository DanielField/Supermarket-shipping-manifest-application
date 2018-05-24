package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import delivery.Manifest;
import delivery.OrdinaryTruck;
import delivery.RefrigeratedTruck;
import delivery.Truck;

/**
 * @author Allen Basic
 *
 */
public class ManifestTests {

	Manifest manifest;
	
	@Before @Test
	public void testInit() {
		manifest = new Manifest();
	}

	@Test
	public void testAddTruck() {
		Truck myTruck = new OrdinaryTruck();
		manifest.add(myTruck);
		
		assertTrue(manifest.contains(myTruck));
	}
	
	@Test
	public void testRemoveTruck() {
		Truck myTruck = new RefrigeratedTruck();
		manifest.add(myTruck);
		
		assertTrue(manifest.contains(myTruck));
		
		manifest.remove(myTruck);
		
		assertFalse(manifest.contains(myTruck));
	}
}