package com.theleapofcode.algosandds.recursion;

import java.util.List;

public class Combination {

	public static void selectKofNWithDuplicates(int index, int[] selections, String[] items, List<String> results) {
		// See if we have made the last assignment.
		if (index == selections.length) {
			// Add the result to the result list.
			String result = "";
			for (int i = 0; i < selections.length; i++)
				result += items[selections[i]];
			results.add(result);
		} else {
			// Get the smallest value we can use for the next selection.
			int start = 0;
			if (index > 0)
				start = selections[index - 1];

			// Make the next assignment.
			for (int i = start; i < items.length; i++) {
				// Add item i to the selection.
				selections[index] = i;

				// Recursively make the other assignments.
				selectKofNWithDuplicates(index + 1, selections, items, results);
			}
		}
	}

	public static void selectKofNWithoutDuplicates(int index, int[] selections, String[] items, List<String> results) {
		// See if we have made the last assignment.
		if (index == selections.length) {
			// Add the result to the result list.
			String result = "";
			for (int i = 0; i < selections.length; i++)
				result += items[selections[i]];
			results.add(result);
		} else {
			// Get the smallest value we can use for the next selection.
			int start = 0;
			if (index > 0)
				start = selections[index - 1] + 1;

			// Make the next assignment.
			for (int i = start; i < items.length; i++) {
				// Add item i to the selection.
				selections[index] = i;

				// Recursively make the other assignments.
				selectKofNWithoutDuplicates(index + 1, selections, items, results);
			}
		}
	}

}
