package com.theleapofcode.algosandds.stacksandqueues;

public class StackUsingArray<T> {

	private static int STACK_SIZE = 100;

	private int count;

	private T[] arr;

	@SuppressWarnings("unchecked")
	public StackUsingArray() {
		this.arr = (T[]) new Object[STACK_SIZE];
	}

	public void push(T element) {
		this.arr[count++] = element;
	}

	public T pop() {
		return this.arr[--count];
	}

}
