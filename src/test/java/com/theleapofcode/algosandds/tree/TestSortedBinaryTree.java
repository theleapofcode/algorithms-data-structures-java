package com.theleapofcode.algosandds.tree;

import org.junit.Assert;
import org.junit.Test;

public class TestSortedBinaryTree {

	@Test
	public void testAdd() {
		SortedBinaryTree<Integer> sbt = new SortedBinaryTree<>(new BinaryTreeNodeWithParent<>(5));
		sbt.add(12);
		sbt.add(9);
		sbt.add(27);
		sbt.add(32);
		sbt.add(29);
		sbt.add(20);
		Assert.assertEquals("5 (, 12 (9 (,), 27 (20 (,), 32 (29 (,),))))", sbt.toString());
	}

	@Test
	public void testFind() {
		BinaryTreeNodeWithParent<Integer> n21 = new BinaryTreeNodeWithParent<>(5);
		BinaryTreeNodeWithParent<Integer> n22 = new BinaryTreeNodeWithParent<>(12);
		BinaryTreeNodeWithParent<Integer> n11 = new BinaryTreeNodeWithParent<>(9, n21, n22);

		BinaryTreeNodeWithParent<Integer> n23 = new BinaryTreeNodeWithParent<>(27);
		BinaryTreeNodeWithParent<Integer> n24 = new BinaryTreeNodeWithParent<>(32);
		BinaryTreeNodeWithParent<Integer> n12 = new BinaryTreeNodeWithParent<>(29, n23, n24);

		BinaryTreeNodeWithParent<Integer> rootNode = new BinaryTreeNodeWithParent<>(20, n11, n12);
		SortedBinaryTree<Integer> sbt = new SortedBinaryTree<>(rootNode);

		String label = sbt.find(27);
		Assert.assertEquals("27", label);

		String label2 = sbt.find(35);
		Assert.assertNull(label2);
	}

	@Test
	public void testDeleteLeafNode() {
		SortedBinaryTree<Integer> sbt = new SortedBinaryTree<>(new BinaryTreeNodeWithParent<>(20));
		sbt.add(9);
		sbt.add(29);
		sbt.add(5);
		sbt.add(12);
		sbt.add(25);
		sbt.add(32);
		sbt.add(2);
		sbt.add(11);
		sbt.add(16);
		sbt.add(21);
		sbt.add(28);
		sbt.add(26);
		boolean deleted = sbt.delete(16);
		Assert.assertTrue(deleted);
		Assert.assertEquals("20 (9 (5 (2 (,),), 12 (11 (,),)), 29 (25 (21 (,), 28 (26 (,),)), 32 (,)))",
				sbt.toString());
	}

	@Test
	public void testDeleteNodeWithOnlyOneChild() {
		SortedBinaryTree<Integer> sbt = new SortedBinaryTree<>(new BinaryTreeNodeWithParent<>(20));
		sbt.add(9);
		sbt.add(29);
		sbt.add(5);
		sbt.add(12);
		sbt.add(25);
		sbt.add(32);
		sbt.add(2);
		sbt.add(11);
		sbt.add(16);
		sbt.add(21);
		sbt.add(28);
		sbt.add(26);
		boolean deleted = sbt.delete(5);
		Assert.assertTrue(deleted);
		Assert.assertEquals("20 (9 (2 (,), 12 (11 (,), 16 (,))), 29 (25 (21 (,), 28 (26 (,),)), 32 (,)))",
				sbt.toString());
	}

	@Test
	public void testDeleteNodeWithLeftChildHavingNoRightChild() {
		SortedBinaryTree<Integer> sbt = new SortedBinaryTree<>(new BinaryTreeNodeWithParent<>(20));
		sbt.add(9);
		sbt.add(29);
		sbt.add(5);
		sbt.add(12);
		sbt.add(25);
		sbt.add(32);
		sbt.add(2);
		sbt.add(11);
		sbt.add(16);
		sbt.add(21);
		sbt.add(28);
		sbt.add(26);
		boolean deleted = sbt.delete(9);
		Assert.assertTrue(deleted);
		Assert.assertEquals("20 (5 (2 (,), 12 (11 (,), 16 (,))), 29 (25 (21 (,), 28 (26 (,),)), 32 (,)))",
				sbt.toString());
	}

	@Test
	public void testDeleteNodeComplicated() {
		SortedBinaryTree<Integer> sbt = new SortedBinaryTree<>(new BinaryTreeNodeWithParent<>(20));
		sbt.add(9);
		sbt.add(29);
		sbt.add(5);
		sbt.add(12);
		sbt.add(25);
		sbt.add(32);
		sbt.add(2);
		sbt.add(11);
		sbt.add(16);
		sbt.add(21);
		sbt.add(28);
		sbt.add(26);
		boolean deleted = sbt.delete(29);
		Assert.assertTrue(deleted);
		Assert.assertEquals("20 (9 (5 (2 (,),), 12 (11 (,), 16 (,))), 28 (25 (21 (,), 26 (,)), 32 (,)))",
				sbt.toString());
	}

}
