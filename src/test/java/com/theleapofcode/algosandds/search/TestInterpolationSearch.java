package com.theleapofcode.algosandds.search;

import org.junit.Assert;
import org.junit.Test;

public class TestInterpolationSearch {

	@Test
	public void testFound() {
		int[] arr = { 0, 2, 4, 8, 9, 10, 12, 13, 15, 17 };
		int index = InterpolationSearch.search(arr, 13);
		Assert.assertEquals(7, index);
	}

	@Test
	public void testNotFound() {
		int[] arr = { 0, 2, 4, 8, 9, 10, 12, 13, 15, 17 };
		int index = InterpolationSearch.search(arr, 7);
		Assert.assertEquals(-1, index);
	}

}
