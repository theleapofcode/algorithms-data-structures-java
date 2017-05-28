package com.theleapofcode.algosandds.list;

public class DoublyLinkedListWithSentinels<T extends Comparable<T>> {

	private static class Node<T> {

		T element;

		Node<T> next;

		Node<T> previous;

		Node(Node<T> previous, T element, Node<T> next) {
			super();
			this.previous = previous;
			this.element = element;
			this.next = next;
		}

	}

	int size;

	Node<T> first;

	Node<T> last;

	public DoublyLinkedListWithSentinels() {
		this.first = new Node<>(null, null, null);
		this.last = new Node<>(null, null, null);
		this.first.next = this.last;
		this.last.previous = this.first;
	}

	public int size() {
		return size;
	}

	@Override
	public String toString() {
		if (size == 0) {
			return "";
		}

		StringBuilder sbnext = new StringBuilder();
		Node<T> next = first.next;
		if (next != last) {
			sbnext.append(next.element);
			while (next.next != last) {
				sbnext.append(" -> ").append(next.next.element);
				next = next.next;
			}
		}

		StringBuilder sbprev = new StringBuilder();
		Node<T> prev = last.previous;
		if (prev != first) {
			sbprev.append(prev.element);
			while (prev.previous != first) {
				sbprev.append(" <- ").append(prev.previous.element);
				prev = prev.previous;
			}
		}

		return new StringBuilder(sbnext).append(" <=> ").append(sbprev).toString();
	}

	public Object[] toArray() {
		Object[] result = new Object[size];
		int i = 0;
		for (Node<T> x = first.next; x != last; x = x.next)
			result[i++] = x.element;
		return result;
	}

	public void add(T element) {
		Node<T> node = last.previous;
		Node<T> newNode = new Node<>(node, element, last);
		node.next = newNode;
		last.previous = newNode;
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
		Node<T> newNode = new Node<>(current, element, next);
		current.next = newNode;
		next.previous = newNode;
		size++;
	}

	// O(N^2)
	public void addInSortedOrder(T element) {
		Node<T> current = first;
		while (current.next.element != null && current.next.element.compareTo(element) < 0) {
			current = current.next;
		}

		Node<T> next = current.next;
		Node<T> newNode = new Node<>(current, element, next);
		current.next = newNode;
		next.previous = newNode;
		size++;
	}

	public void remove(T element) {
		Node<T> current = first;
		while (current.next != last) {
			if (current.next.element.equals(element)) {
				Node<T> next = current.next.next;
				current.next.next = null;
				current.next.previous = null;
				current.next = next;
				current.next.previous = current;
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
		T element = current.next.element;
		current.next.next = null;
		current.next.previous = null;
		current.next = next;
		current.next.previous = current;
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
