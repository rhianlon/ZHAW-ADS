package ch.zhaw.rhiana.ads.Praktikum09;

import java.util.*;

public class MyHashtable<K, V> implements java.util.Map<K, V> {
	private K[] keys;
	private V[] values;
	private int count;
	

	public MyHashtable() {
		initialize(1000);
		count = 0;
	}

	public MyHashtable(int size) {
		initialize(size);
		count = 0;
	}

	// Removes all mappings from this map (optional operation).
	public void clear() {
		initialize(keys.length);
	}

	@SuppressWarnings("unchecked")
	private void initialize(int size) {
		keys = (K[]) new Object[size];
		values = (V[]) new Object[size];
	}
	

	// Associates the specified value with the specified key in this map (optional
	// operation).
	public V put(K key, V value) {
		V returnValue = null;
		if (key == null || value == null) {
			throw new NullPointerException();
		}
		int hashCode = hash(key);
		boolean exists = containsKey(key);

		for (int i = hashCode; i < keys.length; i++) {
			if (!exists && keys[i] == null) {
				// key is not used yet, fill with new value
				keys[i] = key;
				values[i] = value;
				count++;
				break;

			} else if (keys[i] != null && key.equals(keys[i])) {
				// key is already used, fill with new value and return old value
				returnValue = values[i];
				keys[i] = key;
				values[i] = value;
				break;
			}
		}
		return returnValue;
	}

	// Returns the value to which this map maps the specified key.
	public V get(Object key) {
		if (key == null) {
			throw new NullPointerException();
		}
		int hashCode = hash(key);
		// check the first key with the given hashCode
		K current = keys[hashCode];
		if (current != null && key.equals(current)) {
			return values[hashCode];
		} else {
			for (int i = hashCode; i < keys.length; i++) {
				current = keys[i];
				if (current != null && key.equals(current)) {
					return values[i];
				}
			}
		}
		return null;
	}

	// Returns true if this map contains no key-value mappings.
	public boolean isEmpty() {
		return (count == 0) ? true : false;
	}

	// Removes the mapping for this key from this map if present (optional
	// operation).
	public V remove(Object key) {
		if (key == null) {
			throw new NullPointerException();
		}
		V previousValue = null;
		int hashCode = hash(key);
		for (int i = hashCode; i < keys.length; i++) {
			if (keys[i] != null && key.equals(keys[i])) {
				previousValue = values[i];
				keys[i] = null;
				values[i] = null;
				count--;
				break;
			}
		}
		return previousValue;
	}

	// Returns the number of key-value mappings in this map.
	public int size() {
		return count;
	}

	// =======================================================================
	// Returns a set view of the keys contained in this map.
	public Set keySet() {
		throw new UnsupportedOperationException();
	}

	// Copies all of the mappings from the specified map to this map (optional
	// operation).
	public void putAll(Map t) {
		throw new UnsupportedOperationException();
	}

	// Returns a collection view of the values contained in this map.
	public Collection values() {
		throw new UnsupportedOperationException();
	}

	// Returns true if this map contains a mapping for the specified key.
	public boolean containsKey(Object key) {
		if (key == null) {
			throw new NullPointerException();
		}
		for (K k : keys) {
			if (k != null && key.equals(k)) {
				return true;
			}
		}
		return false;
	}

	// Returns true if this map maps one or more keys to the specified value.
	public boolean containsValue(Object value) {
		throw new UnsupportedOperationException();
	}

	// Returns a set view of the mappings contained in this map.
	public Set entrySet() {
		throw new UnsupportedOperationException();
	}

	// Compares the specified object with this map for equality.
	public boolean equals(Object o) {
		throw new UnsupportedOperationException();
	}

	// Returns the hash code value for this map.
	public int hashCode() {
		throw new UnsupportedOperationException();
	}

	private int hash(Object k) {
		int h = Math.abs(k.hashCode());
		return h % keys.length;
	}
}