package com.theleapofcode.algosandds.sorting;

import java.util.Arrays;

public class InsertionSort {

	// O(N^2)
	public static <T extends Comparable<T>> void sort(T[] arr) {
		for (int i = 1; i < arr.length; i++) {
			// Find the spot where item i belongs.
			T item = arr[i];
			int index = 0;
			while ((index <= i) && (item.compareTo(arr[index]) > 0))
				index++;

			// The item belongs in position index.
			// Move the items between values[i - 1] and values[index]
			// one spot to the right to make room.
			for (int j = i - 1; j >= index; j--)
				arr[j + 1] = arr[j];

			// Deposit the item in position index.
			arr[index] = item;

			System.out.println(Arrays.toString(arr));
		}
	}

}
