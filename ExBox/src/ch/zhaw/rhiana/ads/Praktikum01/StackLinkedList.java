package ch.zhaw.rhiana.ads.Praktikum01;

import java.util.LinkedList;

/**
 * @author Rhiana Weber
 */
public class StackLinkedList implements Stack {
	private static final int TOP_OF_STACK = 0;

	private LinkedList<Object> list;

	public StackLinkedList() {
		// removeAll();
		list = new LinkedList<Object>();
	}

	@Override
	public void push(Object x) {
		list.add(TOP_OF_STACK, x);
	}

	@Override
	public Object pop() {
		if (isEmpty()) {
			return null;
		}
		return list.remove(TOP_OF_STACK);
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public Object peek() {
		if (isEmpty()) {
			return null;
		}

		return list.get(TOP_OF_STACK);
	}

	@Override
	public void removeAll() {
		// list = new LinkedList<Object>();
		list.clear();
	}

	@Override
	public boolean isFull() {
		// Ist immer false wenn mit LinkedList gelöst.
		return false;
	}
}
