package com.theleapofcode.algosandds.hashtable;

public class HashTableChaining<K, V> {

	private static class Node<K, V> {

		K key;

		V value;

		Node<K, V> next;

		Node() {
		}

		Node(K key, V value, Node<K, V> next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}

		@Override
		public String toString() {
			return new StringBuilder("(").append(this.key).append(", ").append(this.value).append(")").toString();
		}

	}

	private Node<K, V>[] hashTable;

	private int size;

	private int numBuckets;

	@SuppressWarnings("unchecked")
	public HashTableChaining(int numBuckets) {
		this.numBuckets = numBuckets;
		this.size = 0;
		this.hashTable = new Node[numBuckets];
		for (int i = 0; i < numBuckets; i++) {
			this.hashTable[i] = new Node<>();
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < this.numBuckets; i++) {
			Node<K, V> current = this.hashTable[i];
			sb.append(current.toString());
			while (current.next != null) {
				sb.append(" -> ").append(current.next.toString());
				current = current.next;
			}

			sb.append(System.lineSeparator());
		}

		return sb.toString();
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	// This implements hash function to find index for a key
	private int getBucketIndex(K key) {
		int hashCode = key.hashCode();
		int index = (hashCode & 0x7FFFFFFF) % numBuckets;
		return index;
	}

	@SuppressWarnings("unchecked")
	public void add(K key, V value) {
		// Find the key's bucket.
		int index = getBucketIndex(key);
		Node<K, V> bucket = this.hashTable[index];

		// Search for the item.
		for (Node<K, V> node = bucket.next; node != null; node = node.next) {
			if (node.key == key)
				throw new IllegalArgumentException("This key is already in the hash table. Bucket: " + index);
		}

		// Add the item at the beginning of the list.
		Node<K, V> newNode = new Node<>(key, value, bucket.next);
		bucket.next = newNode;
		size++;

		// If load factor goes beyond threshold, then double hash table size
		if ((1.0 * size) / numBuckets >= 0.7) {
			Node<K, V>[] temp = this.hashTable;
			numBuckets = 2 * numBuckets;
			size = 0;
			this.hashTable = new Node[numBuckets];
			for (int i = 0; i < numBuckets; i++) {
				this.hashTable[i] = new Node<>();
			}

			for (Node<K, V> headNode : temp) {
				while (headNode != null) {
					add(headNode.key, headNode.value);
					headNode = headNode.next;
				}
			}
		}
	}

	public void remove(K key) {
		// Find the key's bucket.
		int index = getBucketIndex(key);
		Node<K, V> bucket = this.hashTable[index];

		// Find the item.
		for (Node<K, V> node = bucket; node.next != null; node = node.next) {
			if (node.next.key == key) {
				Node<K, V> nextNode = node.next.next;
				node.next.next = null;
				node.next = nextNode;
				return;
			}
		}

		// The item is not present.
		throw new IllegalArgumentException("This key is not present in the hash table. Bucket: " + index);
	}

	public V get(K key) {
		// Find the key's bucket.
		int index = getBucketIndex(key);
		Node<K, V> bucket = this.hashTable[index];

		// Find the item.
		for (Node<K, V> node = bucket; node.next != null; node = node.next) {
			if (node.next.key == key) {
				return node.next.value;
			}
		}

		return null;
	}

}
