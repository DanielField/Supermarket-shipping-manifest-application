/**
 * 
 */
package supermart;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @author Daniel Field
 *
 */
public class SaleList {

	private List<Sale> list;
	
	/**
	 * Construct a list of sales.
	 */
	public SaleList() {
		setList(new ArrayList<>());
	}

	public List<Sale> getList() {
		return list;
	}

	public void setList(List<Sale> list) {
		this.list = list;
	}
	
	public void add(Sale sale) {
		list.add(sale);
	}
	
	public void remove(Sale sale) {
		list.remove(sale);
	}
	
	public Sale getSale(int i) {
		return list.get(i);
	}
	
	public void setSale(int i, Sale sale) {
		list.set(i, sale);
	}
	
	public int size() {
		return list.size();
	}
	
	public Iterator<Sale> iterator() {
		return list.iterator();
	}
}
