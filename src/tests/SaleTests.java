package tests;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;
import supermart.Sale;
import supermart.SaleList;

import org.junit.Before;
import exception.StockException;


/**
 * Test cases for the Stock collection.
 * 
 * @author Allen Basic
 *
 */
public class SaleTests {
	
	
	Sale sales;
	SaleList salelist;
	
	/**
	 * Before each test, instantiate the Sale and SaleList class and store it in an object.
	 */
	@Before @Test
	public void testInitialize() {
		sales = new Sale();
		salelist= new SaleList();
	}
	
	/**
	 * test to see if Adding a sale to the SaleList works
	 * @throws StockException
	 */
	@Test
	public void testAddSale() throws StockException {
		Sale sale = new Sale();
		SaleList list = new SaleList();
		
		sale.setItemName("BunchOfApples");
		sale.setQuantity(70);
		
		list.add(sale);
		
		assertTrue(list.getList().contains(sale));
	}
	/**
	 * test the adding of Multiple Sales to the SaleList
	 * @throws StockException
	 */
	@Test
	public void testAddMultipleSales() throws StockException {
		Sale sale1 = new Sale();
		Sale sale2 = new Sale();
		SaleList  list = new SaleList();
		
		sale1.setItemName("Icecream");
		sale1.setQuantity(52);
		sale2.setItemName("banana");
		sale2.setQuantity(15);
		
		list.add(sale1);
		list.add(sale2);
		
		assertTrue(list.getList().contains(sale1));
		assertTrue(list.getList().contains(sale2));				
	}
	
	/**
	 * test to remove a specific Sale From the SaleList
	 * @throws StockException
	 */
	@Test
	public void testRemoveSaleFromList() throws StockException {
		Sale sale1 = new Sale();
		Sale sale2 = new Sale();
		SaleList list = new SaleList();
		
		sale1.setItemName("BunchOfApples");
		sale1.setQuantity(70);
		sale2.setItemName("banana");
		sale2.setQuantity(15);
		
		list.add(sale1);
		list.add(sale2);
		
		list.remove(sale1);
		
		assertFalse(list.getList().contains(sale1));
		assertTrue(list.getList().contains((sale2)));
	}
	
	/**
	 * testing the size method for SaleList
	 * @throws StockException
	 */
	@Test
	public void testSaleSize() throws StockException {
		Sale sale1 = new Sale();
		Sale sale2 = new Sale();
		Sale sale3 = new Sale();
		SaleList list = new SaleList();
		
		sale1.setItemName("BunchOfApples");
		sale1.setQuantity(70);
		sale2.setItemName("bananas");
		sale2.setQuantity(15);
		sale3.setItemName("IcecreamContainers");
		sale3.setQuantity(10);
		
		list.add(sale1);
		list.add(sale2);
		list.add(sale3);
		
		int size = list.size();
		
		assertEquals(3, size);
	}
	/**
	 * testing to see if the result returns the correct size
	 * @throws StockException
	 */
	@Test
	public void testSaleSizeWrong() throws StockException {
		Sale sale1 = new Sale();
		Sale sale2 = new Sale();
		Sale sale3 = new Sale();
		SaleList list = new SaleList();
		
		sale1.setItemName("BunchOfApples");
		sale1.setQuantity(70);
		sale2.setItemName("bananas");
		sale2.setQuantity(15);
		sale3.setItemName("IcecreamContainers");
		sale3.setQuantity(10);
		
		list.add(sale1);
		list.add(sale2);
		list.add(sale3);
		
		int size = list.size();
		
		assertNotEquals(8, size);
	}
	/**
	 * testing the get and set methods in the SaleList Class
	 * @throws StockException
	 */
	@Test
	public void testGetAndSetSale() throws StockException {
		Sale sale1 = new Sale();
		Sale sale2 = new Sale();
		SaleList list = new SaleList();
			
		sale1.setItemName("BunchOfApples");
		sale1.setQuantity(70);
		sale2.setItemName("BoxOfBananas");
		sale2.setQuantity(60);
		

		list.add(sale2);
				
		list.setSale(0, sale1);	
		assertTrue(list.getList().contains(sale1));						
		assertFalse(list.getList().contains(sale2));		
	}
	
	@Test
	/**
	 * Test that the iterator has next
	 */
	public void testIteratorHasNext() throws StockException {
		Sale sale1 = new Sale();
		Sale sale2 = new Sale();
		SaleList list = new SaleList();
		
		sale1.setItemName("BunchOfApples");
		sale1.setQuantity(70);
		sale2.setItemName("bananas");
		sale2.setQuantity(15);
		
		list.add(sale1);
		list.add(sale2);
		
		assertTrue(list.iterator().hasNext());		
	}
	
	/**
	 * test the iterator in the SaleList
	 * result should return false since list is empty
	 * @throws StockException
	 */
	@Test
	public void testIteratorHasNextEmptyList() throws StockException {
		SaleList list = new SaleList();
			
		assertFalse(list.iterator().hasNext());			
	}
	/**
	 * test iterator.next on list of one item
	 * @throws StockException
	 */
	@Test
	public void testIteratorNext() throws StockException {
		Sale sale = new Sale();
		SaleList list = new SaleList();
		
		sale.setItemName("BunchOfApples");
		sale.setQuantity(70);		
		list.add(sale);
		
		assertEquals(sale, list.iterator().next());		
	}
	
	/**
	 * testing to see if iterator.hasnext method works as intended after removing sale
	 * @throws StockException
	 */
	@Test
	public void testHasNextWithRemove() throws StockException {
		Sale sale = new Sale();
		SaleList list = new SaleList();
		
		sale.setItemName("BunchOfApples");
		sale.setQuantity(70);	
		
		list.add(sale);
		assertTrue(list.iterator().hasNext());
		list.remove(sale);
		assertFalse(list.iterator().hasNext());
	}
	
	@Test (expected = NoSuchElementException.class)
	public void testNextWithRemove() throws StockException {
		Sale sale = new Sale();
		SaleList list = new SaleList();
		
		sale.setItemName("BunchOfApples");
		sale.setQuantity(70);	
		
		list.add(sale);
		assertEquals(sale ,list.iterator().next());
		list.remove(sale);
		list.iterator().next(); // No such element
	}
	
	/**
	 * test the getQuantity method in the Sale class
	 * @throws StockException
	 */
	@Test
	public void testGetQuantity() throws StockException {
		Sale sale = new Sale();
		SaleList list = new SaleList();
		
		sale.setItemName("BunchOfApples");
		sale.setQuantity(70);
		list.add(sale);		
		int quantity = sale.getQuantity();
		
		assertEquals(70, quantity);
	}
	
	/**
	 * test adding up all quantities of sales
	 * @throws StockException
	 */
	@Test
	public void testGetQuantityOfAllSales() throws StockException{
		Sale sale1 = new Sale();
		Sale sale2 = new Sale();
		Sale sale3 = new Sale();
		SaleList list = new SaleList();
	
		sale1.setItemName("BunchOfApples");
		sale1.setQuantity(70);
		sale2.setItemName("bananas");
		sale2.setQuantity(15);
		sale3.setItemName("IcecreamContainers");
		sale3.setQuantity(10);
	
		list.add(sale1);
		list.add(sale2);
		list.add(sale3);
	
		int size = sale1.getQuantity() + sale2.getQuantity()+ sale3.getQuantity();
		
		assertEquals(95, size);
	}
	
	/**
	 * test adding quantity to a Sale
	 * @throws StockException
	 */
	@Test
	public void testAddQuantity() throws StockException {
		Sale sale = new Sale();
		SaleList list = new SaleList();
		
		sale.setItemName("BunchOfApples");
		sale.setQuantity(70);
		list.add(sale);	
		int newQuantity = sale.getQuantity() + 52;
		
		assertEquals(122, newQuantity);
	}
	
	/**
	 * test adding zero quantity to a Sale
	 * @throws StockException
	 */
	@Test
	public void testAddZeroQuantity() throws StockException {
		Sale sale = new Sale();
		SaleList list = new SaleList();
		
		sale.setItemName("BunchOfApples");
		sale.setQuantity(70);
		list.add(sale);	
		int newQuantity = sale.getQuantity() + 0;
		
		assertEquals(70, newQuantity);
	}
	
	/**
	 * test adding negative quantity to a Sale
	 * @throws StockException: negative numbers should not be used in adding
	 */
	@Test (expected = StockException.class)
	public void testAddNegativeQuantity() throws StockException {
		Sale sale = new Sale();
		SaleList list = new SaleList();
		
		sale.setItemName("BunchOfApples");
		sale.setQuantity(-70);
	}
	
	/**
	 * test Removing quantity from a Sale
	 * @throws StockException
	 */
	@Test
	public void testRemoveQuantity() throws StockException {
		Sale sale = new Sale();
		SaleList list = new SaleList();
		
		sale.setItemName("BunchOfApples");
		sale.setQuantity(70);
		list.add(sale);	
		int newQuantity = sale.getQuantity() - 52;
		
		assertEquals(18, newQuantity);
	}
	
	/**
	 * test removing more than the quantity of a Sale
	 * @throws StockException: removing more than the quantity should remove the Sale
	 */
	@Test (expected = StockException.class)
	public void testRemoveMoreThanSaleQuantity() throws StockException {
		Sale sale = new Sale();
		SaleList list = new SaleList();
		
		sale.setItemName("BunchOfApples");
		sale.setQuantity(70);
		list.add(sale);	
		int newQuantity = sale.getQuantity() -80;
		sale.setQuantity(newQuantity);
	}
	
	/**
	 * test removing more than the quantity of a Sale
	 * @throws StockException: A sale with 0 quantity should not exist
	 */
	@Test (expected = StockException.class)  
	public void testRemoveAllQuantity() throws StockException {
		Sale sale = new Sale();
		SaleList list = new SaleList();
		
		sale.setItemName("BunchOfApples");
		sale.setQuantity(70);
		list.add(sale);	
		int newQuantity = sale.getQuantity() -70;
		sale.setQuantity(newQuantity);
	}
	
	/**
	 * test removing zero quantity
	 * @throws StockException
	 */
	@Test   
	public void testRemoveZeroQuantity() throws StockException {
		Sale sale = new Sale();
		SaleList list = new SaleList();
		
		sale.setItemName("BunchOfApples");
		sale.setQuantity(70);
		list.add(sale);	
		int newQuantity = sale.getQuantity() -0;
		sale.setQuantity(newQuantity);
		
		assertEquals(70, newQuantity);
	}
	
	/**
	 * testing to see if a sale of zero quantity can be added to list
	 * @throws StockException: sales of zero quantity shouldnt exist
	 */
	@Test (expected = StockException.class)
	public void testSaleZeroQuantity() throws StockException {
		Sale sale = new Sale();
		SaleList list = new SaleList();
		
		sale.setItemName("WhereAreMyApples");
		sale.setQuantity(0);		
		list.add(sale);
	}
	
	/**
	 * testing a sale of a million quantity
	 * @throws StockException
	 */
	@Test 
	public void testSaleMilliQuantity() throws StockException {
		Sale sale = new Sale();
		SaleList list = new SaleList();
		
		sale.setItemName("AMillionApples");
		sale.setQuantity(1000000);		
		list.add(sale);
		
		assertTrue(list.getList().contains(sale));
	}
	
	/**
	 * testing a sale of negative quantity
	 * @throws StockException: any sales with >=0 quantity shouldnt exist
	 */
	@Test (expected = StockException.class)
	public void testSaleNegativeQuantity() throws StockException {
		Sale sale = new Sale();
		SaleList list = new SaleList();
		
		sale.setItemName("InvisibleApples");
		sale.setQuantity(-42);		
		list.add(sale);
	}
		
	/**
	 * testing the add and remove sale methods
	 * @throws StockException
	 */
	@Test
	public void testAddThenRemoveSale() throws StockException {
		Sale sale = new Sale();
		SaleList list = new SaleList();
		
		sale.setItemName("BunchOfApples");
		sale.setQuantity(70);	
		list.add(sale);	
		list.remove(sale);
		
		assertFalse(list.getList().contains(sale));
	}
	
	/**
	 * testing a sale of empty quantity and no name
	 * @throws StockException: any sales with >=0 quantity or no name shouldnt exist
	 */
	@Test (expected = StockException.class)
	public void testEmptySale() throws StockException {
		Sale sale = new Sale();
		SaleList list = new SaleList();
		
		sale.setItemName("");
		sale.setQuantity(0);		
		list.add(sale);
	}	
	
	/**
	 * testing to the GetItemName method in Sale class
	 * @throws StockException
	 */
	@Test
	public void testGetItemName() throws StockException {
		Sale sale = new Sale();
		SaleList list = new SaleList();
		
		sale.setItemName("BunchOfApples");
		sale.setQuantity(70);	
		list.add(sale);	
		String name = sale.getItemName();
		
		assertEquals("BunchOfApples", name);	
	}
	
	/**
	 * testing a sale with no name
	 * @throws StockException: any sale with no name shouldnt exist
	 */
	@Test (expected = StockException.class)
	public void testSaleEmptyName() throws StockException {
		Sale sale = new Sale();
		SaleList list = new SaleList();
		
		sale.setItemName("");
		sale.setQuantity(72);		
		list.add(sale);
	}
	
	/**
	 * testing to see if a very long sale name can be used
	 * @throws StockException
	 */
	@Test
	public void testSaleNameSuperLong() throws StockException {
		Sale sale = new Sale();
		SaleList list = new SaleList();
		
		sale.setItemName("ForSomeReasonWhenIDoTestingILikeToThinkOfThePeopleMarkingThisAndWhatTheyThinkOfTheseUnitTests");
		sale.setQuantity(20);		
		list.add(sale);
		
		assertTrue(list.getList().contains(sale));
	}
}
