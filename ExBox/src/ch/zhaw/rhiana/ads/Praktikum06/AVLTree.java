package ch.zhaw.rhiana.ads.Praktikum06;

import java.io.*;
import java.util.*;

public class AVLTree<T extends Comparable<T>> {

	public static class Node<O extends Comparable<O>> {
		public Node<O> left, right;
		private int height = 1;
		public O value;

		private Node(O val) {
			this.value = val;
		}
	}

	private Node<T> root;

	public Node<T> getRoot() {
		return root;
	}

	public Traversal<T> getTraversal() {
		return new AVLTreeTraversal<T>(this);
	}

	public int count() {
		return count(root);
	}

	public int count(Node<T> node) {
		int left = node.left != null ? count(node.left) : 0;
		int right = node.right != null ? count(node.right) : 0;
		return left + right + 1;
	}

	public int height() {
		return height(root);
	}

	public int height(Node<T> node) {
		if (node == null) {
			return 0;
		}

		return node.height;
	}

	public void insert(T value) {
		Objects.requireNonNull(value, "value is not specifieid");
		root = insertNode(root, value);
	}

	private Node<T> insertNode(Node<T> node, T value) {
		/* 1. Perform the normal BST rotation */
		if (node == null) {
			return (new Node<T>(value));
		}

		if (value.compareTo(node.value) < 0) {
			node.left = insertNode(node.left, value);
		} else {
			node.right = insertNode(node.right, value);
		}

		/* 2. Update height of this ancestor Node<T> */
		node.height = Math.max(height(node.left), height(node.right)) + 1;

		/*
		 * 3. Get the balance factor of this ancestor Node<T> to check whether this
		 * Node<T> became unbalanced
		 */
		int balance = getBalance(node);

		// If this Node<T> becomes unbalanced, then there are 4 cases

        // Left Left Case
        if (balance > 1 && value.compareTo(node.left.value) < 0)
            return rightRotate(node);

        // Right Right Case
        if (balance < -1 && value.compareTo(node.right.value) > 0)
            return leftRotate(node);

        // Left Right Case
        if (balance > 1 && value.compareTo(node.left.value) > 0)
        {
            node.left =  leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && value.compareTo(node.right.value) < 0)
        {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

		/* return the (unchanged) Node<T> pointer */
		return node;
	}

	private Node<T> rightRotate(Node<T> y) {
		Node<T> x = y.left;
		Node<T> T2 = x.right;

		// Perform rotation
		x.right = y;
		y.left = T2;

		// Update heights
		y.height = Math.max(height(y.left), height(y.right)) + 1;
		x.height = Math.max(height(x.left), height(x.right)) + 1;

		// Return new root
		return x;
	}

	private Node<T> leftRotate(Node<T> x) {
		Node<T> y = x.right;
		Node<T> T2 = y.left;

		// Perform rotation
		y.left = x;
		x.right = T2;

		// Update heights
		x.height = Math.max(height(x.left), height(x.right)) + 1;
		y.height = Math.max(height(y.left), height(y.right)) + 1;

		// Return new root
		return y;
	}

	// Get Balance factor of Node<T> N
	private int getBalance(Node<T> node) {
		if (node == null) {
			return 0;
		}

		return height(node.left) - height(node.right);
	}

	public boolean isBalanced() {
		return isBalanced(root);
	}

	private boolean isBalanced(Node<T> node) {
		if (node == null) {
			return true;
		}
		boolean result = true;

		if (isBalanced(node.left) && isBalanced(node.right)) {
			int balance = getBalance(node);
			if (balance < -1 || balance > 1) {
				result = false;
			}
		} else {
			result = false;
		}

		return result;
	}

	public void preOrder(Node<T> root) {
		if (root != null) {
			preOrder(root.left);
			System.out.printf("%d ", root.value);
			preOrder(root.right);
		}
	}

	private Node<T> minValueNode(Node<T> node) {
		Node<T> current = node;
		/* loop down to find the leftmost leaf */
		while (current.left != null)
			current = current.left;
		return current;
	}

	public void delete(T value) {
		Objects.requireNonNull(value, "value is not specified");
		root = deleteNode(root, value);
	}

	private Node<T> deleteNode(Node<T> node, T value) {
		// STEP 1: PERFORM STANDARD BST DELETE

		if (node == null) {
			return node;
		}

		// If the value to be deleted is smaller than the root's value,
		// then it lies in left subtree
		if (value.compareTo(node.value) < 0) {
			node.left = deleteNode(node.left, value);
		}

		// If the value to be deleted is greater than the root's value,
		// then it lies in right subtree
		else if (value.compareTo(node.value) > 0) {
			node.right = deleteNode(node.right, value);
		}

		// if value is same as root's value, then This is the Node<T>
		// to be deleted
		else {
			// Node<T> with only one child or no child
			if (node.left == null || node.right == null) {

				Node<T> temp;
				if (node.left != null) {
					temp = node.left;
				} else {
					temp = node.right;
				}

				// No child case
				if (temp == null) {
					temp = node;
					node = null;
				} else { // One child case
					node = temp; // Copy the contents of the non-empty child
				}	

				temp = null;
			} else {
				// Node<T> with two children: Get the inorder successor (smallest
				// in the right subtree)
				Node<T> temp = minValueNode(node.right);

				// Copy the inorder successor's data to this Node<T>
				node.value = temp.value;

				// Delete the inorder successor
				node.right = deleteNode(node.right, temp.value);
			}
		}

		// If the tree had only one Node<T> then return
		if (node == null) {
			return node;
		}

		// STEP 2: UPDATE HEIGHT OF THE CURRENT Node<T>
		node.height = Math.max(height(node.left), height(node.right)) + 1;

		// STEP 3: GET THE BALANCE FACTOR OF THIS Node<T> (to check whether
		// this Node<T> became unbalanced)
		int balance = getBalance(node);

		// If this Node<T> becomes unbalanced, then there are 4 cases

		// Left Left Case
		if (balance > 1 && getBalance(node.left) >= 0) {
			return rightRotate(node);
		}

		// Left Right Case
		if (balance > 1 && getBalance(node.left) < 0) {
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}

		// Right Right Case
		if (balance < -1 && getBalance(node.right) <= 0) {
			return leftRotate(node);
		}

		// Right Left Case
		if (balance < -1 && getBalance(node.right) > 0) {
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}

		return node;
	}

	public void print(Node<T> root) {
		if (root == null) {
			System.out.println("(XXXXXX)");
			return;
		}

		int height = root.height, width = (int) Math.pow(2, height - 1);

		// Preparing variables for loop.
		List<Node<T>> current = new ArrayList<Node<T>>(1), next = new ArrayList<Node<T>>(2);
		current.add(root);

		final int maxHalfLength = 4;
		int elements = 1;

		StringBuilder sb = new StringBuilder(maxHalfLength * width);
		for (int i = 0; i < maxHalfLength * width; i++)
			sb.append(' ');
		String textBuffer;

		// Iterating through height levels.
		for (int i = 0; i < height; i++) {

			sb.setLength(maxHalfLength * ((int) Math.pow(2, height - 1 - i) - 1));

			// Creating spacer space indicator.
			textBuffer = sb.toString();

			// Print tree Node<T> elements
			for (Node<T> n : current) {

				System.out.print(textBuffer);

				if (n == null) {

					System.out.print("        ");
					next.add(null);
					next.add(null);

				} else {

					System.out.printf("(%6s)", n.value.toString());
					next.add(n.left);
					next.add(n.right);

				}

				System.out.print(textBuffer);

			}

			System.out.println();
			// Print tree Node<T> extensions for next level.
			if (i < height - 1) {

				for (Node<T> n : current) {

					System.out.print(textBuffer);

					if (n == null)
						System.out.print("        ");
					else
						System.out.printf("%s      %s", n.left == null ? " " : "/", n.right == null ? " " : "\\");

					System.out.print(textBuffer);

				}

				System.out.println();

			}

			// Renewing indicators for next run.
			elements *= 2;
			current = next;
			next = new ArrayList<Node<T>>(elements);

		}

		System.out.println();
	}

	private static final String EOI = "-";

	public static void main(String args[]) {
		AVLTree<String> t = new AVLTree<>();
		Node<String> root = null;

		while (true) {
			System.out.println("(1) Insert");
			System.out.println("(2) Delete");
			System.out.println();

			try {
				BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
				String s = bufferRead.readLine();

				if (Integer.parseInt(s) == 1) {
					System.out.print("Value to be inserted:\n");

					Scanner scanner = new Scanner(new InputStreamReader(System.in));
					while (scanner.hasNext()) {
						String value = scanner.next();
						if (value.equals(EOI)) {
							break;
						}
						root = t.insertNode(root, value);
					}
//					scanner.close();

				} else if (Integer.parseInt(s) == 2) {
					System.out.print("Value to be deleted:\n");

					Scanner scanner = new Scanner(new InputStreamReader(System.in));
					while (scanner.hasNext()) {
						String value = scanner.next();
						if (value.equals(EOI)) {
							break;
						}
						root = t.deleteNode(root, value);
					}
//					scanner.close();

				} else {
					System.out.println("Invalid choice, try again!\n");
					continue;
				}

				t.print(root);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}