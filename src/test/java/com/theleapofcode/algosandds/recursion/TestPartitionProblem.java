package com.theleapofcode.algosandds.recursion;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import com.theleapofcode.algosandds.recursion.PartitionProblem.PartitionProblemSolution;

public class TestPartitionProblem {

	@Test
	public void testSolveByExhaustiveSearch() {
		int[] values = { 2, 4, 1, 1 };
		PartitionProblemSolution solution = PartitionProblem.solveByExhaustiveSearch(values);
		Assert.assertEquals("[0, 1, 0, 0]", Arrays.toString(solution.getSolution()));
		Assert.assertEquals(0, solution.getDifference());
	}

	@Test
	public void testSolveByBranchAndBound() {
		int[] values = { 2, 4, 1, 1 };
		PartitionProblemSolution solution = PartitionProblem.solveByBranchAndBound(values);
		Assert.assertEquals("[0, 1, 0, 0]", Arrays.toString(solution.getSolution()));
		Assert.assertEquals(0, solution.getDifference());
	}

	@Test
	public void testSolveByRandom() {
		int[] values = { 2, 4, 1, 1 };
		PartitionProblemSolution solution = PartitionProblem.solveByRandom(values, 100);
		Assert.assertTrue("[0, 1, 0, 0]".equals(Arrays.toString(solution.getSolution()))
				|| "[1, 0, 1, 1]".equals(Arrays.toString(solution.getSolution())));
		Assert.assertEquals(0, solution.getDifference());
	}

	@Test
	public void testSolveByRandomWithSwaps() {
		int[] values = { 2, 4, 1, 1 };
		PartitionProblemSolution solution = PartitionProblem.solveByRandomWithSwaps(values, 100);
		Assert.assertTrue("[0, 1, 0, 0]".equals(Arrays.toString(solution.getSolution()))
				|| "[1, 0, 1, 1]".equals(Arrays.toString(solution.getSolution())));
		Assert.assertEquals(0, solution.getDifference());
	}

}
