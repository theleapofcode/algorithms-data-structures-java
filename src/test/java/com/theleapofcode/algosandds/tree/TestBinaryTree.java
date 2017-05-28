package com.theleapofcode.algosandds.tree;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class TestBinaryTree {

	@Test
	public void testCreate() {
		BinaryTreeNode<String> lc = new BinaryTreeNode<>("N11");
		BinaryTreeNode<String> rc = new BinaryTreeNode<>("N12");
		BinaryTreeNode<String> rootNode = new BinaryTreeNode<>("N0", lc, rc);
		BinaryTree<String> bt = new BinaryTree<>(rootNode);
		Assert.assertEquals("N0 (N11 (,), N12 (,))", bt.toString());
	}

	@Test
	public void testSize() {
		BinaryTreeNode<String> n21 = new BinaryTreeNode<>("N21");
		BinaryTreeNode<String> n22 = new BinaryTreeNode<>("N22");
		BinaryTreeNode<String> n11 = new BinaryTreeNode<>("N11", n21, n22);

		BinaryTreeNode<String> n23 = new BinaryTreeNode<>("N23");
		BinaryTreeNode<String> n24 = new BinaryTreeNode<>("N24");
		BinaryTreeNode<String> n12 = new BinaryTreeNode<>("N12", n23, n24);

		BinaryTreeNode<String> rootNode = new BinaryTreeNode<>("N0", n11, n12);
		BinaryTree<String> bt = new BinaryTree<>(rootNode);
		int size = bt.size();
		Assert.assertEquals(7, size);
	}

	@Test
	public void testHeight() {
		BinaryTreeNode<String> n21 = new BinaryTreeNode<>("N21");
		BinaryTreeNode<String> n22 = new BinaryTreeNode<>("N22");
		BinaryTreeNode<String> n11 = new BinaryTreeNode<>("N11", n21, n22);

		BinaryTreeNode<String> n23 = new BinaryTreeNode<>("N23");
		BinaryTreeNode<String> n24 = new BinaryTreeNode<>("N24");
		BinaryTreeNode<String> n12 = new BinaryTreeNode<>("N12", n23, n24);

		BinaryTreeNode<String> rootNode = new BinaryTreeNode<>("N0", n11, n12);
		BinaryTree<String> bt = new BinaryTree<>(rootNode);
		int height = bt.height();
		Assert.assertEquals(2, height);
	}

	@Test
	public void testPostOrderTraversal() {
		BinaryTreeNode<String> n21 = new BinaryTreeNode<>("N21");
		BinaryTreeNode<String> n22 = new BinaryTreeNode<>("N22");
		BinaryTreeNode<String> n11 = new BinaryTreeNode<>("N11", n21, n22);

		BinaryTreeNode<String> n23 = new BinaryTreeNode<>("N23");
		BinaryTreeNode<String> n24 = new BinaryTreeNode<>("N24");
		BinaryTreeNode<String> n12 = new BinaryTreeNode<>("N12", n23, n24);

		BinaryTreeNode<String> rootNode = new BinaryTreeNode<>("N0", n11, n12);
		BinaryTree<String> bt = new BinaryTree<>(rootNode);
		List<BinaryTreeNode<String>> nodes = bt.postOrderTraverse();
		Assert.assertEquals("[N21, N22, N11, N23, N24, N12, N0]", nodes.toString());
	}

	@Test
	public void testInOrderTraversal() {
		BinaryTreeNode<String> n21 = new BinaryTreeNode<>("N21");
		BinaryTreeNode<String> n22 = new BinaryTreeNode<>("N22");
		BinaryTreeNode<String> n11 = new BinaryTreeNode<>("N11", n21, n22);

		BinaryTreeNode<String> n23 = new BinaryTreeNode<>("N23");
		BinaryTreeNode<String> n24 = new BinaryTreeNode<>("N24");
		BinaryTreeNode<String> n12 = new BinaryTreeNode<>("N12", n23, n24);

		BinaryTreeNode<String> rootNode = new BinaryTreeNode<>("N0", n11, n12);
		BinaryTree<String> bt = new BinaryTree<>(rootNode);
		List<BinaryTreeNode<String>> nodes = bt.inOrderTraverse();
		Assert.assertEquals("[N21, N11, N22, N0, N23, N12, N24]", nodes.toString());
	}

	@Test
	public void testBreadthFirstTraversal() {
		BinaryTreeNode<String> n21 = new BinaryTreeNode<>("N21");
		BinaryTreeNode<String> n22 = new BinaryTreeNode<>("N22");
		BinaryTreeNode<String> n11 = new BinaryTreeNode<>("N11", n21, n22);

		BinaryTreeNode<String> n23 = new BinaryTreeNode<>("N23");
		BinaryTreeNode<String> n24 = new BinaryTreeNode<>("N24");
		BinaryTreeNode<String> n12 = new BinaryTreeNode<>("N12", n23, n24);

		BinaryTreeNode<String> rootNode = new BinaryTreeNode<>("N0", n11, n12);
		BinaryTree<String> bt = new BinaryTree<>(rootNode);
		List<BinaryTreeNode<String>> nodes = bt.breadthFirstTraverse();
		Assert.assertEquals("[N0, N11, N12, N21, N22, N23, N24]", nodes.toString());
	}

}
