package com.theleapofcode.algosandds.sorting;

import java.util.Arrays;

public class CountingSort {

	// O(N + M) - M -> Range of integers
	public static void sort(int[] arr, int min, int max) {
		// Make the counts.
		int[] counts = new int[max - min + 1];
		for (int i = 0; i < arr.length; i++)
			counts[arr[i] - min]++;

		System.out.println(Arrays.toString(counts));

		// Write the values back into the array.
		int index = 0;
		int nextValue = min;
		for (int i = 0; i < counts.length; i++) {
			for (int j = 0; j < counts[i]; j++)
				arr[index++] = nextValue;
			nextValue++;
		}
	}

}
