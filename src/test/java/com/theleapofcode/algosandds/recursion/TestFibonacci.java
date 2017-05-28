package com.theleapofcode.algosandds.recursion;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class TestFibonacci {

	@Test
	public void testFibonacciByRecursion() {
		int[] fs = Fibonacci.getFibonacciSequenceByRecursion(10);
		Assert.assertEquals("[1, 1, 2, 3, 5, 8, 13, 21, 34, 55]", Arrays.toString(fs));
	}

	@Test
	public void testFibonacciByRecursionCached() {
		int[] fs = Fibonacci.getFibonacciSequenceByRecursionCached(10);
		Assert.assertEquals("[1, 1, 2, 3, 5, 8, 13, 21, 34, 55]", Arrays.toString(fs));
	}

}
