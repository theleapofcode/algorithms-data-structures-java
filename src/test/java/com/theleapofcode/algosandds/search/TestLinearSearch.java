package com.theleapofcode.algosandds.search;

import org.junit.Assert;
import org.junit.Test;

public class TestLinearSearch {

	@Test
	public void testFound() {
		Integer[] arr = { 10, 20, 30 };
		int index = LinearSearch.search(arr, 20);
		Assert.assertEquals(1, index);
	}

	@Test
	public void testNotFound() {
		Integer[] arr = { 10, 20, 30 };
		int index = LinearSearch.search(arr, 40);
		Assert.assertEquals(-1, index);
	}

}
