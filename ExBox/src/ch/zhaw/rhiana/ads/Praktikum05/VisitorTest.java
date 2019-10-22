package ch.zhaw.rhiana.ads.Praktikum05;

import static org.junit.Assert.*;

import java.util.Stack;

import org.junit.Before;
import org.junit.Test;

public class VisitorTest {
	
	private TreeNode<Integer> root;
	private TreeTraversal<Integer> tt;
	
	@Before
	public void setup() {
		root = new TreeNode<>(1);
		root.left = new TreeNode<>(2);
		root.left.left = new TreeNode<>(3);
		root.left.right = new TreeNode<>(4);
		root.left.left.left = new TreeNode<>(5);
		root.left.left.right = new TreeNode<>(6);
		root.left.right.left = new TreeNode<>(7);
		root.left.right.right = new TreeNode<>(8);
		
		root.right = new TreeNode<>(9);
		root.right.left = new TreeNode<>(10);
		root.right.right = new TreeNode<>(11);
		root.right.left.left = new TreeNode<>(12);
		root.right.left.right = new TreeNode<>(13);
		root.right.right.left = new TreeNode<>(14);
		root.right.right.right = new TreeNode<>(15);

		tt = new TreeTraversal<>(root);
	}

	@Test
	public void testPreorder() {
		final Stack<Integer> expected = new Stack<>();
		expected.push(1);
		expected.push(2);
		expected.push(3);
		expected.push(5);
		expected.push(6);
		expected.push(4);
		expected.push(7);
		expected.push(8);
		expected.push(9);
		expected.push(10);
		expected.push(12);
		expected.push(13);
		expected.push(11);
		expected.push(14);
		expected.push(15);
		
		final Stack<Integer> actual = new Stack<>();
		tt.preorder((obj) -> actual.push(obj));
		assertEquals(expected, actual);
	}
	
	@Test
	public void testPostorder() {
		final Stack<Integer> expected = new Stack<>();
		expected.push(5);
		expected.push(6);
		expected.push(3);
		expected.push(7);
		expected.push(8);
		expected.push(4);
		expected.push(2);
		expected.push(12);
		expected.push(13);
		expected.push(10);
		expected.push(14);
		expected.push(15);
		expected.push(11);
		expected.push(9);
		expected.push(1);
		
		final Stack<Integer> actual = new Stack<>();
		tt.postorder((obj) -> actual.push(obj));
		assertEquals(expected, actual);
	}
	
	@Test
	public void testInorder() {
		final Stack<Integer> expected = new Stack<>();
		expected.push(5);
		expected.push(3);
		expected.push(6);
		expected.push(2);
		expected.push(7);
		expected.push(4);
		expected.push(8);
		expected.push(1);
		expected.push(12);
		expected.push(10);
		expected.push(13);
		expected.push(9);
		expected.push(14);
		expected.push(11);
		expected.push(15);
		
		final Stack<Integer> actual = new Stack<>();
		tt.inorder((obj) -> actual.push(obj));
		assertEquals(expected, actual);
	}
	
	@Test
	public void testLevelorder() {
		final Stack<Integer> expected = new Stack<>();
		expected.push(1);
		expected.push(2);
		expected.push(9);
		expected.push(3);
		expected.push(4);
		expected.push(10);
		expected.push(11);
		expected.push(5);
		expected.push(6);
		expected.push(7);
		expected.push(8);
		expected.push(12);
		expected.push(13);
		expected.push(14);
		expected.push(15);
		
		final Stack<Integer> actual = new Stack<>();
		tt.levelorder((obj) -> actual.push(obj));
		assertEquals(expected, actual);
	}

	
	@Test
	public void testInterval_4_8() {
		root = new TreeNode<>(8);
		root.left = new TreeNode<>(4);
		root.left.left = new TreeNode<>(2);
		root.left.left.left = new TreeNode<>(1);
		root.left.left.right = new TreeNode<>(3);
		
		root.left.right = new TreeNode<>(6);
		root.left.right.left = new TreeNode<>(5);
		root.left.right.right = new TreeNode<>(7);
		
		root.right = new TreeNode<>(12);
		root.right.left = new TreeNode<>(10);
		root.right.left.left = new TreeNode<>(9);
		root.right.left.right = new TreeNode<>(11);
		
		root.right.right = new TreeNode<>(14);
		root.right.right.left = new TreeNode<>(13);
		root.right.right.right = new TreeNode<>(15);

		tt = new TreeTraversal<>(root);
		
		
		final Stack<Integer> expected = new Stack<>();
		expected.push(4);
		expected.push(5);
		expected.push(6);
		expected.push(7);
		expected.push(8);
		
		final Stack<Integer> actual = new Stack<>();
		tt.interval(4, 8, (obj) -> actual.push(obj));
		assertEquals(expected, actual);
	}
	
	@Test
	public void testInterval_1_15() {
		root = new TreeNode<>(8);
		root.left = new TreeNode<>(4);
		root.left.left = new TreeNode<>(2);
		root.left.left.left = new TreeNode<>(1);
		root.left.left.right = new TreeNode<>(3);
		
		root.left.right = new TreeNode<>(6);
		root.left.right.left = new TreeNode<>(5);
		root.left.right.right = new TreeNode<>(7);
		
		root.right = new TreeNode<>(12);
		root.right.left = new TreeNode<>(10);
		root.right.left.left = new TreeNode<>(9);
		root.right.left.right = new TreeNode<>(11);
		
		root.right.right = new TreeNode<>(14);
		root.right.right.left = new TreeNode<>(13);
		root.right.right.right = new TreeNode<>(15);

		tt = new TreeTraversal<>(root);
		
		
		final Stack<Integer> expected = new Stack<>();
		for (int i = 1; i <= 15; i++) {
			expected.push(i);
		}
		
		final Stack<Integer> actual = new Stack<>();
		tt.interval(1, 15, (obj) -> actual.push(obj));
		assertEquals(expected, actual);
	}

}
