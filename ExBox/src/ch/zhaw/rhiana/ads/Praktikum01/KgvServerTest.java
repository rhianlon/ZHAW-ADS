package ch.zhaw.rhiana.ads.Praktikum01;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class KgvServerTest {

	KgvServer server;

	@Before
	public void setUp() throws Exception {
		server = new KgvServer();
	}

	@Test
	public void testKgv() throws KgvNegativeNumberException {
		assertEquals(server.kgv(3, 4), 12);
		assertEquals(server.kgv(2, 4), 4);
		assertEquals(server.kgv(5, 7), 35);
		assertEquals(server.kgv(4, 6), 12);
		assertEquals(server.kgv(0, 0), 0);
		assertEquals(server.kgv(0, 6), 0);
		assertEquals(server.kgv(7, 0), 0);
	}

	@Test(expected = KgvNegativeNumberException.class)
	public void testKgvNegativeA() throws KgvNegativeNumberException {
		server.kgv(-2, 10);
	}

	@Test(expected = KgvNegativeNumberException.class)
	public void testKgvNegativeB() throws KgvNegativeNumberException {
		server.kgv(2, -10);
	}

	@Test(expected = KgvNegativeNumberException.class)
	public void testKgvNegativeAandB() throws KgvNegativeNumberException {
		server.kgv(-2, -10);
	}

	@Test(expected = KgvNegativeNumberException.class)
	public void testKgvNegativeBEqualsZero() throws KgvNegativeNumberException {
		server.kgv(-2, 0);
	}

	@Test(expected = KgvNegativeNumberException.class)
	public void testKgvNegativeAEqualsZero() throws KgvNegativeNumberException {
		server.kgv(0, -2);
	}
}
