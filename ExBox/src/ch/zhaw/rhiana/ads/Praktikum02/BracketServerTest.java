package ch.zhaw.rhiana.ads.Praktikum02;

import org.junit.Test;

import org.junit.Before;
import static org.junit.Assert.*;

public class BracketServerTest {

	BracketServer bs;

	@Before
	public void setUp() throws Exception {
		bs = new BracketServer();
	}

	private void test(String s, boolean b) {
		assertEquals(s, bs.checkBrackets(s), b);
	}

	@Test
	public void testBracket() {
		test("(", false);
		test(")", false);
		test("()", true);
		test("(()]", false);
		test("((([([])])))", true);
		test("[(])", false);
	}
	
	@Test
	public void testAngleBracket() {
		test("<(<>)>", true);
		test("<(<)>>", false);
	}
	
	@Test
	public void testCustomBracket() {
		test("<*(<*<>*>)*>",true);
		test("<(<**>)*>",false);
	}

	@Test
	public void testBracketsWithNumbers() {
		test("[(3 +3)* 35 +3]* {3 +2}", true);
		test("[({3 +3)* 35} +3]* {3 +2}", false);
	}

	@Test
	public void testBracketsWithLetters() {
		test("abc(def{ghi[jkl]mno}pqr)stu", true);
		test("abc[def{ghi[jkl)mno}pqr}stu", false);
	}
}
