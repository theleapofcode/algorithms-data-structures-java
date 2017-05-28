package com.theleapofcode.algosandds.recursion;

public class TowerOfHanoi {

	// O(2^N)
	public static String solve(String fromPeg, String toPeg, String otherPeg, int numDisks) {
		StringBuilder result = new StringBuilder();

		// Recursively move the top n - 1 disks from from_peg to other_peg.
		if (numDisks > 1)
			result.append(solve(fromPeg, otherPeg, toPeg, numDisks - 1));

		// Move the last disk from from_peg to to_peg.
		if (numDisks > 1)
			result.append(" ");
		result.append(fromPeg).append("->").append(toPeg);

		// Recursively move the top n - 1 disks back from other_peg to to_peg.
		if (numDisks > 1)
			result.append(" ").append(solve(otherPeg, toPeg, fromPeg, numDisks - 1));

		return result.toString();
	}

}
