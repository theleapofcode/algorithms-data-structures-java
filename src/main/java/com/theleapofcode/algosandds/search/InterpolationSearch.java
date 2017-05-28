package com.theleapofcode.algosandds.search;

public class InterpolationSearch {

	public static int search(int[] arr, int item) {
		// Make an initial guess.
		int min = 0;
		int max = arr.length - 1;
		double fraction = (item - arr[0]) / (double) (arr[max] - arr[0]);
		int guess = (int) ((max - min) * fraction);
		if (guess < 0)
			guess = 0;
		else if (guess > max)
			guess = max;

		if (item == arr[guess])
			return guess;
		if (item < arr[guess])
			max = guess;
		else
			min = guess;

		// Binary search from this point.
		while (min <= max) {
			int mid = (max + min) / 2;
			long diff = item - arr[mid];
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
