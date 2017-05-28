package com.theleapofcode.algosandds.sorting;

import java.util.Arrays;

public class QuickSort {

	// O(N logN) if random. O(N^2) worst case
	public static <T extends Comparable<T>> void sort(T[] arr) {
		doQuickSort(arr, 0, arr.length - 1);
	}

	private static <T extends Comparable<T>> void doQuickSort(T[] arr, int min, int max) {
		// If min >= max, there's nothing to sort.
		if (min >= max)
			return;

		// Pick the dividing item.
		T divider = arr[min];
		int left = min;
		int right = max;

		// Divide the array into two halves.
		while (left < right) {
			// The empty spot is at values[left].
			// Look down from position right.
			while ((right > left) && (arr[right].compareTo(divider) > 0))
				right--;

			// See if we're done.
			if (right <= left)
				break;

			// Swap this item into the left side.
			arr[left] = arr[right];
			left++;

			// The empty spot is at values[right].
			// Look up from position left.
			while ((right > left) && (arr[left].compareTo(divider) <= 0))
				left++;

			// See if we're done.
			if (right <= left)
				break;

			// Swap this item into the right side.
			arr[right] = arr[left];
			right--;
		}

		// Desposit the dividing item.
		arr[left] = divider;
		
		System.out.println(Arrays.toString(arr));

		// Recurse.
		doQuickSort(arr, min, left - 1);
		doQuickSort(arr, left + 1, max);
	}

}
