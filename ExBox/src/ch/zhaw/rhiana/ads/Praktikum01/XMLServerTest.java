package ch.zhaw.rhiana.ads.Praktikum01;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Rhiana Weber
 */
public class XMLServerTest {

	XMLServer server;

	@Before
	public void setUp() throws Exception {
		server = new XMLServer();
	}

	private void test(String s, boolean b) {
		assertEquals(s, server.checkWellformed(s), b);
	}

	@Test
	public void testXMLFile() {
		test("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + "<note>\r\n" + "<to>Tove</to>\r\n"
				+ "<from>Jani</from> \r\n" + "<heading>Reminder</heading>\r\n"
				+ "<body>Don't forget me this weekend!</body>\r\n" + "</note>", true);
		test("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + "<note>\r\n" + "<to>Tove</to>\r\n"
				+ "<from>Jani<from> \r\n" + "<heading>Reminder</heading>\r\n"
				+ "<body>Don't forget me this weekend!</body>\r\n" + "</note>", false);
		test("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + "<note>\r\n"
				+ "<to>Tove</to>\r\n" + "<from>Jani</from> \r\n" + "<heading>Reminder</heading>\r\n"
				+ "<body>Don't forget me this weekend!</body>\r\n" + "</vote>", false);
		test("", true);
		
	}
}
