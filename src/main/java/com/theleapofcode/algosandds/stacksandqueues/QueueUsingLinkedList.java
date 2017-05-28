package com.theleapofcode.algosandds.stacksandqueues;

import com.theleapofcode.algosandds.list.DoublyLinkedList;

public class QueueUsingLinkedList<T extends Comparable<T>> {

	private DoublyLinkedList<T> ll;

	public QueueUsingLinkedList() {
		this.ll = new DoublyLinkedList<>();
	}

	public void enqueue(T element) {
		this.ll.add(0, element);
	}

	public T dequeue() {
		return this.ll.remove(this.ll.size() - 1);
	}

	public T peek() {
		return this.ll.get(this.ll.size() - 1);
	}
	
	public int size() {
		return this.ll.size();
	}

}
