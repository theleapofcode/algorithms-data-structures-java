package com.theleapofcode.algosandds.tree;

import java.util.LinkedList;
import java.util.List;

public class BinaryTree<T> {

	private BinaryTreeNode<T> rootNode;

	public BinaryTree(BinaryTreeNode<T> rootNode) {
		this.rootNode = rootNode;
	}

	public BinaryTreeNode<T> getRootNode() {
		return rootNode;
	}

	public void setRootNode(BinaryTreeNode<T> rootNode) {
		this.rootNode = rootNode;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		return treeStringBuilder(sb, this.rootNode).toString();
	}

	private StringBuilder treeStringBuilder(StringBuilder sb, BinaryTreeNode<T> node) {
		if (node != null) {
			sb.append(node.getLabel()).append(" (");
			if (node.getLeftChild() != null) {
				treeStringBuilder(sb, node.getLeftChild());
			}
			sb.append(",");

			if (node.getRightChild() != null) {
				sb.append(" ");
				treeStringBuilder(sb, node.getRightChild());
			}
			sb.append(")");
		}
		return sb;
	}

	public int size() {
		List<BinaryTreeNode<T>> nodes = this.preOrderTraverse();
		return nodes.size();
	}

	public int height() {
		return new Double(Math.log(this.size() + 1) / Math.log(2) - 1).intValue();
	}

	public List<BinaryTreeNode<T>> preOrderTraverse() {
		List<BinaryTreeNode<T>> result = new LinkedList<>();
		doPreOrderTraverse(this.rootNode, result);
		return result;
	}

	private void doPreOrderTraverse(BinaryTreeNode<T> node, List<BinaryTreeNode<T>> result) {
		result.add(node);

		if (node.getLeftChild() != null) {
			doPreOrderTraverse(node.getLeftChild(), result);
		}

		if (node.getRightChild() != null) {
			doPreOrderTraverse(node.getRightChild(), result);
		}
	}

	public List<BinaryTreeNode<T>> postOrderTraverse() {
		List<BinaryTreeNode<T>> result = new LinkedList<>();
		doPostOrderTraverse(this.rootNode, result);
		return result;
	}

	private void doPostOrderTraverse(BinaryTreeNode<T> node, List<BinaryTreeNode<T>> result) {
		if (node.getLeftChild() != null) {
			doPostOrderTraverse(node.getLeftChild(), result);
		}

		if (node.getRightChild() != null) {
			doPostOrderTraverse(node.getRightChild(), result);
		}

		result.add(node);
	}

	public List<BinaryTreeNode<T>> inOrderTraverse() {
		List<BinaryTreeNode<T>> result = new LinkedList<>();
		doInOrderTraverse(this.rootNode, result);
		return result;
	}

	private void doInOrderTraverse(BinaryTreeNode<T> node, List<BinaryTreeNode<T>> result) {
		if (node.getLeftChild() != null) {
			doInOrderTraverse(node.getLeftChild(), result);
		}

		result.add(node);

		if (node.getRightChild() != null) {
			doInOrderTraverse(node.getRightChild(), result);
		}
	}

	public List<BinaryTreeNode<T>> breadthFirstTraverse() {
		List<BinaryTreeNode<T>> result = new LinkedList<>();
		LinkedList<BinaryTreeNode<T>> queue = new LinkedList<>();
		queue.addFirst(this.rootNode);
		doBreadthFirstTraverse(queue, result);
		return result;
	}

	private void doBreadthFirstTraverse(LinkedList<BinaryTreeNode<T>> queue, List<BinaryTreeNode<T>> result) {
		if (queue.isEmpty())
			return;

		BinaryTreeNode<T> node = queue.removeLast();
		result.add(node);
		if (node.getLeftChild() != null) {
			queue.addFirst(node.getLeftChild());
		}

		if (node.getRightChild() != null) {
			queue.addFirst(node.getRightChild());
		}

		doBreadthFirstTraverse(queue, result);
	}

}
