package ch.zhaw.rhiana.ads.Praktikum03;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ch.zhaw.rhiana.ads.Praktikum02.SortedList;


public class CompetitorServerTest {
	
	CompetitorServer cs;
	
	@Before
	public void setUp() throws Exception {
		cs = new CompetitorServer();
	}
	
	private void test(String s, boolean b) throws Exception {
		assertEquals(s,cs.execute(s),b);
	}

	@Test
	public void testParseRanglist() throws Exception {
		test("3;Kiptum Daniel;1978;Reconvilier;02:11:31.1;",true);
	}

}
