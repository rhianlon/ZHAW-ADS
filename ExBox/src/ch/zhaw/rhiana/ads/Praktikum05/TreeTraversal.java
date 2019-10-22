package ch.zhaw.rhiana.ads.Praktikum05;

import java.util.Objects;
import java.util.Stack;

public class TreeTraversal<T extends Comparable<T>> implements Traversal<T> {

	private TreeNode<T> root;

	public TreeTraversal(TreeNode<T> root) {
		this.root = root;
	}

	@Override
	public void inorder(Visitor<T> vis) {
		inorder(root, vis);
	}

	private void inorder(TreeNode<T> node, Visitor<T> vis) {
		if (node != null) {
			inorder(node.left, vis);
			vis.visit(node.element);
			inorder(node.right, vis);
		}
	}

	@Override
	public void preorder(Visitor<T> vis) {
		preorder(root, vis);
	}

	private void preorder(TreeNode<T> node, Visitor<T> vis) {
		if (node != null) {
			vis.visit(node.element);
			preorder(node.left, vis);
			preorder(node.right, vis);
		}
	}

	@Override
	public void postorder(Visitor<T> vis) {
		postorder(root, vis);
	}

	private void postorder(TreeNode<T> node, Visitor<T> vis) {
		if (node != null) {
			postorder(node.left, vis);
			postorder(node.right, vis);
			vis.visit(node.element);
		}
	}

	@Override
	public void levelorder(Visitor<T> vis) {
		int height = root.getHeight();
		for (int i = 1; i <= height; i++) {
			levelorder(root, vis, i);
		}
	}

	private void levelorder(TreeNode<T> node, Visitor<T> vis, int level) {
		if (node == null) {
			return;
		}

		if (level == 1) {
			vis.visit(node.element);

		} else if (level > 1) {
			levelorder(node.left, vis, level - 1);
			levelorder(node.right, vis, level - 1);
		}
	}
	
	@Override
	public void interval(T min, T max, Visitor<T> vis) {
		Objects.requireNonNull(min, "min is not specified");
		Objects.requireNonNull(max, "max is not specified");
		
		if (min.compareTo(max) > 0) {
			throw new IllegalArgumentException("min is greater than max");
		}
		
		interval(root, min, max, vis);
	}
	
	private void interval(TreeNode<T> node, T min, T max, Visitor<T> vis) {
		if (node != null) {
			if (node.element.compareTo(min) < 0) {
				interval(node.right, min, max, vis);
			} else if (node.element.compareTo(max) > 0) {
				interval(node.left, min, max, vis);
			} else {
				interval(node.left, min, max, vis);
				vis.visit(node.element);
				interval(node.right, min, max, vis);
			}
		}
	}
}
