package com.theleapofcode.algosandds.recursion;

public class Fibonacci {

	public static int getFibonacciNumberByRecursion(int n) {
		if (n < 2) {
			return 1;
		} else {
			return getFibonacciNumberByRecursion(n - 1) + getFibonacciNumberByRecursion(n - 2);
		}
	}

	// O(Fibonacci(N))
	public static int[] getFibonacciSequenceByRecursion(int n) {
		int[] fibonacciSequence = new int[n];
		for (int i = 0; i < n; i++) {
			fibonacciSequence[i] = getFibonacciNumberByRecursion(i);
		}

		return fibonacciSequence;
	}

	// O(N)
	public static int[] getFibonacciSequenceByRecursionCached(int n) {
		int[] fibonacciSequence = new int[n];
		for (int i = 0; i < n; i++) {
			if (fibonacciSequence[i] == 0) {
				fibonacciSequence[i] = getFibonacciNumberByRecursion(i);
			}
		}

		return fibonacciSequence;
	}

}
