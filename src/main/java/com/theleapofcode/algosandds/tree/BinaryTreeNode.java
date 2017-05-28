package com.theleapofcode.algosandds.tree;

public class BinaryTreeNode<T> {

	private String label;

	private T value;

	private BinaryTreeNode<T> leftChild;

	private BinaryTreeNode<T> rightChild;

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

	public BinaryTreeNode<T> getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(BinaryTreeNode<T> leftChild) {
		this.leftChild = leftChild;
	}

	public BinaryTreeNode<T> getRightChild() {
		return rightChild;
	}

	public void setRightChild(BinaryTreeNode<T> rightChild) {
		this.rightChild = rightChild;
	}

	public BinaryTreeNode(String label, T value, BinaryTreeNode<T> leftChild, BinaryTreeNode<T> rightChild) {
		super();
		this.label = label;
		this.value = value;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}

	public BinaryTreeNode(T value, BinaryTreeNode<T> leftChild, BinaryTreeNode<T> rightChild) {
		super();
		this.label = value.toString();
		this.value = value;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}

	public BinaryTreeNode(T value) {
		super();
		this.label = value.toString();
		this.value = value;
	}

	@Override
	public String toString() {
		return label;
	}

}
