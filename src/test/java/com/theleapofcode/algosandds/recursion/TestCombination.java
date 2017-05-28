package com.theleapofcode.algosandds.recursion;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class TestCombination {

	@Test
	public void testSelectKofNWithDuplicates() {
		int k = 3;
		int n = 10;
		int[] selections = new int[k];
		String[] items = new String[n];
		for (int i = 0; i < n; i++) {
			items[i] = "A" + i;
		}
		List<String> results = new LinkedList<>();
		Combination.selectKofNWithDuplicates(0, selections, items, results);
		System.out.println(results);
		Assert.assertEquals(selectionCount(n + k - 1, k), results.size());
	}

	@Test
	public void testSelectKofNWithoutDuplicates() {
		int k = 3;
		int n = 10;
		int[] selections = new int[k];
		String[] items = new String[n];
		for (int i = 0; i < n; i++) {
			items[i] = "A" + i;
		}
		List<String> results = new LinkedList<>();
		Combination.selectKofNWithoutDuplicates(0, selections, items, results);
		System.out.println(results);
		Assert.assertEquals(selectionCount(n, k), results.size());
	}

	private long selectionCount(long n, long k) {
		return factorial(n) / factorial(k) / factorial(n - k);
	}

	private long factorial(long n) {
		long result = 1;
		for (int i = 2; i <= n; i++)
			result *= i;
		return result;
	}

}
