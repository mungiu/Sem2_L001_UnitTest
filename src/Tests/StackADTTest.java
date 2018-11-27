package Tests;

import Stacks.ArrayStack;
import Stacks.StackADT;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StackADTTest extends Object {

	StackADT<String> a;

	@Before
	public void setUp() throws Exception {
		a = new ArrayStack<String>(5);
	}

	@Test(expected = IllegalStateException.class)
	public void pushMax() {
		a.push("a");
		a.push("a");
		a.push("a");
		a.push("a");
		a.push("a");
		a.push("a");
	}

	@Test(expected = IllegalArgumentException.class)
	public void pushNull() {
		a.push(null);
	}

	@Test
	public void pop() {
		a.push("a");
		a.push("b");
		a.push("c");
		assertEquals("c", a.pop());
	}

	@Test(expected = IllegalStateException.class)
	public void popEmpty() {
		a.pop();
	}

	@Test
	public void peek() {
		a.push("a");
		a.push("b");
		a.push("c");
		assertEquals("c", a.peek());
	}

	@Test(expected = IllegalStateException.class)
	public void peekEmpty() {
		a.peek();
	}

	// not stack index is different from queues index
	@Test
	public void indexOf() {
		a.push("a");
		a.push("b");
		a.push("c");
		a.push("b");
		assertEquals(0, a.indexOf("b"));
		assertEquals(-1, a.indexOf("QWERTY"));
	}

	@Test
	public void isEmpty() {
		assertEquals(true, a.isEmpty());
		a.push("a");
		assertEquals(false, a.isEmpty());
	}

	@Test
	public void isFull() {
		assertEquals(false, a.isFull());
		a.push("a");
		assertEquals(false, a.isFull());
		a.push("a");
		a.push("a");
		a.push("a");
		a.push("a");
		assertEquals(true, a.isFull());
	}

	@Test
	public void size() {
		assertEquals(0, a.size());
		a.push("a");
		a.push("a");
		a.push("a");
		a.push("a");
		a.push("a");
		assertEquals(5, a.size());

	}

	// NOTE that stacks work in reverse order VS queues
	@Test
	public void toStringTest() {
		a.push("a");
		a.push("a");
		a.push("B");
		assertEquals("{B, a, a}", a.toString());
	}
}