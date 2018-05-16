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
	
	public boolean remove(Truck o) {
		return manifest.remove(o);
	}
	
	@Override
	public boolean add(Truck e) {
		return manifest.add(e);
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