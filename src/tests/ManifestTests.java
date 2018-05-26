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
	/**
	 * Test to add multiple trucks to the manifest
	 * expected result is have two trucks in the Manifest
	 */
	@Test
	public void testAddMultipleTrucks() {
		Truck truck1 = new OrdinaryTruck();
		Truck truck2 = new RefrigeratedTruck();
		
		manifest.add(truck1);
		manifest.add(truck2);
		
		assertTrue(manifest.contains(truck1));
		assertTrue(manifest.contains(truck2));
	}
	
	/**
	 * Testing the size method in the Manifest Class
	 * expected result: add 4 to manifest, expect the result of 4 when checking size
	 */
	@Test
	public void testAddTrucksCheckSize() {
		Truck truck1 = new OrdinaryTruck();
		Truck truck2 = new RefrigeratedTruck();
		Truck truck3 = new RefrigeratedTruck();
		Truck truck4 = new OrdinaryTruck();
		
		manifest.add(truck1);
		manifest.add(truck2);
		manifest.add(truck3);
		manifest.add(truck4);
		
		int size = manifest.size();
		
		assertEquals(4, size);		
	}
	
	/**
	 * adding the truck to manifest by getting its index with the Manifest Get method
	 */
	@Test
	public void testAddTruckGetIndex() {
		Truck truck1 = new OrdinaryTruck();
		Truck truck2 = new RefrigeratedTruck();				
					
		assertFalse(manifest.contains(truck1));
		assertFalse(manifest.contains(truck2));
		
		manifest.add(truck1);
		manifest.add(truck2);
		
		Truck yummyTruck = manifest.get(0);
		Truck coldTruck = manifest.get(1);
		
		assertTrue(manifest.contains(yummyTruck));
		assertTrue(manifest.contains(coldTruck));		
	}
	
	/**
	 * Test to see if the remove method from the Manifest class works as intended
	 */
	@Test
	public void testRemoveTruck() {
		Truck myTruck = new RefrigeratedTruck();
		manifest.add(myTruck);
		
		assertTrue(manifest.contains(myTruck));		
		manifest.remove(myTruck);		
		assertFalse(manifest.contains(myTruck));
	}
		
	/**
	 * test to check the size of manifest after removing some trucks
	 * Expected result: add 4 trucks to manifest, remove 2, expect 2 to be left
	 */
	@Test
	public void testRemoveTrucksCheckSize() {
		Truck truck1 = new OrdinaryTruck();
		Truck truck2 = new RefrigeratedTruck();
		Truck truck3 = new RefrigeratedTruck();
		Truck truck4 = new OrdinaryTruck();
		
		manifest.add(truck1);
		manifest.add(truck2);
		manifest.add(truck3);
		manifest.add(truck4);
		
		int size = manifest.size();	
		
		assertEquals(4, size);
		manifest.remove(truck1);
		manifest.remove(truck3);
		
		int newSize = manifest.size();
		assertEquals(2, newSize);		
	}
	
	/**
	 * testing to see if removing just one truck works as intended
	 * Expected result is for the other truck to remain in manifest
	 */
	@Test
	public void testAddTrucksRemoveJustOne() {
		Truck truck1 = new OrdinaryTruck();
		Truck truck2 = new RefrigeratedTruck();
		
		manifest.add(truck1);
		manifest.add(truck2);
		
		assertTrue(manifest.contains(truck1));
		assertTrue(manifest.contains(truck2));			
		manifest.remove(truck1);		
		assertTrue(manifest.contains(truck2));
		assertFalse(manifest.contains(truck1));		
	}
	
	/**
	 * Tests the size of two manifests added together
	 * Expected result: Size of both manifests
	 */
	@Test
	public void testSizeOfTwoManifests() {
		Manifest m1 = new Manifest();
		Manifest m2 = new Manifest();
		Truck truck1 = new OrdinaryTruck();
		Truck truck2 = new RefrigeratedTruck();
		
		m1.add(truck2);
		m2.add(truck1);		
		int size = m1.size() + m2.size();
		
		assertEquals(2, size);
	}
	
	/**
	 * Testing to check whether one truck can belong to different manifests
	 */
	@Test
	public void testTwoManifestsOneTruck() {
		Manifest m1 = new Manifest();
		Manifest m2 = new Manifest();
		Truck truck1 = new OrdinaryTruck();
		
		m1.add(truck1);
		m2.add(truck1);				
		
		assertTrue(m1.contains(truck1));
		assertTrue(m2.contains(truck1));
	}
	
	
	/**
	 * Testing the get method from Manifest Class
	 */
	@Test
	public void testRemoveTruckByIndex() {
		Truck truck1 = new OrdinaryTruck();
		Truck truck2 = new RefrigeratedTruck();
		Truck truck3 = new RefrigeratedTruck();
		
		manifest.add(truck1); //0 index
		manifest.add(truck2); //1 index
		manifest.add(truck3); //2 index
		
		Truck yuckytruck = manifest.get(1);
		
		assertTrue(manifest.contains(truck2));
		manifest.remove(yuckytruck);
		assertTrue(manifest.contains(truck1));
		assertFalse(manifest.contains(truck2));
		assertTrue(manifest.contains(truck3));
	}
	
	/**
	 * Test case of checking what happens when a truck that isnt in manifest is removed
	 * @throws IndexOutOfBoundsException: Should throw this since we are trying to reference nothing
	 */
	@Test (expected = IndexOutOfBoundsException.class)
	public void testRemoveNonExistentIndex() throws IndexOutOfBoundsException {
		Truck truck1 = new OrdinaryTruck();
		Truck truck2 = new RefrigeratedTruck();
		
		manifest.add(truck1); //0 index
		manifest.add(truck2); //1 index
		
		Truck yummyTruck = manifest.get(0);
		Truck coldTruck = manifest.get(1);		
		Truck NonExistent = manifest.get(4);
		
		manifest.remove(4);		
	}
	
	/**
	 * Tests to see if a non existent Index can be added to manifest
	 * Expected result 
	 * @throws IndexOutOfBoundsException
	 */
	@Test (expected = IndexOutOfBoundsException.class)
	public void testAddNonExistentIndex() throws IndexOutOfBoundsException {	
		Truck NonExistent = manifest.get(4);
		manifest.add(NonExistent);		
	}
	
	/**
	 * Test case of checking what happens when we try to get an index that has no truck assigned
	 * @throws IndexOutOfBoundsException: Should throw this since we are trying to reference nothing
	 */
	@Test (expected = IndexOutOfBoundsException.class)
	public void testGetNonExistentIndex() throws IndexOutOfBoundsException {
		Truck truck1 = new OrdinaryTruck();
		Truck truck2 = new RefrigeratedTruck();
		
		manifest.add(truck1); //0 index
		manifest.add(truck2); //1 index

		Truck yummyTruck = manifest.get(0);
		Truck coldTruck = manifest.get(3);				
	}
	
	/**
	 * Test to see if the size method counts an empty manifest correctly
	 * @throws IndexOutOfBoundsException
	 */
	@Test 
	public void testGetSizeOfEmptyManifest() throws IndexOutOfBoundsException {			
		assertEquals(0, new Manifest().size());	
	}
	
	
	
}