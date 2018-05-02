package delivery;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a collection of trucks.
 * 
 * @author Daniel Field
 *
 */
public class Manifest extends AbstractList<Truck> {

	private List<Truck> manifest;
	
	public Manifest() {
		manifest = new ArrayList<>();
	}
	
	@Override
	public boolean add(Truck e) {
		return manifest.add(e);
	}
	
	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return manifest.remove(o);
	}
	
	@Override
	public Truck get(int index) {
		return manifest.get(index);
	}

	@Override
	public int size() {
		return manifest.size();
	}

}