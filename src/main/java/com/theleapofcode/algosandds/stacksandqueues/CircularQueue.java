package com.theleapofcode.algosandds.stacksandqueues;

public class CircularQueue<T> {

	private T[] arr;

	private int top;

	private int bottom;

	private int count;

	@SuppressWarnings("unchecked")
	public CircularQueue(int size) {
		this.arr = (T[]) new Object[size];
	}

	public void enque(T element) {
		if (count == arr.length) {
			throw new RuntimeException("Queue is full");
		}
		this.arr[top] = element;
		top = (top + 1) % arr.length;
		count++;
	}

	public T dequeue() {
		if (count == 0) {
			throw new RuntimeException("Queue is empty");
		}
		T element = this.arr[bottom];
		bottom = (bottom + 1) % arr.length;
		count--;
		return element;
	}

	public T peek() {
		return this.arr[bottom];
	}

}
