package ch.zhaw.rhiana.ads.Praktikum04;

import static org.junit.Assert.*;

import org.junit.Test;

public class HilbertServerTest {
	

	// Test input

	@Test(expected = IllegalArgumentException.class)
	public void testInputNull() throws Exception {
		HilbertServer server = new HilbertServer();
		server.execute(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInputEmpty() throws Exception {
		HilbertServer server = new HilbertServer();
		server.execute("");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInputArgSize1() throws Exception {
		HilbertServer server = new HilbertServer();
		server.execute("a");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInputArgSize3() throws Exception {
		HilbertServer server = new HilbertServer();
		server.execute("a b c");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInputArg1Illegal() throws Exception {
		HilbertServer server = new HilbertServer();
		server.execute("a 1");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInputArg2Illegal() throws Exception {
		HilbertServer server = new HilbertServer();
		server.execute("1 a");
	}

	@Test
	public void testInputSuccess() throws Exception {
		HilbertServer server = new HilbertServer();
		server.execute("1 1");
	}


	// Test level

	@Test(expected = IllegalArgumentException.class)
	public void testInputHilbertInvalidArg1Negative() throws Exception {
		HilbertServer server = new HilbertServer();
		server.execute("-1 1");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInputHilbertInvalidArg1Zero() throws Exception {
		HilbertServer server = new HilbertServer();
		server.execute("0 1");
	}
	

	// Test distance
	
	@Test(expected = IllegalArgumentException.class)
	public void testInputHilbertInvalidArg2Negative() throws Exception {
		HilbertServer server = new HilbertServer();
		server.execute("1 -1");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInputHilbertInvalidArg2Zero() throws Exception {
		HilbertServer server = new HilbertServer();
		server.execute("1 0");
	}

	
	// Test 1 1
	private static final String OUTPUT_1_1 = 
		"<line x1=\"0.25\" y1=\"0.75\" x2=\"0.25\" y2=\"-0.25\"/>\n" +
		"<line x1=\"0.25\" y1=\"-0.25\" x2=\"1.25\" y2=\"-0.25\"/>\n" +
		"<line x1=\"1.25\" y1=\"-0.25\" x2=\"1.25\" y2=\"0.75\"/>\n";
	
	@Test
	public void testInput_1_1() throws Exception {
		HilbertServer server = new HilbertServer();
		String output = server.execute("1 1");
		assertEquals(OUTPUT_1_1, output);
	}

	
	// Test 2 1
	private static final String OUTPUT_2_1 = 
		"<line x1=\"0.25\" y1=\"0.75\" x2=\"1.25\" y2=\"0.75\"/>\n" + 
		"<line x1=\"1.25\" y1=\"0.75\" x2=\"1.25\" y2=\"-0.25\"/>\n" + 
		"<line x1=\"1.25\" y1=\"-0.25\" x2=\"0.25\" y2=\"-0.25\"/>\n" + 
		"<line x1=\"0.25\" y1=\"-0.25\" x2=\"0.25\" y2=\"-1.25\"/>\n" + 
		"<line x1=\"0.25\" y1=\"-1.25\" x2=\"0.25\" y2=\"-2.25\"/>\n" + 
		"<line x1=\"0.25\" y1=\"-2.25\" x2=\"1.25\" y2=\"-2.25\"/>\n" + 
		"<line x1=\"1.25\" y1=\"-2.25\" x2=\"1.25\" y2=\"-1.25\"/>\n" + 
		"<line x1=\"1.25\" y1=\"-1.25\" x2=\"2.25\" y2=\"-1.25\"/>\n" + 
		"<line x1=\"2.25\" y1=\"-1.25\" x2=\"2.25\" y2=\"-2.25\"/>\n" + 
		"<line x1=\"2.25\" y1=\"-2.25\" x2=\"3.25\" y2=\"-2.25\"/>\n" + 
		"<line x1=\"3.25\" y1=\"-2.25\" x2=\"3.25\" y2=\"-1.25\"/>\n" + 
		"<line x1=\"3.25\" y1=\"-1.25\" x2=\"3.25\" y2=\"-0.25\"/>\n" + 
		"<line x1=\"3.25\" y1=\"-0.25\" x2=\"2.25\" y2=\"-0.25\"/>\n" + 
		"<line x1=\"2.25\" y1=\"-0.25\" x2=\"2.25\" y2=\"0.75\"/>\n" + 
		"<line x1=\"2.25\" y1=\"0.75\" x2=\"3.25\" y2=\"0.75\"/>\n";
	
	@Test
	public void testInput_2_1() throws Exception {
		HilbertServer server = new HilbertServer();
		String output = server.execute("2 1");
		assertEquals(OUTPUT_2_1, output);
	}

	
	// Test 3 1
	private static final String OUTPUT_3_1 = 
		"<line x1=\"0.25\" y1=\"0.75\" x2=\"0.25\" y2=\"-0.25\"/>\n" + 
		"<line x1=\"0.25\" y1=\"-0.25\" x2=\"1.25\" y2=\"-0.25\"/>\n" + 
		"<line x1=\"1.25\" y1=\"-0.25\" x2=\"1.25\" y2=\"0.75\"/>\n" + 
		"<line x1=\"1.25\" y1=\"0.75\" x2=\"2.25\" y2=\"0.75\"/>\n" + 
		"<line x1=\"2.25\" y1=\"0.75\" x2=\"3.25\" y2=\"0.75\"/>\n" + 
		"<line x1=\"3.25\" y1=\"0.75\" x2=\"3.25\" y2=\"-0.25\"/>\n" + 
		"<line x1=\"3.25\" y1=\"-0.25\" x2=\"2.25\" y2=\"-0.25\"/>\n" + 
		"<line x1=\"2.25\" y1=\"-0.25\" x2=\"2.25\" y2=\"-1.25\"/>\n" + 
		"<line x1=\"2.25\" y1=\"-1.25\" x2=\"3.25\" y2=\"-1.25\"/>\n" + 
		"<line x1=\"3.25\" y1=\"-1.25\" x2=\"3.25\" y2=\"-2.25\"/>\n" + 
		"<line x1=\"3.25\" y1=\"-2.25\" x2=\"2.25\" y2=\"-2.25\"/>\n" + 
		"<line x1=\"2.25\" y1=\"-2.25\" x2=\"1.25\" y2=\"-2.25\"/>\n" + 
		"<line x1=\"1.25\" y1=\"-2.25\" x2=\"1.25\" y2=\"-1.25\"/>\n" + 
		"<line x1=\"1.25\" y1=\"-1.25\" x2=\"0.25\" y2=\"-1.25\"/>\n" + 
		"<line x1=\"0.25\" y1=\"-1.25\" x2=\"0.25\" y2=\"-2.25\"/>\n" + 
		"<line x1=\"0.25\" y1=\"-2.25\" x2=\"0.25\" y2=\"-3.25\"/>\n" + 
		"<line x1=\"0.25\" y1=\"-3.25\" x2=\"1.25\" y2=\"-3.25\"/>\n" + 
		"<line x1=\"1.25\" y1=\"-3.25\" x2=\"1.25\" y2=\"-4.25\"/>\n" + 
		"<line x1=\"1.25\" y1=\"-4.25\" x2=\"0.25\" y2=\"-4.25\"/>\n" + 
		"<line x1=\"0.25\" y1=\"-4.25\" x2=\"0.25\" y2=\"-5.25\"/>\n" + 
		"<line x1=\"0.25\" y1=\"-5.25\" x2=\"0.25\" y2=\"-6.25\"/>\n" + 
		"<line x1=\"0.25\" y1=\"-6.25\" x2=\"1.25\" y2=\"-6.25\"/>\n" + 
		"<line x1=\"1.25\" y1=\"-6.25\" x2=\"1.25\" y2=\"-5.25\"/>\n" + 
		"<line x1=\"1.25\" y1=\"-5.25\" x2=\"2.25\" y2=\"-5.25\"/>\n" + 
		"<line x1=\"2.25\" y1=\"-5.25\" x2=\"2.25\" y2=\"-6.25\"/>\n" + 
		"<line x1=\"2.25\" y1=\"-6.25\" x2=\"3.25\" y2=\"-6.25\"/>\n" + 
		"<line x1=\"3.25\" y1=\"-6.25\" x2=\"3.25\" y2=\"-5.25\"/>\n" + 
		"<line x1=\"3.25\" y1=\"-5.25\" x2=\"3.25\" y2=\"-4.25\"/>\n" + 
		"<line x1=\"3.25\" y1=\"-4.25\" x2=\"2.25\" y2=\"-4.25\"/>\n" + 
		"<line x1=\"2.25\" y1=\"-4.25\" x2=\"2.25\" y2=\"-3.25\"/>\n" + 
		"<line x1=\"2.25\" y1=\"-3.25\" x2=\"3.25\" y2=\"-3.25\"/>\n" + 
		"<line x1=\"3.25\" y1=\"-3.25\" x2=\"4.25\" y2=\"-3.25\"/>\n" + 
		"<line x1=\"4.25\" y1=\"-3.25\" x2=\"5.25\" y2=\"-3.25\"/>\n" + 
		"<line x1=\"5.25\" y1=\"-3.25\" x2=\"5.25\" y2=\"-4.25\"/>\n" + 
		"<line x1=\"5.25\" y1=\"-4.25\" x2=\"4.25\" y2=\"-4.25\"/>\n" + 
		"<line x1=\"4.25\" y1=\"-4.25\" x2=\"4.25\" y2=\"-5.25\"/>\n" + 
		"<line x1=\"4.25\" y1=\"-5.25\" x2=\"4.25\" y2=\"-6.25\"/>\n" + 
		"<line x1=\"4.25\" y1=\"-6.25\" x2=\"5.25\" y2=\"-6.25\"/>\n" + 
		"<line x1=\"5.25\" y1=\"-6.25\" x2=\"5.25\" y2=\"-5.25\"/>\n" + 
		"<line x1=\"5.25\" y1=\"-5.25\" x2=\"6.25\" y2=\"-5.25\"/>\n" + 
		"<line x1=\"6.25\" y1=\"-5.25\" x2=\"6.25\" y2=\"-6.25\"/>\n" + 
		"<line x1=\"6.25\" y1=\"-6.25\" x2=\"7.25\" y2=\"-6.25\"/>\n" + 
		"<line x1=\"7.25\" y1=\"-6.25\" x2=\"7.25\" y2=\"-5.25\"/>\n" + 
		"<line x1=\"7.25\" y1=\"-5.25\" x2=\"7.25\" y2=\"-4.25\"/>\n" + 
		"<line x1=\"7.25\" y1=\"-4.25\" x2=\"6.25\" y2=\"-4.25\"/>\n" + 
		"<line x1=\"6.25\" y1=\"-4.25\" x2=\"6.25\" y2=\"-3.25\"/>\n" + 
		"<line x1=\"6.25\" y1=\"-3.25\" x2=\"7.25\" y2=\"-3.25\"/>\n" + 
		"<line x1=\"7.25\" y1=\"-3.25\" x2=\"7.25\" y2=\"-2.25\"/>\n" + 
		"<line x1=\"7.25\" y1=\"-2.25\" x2=\"7.25\" y2=\"-1.25\"/>\n" + 
		"<line x1=\"7.25\" y1=\"-1.25\" x2=\"6.25\" y2=\"-1.25\"/>\n" + 
		"<line x1=\"6.25\" y1=\"-1.25\" x2=\"6.25\" y2=\"-2.25\"/>\n" + 
		"<line x1=\"6.25\" y1=\"-2.25\" x2=\"5.25\" y2=\"-2.25\"/>\n" + 
		"<line x1=\"5.25\" y1=\"-2.25\" x2=\"4.25\" y2=\"-2.25\"/>\n" + 
		"<line x1=\"4.25\" y1=\"-2.25\" x2=\"4.25\" y2=\"-1.25\"/>\n" + 
		"<line x1=\"4.25\" y1=\"-1.25\" x2=\"5.25\" y2=\"-1.25\"/>\n" + 
		"<line x1=\"5.25\" y1=\"-1.25\" x2=\"5.25\" y2=\"-0.25\"/>\n" + 
		"<line x1=\"5.25\" y1=\"-0.25\" x2=\"4.25\" y2=\"-0.25\"/>\n" + 
		"<line x1=\"4.25\" y1=\"-0.25\" x2=\"4.25\" y2=\"0.75\"/>\n" + 
		"<line x1=\"4.25\" y1=\"0.75\" x2=\"5.25\" y2=\"0.75\"/>\n" + 
		"<line x1=\"5.25\" y1=\"0.75\" x2=\"6.25\" y2=\"0.75\"/>\n" + 
		"<line x1=\"6.25\" y1=\"0.75\" x2=\"6.25\" y2=\"-0.25\"/>\n" + 
		"<line x1=\"6.25\" y1=\"-0.25\" x2=\"7.25\" y2=\"-0.25\"/>\n" + 
		"<line x1=\"7.25\" y1=\"-0.25\" x2=\"7.25\" y2=\"0.75\"/>\n";
	
	@Test
	public void testInput_3_1() throws Exception {
		HilbertServer server = new HilbertServer();
		String output = server.execute("3 1");
		assertEquals(OUTPUT_3_1, output);
	}
}
