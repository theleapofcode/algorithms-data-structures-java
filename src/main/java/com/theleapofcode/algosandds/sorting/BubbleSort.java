package com.theleapofcode.algosandds.sorting;

import java.util.Arrays;

public class BubbleSort {

	// O(N^k) - k -> farthest distance traveled. Worst - O(N^2)
	public static <T extends Comparable<T>> void sort(T[] arr) {
		boolean swapped = false;
		do {
			swapped = false;
			for (int i = 1; i < arr.length; i++) {
				// See if values[i] < values[i - 1].
				if (arr[i].compareTo(arr[i - 1]) < 0) {
					// Swap values[i] and values[i - 1].
					T temp = arr[i];
					arr[i] = arr[i - 1];
					arr[i - 1] = temp;
					swapped = true;
				}
			}

			System.out.println(Arrays.toString(arr));
		} while (swapped);
	}

	// O(N^M) - M -> Number of items out of order. Worst - O(N^2)
	public static <T extends Comparable<T>> void sortBySwappingBothSides(T[] arr) {
		boolean swapped = false;
		while (true) {
			// Swap down.
			swapped = false;
			for (int i = 1; i < arr.length; i++) {
				// See if values[i] < values[i - 1].
				if (arr[i].compareTo(arr[i - 1]) < 0) {
					// Swap values[i] and values[i - 1].
					T temp = arr[i];
					arr[i] = arr[i - 1];
					arr[i - 1] = temp;
					swapped = true;
				}
			}
			System.out.println(Arrays.toString(arr));
			if (!swapped)
				break;

			// Swap up.
			swapped = false;
			for (int i = arr.length - 1; i > 0; i--) {
				// See if values[i] < values[i - 1].
				if (arr[i].compareTo(arr[i - 1]) < 0) {
					// Swap values[i] and values[i - 1].
					T temp = arr[i];
					arr[i] = arr[i - 1];
					arr[i - 1] = temp;
					swapped = true;
				}
			}
			System.out.println(Arrays.toString(arr));
			if (!swapped)
				break;
		}
	}

}
