package com.theleapofcode.algosandds.sorting;

import java.util.Arrays;

public class SelectionSort {

	// O(N^2)
	public static <T extends Comparable<T>> void sort(T[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			// Find the smallest item with index >= i.
			int bestIndex = i;
			T bestValue = arr[bestIndex];
			for (int j = i + 1; j < arr.length; j++) {
				// See if values[j] is smaller.
				if (bestValue.compareTo(arr[j]) > 0) {
					// Update the best value.
					bestIndex = j;
					bestValue = arr[j];
				}
			}

			// Swap values[i] and values[bestIndex].
			arr[bestIndex] = arr[i];
			arr[i] = bestValue;

			System.out.println(Arrays.toString(arr));
		}
	}

}
