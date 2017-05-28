package com.theleapofcode.algosandds.sorting;

import java.util.Arrays;

public class HeapSort {

	// O(N logN)
	public static <T extends Comparable<T>> void sort(T[] arr) {
		buildHeap(arr);
		System.out.println("====================");
		heapToSortedArray(arr);
	}

	private static <T extends Comparable<T>> void buildHeap(T[] arr) {
		// Start at index 1 because the values form a
		// trivial heap when only item 0 is in the tree.
		for (int i = 1; i < arr.length; i++) {
			// Add values[i] to the bottom of the heap.
			// Fix the heap from the bottom up.
			int child = i;
			while (true) {
				int parent = (child - 1) / 2;

				// Compare the value to its parent.
				// If values[child] <= values[parent], the tree is a heap.
				if (arr[child].compareTo(arr[parent]) <= 0)
					break;

				// Swap the new value and its parent.
				T temp = arr[child];
				arr[child] = arr[parent];
				arr[parent] = temp;

				// Move up to the next level.
				child = parent;
			}

			System.out.println(Arrays.toString(arr));
		}
	}

	private static <T extends Comparable<T>> void heapToSortedArray(T[] arr) {
		// Loop through the array from back-to-front till index 1.
		for (int i = arr.length - 1; i > 0; i--) {
			// Swap values[0] and values[i].
			T temp = arr[i];
			arr[i] = arr[0];
			arr[0] = temp;

			// Fix the heap by pushing the root item down into the tree.
			int parent = 0;
			while (true) {
				// Get the child indexes.
				int child1 = 2 * parent + 1;
				if (child1 >= i)
					break; // Outside of the current heap.

				// If child2 is outside of the current heap, just use child1.
				int child2 = child1 + 1;
				if (child2 >= i)
					child2 = child1;

				// Find the larger child.
				int largerIndex = child1;
				T largerValue = arr[child1];
				if (largerValue.compareTo(arr[child2]) < 0) {
					largerIndex = child2;
					largerValue = arr[child2];
				}

				// If the larger child is <= the parent, it's a heap again.
				if (largerValue.compareTo(arr[parent]) <= 0)
					break;

				// Swap the parent with the larger child.
				arr[largerIndex] = arr[parent];
				arr[parent] = largerValue;
				parent = largerIndex;
			}

			System.out.println(Arrays.toString(arr));
		}
	}

}
