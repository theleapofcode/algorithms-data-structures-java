package com.theleapofcode.algosandds.sorting;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class TestBubbleSort {

	@Test
	public void testSortAlreadySorted() {
		Integer[] arr = { 10, 20, 30, 40, 50 };
		System.out.println(Arrays.toString(arr));
		System.out.println("====================");
		BubbleSort.sort(arr);
		System.out.println("====================");
		System.out.println(Arrays.toString(arr));
		Assert.assertEquals("[10, 20, 30, 40, 50]", Arrays.toString(arr));
	}

	@Test
	public void testSortReverseSorted() {
		Integer[] arr = { 50, 40, 30, 20, 10 };
		System.out.println(Arrays.toString(arr));
		System.out.println("====================");
		BubbleSort.sort(arr);
		System.out.println("====================");
		System.out.println(Arrays.toString(arr));
		Assert.assertEquals("[10, 20, 30, 40, 50]", Arrays.toString(arr));
	}

	@Test
	public void testSortRandomCase() {
		Integer[] arr = { 30, 10, 40, 20, 50 };
		System.out.println(Arrays.toString(arr));
		System.out.println("====================");
		BubbleSort.sort(arr);
		System.out.println("====================");
		System.out.println(Arrays.toString(arr));
		Assert.assertEquals("[10, 20, 30, 40, 50]", Arrays.toString(arr));
	}

	@Test
	public void testSortAlreadySortedBySwappingBothSides() {
		Integer[] arr = { 10, 20, 30, 40, 50 };
		System.out.println(Arrays.toString(arr));
		System.out.println("====================");
		BubbleSort.sortBySwappingBothSides(arr);
		System.out.println("====================");
		System.out.println(Arrays.toString(arr));
		Assert.assertEquals("[10, 20, 30, 40, 50]", Arrays.toString(arr));
	}

	@Test
	public void testSortReverseSortedBySwappingBothSides() {
		Integer[] arr = { 50, 40, 30, 20, 10 };
		System.out.println(Arrays.toString(arr));
		System.out.println("====================");
		BubbleSort.sortBySwappingBothSides(arr);
		System.out.println("====================");
		System.out.println(Arrays.toString(arr));
		Assert.assertEquals("[10, 20, 30, 40, 50]", Arrays.toString(arr));
	}

	@Test
	public void testSortRandomCaseBySwappingBothSides() {
		Integer[] arr = { 30, 10, 40, 20, 50 };
		System.out.println(Arrays.toString(arr));
		System.out.println("====================");
		BubbleSort.sortBySwappingBothSides(arr);
		System.out.println("====================");
		System.out.println(Arrays.toString(arr));
		Assert.assertEquals("[10, 20, 30, 40, 50]", Arrays.toString(arr));
	}

}
