package com.theleapofcode.algosandds.search;

public class BinarySearch {

	public static <T extends Comparable<T>> int search(T[] arr, T item) {
		int min = 0;
		int max = arr.length - 1;
		while (min <= max) {
			int mid = (max + min) / 2;
			int diff = arr[mid].compareTo(item);
			if (diff == 0)
				return mid;
			if (diff < 0)
				max = mid - 1;
			else
				min = mid + 1;
		}

		return -1;
	}

}
