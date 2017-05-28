package com.theleapofcode.algosandds.list;

import org.junit.Assert;
import org.junit.Test;

public class TestDoublyLinkedList {

	@Test
	public void testToArray() {
		DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
		dll.add(10);
		dll.add(20);
		dll.add(30);
		Object[] arr = dll.toArray();
		Assert.assertArrayEquals(new Integer[] { 10, 20, 30 }, arr);
	}

	@Test
	public void testAdd() {
		DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
		Assert.assertEquals(0, dll.size());
		Assert.assertEquals("", dll.toString());
		dll.add(10);
		dll.add(20);
		dll.add(30);
		Assert.assertEquals(3, dll.size());
		Assert.assertEquals("10 -> 20 -> 30 <=> 30 <- 20 <- 10", dll.toString());
	}

	@Test
	public void testAddAtIndex() {
		DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
		dll.add(0, 10);
		dll.add(1, 20);
		dll.add(2, 30);
		dll.add(0, 5);
		Assert.assertEquals(4, dll.size());
		Assert.assertEquals("5 -> 10 -> 20 -> 30 <=> 30 <- 20 <- 10 <- 5", dll.toString());
		dll.add(2, 25);
		Assert.assertEquals(5, dll.size());
		Assert.assertEquals("5 -> 10 -> 25 -> 20 -> 30 <=> 30 <- 20 <- 25 <- 10 <- 5", dll.toString());
		dll.add(5, 40);
		Assert.assertEquals(6, dll.size());
		Assert.assertEquals("5 -> 10 -> 25 -> 20 -> 30 -> 40 <=> 40 <- 30 <- 20 <- 25 <- 10 <- 5", dll.toString());

		try {
			dll.add(7, 100);
			Assert.fail("testAddAtIndex passed");
		} catch (IndexOutOfBoundsException ioobe) {
			Assert.assertEquals("Index: 7, Size: 6", ioobe.getMessage());
		}
	}

	@Test
	public void testAddInSortedOrder() {
		DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
		dll.addInSortedOrder(20);
		dll.addInSortedOrder(10);
		dll.addInSortedOrder(30);
		dll.addInSortedOrder(5);
		Assert.assertEquals(4, dll.size());
		Assert.assertEquals("5 -> 10 -> 20 -> 30 <=> 30 <- 20 <- 10 <- 5", dll.toString());
	}

	@Test
	public void testRemove() {
		DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
		dll.add(10);
		dll.add(20);
		dll.add(30);
		Assert.assertEquals(3, dll.size());
		Assert.assertEquals("10 -> 20 -> 30 <=> 30 <- 20 <- 10", dll.toString());
		dll.remove(new Integer(10));
		Assert.assertEquals(2, dll.size());
		Assert.assertEquals("20 -> 30 <=> 30 <- 20", dll.toString());
		dll.remove(new Integer(40));
		Assert.assertEquals(2, dll.size());
		Assert.assertEquals("20 -> 30 <=> 30 <- 20", dll.toString());
		dll.remove(new Integer(30));
		Assert.assertEquals(1, dll.size());
		Assert.assertEquals("20 <=> 20", dll.toString());
		dll.remove(new Integer(20));
		Assert.assertEquals(0, dll.size());
		Assert.assertEquals("", dll.toString());
	}

	@Test
	public void testRemoveAtIndex() {
		DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
		dll.add(10);
		dll.add(20);
		dll.add(30);
		dll.add(40);
		dll.remove(0);
		Assert.assertEquals(3, dll.size());
		Assert.assertEquals("20 -> 30 -> 40 <=> 40 <- 30 <- 20", dll.toString());
		dll.remove(1);
		Assert.assertEquals(2, dll.size());
		Assert.assertEquals("20 -> 40 <=> 40 <- 20", dll.toString());

		try {
			dll.remove(7);
			Assert.fail("testRemoveAtIndex passed");
		} catch (IndexOutOfBoundsException ioobe) {
			Assert.assertEquals("Index: 7, Size: 2", ioobe.getMessage());
		}

		dll.remove(1);
		Assert.assertEquals(1, dll.size());
		Assert.assertEquals("20 <=> 20", dll.toString());
		dll.remove(0);
		Assert.assertEquals(0, dll.size());
		Assert.assertEquals("", dll.toString());
	}
	
	@Test
	public void testGet() {
		DoublyLinkedList<Integer> sll = new DoublyLinkedList<>();
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
