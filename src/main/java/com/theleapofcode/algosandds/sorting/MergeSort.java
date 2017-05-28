package com.theleapofcode.algosandds.sorting;

import java.lang.reflect.Array;

public class MergeSort {

	// O(N logN)
	public static <T extends Comparable<T>> void sort(T[] arr, Class<T> clazz) {
		// Make a temporary storage array so we don't have to
		// make lots of arrays in the calls to DoMergesort.
		@SuppressWarnings("unchecked")
		T[] temp = (T[]) Array.newInstance(clazz, arr.length);

		// Perform the sort.
		doMergesort(temp, arr, 0, arr.length - 1);
	}

	private static <T extends Comparable<T>> void doMergesort(T[] temp, T[] arr, int min, int max) {
		// If we're working with 0 or 1 items, we're done.
		if (max - min < 1)
			return;

		// Find the middle index;
		int mid = (max + min) / 2;

		// Recursively sort the two halves [min, mid] and [mid + 1, max].
		doMergesort(temp, arr, min, mid);
		doMergesort(temp, arr, mid + 1, max);

		// Use the temporary array to merge the results.
		int leftIndex = min;
		int rightIndex = mid + 1;
		T smallerValue;
		for (int i = min; i <= max; i++) {
			if (leftIndex > mid) {
				// We ran out of left values. Use the next right value.
				smallerValue = arr[rightIndex];
				rightIndex++;
			} else if (rightIndex > max) {
				// We ran out of right values. Use the next left value.
				smallerValue = arr[leftIndex];
				leftIndex++;
			} else {
				// Use whichever value is smaller.
				if (arr[leftIndex].compareTo(arr[rightIndex]) <= 0) {
					// Use the left value.
					smallerValue = arr[leftIndex];
					leftIndex++;
				} else {
					// Use the right value.
					smallerValue = arr[rightIndex];
					rightIndex++;
				}
			}

			// Move the selected value into the temp array.
			temp[i] = smallerValue;
		}

		// Copy the results back into the values array.
		for (int i = min; i <= max; i++) {
			arr[i] = temp[i];
		}
	}

}
