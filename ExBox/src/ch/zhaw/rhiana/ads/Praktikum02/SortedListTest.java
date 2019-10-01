package ch.zhaw.rhiana.ads.Praktikum02;

import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class SortedListTest {

	SortedList<String> list;

	@Before
	public void setUp() throws Exception {
		list = new SortedList<String>();
	}

	@Test
	public void testAdd() {
		list.clear();
		list.add("A");
		Object o = list.get(0);
		assertEquals(o, "A");

		assertEquals(1, list.size());
	}

	@Test
	public void testAdd2() {
		list.clear();
		list.add("A");
		list.add("B");
		Object o = list.get(0);
		assertEquals(o, "A");
		o = list.get(1);
		assertEquals(o, "B");

		assertEquals(2, list.size());
	}

	@Test
	public void testAdd8() {
		list.clear();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");
		list.add("F");
		list.add("G");
		list.add("H");

		Object o = list.get(0);
		assertEquals(o, "A");
		o = list.get(1);
		assertEquals(o, "B");
		o = list.get(2);
		assertEquals(o, "C");
		o = list.get(3);
		assertEquals(o, "D");
		o = list.get(4);
		assertEquals(o, "E");
		o = list.get(5);
		assertEquals(o, "F");
		o = list.get(6);
		assertEquals(o, "G");
		o = list.get(7);
		assertEquals(o, "H");

		assertEquals(8, list.size());
	}

	@Test
	public void testSize() {
		list.clear();
		assertEquals(0, list.size());
		testAdd2();
		assertEquals(2, list.size());
	}

	@Test
	public void testRemove() {
		list.clear();
		list.add("A");
		list.remove("A");
		assertEquals(0, list.size());
		list.add("A");
		list.remove("B");
		assertEquals(1, list.size());
		list.remove("A");
		assertEquals(0, list.size());
	}

	@Test
	public void testMixed() {
		list.clear();
		List<String> list2 = new LinkedList<String>();
		for (int i = 0; i < 100; i++) {
			String s = Character.toString((char) ('A' + (Math.random() * 26)));
			int op = (int) (Math.random() * 2);
			switch (op) {
			case 0:
				list.add(s);
				list2.add(s);
				break;
			case 1:
				list.remove(s);
				list2.remove(s);
				break;
			}
		}
		assertEquals(list2.size(), list.size());

		Collections.sort(list2);

		for (int i = 0; i < list.size(); i++) {
			String s1 = list.get(i);
			String s2 = list2.get(i);
			assertEquals(s1, s2);
		}
	}
}
