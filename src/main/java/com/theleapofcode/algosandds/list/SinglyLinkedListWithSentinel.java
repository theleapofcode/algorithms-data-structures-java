package com.theleapofcode.algosandds.list;

public class SinglyLinkedListWithSentinel<T extends Comparable<T>> {

	private static class Node<T> {

		T element;

		Node<T> next;

		Node(T element, Node<T> next) {
			super();
			this.element = element;
			this.next = next;
		}

	}

	int size;

	Node<T> first;

	public SinglyLinkedListWithSentinel() {
		this.first = new Node<>(null, null);
	}

	public int size() {
		return size;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node<T> current = first.next;
		if (current != null) {
			sb.append(current.element);
			while (current.next != null) {
				sb.append(" -> ").append(current.next.element);
				current = current.next;
			}
		}

		return sb.toString();
	}

	public Object[] toArray() {
		Object[] result = new Object[size];
		int i = 0;
		for (Node<T> x = first.next; x != null; x = x.next)
			result[i++] = x.element;
		return result;
	}

	public void add(T element) {
		Node<T> last = first;
		while (last.next != null) {
			last = last.next;
		}
		last.next = new Node<>(element, null);
		size++;
	}

	public void add(int index, T element) {
		if (index > size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}

		Node<T> current = first;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}

		Node<T> next = current.next;
		current.next = new Node<>(element, next);
		size++;
	}

	// O(N^2)
	public void addInSortedOrder(T element) {
		Node<T> current = first;
		while (current.next != null && current.next.element.compareTo(element) < 0) {
			current = current.next;
		}

		Node<T> next = current.next;
		current.next = new Node<>(element, next);
		size++;
	}

	public void remove(T element) {
		Node<T> current = first;
		while (current.next != null) {
			if (current.next.element.equals(element)) {
				Node<T> next = current.next.next;
				current.next.next = null;
				current.next = next;
				size--;
				return;
			}
			current = current.next;
		}
	}

	public T remove(int index) {
		if (index >= size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}

		Node<T> current = first;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}

		Node<T> next = current.next.next;
		current.next.next = null;
		T element = current.next.element;
		current.next = next;
		size--;

		return element;
	}

	public T get(int index) {
		if (index > size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}

		Node<T> current = first.next;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}

		return current.element;
	}

}
