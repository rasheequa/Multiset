package pobj.multiset;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;

import java.util.Iterator;
import java.util.List;


public class NaiveMultiSet<T>  extends AbstractCollection<T>  implements MultiSet<T> {
	public ArrayList<T> liste;
	
	public NaiveMultiSet() {
		liste = new ArrayList<>();
	}
	

	public NaiveMultiSet(Collection<T> collection) {
		liste = new ArrayList<>(collection);
	}	
	
	@Override
	public boolean add(T e, int count) {
		if (count<0) return false;
		for(int i = 0; i<count;i++) {
			liste.add(e);
		}
		return true;
	}

	@Override
	public boolean add(T e) {
		return liste.add(e);
		
	}

	@Override
	public boolean remove(Object e) {
		return liste.remove(e);
	}

	@Override
	public boolean remove(Object e, int count) {
		if (count <= 0) return false;
        boolean removed = false;
        
        for (int i = 0; i < count && liste.contains(e); i++) {
            liste.remove(e);
            removed = true;
        }
        
        return removed;
    }

	@Override
	public int count(T o) {
		// TODO Auto-generated method stub
		int count=0;
		for(T t : liste) {
			if (t.equals(o))
				count++;
		}
		return count;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		liste.clear();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return liste.size();
	}
	
	@Override
	public List<T> elements() {
		// TODO Auto-generated method stub
		List<T> elements = new ArrayList<>();
		
		for(T t : liste) {
			if (!elements.contains(t) ) {
				elements.add(t);	
			}
		}
	    return elements;	
	}

	@Override
    public Iterator<T> iterator() {
        return liste.iterator();
    }
		
}

	
