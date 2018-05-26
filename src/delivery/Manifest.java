package delivery;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a collection of trucks.
 * 
 * @author Daniel Field
 * @author Allen Basic
 */
public class Manifest extends AbstractList<Truck> {

	private List<Truck> manifest;
	
	/**
	 * Construct a new list of trucks.
	 */
	public Manifest() {
		manifest = new ArrayList<>();
	}
	
	/* (non-Javadoc)
	 * @see java.util.AbstractCollection#remove(java.lang.Object)
	 */
	@Override
	public boolean remove(Object o) {
		return manifest.remove(o);
	}
	
	/* (non-Javadoc)
	 * @see java.util.AbstractList#add(java.lang.Object)
	 */
	@Override
	public boolean add(Truck e) {
		return manifest.add(e);
	}
	
	/* (non-Javadoc)
	 * @see java.util.AbstractList#get(int)
	 */
	@Override
	public Truck get(int index) {
		return manifest.get(index);
	}

	/* (non-Javadoc)
	 * @see java.util.AbstractCollection#size()
	 */
	@Override
	public int size() {
		return manifest.size();
	}
}