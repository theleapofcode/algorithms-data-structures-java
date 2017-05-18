package com.theleapofcode.algosandds.numerical;

import java.util.LinkedList;
import java.util.List;

public class Calculator {

	// Euclid's algorithm -> gcd(a, b) = gcd(b, remainder)
	// O(Log N)
	public static long gcd(long a, long b) {
		while (b != 0) {
			long remainder = a % b;
			a = b;
			b = remainder;
		}

		return a;
	}

	// lcm(a, b) = (a * b) / gcd(a, b)
	// O(Log N)
	public static long lcm(long a, long b) {
		return a / gcd(a, b) * b;
	}

	// O(sqrt(2)^N) -> N is number of bits in binary representation of a
	public static List<Long> primeFactors(long a) {
		List<Long> primeFactors = new LinkedList<>();

		// Extract all 2 factors
		while (a % 2 == 0) {
			primeFactors.add(2l);
			a = a / 2;
		}

		// Start from 3
		long factor = 3;

		// Prime factors are always less than or equal to sqrt(a)
		while (factor * factor <= a) {
			while (a % factor == 0) {
				primeFactors.add(factor);
				a = a / factor;
			}

			// Skip all multiples of 2
			factor = factor + 2;
		}

		// Finally add remaining number if not 1
		if (a > 1) {
			primeFactors.add(a);
		}

		return primeFactors;
	}

	public static boolean isPrime(int a) {
		// check if a is a multiple of 2
		if (a % 2 == 0)
			return false;

		// if not, then just check the odds
		for (int i = 3; i * i <= a; i += 2) {
			if (a % i == 0)
				return false;
		}
		return true;
	}

	// Sieve of Eratostenis algorithm
	public static List<Integer> primesTill(int a) {
		List<Integer> primes = new LinkedList<>();
		// Flags to hold if number at position is not prime
		boolean[] isNotPrime = new boolean[a];

		// Cancel multiples of 2
		for (int i = 4; i <= a; i += 2) {
			isNotPrime[i - 1] = true;
		}

		for (int i = 3; i * i <= a; i += 2) {
			if (!isNotPrime[i - 1]) {
				for (int j = ((i * i) - 1); j < a; j += (2 * i)) {
					isNotPrime[j] = true;
				}
			}
		}

		for (int x = 2; x <= isNotPrime.length; x++) {
			if (!isNotPrime[x - 1]) {
				primes.add(x);
			}
		}

		return primes;
	}

}
