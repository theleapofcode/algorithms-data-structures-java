package com.theleapofcode.algosandds.recursion;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class TestPermutation {

	@Test
	public void testPermutateKofNWithDuplicates() {
		int k = 3;
		int n = 10;
		int[] selections = new int[k];
		String[] items = new String[n];
		for (int i = 0; i < n; i++) {
			items[i] = "A" + i;
		}
		List<String> results = new LinkedList<>();
		Permutation.permutateKofNWithDuplicates(0, selections, items, results);
		System.out.println(results);
		Assert.assertEquals(new Double(Math.pow(n, k)), new Double(results.size()));
	}

	@Test
	public void testPermutateKofNWithoutDuplicates() {
		int k = 3;
		int n = 10;
		int[] selections = new int[k];
		String[] items = new String[n];
		for (int i = 0; i < n; i++) {
			items[i] = "A" + i;
		}
		List<String> results = new LinkedList<>();
		Permutation.permutateKofNWithoutDuplicates(0, selections, items, results);
		System.out.println(results);

		int total = 1;
		for (int i = n; i > n - k; i--)
			total *= i;
		Assert.assertEquals(total, results.size());
	}

}
