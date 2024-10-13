package pobj.multiset.test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pobj.multiset.MultiSet;
import pobj.multiset.NaiveMultiSet;

public class NaiveMultiSetTest {
	private MultiSet<String> m;
	
	@BeforeEach
	public void before() {
		m = new NaiveMultiSet<String>();
		m.add("a");
		m.add("a",5);
		m.add("b",3);
	}
	
	@Test 
	public void test1() {
		assertEquals(6, m.count("a"));
	}
}
