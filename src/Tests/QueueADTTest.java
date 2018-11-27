package Tests;

import Queues.BoundedArrayQueueA;
import Queues.QueueADT;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class QueueADTTest extends Object
{
	QueueADT<String> q;

	// this runs before every Test method automatically
	@Before
	public void setUp() throws Exception
	{
		// Because BoundedArray implements QueueADT interface
		q = new BoundedArrayQueueA<>(5);
	}

	@Test(expected = IllegalStateException.class)
	public void enqueueTooMany()
	{
		for (int i = 0; i < 3; i++)
			q.enqueue("asd" + i);
		assertEquals(3, q.size());

		for (int i = 0; i < 3; i++)
			q.enqueue("asd" + i);
		assertEquals(5, q.size());

		q.enqueue("asd");
	}

	@Test(expected = IllegalArgumentException.class)
	public void enqueueNull()
	{
		q.enqueue(null);
	}

	@Test(expected = IllegalStateException.class)
	public void dequeue()
	{
		q.enqueue("asd");
		q.enqueue("dsa");
		assertEquals("asd", q.dequeue());
		q.dequeue();
		q.dequeue();
	}

	@Test(expected = IllegalStateException.class)
	public void first()
	{
		assertEquals(null, q.first());
		q.enqueue("asd");
		q.enqueue("dsa");
		assertEquals("asd", q.first());
		assertEquals("asd", q.first());
	}

	@Test
	public void size()
	{

		q.enqueue("asd");
		q.enqueue("dsa");
		q.enqueue("fds");
		q.enqueue("asgdfg");
		q.enqueue("dasfsdgh");
		assertEquals(5, q.size());
	}

	@Test
	public void isEmpty()
	{
		assertEquals(true, q.isEmpty());
		q.enqueue("asd");
		assertEquals(false, q.isEmpty());
	}

	@Test
	public void indexOf()
	{
		assertEquals(-1, q.indexOf("asd"));
		q.enqueue("asd");
		q.enqueue("asd");
		q.enqueue("dsa");
		assertEquals(2, q.indexOf("dsa"));
		assertEquals(0, q.indexOf("asd"));
	}

	@Test
	public void contains()
	{
		q.enqueue("dsa");
		q.enqueue("bca");
		q.enqueue("asd");
		assertEquals(true, q.contains("asd"));
	}

	@Test
	public void toStringTest()
	{
		q.enqueue("A");
		q.enqueue("b");
		q.enqueue("C");
		assertEquals("{A, b, C}", q.toString());
	}
}