package pobj.multiset;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HashMultiSet<T> extends AbstractCollection<T> implements MultiSet<T> {
	public int size;
	public HashMap<T,Integer> map;
	
	public HashMultiSet() {
		map= new HashMap<T,Integer>() ;
		size=0;
	}
	

	public HashMultiSet(Collection<T> collection) {
		map= new HashMap<T,Integer>() ;
		size=0;
		for(T element : collection) {
			add((T)element);
		}
	}
		
	public Iterator<T> iterator(){
		return new HashMultiSetIterator();
	}
	
	@Override
	public boolean add(T e, int count) {
		if(count<0) throw new IllegalArgumentException("count ne peut pas être négatif");
		map.put(e, map.getOrDefault(e,0)+count);
		size+=count;
		return true;
		
	}

	@Override
	public boolean add(T e) {
		return add(e, 1);

	}

	@Override
	public boolean remove(Object e) {
		return remove(e,1);
	}

	@Override
	public boolean remove(Object e, int count) {
		
		if (count <0) throw new IllegalArgumentException("count ne peut pas être négatif");
		
		if(map.containsKey(e)) {
			int current_count = map.get(e);
			if(count>=current_count) {
				size -= current_count;
				map.remove(e);
				return true;
			}
			else {
				size-=count;
				map.put((T) e,current_count-count);
				return true;
			}
		}

		return false;	
	}

	@Override
	public int count(T o) {
		// TODO Auto-generated method stub
		return map.getOrDefault(o,0);
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		size=0;
		map.clear();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	
	@Override
	public List<T> elements() {
		// TODO Auto-generated method stub
		List<T> elements = new ArrayList<>(map.keySet());
	    return elements;	
	}
	
	
	public class HashMultiSetIterator implements Iterator<T> {
		private int count = 0;
		private Iterator<Map.Entry<T,Integer>> iterator;
		private Map.Entry<T,Integer> current;
		
		public HashMultiSetIterator() {
            iterator = map.entrySet().iterator();
        }
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return count > 0 || iterator.hasNext();
		}

		@Override
		public T next() {
			if (count == 0) {
	            current = iterator.next(); 
	            count = current.getValue(); 
	        }

	        count--; 
	        return current.getKey(); 
		
		}

		
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		map.forEach( (k,v) -> sb.append(k).append(":").append(v).append("; "));
//		sb.delete(sb.length()-"; ".length(), sb.length());
		sb.append("]");
		return sb.toString();
	}
	
}
