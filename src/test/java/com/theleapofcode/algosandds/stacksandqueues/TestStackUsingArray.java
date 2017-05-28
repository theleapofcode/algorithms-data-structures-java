package com.theleapofcode.algosandds.stacksandqueues;

import org.junit.Assert;
import org.junit.Test;

public class TestStackUsingArray {

	@Test
	public void testStack() {
		StackUsingArray<Integer> stack = new StackUsingArray<>();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		Assert.assertEquals(new Integer(30), stack.pop());
		Assert.assertEquals(new Integer(20), stack.pop());
		Assert.assertEquals(new Integer(10), stack.pop());
	}

}
