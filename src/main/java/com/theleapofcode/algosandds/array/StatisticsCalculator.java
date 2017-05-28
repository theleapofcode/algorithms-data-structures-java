package com.theleapofcode.algosandds.array;

public class StatisticsCalculator {

	public static int sum(int[] nums) {
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}

		return sum;
	}

	public static double mean(int[] nums) {
		return sum(nums) / nums.length;
	}

	public static double variance(int[] nums) {
		double mean = mean(nums);

		double sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += ((nums[i] - mean) * (nums[i] - mean));
		}

		return sum / nums.length;
	}

	public static double standardDeviation(int[] nums) {
		return Math.sqrt(variance(nums));
	}

}
