package ch.zhaw.rhiana.ads.Praktikum01;

import java.util.LinkedList;

public class StackLinkedList implements Stack {
	
	private LinkedList<Object> list;
	
	public StackLinkedList() {
		removeAll();
	}

	@Override
	public void push(Object x)  {
		list.add(0,x);

	}

	@Override
	public Object pop() {
		if (isEmpty()) {
			return null;
		}
		return list.remove(0);
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
		return list.get(0);
	}

	@Override
	public void removeAll() {
		list = new LinkedList();

	}

	@Override
	public boolean isFull() {
		return false;
	}

}
