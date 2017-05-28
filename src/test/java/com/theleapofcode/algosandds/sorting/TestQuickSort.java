package com.theleapofcode.algosandds.sorting;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class TestQuickSort {

	@Test
	public void testSortAlreadySorted() {
		Integer[] arr = { 10, 20, 30, 40, 50 };
		System.out.println(Arrays.toString(arr));
		System.out.println("====================");
		QuickSort.sort(arr);
		System.out.println("====================");
		System.out.println(Arrays.toString(arr));
		Assert.assertEquals("[10, 20, 30, 40, 50]", Arrays.toString(arr));
	}

	@Test
	public void testSortReverseSorted() {
		Integer[] arr = { 50, 40, 30, 20, 10 };
		System.out.println(Arrays.toString(arr));
		System.out.println("====================");
		QuickSort.sort(arr);
		System.out.println("====================");
		System.out.println(Arrays.toString(arr));
		Assert.assertEquals("[10, 20, 30, 40, 50]", Arrays.toString(arr));
	}

	@Test
	public void testSortRandomCase() {
		Integer[] arr = { 30, 10, 40, 20, 50 };
		System.out.println(Arrays.toString(arr));
		System.out.println("====================");
		QuickSort.sort(arr);
		System.out.println("====================");
		System.out.println(Arrays.toString(arr));
		Assert.assertEquals("[10, 20, 30, 40, 50]", Arrays.toString(arr));
	}

}
