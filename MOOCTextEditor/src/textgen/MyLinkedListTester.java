/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
	    // shortList.add(null);
	    shortList.add("A");
		shortList.add("B");
		// shortList.add(0, null);
		// shortList.add(3, "C");
		shortList.add(0, "C");
		shortList.add(1, "D");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "C", shortList.get(0));
		assertEquals("Check second", "D", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(5);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		assertEquals("Remove: check a is correct ", (Integer) 65, list1.remove(0));
		
		// test remove element in an empty list, remove should throw an exception
		try {
			emptyList.remove(0);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {
			
		}
		
		try {
			shortList.remove(5);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {
			
		}
		// TODO: Add more tests here
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	
	@Test
	public void testAddEnd()
	{
        // TODO: implement this test
		// test adding null element
		try {
			shortList.add(null);
			fail("Check null object");
		} catch (NullPointerException e) {
			
		}
		// test adding the first element to an empty list
		assertEquals("Check the firstly-added element", true, shortList.add("A"));
		//assertEquals("Check the firstly-added element", false, false);
		// test adding the second element to an empty list
		assertEquals("Check the secondly-added element", true, shortList.add("B"));
		//assertEquals("Check the secondly-added element", false, false);
	}


	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		// TODO: implement this test
		// test size of empty list
		assertEquals("Check size of empty list ", 0, emptyList.size());
		// test size of short list
		assertEquals("Check size of short list ", 4, shortList.size());
		// test size of list1
		assertEquals("Check size of list1 list ", 3, list1.size());
	}

	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	
	@Test
	public void testAddAtIndex()
	{
        // TODO: implement this test
		// test adding null element
		try {
			shortList.add(0, null);
			fail("Check null object");
		} catch (NullPointerException e) {
			
		}
		// test adding invalid index
		try {
			shortList.add(5, "C");
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {
			
		}
		// test adding element to the first position in the list
		//assertEquals("Check total num of elements", 4, shortList.size());
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
	    // TODO: implement this test
		try {
			list1.set(3, 16);
			fail("Check index");
		} catch (IndexOutOfBoundsException e) {
			
		}
		
		try {
			list1.set(1, null);
			fail("Check null object");
		} catch (NullPointerException e) {
			
		}
		
		assertEquals("Set: check set 1 is correct ", (Integer) 21, list1.set(1, 16));
		assertEquals("Set: check set 0 is correct ", (Integer) 65, list1.set(0, 33));
		assertEquals("Set: check set 2 is correct ", (Integer) 42, list1.set(2, 49));
	
	}
	
	
	// TODO: Optionally add more test methods.
	
}
