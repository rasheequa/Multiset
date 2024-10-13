package pobj.multiset.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.Test;

import pobj.multiset.HashMultiSet;
import pobj.multiset.MultiSet;

public class HashMultiSetTest2 {
		
		@Test
		public void testAdd1() { 
		MultiSet<String> ms = new HashMultiSet<>(); 
		ms.add("a"); 
		ms.add("a",5); 
		assertEquals(ms.count("a"), 6); 
		} 
		
		@Test 
		public void testAdd2() { 
		MultiSet<String> ms = new HashMultiSet<>(); 
		ms.add("a"); 
		assertThrows(IllegalArgumentException.class,
		() -> { ms.add("a",-1); }
		); 
		}
		
		@Test
		public void testRemove1() { 
		MultiSet<String> ms = new HashMultiSet<>(); 
		ms.add("b", 3);
	    ms.remove("b", 2);
	    assertEquals(1, ms.count("b"));
	    ms.remove("b", 1);
	    assertEquals(0, ms.count("b"));
	    assertFalse(ms.remove("b"));
		} 
		
		@Test 
		public void testRemove2() { 
		MultiSet<String> ms = new HashMultiSet<>(); 
		ms.add("a"); 
		assertThrows(IllegalArgumentException.class,
		() -> { ms.remove("a",-1); }
		); 
		}
		
		@Test
		public void testClear() {
		    MultiSet<String> ms = new HashMultiSet<>();
		    ms.add("f", 5);
		    ms.clear();
		    assertEquals(0, ms.size());
		    assertEquals("[]", ms.toString());
		}
			
		@Test
		public void testSize() {
		    MultiSet<String> ms = new HashMultiSet<>();
		    ms.add("c", 4);
		    assertEquals(4, ms.size());
		    ms.remove("c", 2);
		    assertEquals(2, ms.size());
		}
		
		@Test
		public void testToString() {
		    MultiSet<String> ms = new HashMultiSet<>();
		    ms.add("d", 2);
		    ms.add("e", 3);
		    assertEquals("[d:2; e:3; ]", ms.toString());
		}
		
		@Test
		public void testAddRemove() {
		    MultiSet<String> ms = new HashMultiSet<>();
		    ms.add("g", 2);
		    ms.add("h", 4);
		    ms.remove("g", 1);
		    ms.add("i", 3);
		    ms.remove("h", 2);
		    assertEquals(1, ms.count("g"));
		    assertEquals(2, ms.count("h"));
		    assertEquals(3, ms.count("i"));
		    assertEquals(6, ms.size());
		}
		
		@Test
		public void testAddRemoveCount() {
		    MultiSet<String> ms = new HashMultiSet<>();
		    ms.add("k", 7);
		    ms.remove("k", 7);
		    assertEquals(0, ms.count("k"));
		}
		@Test
		public void testCount() {
		    MultiSet<String> ms = new HashMultiSet<>();
		    assertEquals(0, ms.count("l")); 
		}

}
