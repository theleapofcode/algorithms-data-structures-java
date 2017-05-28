package com.theleapofcode.algosandds.search;

public class LinearSearch {

	public static <T extends Comparable<T>> int search(T[] arr, T item) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].compareTo(item) == 0)
				return i;
		}

		return -1;
	}

}
