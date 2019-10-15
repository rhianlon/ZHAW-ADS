package ch.zhaw.rhiana.ads.Praktikum04;

import static org.junit.Assert.*;

import org.junit.Test;

public class HanoiServerTest {
	
	public static final String OUTPUT_3 = 
		"Move A to C\n" + 
		"Move A to B\n" + 
		"Move C to B\n" + 
		"Move A to C\n" + 
		"Move B to A\n" + 
		"Move B to C\n" + 
		"Move A to C\n";
	
	@Test
	public void test_3() {
		String output = HanoiServer.moveDisk(3, 'A', 'C', 'B');
		assertEquals(OUTPUT_3, output);
	}
	
	
	public static final String OUTPUT_4 = 
			"Move A to B\n" + 
			"Move A to C\n" + 
			"Move B to C\n" + 
			"Move A to B\n" + 
			"Move C to A\n" + 
			"Move C to B\n" + 
			"Move A to B\n" + 
			"Move A to C\n" + 
			"Move B to C\n" + 
			"Move B to A\n" + 
			"Move C to A\n" + 
			"Move B to C\n" + 
			"Move A to B\n" + 
			"Move A to C\n" + 
			"Move B to C\n";
		
	@Test
	public void test_4() {
		String output = HanoiServer.moveDisk(4, 'A', 'C', 'B');
		assertEquals(OUTPUT_4, output);
	}

}
	