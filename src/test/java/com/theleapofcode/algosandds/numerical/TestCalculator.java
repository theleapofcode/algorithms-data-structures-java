package com.theleapofcode.algosandds.numerical;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class TestCalculator {

	@Test
	public void testGCD() {
		long gcd = Calculator.gcd(24, 60);
		Assert.assertEquals(12, gcd);
	}

	@Test
	public void testLCM() {
		long lcm = Calculator.lcm(24, 60);
		Assert.assertEquals(120, lcm);
	}

	@Test
	public void testPrimeFactors() {
		List<Long> primeFactors = Calculator.primeFactors(60);
		Assert.assertEquals("[2, 2, 3, 5]", primeFactors.toString());
	}

	@Test
	public void testIsPrime() {
		boolean isPrime = Calculator.isPrime(29);
		Assert.assertTrue(isPrime);

		boolean isPrime2 = Calculator.isPrime(49);
		Assert.assertFalse(isPrime2);
	}

	@Test
	public void testPrimesTill() {
		List<Integer> primes = Calculator.primesTill(20);
		Assert.assertEquals("[2, 3, 5, 7, 11, 13, 17, 19]", primes.toString());
	}

}
