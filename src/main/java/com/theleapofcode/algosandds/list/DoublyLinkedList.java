package com.theleapofcode.algosandds.list;

public class DoublyLinkedList<T extends Comparable<T>> {

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

	public int size() {
		return size;
	}

	@Override
	public String toString() {
		if (first == null || last == null) {
			return "";
		}

		StringBuilder sbnext = new StringBuilder();
		Node<T> next = first;
		if (next != null) {
			sbnext.append(next.element);
			while (next.next != null) {
				sbnext.append(" -> ").append(next.next.element);
				next = next.next;
			}
		}

		StringBuilder sbprev = new StringBuilder();
		Node<T> prev = last;
		if (prev != null) {
			sbprev.append(prev.element);
			while (prev.previous != null) {
				sbprev.append(" <- ").append(prev.previous.element);
				prev = prev.previous;
			}
		}

		return new StringBuilder(sbnext).append(" <=> ").append(sbprev).toString();
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
			first = new Node<>(null, element, null);
			last = first;
		} else {
			Node<T> node = first;
			while (node.next != null) {
				node = node.next;
			}
			node.next = new Node<>(node, element, null);
			last = node.next;
		}
		size++;
	}

	public void add(int index, T element) {
		if (index > size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}

		Node<T> current = first;
		if (index == 0) {
			first = new Node<>(null, element, current);
			if (current != null) {
				current.previous = first;
			} else {
				last = first;
			}
		} else {
			for (int i = 0; i < index - 1; i++) {
				current = current.next;
			}

			Node<T> next = current.next;
			current.next = new Node<>(current, element, next);
			if (current.next.next != null) {
				current.next.next.previous = current.next;
			} else {
				last = current.next;
			}
		}
		size++;
	}

	// O(N^2)
	public void addInSortedOrder(T element) {
		if (size == 0) {
			first = new Node<>(null, element, null);
			last = first;
		} else {
			Node<T> current = first;
			if (current.element.compareTo(element) > 0) {
				first = new Node<>(null, element, current);
				current.previous = first;
			} else {
				while (current.next != null && current.next.element.compareTo(element) < 0) {
					current = current.next;
				}

				Node<T> next = current.next;
				current.next = new Node<>(current, element, next);
				if (current.next.next != null) {
					current.next.next.previous = current.next;
				} else {
					last = current.next;
				}
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
				if (first != null) {
					first.previous = null;
				}
				size--;
				return;
			}

			while (current.next != null) {
				if (current.next.element.equals(element)) {
					Node<T> next = current.next.next;
					current.next.next = null;
					current.next.previous = null;
					current.next = next;
					if (current.next != null) {
						current.next.previous = current;
					} else {
						last = current;
					}
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
			element = first.element;
			first.next = null;
			if (newFirst != null) {
				newFirst.previous = null;
			}
			first = newFirst;
		} else {
			Node<T> current = first;
			for (int i = 0; i < index - 1; i++) {
				current = current.next;
			}

			Node<T> next = current.next.next;
			element = current.next.element;
			current.next.next = null;
			current.next.previous = null;
			current.next = next;
			if (current.next != null) {
				current.next.previous = current;
			} else {
				last = current;
			}
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
