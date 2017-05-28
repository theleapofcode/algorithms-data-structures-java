package com.theleapofcode.algosandds.stacksandqueues;

import org.junit.Assert;
import org.junit.Test;

public class TestDequeUsingDoublyLinkedList {

	@Test
	public void testQueue() {
		DequeUsingDoublyLinkedList<Integer> queue = new DequeUsingDoublyLinkedList<>();
		queue.enqueueFirst(10);
		queue.enqueueFirst(20);
		queue.enqueueLast(30);
		queue.enqueueLast(40);
		Assert.assertEquals(new Integer(20), queue.peekFirst());
		Assert.assertEquals(new Integer(20), queue.dequeueFirst());
		Assert.assertEquals(new Integer(40), queue.peekLast());
		Assert.assertEquals(new Integer(40), queue.dequeueLast());
	}

}
