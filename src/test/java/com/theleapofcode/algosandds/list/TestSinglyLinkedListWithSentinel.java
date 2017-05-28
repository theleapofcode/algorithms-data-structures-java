package com.theleapofcode.algosandds.list;

import org.junit.Assert;
import org.junit.Test;

public class TestSinglyLinkedListWithSentinel {

	@Test
	public void testToArray() {
		SinglyLinkedListWithSentinel<Integer> sll = new SinglyLinkedListWithSentinel<>();
		sll.add(10);
		sll.add(20);
		sll.add(30);
		Object[] arr = sll.toArray();
		Assert.assertArrayEquals(new Integer[] { 10, 20, 30 }, arr);
	}

	@Test
	public void testAdd() {
		SinglyLinkedListWithSentinel<Integer> sll = new SinglyLinkedListWithSentinel<>();
		Assert.assertEquals(0, sll.size());
		Assert.assertEquals("", sll.toString());
		sll.add(10);
		sll.add(20);
		sll.add(30);
		Assert.assertEquals(3, sll.size());
		Assert.assertEquals("10 -> 20 -> 30", sll.toString());
	}

	@Test
	public void testAddAtIndex() {
		SinglyLinkedListWithSentinel<Integer> sll = new SinglyLinkedListWithSentinel<>();
		sll.add(10);
		sll.add(20);
		sll.add(30);
		sll.add(0, 5);
		sll.add(2, 25);
		sll.add(5, 40);
		Assert.assertEquals(6, sll.size());
		Assert.assertEquals("5 -> 10 -> 25 -> 20 -> 30 -> 40", sll.toString());

		try {
			sll.add(7, 100);
			Assert.fail("testAddAtIndex passed");
		} catch (IndexOutOfBoundsException ioobe) {
			Assert.assertEquals("Index: 7, Size: 6", ioobe.getMessage());
		}
	}

	@Test
	public void testAddInSortedOrder() {
		SinglyLinkedListWithSentinel<Integer> sll = new SinglyLinkedListWithSentinel<>();
		sll.addInSortedOrder(20);
		sll.addInSortedOrder(10);
		sll.addInSortedOrder(30);
		sll.addInSortedOrder(5);
		Assert.assertEquals(4, sll.size());
		Assert.assertEquals("5 -> 10 -> 20 -> 30", sll.toString());
	}

	@Test
	public void testRemove() {
		SinglyLinkedListWithSentinel<Integer> sll = new SinglyLinkedListWithSentinel<>();
		sll.add(10);
		sll.add(20);
		sll.add(30);
		Assert.assertEquals(3, sll.size());
		Assert.assertEquals("10 -> 20 -> 30", sll.toString());
		sll.remove(new Integer(10));
		Assert.assertEquals(2, sll.size());
		Assert.assertEquals("20 -> 30", sll.toString());
		sll.remove(new Integer(40));
		Assert.assertEquals(2, sll.size());
		Assert.assertEquals("20 -> 30", sll.toString());
	}

	@Test
	public void testRemoveAtIndex() {
		SinglyLinkedListWithSentinel<Integer> sll = new SinglyLinkedListWithSentinel<>();
		sll.add(10);
		sll.add(20);
		sll.add(30);
		sll.add(40);
		Assert.assertEquals(4, sll.size());
		Assert.assertEquals("10 -> 20 -> 30 -> 40", sll.toString());
		sll.remove(0);
		Assert.assertEquals(3, sll.size());
		Assert.assertEquals("20 -> 30 -> 40", sll.toString());
		sll.remove(1);
		Assert.assertEquals(2, sll.size());
		Assert.assertEquals("20 -> 40", sll.toString());

		try {
			sll.remove(7);
			Assert.fail("testRemoveAtIndex passed");
		} catch (IndexOutOfBoundsException ioobe) {
			Assert.assertEquals("Index: 7, Size: 2", ioobe.getMessage());
		}
	}
	
	@Test
	public void testGet() {
		SinglyLinkedListWithSentinel<Integer> sll = new SinglyLinkedListWithSentinel<>();
		sll.add(0, 10);
		sll.add(1, 20);
		sll.add(2, 30);
		Assert.assertEquals(new Integer(10), sll.get(0));
		Assert.assertEquals(new Integer(20), sll.get(1));
		Assert.assertEquals(new Integer(30), sll.get(2));

		try {
			sll.get(4);
			Assert.fail("testGet passed");
		} catch (IndexOutOfBoundsException ioobe) {
			Assert.assertEquals("Index: 4, Size: 3", ioobe.getMessage());
		}
	}

}
