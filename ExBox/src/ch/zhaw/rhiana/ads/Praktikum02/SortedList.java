package ch.zhaw.rhiana.ads.Praktikum02;

import java.util.Collections;

/**
 * Representiert eine sortierte double-linked-list.
 * 
 * @author Yanick Senn
 */
public class SortedList<T extends Comparable<T>> extends DoubleLinkedList<T> {
	@Override
	public boolean add(T e) {
		boolean result = super.add(e);
		
		// Default-sort bei jeder Änderung aufrufen
		Collections.sort(this);
		return result;
	}
}
