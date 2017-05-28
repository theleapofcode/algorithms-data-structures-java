package com.theleapofcode.algosandds.recursion;

import org.junit.Assert;
import org.junit.Test;

public class TestTowerOfHanoi {

	@Test
	public void testSolve() {
		String result = TowerOfHanoi.solve("A", "B", "C", 3);
		Assert.assertEquals("A->B A->C B->C A->B C->A C->B A->B", result);
	}

}
