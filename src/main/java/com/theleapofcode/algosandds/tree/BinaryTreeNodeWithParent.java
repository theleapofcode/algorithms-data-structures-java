package com.theleapofcode.algosandds.tree;

public class BinaryTreeNodeWithParent<T> {

	private String label;

	private T value;

	private BinaryTreeNodeWithParent<T> leftChild;

	private BinaryTreeNodeWithParent<T> rightChild;

	private BinaryTreeNodeWithParent<T> parent;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public BinaryTreeNodeWithParent<T> getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(BinaryTreeNodeWithParent<T> leftChild) {
		this.leftChild = leftChild;
		if (leftChild != null) {
			leftChild.setParent(this);
		}
	}

	public BinaryTreeNodeWithParent<T> getRightChild() {
		return rightChild;
	}

	public void setRightChild(BinaryTreeNodeWithParent<T> rightChild) {
		this.rightChild = rightChild;
		if (rightChild != null) {
			rightChild.setParent(this);
		}
	}

	public BinaryTreeNodeWithParent<T> getParent() {
		return parent;
	}

	public void setParent(BinaryTreeNodeWithParent<T> parent) {
		this.parent = parent;
	}

	public BinaryTreeNodeWithParent(String label, T value, BinaryTreeNodeWithParent<T> leftChild,
			BinaryTreeNodeWithParent<T> rightChild) {
		super();
		this.label = label;
		this.value = value;
		this.leftChild = leftChild;
		if (leftChild != null) {
			leftChild.setParent(this);
		}
		this.rightChild = rightChild;
		if (rightChild != null) {
			rightChild.setParent(this);
		}
	}

	public BinaryTreeNodeWithParent(T value, BinaryTreeNodeWithParent<T> leftChild,
			BinaryTreeNodeWithParent<T> rightChild) {
		super();
		this.label = value.toString();
		this.value = value;
		this.leftChild = leftChild;
		if (leftChild != null) {
			leftChild.setParent(this);
		}
		this.rightChild = rightChild;
		if (rightChild != null) {
			rightChild.setParent(this);
		}
	}

	public BinaryTreeNodeWithParent(T value) {
		super();
		this.label = value.toString();
		this.value = value;
	}

	@Override
	public String toString() {
		return label;
	}

}
