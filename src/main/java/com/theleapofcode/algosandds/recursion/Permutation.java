package com.theleapofcode.algosandds.recursion;

import java.util.List;

public class Permutation {

	public static void permutateKofNWithDuplicates(int index, int[] selections, String[] items, List<String> results) {
		// See if we have made the last assignment.
		if (index == selections.length) {
			// Add the result to the result list.
			String result = "";
			for (int i = 0; i < selections.length; i++)
				result += items[selections[i]];
			results.add(result);
		} else {
			// Make the next assignment.
			for (int i = 0; i < items.length; i++) {
				// Add item i to the selection.
				selections[index] = i;

				// Recursively make the other assignments.
				permutateKofNWithDuplicates(index + 1, selections, items, results);
			}
		}
	}

	public static void permutateKofNWithoutDuplicates(int index, int[] selections, String[] items,
			List<String> results) {
		// See if we have made the last assignment.
		if (index == selections.length) {
			// Add the result so far to the result list.
			String result = "";
			for (int i = 0; i < selections.length; i++)
				result += items[selections[i]];
			results.add(result);
		} else {
			// Make the next assignment.
			for (int i = 0; i < items.length; i++) {
				// Make sure item i hasn't been used yet.
				boolean used = false;
				for (int j = 0; j < index; j++) {
					if (selections[j] == i)
						used = true;
				}

				if (!used) {
					// Add item i to the selection.
					selections[index] = i;

					// Recursively make the other assignments.
					permutateKofNWithoutDuplicates(index + 1, selections, items, results);
				}
			}
		}
	}

}
