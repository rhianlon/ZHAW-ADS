package ch.zhaw.rhiana.ads.Praktikum01;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

/**
 * @author Rhiana Weber
 */
public class StackTest {
	
	StackLinkedList stack;
	
	@Before
	public void setUp() throws Exception {
		stack = new StackLinkedList();
	}
    
	@Test
	public void testPush1() {
		stack.push("A");
		Object o = stack.pop();
		assertEquals(o, "A");
	}	
		
	@Test
	public void testPush2() {
		stack.push("A");
		stack.push("B");
		assertEquals(stack.pop(), "B");
		assertEquals(stack.pop(), "A");
	}	
		
	@Test
	public void testIsEmpty() {
		assertTrue(stack.isEmpty());
		stack.push("A");
		assertFalse(stack.isEmpty());
		stack.pop();
		assertTrue(stack.isEmpty());
	}	
		
	@Test
	public void testIsFull() {
		assertFalse(stack.isFull());
	}	
		
	@Test
	public void testEmptyPop() {
		assertEquals(stack.pop(), null);
	}	
}