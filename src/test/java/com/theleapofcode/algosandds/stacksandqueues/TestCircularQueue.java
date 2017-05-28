package com.theleapofcode.algosandds.stacksandqueues;

import org.junit.Assert;
import org.junit.Test;

public class TestCircularQueue {

	@Test
	public void testCircularQueue() {
		CircularQueue<Integer> queue = new CircularQueue<>(5);
		queue.enque(10);
		queue.enque(20);
		queue.enque(30);
		queue.enque(40);
		queue.enque(50);
		Assert.assertEquals(new Integer(10), queue.peek());
		Assert.assertEquals(new Integer(10), queue.dequeue());
		Assert.assertEquals(new Integer(20), queue.peek());
		Assert.assertEquals(new Integer(20), queue.dequeue());
		Assert.assertEquals(new Integer(30), queue.peek());
		Assert.assertEquals(new Integer(30), queue.dequeue());
	}

}
