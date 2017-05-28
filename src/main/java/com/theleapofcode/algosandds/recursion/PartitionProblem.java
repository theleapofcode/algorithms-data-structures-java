package com.theleapofcode.algosandds.recursion;

import java.util.Arrays;
import java.util.Random;

public class PartitionProblem {

	public static class PartitionProblemSolution {
		private int[] solution;

		private int difference;

		public int[] getSolution() {
			return solution;
		}

		public void setSolution(int[] solution) {
			this.solution = solution;
		}

		public int getDifference() {
			return difference;
		}

		public void setDifference(int difference) {
			this.difference = difference;
		}

		public PartitionProblemSolution(int[] solution, int difference) {
			super();
			this.solution = solution;
			this.difference = difference;
		}
	}

	// O(2^N)
	public static PartitionProblemSolution solveByExhaustiveSearch(int[] values) {
		int[] testSolution = new int[values.length];
		PartitionProblemSolution solution = new PartitionProblemSolution(new int[values.length], Integer.MAX_VALUE);
		doExhaustiveSearch(values, 0, testSolution, solution);
		return solution;
	}

	private static boolean doExhaustiveSearch(int[] values, int numAssigned, int[] testSolution,
			PartitionProblemSolution bestSolution) {
		// See if we have a complete assignment.
		if (numAssigned == values.length) {
			// Evaluate this solution.
			int[] totals = new int[2];
			for (int i = 0; i < values.length; i++)
				totals[testSolution[i]] += values[i];

			// See if this is an improvement.
			int testDifference = Math.abs(totals[0] - totals[1]);
			if (testDifference < bestSolution.getDifference()) {
				bestSolution.setDifference(testDifference);
				bestSolution.setSolution(testSolution);
			}
			return (bestSolution.getDifference() == 0);
		} else {
			// Try adding the next item to set 0.
			testSolution[numAssigned] = 0;
			if (doExhaustiveSearch(values, numAssigned + 1, testSolution, bestSolution))
				return true;

			// Try adding the next item to set 1.
			testSolution[numAssigned] = 1;
			if (doExhaustiveSearch(values, numAssigned + 1, testSolution, bestSolution))
				return true;

			// We found no perfect solution from this point.
			return false;
		}
	}

	public static PartitionProblemSolution solveByBranchAndBound(int[] values) {
		int[] testSolution = new int[values.length];
		PartitionProblemSolution solution = new PartitionProblemSolution(new int[values.length], Integer.MAX_VALUE);
		doBranchAndBound(values, 0, testSolution, Arrays.stream(values).sum(), 0, 0, solution);
		return solution;
	}

	private static boolean doBranchAndBound(int[] values, int numAssigned, int[] testSolution, int totalUnassigned,
			int total0, int total1, PartitionProblemSolution bestSolution) {
		// See if we have a complete assignment.
		if (numAssigned == values.length) {
			int testDifference = Math.abs(total0 - total1);
			if (testDifference < bestSolution.getDifference()) {
				bestSolution.setDifference(testDifference);
				bestSolution.setSolution(testSolution);
			}
			return (bestSolution.getDifference() == 0);
		} else {
			// We're going to try to assign this value.
			totalUnassigned -= values[numAssigned];

			// Try adding the next item to set 0.
			total0 += values[numAssigned];

			// See if that might lead to an improved solution.
			int testDiff = Math.abs(total0 - total1);
			if (testDiff - totalUnassigned < bestSolution.getDifference()) {
				testSolution[numAssigned] = 0;
				if (doBranchAndBound(values, numAssigned + 1, testSolution, totalUnassigned, total0, total1,
						bestSolution))
					return true;
			}

			// Try adding the next item to set 1.
			total0 -= values[numAssigned];
			total1 += values[numAssigned];

			// See if that might lead to an improved solution.
			testDiff = Math.abs(total0 - total1);
			if (testDiff - totalUnassigned < bestSolution.getDifference()) {
				testSolution[numAssigned] = 1;
				if (doBranchAndBound(values, numAssigned + 1, testSolution, totalUnassigned, total0, total1,
						bestSolution))
					return true;
			}

			// Unassign the most recent value.
			total1 -= values[numAssigned];

			// We found no perfect solution from this point.
			return false;
		}
	}

	private static class PartitionSums {
		int total0;

		int total1;

		PartitionSums(int total0, int total1) {
			this.total0 = total0;
			this.total1 = total1;
		}
	}

	public static PartitionProblemSolution solveByRandom(int[] values, int maxTries) {
		int[] testSolution = new int[values.length];
		PartitionProblemSolution solution = new PartitionProblemSolution(new int[values.length], Integer.MAX_VALUE);

		// Perform up to maxTries trials.
		for (int i = 0; i < maxTries; i++) {
			// Make a random solution.
			PartitionSums partitionSums = new PartitionSums(0, 0);
			doRandom(values, testSolution, partitionSums);

			// See if this is an improvement.
			int testDifference = Math.abs(partitionSums.total0 - partitionSums.total1);
			if (testDifference < solution.getDifference()) {
				solution.setSolution(testSolution);
				solution.setDifference(testDifference);
				if (solution.getDifference() == 0)
					return solution;
			}
		}

		return solution;
	}

	// Make a random assignment.
	private static void doRandom(int[] values, int[] solution, PartitionSums partitionSums) {
		partitionSums.total0 = 0;
		partitionSums.total1 = 0;
		for (int i = 0; i < solution.length; i++) {
			solution[i] = new Random().nextInt(2);
			if (solution[i] == 0)
				partitionSums.total0 += values[i];
			else
				partitionSums.total1 += values[i];
		}
	}

	public static PartitionProblemSolution solveByRandomWithSwaps(int[] values, int maxTries) {
		int[] testSolution = new int[values.length];
		PartitionProblemSolution solution = new PartitionProblemSolution(new int[values.length], Integer.MAX_VALUE);

		// Perform up to maxTries trials.
		for (int i = 0; i < maxTries; i++) {
			// Make a random solution.
			PartitionSums partitionSums = new PartitionSums(0, 0);
			doRandom(values, testSolution, partitionSums);

			// Try to improve the solution with pair swaps.
			tryPairSwaps(values, testSolution, partitionSums);

			// See if this is an improvement.
			int testDifference = Math.abs(partitionSums.total0 - partitionSums.total1);
			if (testDifference < solution.getDifference()) {
				solution.setSolution(testSolution);
				solution.setDifference(testDifference);
				if (solution.getDifference() == 0)
					return solution;
			}
		}

		return solution;
	}

	// Try all possible pair swaps to look for improvements.
	// Return true if we find a perfect solution.
	private static boolean tryPairSwaps(int[] values, int[] solution, PartitionSums partitionSums) {
		int difference = Math.abs(partitionSums.total0 - partitionSums.total1);
		boolean improved = true;
		while (improved) {
			improved = false;
			for (int i = 0; i < solution.length; i++) {
				for (int j = 0; j < solution.length; j++) {
					if ((i != j) && (solution[i] != solution[j])) {
						// See if we should swap values i and j.
						int change0 = -values[i] + values[j]; // The change to
																// set 0.
						if (solution[i] == 1)
							change0 = -change0;
						int change1 = -change0;
						int testDifference = Math
								.abs((partitionSums.total0 + change0) - (partitionSums.total1 + change1));
						if (testDifference < difference) {
							// Keep this change.
							difference = testDifference;
							solution[i] = 1 - solution[i];
							solution[j] = 1 - solution[j];
							improved = true;

							// See if this is a perfect solution.
							if (difference == 0)
								return true;
						}
					}
				}
			}
		}

		// We're not finding any more improvements and
		// we didn't find a perfect solution.
		return false;
	}

	public static PartitionProblemSolution solveByGreedyHueristic(int[] values) {
		int[] testSolution = new int[values.length];
		int total0 = 0, total1 = 0;
		for (int i = 0; i < values.length; i++) {
			// Add the next item to the smaller set.
			if (total0 < total1) {
				total0 += values[i];
				testSolution[i] = 0;
			} else {
				total1 += values[i];
				testSolution[i] = 1;
			}
		}
		int difference = Math.abs(total0 - total1);

		PartitionProblemSolution solution = new PartitionProblemSolution(testSolution, difference);
		return solution;
	}

}
