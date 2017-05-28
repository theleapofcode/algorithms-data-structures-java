package com.theleapofcode.algosandds.tree;

import org.junit.Assert;
import org.junit.Test;

public class TestBTree {

	@Test
	public void testAdd() {
		BTree<Integer> btree = new BTree<>(2);
		btree.add(11);
		btree.add(13);
		btree.add(32);
		btree.add(25);
		btree.add(15);
		btree.add(37);
		btree.add(16);
		btree.add(2);
		btree.add(5);
		btree.add(18);
		System.out.println(btree);
	}

	@Test
	public void testFind() {
		BTree<Integer> btree = new BTree<>(2);
		btree.add(11);
		btree.add(13);
		btree.add(32);
		btree.add(25);
		btree.add(15);
		btree.add(37);
		btree.add(16);
		btree.add(2);
		btree.add(5);
		btree.add(18);

		boolean present = btree.find(16);
		Assert.assertTrue(present);

		boolean present2 = btree.find(39);
		Assert.assertFalse(present2);
	}

	@Test
	public void testRemove() {
		BTree<Integer> btree = new BTree<>(2);
		btree.add(11);
		btree.add(13);
		btree.add(32);
		btree.add(25);
		btree.add(15);
		btree.add(37);
		btree.add(16);
		btree.add(2);
		btree.add(5);
		btree.add(18);
		System.out.println(btree);

		btree.remove(11);
		System.out.println(btree);
	}

}
