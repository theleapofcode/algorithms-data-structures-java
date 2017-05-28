package com.theleapofcode.algosandds.stacksandqueues;

import org.junit.Assert;
import org.junit.Test;

public class TestQueueUsingLinkedList {

	@Test
	public void testQueue() {
		QueueUsingLinkedList<Integer> queue = new QueueUsingLinkedList<>();
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		Assert.assertEquals(new Integer(10), queue.peek());
		Assert.assertEquals(new Integer(10), queue.dequeue());
		Assert.assertEquals(new Integer(20), queue.peek());
		Assert.assertEquals(new Integer(20), queue.dequeue());
		Assert.assertEquals(new Integer(30), queue.peek());
		Assert.assertEquals(new Integer(30), queue.dequeue());
	}

}
