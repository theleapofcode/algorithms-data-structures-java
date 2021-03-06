package com.theleapofcode.algosandds.hashtable;

import java.util.Arrays;

public class HashTableLinearProbing<K, V> {

	private static final int LINEAR_PROBING_CONSTANT = 1;

	private static class Node<K, V> {

		K key;

		V value;

		Node(K key, V value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public String toString() {
			return new StringBuilder("(").append(this.key).append(", ").append(this.value).append(")").toString();
		}

	}

	private Node<K, V>[] hashTable;

	private int size;

	private int totalSize;

	@SuppressWarnings("unchecked")
	public HashTableLinearProbing(int totalSize) {
		this.totalSize = totalSize;
		this.size = 0;
		this.hashTable = new Node[totalSize];
	}

	@Override
	public String toString() {
		return Arrays.toString(this.hashTable);
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	// This implements hash function to find index for a key
	private int getIndex(K key) {
		int hashCode = key.hashCode();
		int index = (hashCode & 0x7FFFFFFF) % totalSize;
		return index;
	}

	@SuppressWarnings("unchecked")
	public void add(K key, V value) {
		int index = getIndex(key);

		while (this.hashTable[index] != null) {
			if (this.hashTable[index].key == key) {
				throw new IllegalArgumentException("This key is already in the hash table. Index: " + index);
			}
			index = (index + LINEAR_PROBING_CONSTANT) % totalSize;
		}

		// Add the item.
		this.hashTable[index] = new Node<>(key, value);
		size++;

		// If load factor goes beyond threshold, then double hash table size
		if ((1.0 * size) / totalSize >= 0.7) {
			Node<K, V>[] temp = this.hashTable;
			totalSize = 2 * totalSize;
			size = 0;
			this.hashTable = new Node[totalSize];

			for (Node<K, V> headNode : temp) {
				while (headNode != null) {
					add(headNode.key, headNode.value);
				}
			}
		}
	}

	public void remove(K key) {
		int index = getIndex(key);

		int count = 0;
		if (this.hashTable[index] == null) {
			throw new IllegalArgumentException("This key is not present in the hash table. Index: " + index);
		} else {
			while (this.hashTable[index].key != key) {
				index = (index + LINEAR_PROBING_CONSTANT) % totalSize;
				if (count == totalSize)
					throw new IllegalArgumentException("This key is not present in the hash table. Index: " + index);
				count++;
			}
		}

		this.hashTable[index] = null;
	}

	public V get(K key) {
		int index = getIndex(key);
		int count = 0;
		if (this.hashTable[index] == null) {
			throw new IllegalArgumentException("This key is not present in the hash table. Index: " + index);
		} else {
			while (this.hashTable[index].key != key) {
				index = (index + LINEAR_PROBING_CONSTANT) % totalSize;
				if (count == totalSize)
					throw new IllegalArgumentException("This key is not present in the hash table. Index: " + index);
				count++;
			}
		}

		return this.hashTable[index].value;
	}

}
