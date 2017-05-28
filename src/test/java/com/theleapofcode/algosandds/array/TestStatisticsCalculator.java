package com.theleapofcode.algosandds.array;

import org.junit.Test;

import junit.framework.Assert;

public class TestStatisticsCalculator {

	@Test
	public void testMean() {
		int[] nums = { 10, 20, 30, 40, 50 };
		double mean = StatisticsCalculator.mean(nums);
		Assert.assertEquals(30.0, mean);
	}

	@Test
	public void testVariance() {
		int[] nums = { 10, 20, 30, 40, 50 };
		double variance = StatisticsCalculator.variance(nums);
		Assert.assertEquals(200.0, variance);
	}

	@Test
	public void testStandardDeviation() {
		int[] nums = { 10, 20, 30, 40, 50 };
		double standardDeviation = StatisticsCalculator.standardDeviation(nums);
		Assert.assertEquals(Math.sqrt(200), standardDeviation);
	}

}
