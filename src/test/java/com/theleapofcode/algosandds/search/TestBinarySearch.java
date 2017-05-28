package com.theleapofcode.algosandds.search;

import org.junit.Assert;
import org.junit.Test;

public class TestBinarySearch {

	@Test
	public void testFound() {
		Integer[] arr = { 10, 20, 30 };
		int index = BinarySearch.search(arr, 20);
		Assert.assertEquals(1, index);
	}

	@Test
	public void testNotFound() {
		Integer[] arr = { 10, 20, 30 };
		int index = BinarySearch.search(arr, 40);
		Assert.assertEquals(-1, index);
	}

}
