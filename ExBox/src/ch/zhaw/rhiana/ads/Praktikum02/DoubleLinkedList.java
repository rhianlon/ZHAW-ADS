package ch.zhaw.rhiana.ads.Praktikum02;

import java.util.AbstractList;
import java.util.Objects;

/**
 * Representiert eine double-linked-list.
 * 
 * @author Yanick Senn
 *
 * @param <T> Type.
 */
public class DoubleLinkedList<T> extends AbstractList<T> {
	
	private Link<T> head;
	
	public DoubleLinkedList() {
		head = new Link<T>();
		head.next = head;
		head.previous = head;
	}
	
	@Override
	public T set(int index, T element) {
		if (index < 0) {
			throw new IndexOutOfBoundsException("index should not be below zero");
		}
		
		int size = size();
		if (index > size) {
			throw new IndexOutOfBoundsException("index should not be above the size");
		}
		
		if (index == size) {
			add(element);
			return null;
		}
		
		Link<T> link = getLink(index);
		T oldValue = link.value;
		link.value = element;
		
		return oldValue;
	}
	
	@Override
	public boolean add(T e) {
		Objects.requireNonNull(e, "e is not specified");
		if (head.isEmpty()) {
			head.value = e;
			head.next = head;
			head.previous = head;
		} else {
			Link<T> oldLast = getLast();
			Link<T> newLast = new Link<>();
			newLast.value = e;
			
			newLast.previous = oldLast;
			newLast.next = head;
			
			oldLast.next = newLast;
			head.previous = newLast;
		}
		
		return true;
	}
	
	@Override
	public boolean remove(Object o) {
		if (head.isEmpty()) {
			return false;
		}
		
		boolean result = false;
		
		int size = size();
		// for (int i = size - 1; i >= 0; i --) { // Any occurence
		for (int i = 0; i < size; i ++) { // First occurence
			Link<T> link = getLink(i);
			
			if (Objects.equals(link.value, o)) {   
				link.next.previous = link.previous;
				link.previous.next = link.next;
				
				if (link.isHead()) {
					head.value = null;
					head = link.next;
				}
				
				result = true;
				break; // first occurence
			}
		}
		
		return result;
	}

	@Override
	public T get(int index) {
		Link<T> link = getLink(index);
		return link != null ? link.value : null;
	}

	@Override
	public int size() {
		if (head.isEmpty()) {
			return 0;
		}
		
		int size = 1;
		Link<T> c = head.next;
		while (!c.isHead()) {
			size ++;
			c = c.next;
		}
		
		return size;
	}
	
	@Override
	public void clear() {
		head.value = null;
		head.next = head;
		head.previous = head;
	}
	
	
	private Link<T> getLink(int index) {
		if (index < 0) {
			throw new IllegalArgumentException("index should not be below zero");
		}
		
		if (head.isEmpty()) {
			return null;
		}
		
		if (index == 0) {
			return head;
		}
		
		int i = 0;
		Link<T> c = head;
		while (i < index) {
			i ++;
			c = c.next;
		}
		
		return c;
	}
	
	private Link<T> getLast() {
		return head.previous;
	}
	
	
	private final class Link<E> {
		public Link<E> next;
		public Link<E> previous;
		public E value;
		
		public Link() {
			
		}
		
		public boolean isHead() {
			return this == head;
		}
		
		public boolean isEmpty() {
			return value == null;
		}
	}
}
