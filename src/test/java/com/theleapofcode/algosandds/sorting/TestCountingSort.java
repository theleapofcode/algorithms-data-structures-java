package com.theleapofcode.algosandds.sorting;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class TestCountingSort {

	@Test
	public void testSort() {
		int[] arr = { 1, 1, 3, 4, 2, 2 };
		System.out.println(Arrays.toString(arr));
		System.out.println("====================");
		CountingSort.sort(arr, 1, 4);
		System.out.println("====================");
		System.out.println(Arrays.toString(arr));
		Assert.assertEquals("[1, 1, 2, 2, 3, 4]", Arrays.toString(arr));
	}

}
