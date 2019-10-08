package ch.zhaw.rhiana.ads.Praktikum03;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class CompetitorServerTest {
	
	CompetitorServer cs;
	
	@Before
	public void setUp() throws Exception {
		cs = new CompetitorServer();
	}
	/**
	 * 
	 * @param input one Competitor
	 * @param expected output of one Competitor on console/server
	 * @throws Exception
	 */
	private void test(String input, String expected) throws Exception {
		String output = cs.execute(input).trim();
		String[] lines = output.split("\n");
		
		String result = "";
		for (int i = 0; i < lines.length; i ++) {
			if (i == 0) {
				continue;
			}
			
			result += lines[i] + "\n";
		}
		
		assertEquals(expected, result.trim());
	}

	@Test
	public void testParseRanglistWithOne() throws Exception {
		test("3;Kiptum Daniel;1978;Reconvilier;02:11:31.1;","1 3 Kiptum Daniel 1978 Reconvilier 02:11:31.1");
		test("55;Oliver Ruben;1976;Ebmatingen;02:32:12.8;","1 55 Oliver Ruben 1976 Ebmatingen 02:32:12.8");
	}
	@Test
	public void testParseRanglistWithTwo() throws Exception {
		test("3;Kiptum Daniel;1978;Reconvilier;02:11:31.1;\n55;Oliver Ruben;1976;Ebmatingen;02:32:12.8;","1 3 Kiptum Daniel 1978 Reconvilier 02:11:31.1\n2 55 Oliver Ruben 1976 Ebmatingen 02:32:12.8");
	}

}
