/**
 * 
 */
package sales;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Holds a list of sales.
 * 
 * @author Daniel Field
 * @author Allen Basic
 */
public class SaleList {

	private List<Sale> list;
	
	/**
	 * Construct an array list of sales.
	 */
	public SaleList() {
		setList(new ArrayList<>());
	}

	/**
	 * Get the list of sales.
	 * 
	 * @return List<Sale>
	 */
	public List<Sale> getList() {
		return list;
	}

	/**
	 * Set the list of sales.
	 * 
	 * @param list
	 */
	public void setList(List<Sale> list) {
		this.list = list;
	}
	
	/**
	 * Add to the list of sales.
	 * 
	 * @param sale
	 */
	public void add(Sale sale) {
		list.add(sale);
	}
	
	/**
	 * Remove from the list of sales.
	 * 
	 * @param sale
	 */
	public void remove(Sale sale) {
		list.remove(sale);
	}
	
	/**
	 * Get a specific sale.
	 * 
	 * @param i Index of the sale.
	 * @return Sale object.
	 */
	public Sale getSale(int i) {
		return list.get(i);
	}
	
	/**
	 * Set the specified sale.
	 * 
	 * @param i index of the sale
	 * @param sale sale object
	 */
	public void setSale(int i, Sale sale) {
		list.set(i, sale);
	}
	
	/**
	 * Get the size of the sale List.
	 * 
	 * @return Sale list size
	 */
	public int size() {
		return list.size();
	}
	
	/**
	 * Get the iterator for the list
	 * 
	 * @return
	 */
	public Iterator<Sale> iterator() {
		return list.iterator();
	}
}
