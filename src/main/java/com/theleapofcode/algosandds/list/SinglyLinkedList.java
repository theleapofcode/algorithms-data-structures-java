package com.theleapofcode.algosandds.list;

public class SinglyLinkedList<T extends Comparable<T>> {

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

	public int size() {
		return size;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node<T> current = first;
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
		for (Node<T> x = first; x != null; x = x.next)
			result[i++] = x.element;
		return result;
	}

	public void add(T element) {
		if (size == 0) {
			first = new Node<>(element, null);
		} else {
			Node<T> last = first;
			while (last.next != null) {
				last = last.next;
			}
			last.next = new Node<>(element, null);
		}
		size++;
	}

	public void add(int index, T element) {
		if (index > size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}

		Node<T> current = first;
		if (index == 0) {
			first = new Node<>(element, current);
		} else {
			for (int i = 0; i < index - 1; i++) {
				current = current.next;
			}

			Node<T> next = current.next;
			current.next = new Node<>(element, next);
		}
		size++;
	}

	// O(N^2)
	public void addInSortedOrder(T element) {
		if (size == 0) {
			first = new Node<>(element, null);
		} else {
			Node<T> current = first;
			if (current.element.compareTo(element) > 0) {
				first = new Node<>(element, current);
			} else {
				while (current.next != null && current.next.element.compareTo(element) < 0) {
					current = current.next;
				}

				Node<T> next = current.next;
				current.next = new Node<>(element, next);
			}
		}
		size++;
	}

	public void remove(T element) {
		Node<T> current = first;
		if (current != null) {
			if (current.element.equals(element)) {
				first = current.next;
				current.next = null;
				size--;
				return;
			}

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
	}

	public T remove(int index) {
		if (index >= size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}

		T element;
		if (index == 0) {
			Node<T> newFirst = first.next;
			first.next = null;
			element = first.element;
			first = newFirst;
		} else {
			Node<T> current = first;
			for (int i = 0; i < index - 1; i++) {
				current = current.next;
			}

			Node<T> next = current.next.next;
			current.next.next = null;
			element = current.next.element;
			current.next = next;
		}
		size--;

		return element;
	}

	public T get(int index) {
		if (index > size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}

		Node<T> current = first;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}

		return current.element;
	}

}
