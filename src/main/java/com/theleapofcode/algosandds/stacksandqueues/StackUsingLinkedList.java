package com.theleapofcode.algosandds.stacksandqueues;

import com.theleapofcode.algosandds.list.SinglyLinkedList;

public class StackUsingLinkedList<T extends Comparable<T>> {

	private SinglyLinkedList<T> ll;

	public StackUsingLinkedList() {
		this.ll = new SinglyLinkedList<>();
	}

	public void push(T element) {
		this.ll.add(0, element);
	}

	public T pop() {
		return this.ll.remove(0);
	}

}
