package com.theleapofcode.algosandds.stacksandqueues;

import com.theleapofcode.algosandds.list.DoublyLinkedListWithSentinels;

public class DequeUsingDoublyLinkedList<T extends Comparable<T>> {

	private DoublyLinkedListWithSentinels<T> dll;

	public DequeUsingDoublyLinkedList() {
		dll = new DoublyLinkedListWithSentinels<>();
	}

	public void enqueueFirst(T element) {
		this.dll.add(0, element);
	}

	public void enqueueLast(T element) {
		this.dll.add(this.dll.size(), element);
	}

	public T dequeueFirst() {
		return this.dll.remove(0);
	}

	public T dequeueLast() {
		return this.dll.remove(this.dll.size() - 1);
	}

	public T peekFirst() {
		return this.dll.get(0);
	}

	public T peekLast() {
		return this.dll.get(this.dll.size() - 1);
	}
	
	public int size() {
		return this.dll.size();
	}
	
}
