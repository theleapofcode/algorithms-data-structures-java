package com.theleapofcode.algosandds.tree;

import java.util.LinkedList;
import java.util.List;

public class SortedBinaryTree<T extends Comparable<T>> {

	private BinaryTreeNodeWithParent<T> rootNode;

	public SortedBinaryTree(BinaryTreeNodeWithParent<T> rootNode) {
		this.rootNode = rootNode;
	}

	public BinaryTreeNodeWithParent<T> getRootNode() {
		return rootNode;
	}

	public void setRootNode(BinaryTreeNodeWithParent<T> rootNode) {
		this.rootNode = rootNode;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		return treeStringBuilder(sb, this.rootNode).toString();
	}

	private StringBuilder treeStringBuilder(StringBuilder sb, BinaryTreeNodeWithParent<T> node) {
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

	// O(Log N)
	public void add(T value) {
		BinaryTreeNodeWithParent<T> current = this.rootNode;
		if (current == null) {
			this.rootNode = new BinaryTreeNodeWithParent<>(value);
			return;
		}

		while (true) {
			if (current.getValue().compareTo(value) > 0) {
				if (current.getLeftChild() != null) {
					current = current.getLeftChild();
				} else {
					current.setLeftChild(new BinaryTreeNodeWithParent<>(value));
					return;
				}
			} else if (current.getValue().compareTo(value) < 0) {
				if (current.getRightChild() != null) {
					current = current.getRightChild();
				} else {
					current.setRightChild(new BinaryTreeNodeWithParent<>(value));
					return;
				}
			} else {
				return;
			}
		}

	}

	// O(Log N)
	public String find(T value) {
		BinaryTreeNodeWithParent<T> current = this.rootNode;

		while (current != null) {
			if (current.getValue().compareTo(value) > 0) {
				current = current.getLeftChild();
			} else if (current.getValue().compareTo(value) < 0) {
				current = current.getRightChild();
			} else {
				return current.getLabel();
			}
		}

		return null;
	}

	public List<BinaryTreeNodeWithParent<T>> traverse() {
		List<BinaryTreeNodeWithParent<T>> result = new LinkedList<>();
		doTraverse(this.rootNode, result);
		return result;
	}

	private void doTraverse(BinaryTreeNodeWithParent<T> node, List<BinaryTreeNodeWithParent<T>> result) {
		if (node.getLeftChild() != null) {
			doTraverse(node.getLeftChild(), result);
		}

		result.add(node);

		if (node.getRightChild() != null) {
			doTraverse(node.getRightChild(), result);
		}
	}

	// O(Log N)
	public boolean delete(T value) {
		BinaryTreeNodeWithParent<T> current = this.rootNode;

		while (current != null) {
			if (current.getValue().compareTo(value) > 0) {
				current = current.getLeftChild();
			} else if (current.getValue().compareTo(value) < 0) {
				current = current.getRightChild();
			} else {
				// This is the node.
				// See if this is a leaf node.
				if ((current.getLeftChild() == null) && (current.getRightChild() == null)) {
					// This is a leaf node. Simply remove it.
					if (current.getParent().getLeftChild() == current)
						current.getParent().setLeftChild(null);
					else
						current.getParent().setRightChild(null);
					current = null;
					return true;
				}

				// See if we have one child.
				if (current.getLeftChild() == null) {
					// Replace this node with its right child.
					if (current.getParent().getLeftChild() == current)
						current.getParent().setLeftChild(current.getRightChild());
					else
						current.getParent().setRightChild(current.getRightChild());
					current = null;
					return true;
				}
				if (current.getRightChild() == null) {
					// Replace this node with its left child.
					if (current.getParent().getLeftChild() == current)
						current.getParent().setLeftChild(current.getLeftChild());
					else
						current.getParent().setRightChild(current.getLeftChild());
					current = null;
					return true;
				}

				// We have two children. See if the left child has no right
				// child.
				if (current.getLeftChild().getRightChild() == null) {
					// Replace this node with the left child.
					current.getLeftChild().setRightChild(current.getRightChild());
					if (current.getParent().getLeftChild() == current)
						current.getParent().setLeftChild(current.getLeftChild());
					else
						current.getParent().setRightChild(current.getLeftChild());
					current = null;
					return true;
				}

				// We have the hard case.
				// Find the parent of the righmost node in the left subtree.
				BinaryTreeNodeWithParent<T> rightmostParent = findRightmostParent(current.getLeftChild());
				BinaryTreeNodeWithParent<T> rightmost = rightmostParent.getRightChild();
				BinaryTreeNodeWithParent<T> rightmostsLeftChild = rightmost.getLeftChild();

				// Move the rightmost node into this position.
				rightmost.setLeftChild(current.getLeftChild());
				rightmost.setRightChild(current.getRightChild());
				if (current.getParent().getLeftChild() == current)
					current.getParent().setLeftChild(rightmost);
				else
					current.getParent().setRightChild(rightmost);
				current = null;

				// Move the rightmost node's left child into the rightmost
				// node's former position.
				rightmostParent.setRightChild(rightmostsLeftChild);
				return true;
			}
		}

		return false;
	}

	// Find the parent of the rightmost node below this one.
	private BinaryTreeNodeWithParent<T> findRightmostParent(BinaryTreeNodeWithParent<T> node) {
		// See if this node's right child has no right child.
		if (node.getRightChild().getRightChild() == null)
			return node;

		// Search deeper.
		return findRightmostParent(node.getRightChild());
	}

}
