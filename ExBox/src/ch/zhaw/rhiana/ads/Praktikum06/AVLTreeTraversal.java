package ch.zhaw.rhiana.ads.Praktikum06;

import java.util.Objects;

import ch.zhaw.rhiana.ads.Praktikum06.AVLTree.Node;

public class AVLTreeTraversal<T extends Comparable<T>> implements Traversal<T> {

	private AVLTree<T> tree;

	public AVLTreeTraversal(AVLTree<T> tree) {
		this.tree = tree;
	}

	private void inorder(Node<T> node, Visitor<T> vis) {
		if (node != null) {
			inorder(node.left, vis);
//            for (int i=0; i < tree.count(node); i++) vis.visit(node.value);
			vis.visit(node.value);
			inorder(node.right, vis);
		}
	}

	@Override
	public void inorder(Visitor<T> visitor) {
		Objects.requireNonNull(visitor, "visitor is not specified");
		inorder(tree.getRoot(), visitor);
	}

	private void preorder(Node<T> node, Visitor<T> vis) {
		if (node != null) {
//          for (int i=0; i < tree.count(node); i++) vis.visit(node.value);
			vis.visit(node.value);
			preorder(node.left, vis);
			preorder(node.right, vis);
		}
	}

	@Override
	public void preorder(Visitor<T> visitor) {
		Objects.requireNonNull(visitor, "visitor is not specified");
		preorder(tree.getRoot(), visitor);
	}

	private void postorder(Node<T> node, Visitor<T> vis) {
		if (node != null) {
			postorder(node.left, vis);
			postorder(node.right, vis);
//          for (int i=0; i < tree.count(node); i++) vis.visit(node.value);
			vis.visit(node.value);
		}
	}

	@Override
	public void postorder(Visitor<T> visitor) {
		postorder(tree.getRoot(), visitor);
	}

	void levelorder(Node<T> node, Visitor<T> visitor, int level) {
		if (node == null) {
			return;
		}

		if (level == 1) {
			visitor.visit(node.value);

		} else if (level > 1) {
			levelorder(node.left, visitor, level - 1);
			levelorder(node.right, visitor, level - 1);
		}
	}

	@Override
	public void levelorder(Visitor<T> visitor) {
		Objects.requireNonNull(visitor, "visitor is not specified");
		
		int height = tree.height();
		for (int i = 1; i <= height; i++) {
			levelorder(tree.getRoot(), visitor, i);
		}
	}

	void interval(Node<T> node, T min, T max, Visitor<T> visitor) {
		if (node != null) {
			if (node.value.compareTo(min) < 0) {
				interval(node.right, min, max, visitor);
			} else if (node.value.compareTo(max) > 0) {
				interval(node.left, min, max, visitor);
			} else {
				interval(node.left, min, max, visitor);
				visitor.visit(node.value);
				interval(node.right, min, max, visitor);
			}
		}
	}

	@Override
	public void interval(T min, T max, Visitor<T> visitor) {
		Objects.requireNonNull(min, "min is not specified");
		Objects.requireNonNull(max, "max is not specified");
		Objects.requireNonNull(visitor, "visitor is not specified");

		if (min.compareTo(max) > 0) {
			throw new IllegalArgumentException("min should not be greater than max");
		}
		interval(tree.getRoot(), min, max, visitor);
	}
}
