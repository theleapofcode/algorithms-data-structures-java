package com.theleapofcode.algosandds.array;

public class TriangularArray<T extends Comparable<T>> {

	private int numRows;

	private T[] storageArray;

	@SuppressWarnings("unchecked")
	public TriangularArray(int numRows) {
		this.numRows = numRows;
		this.storageArray = (T[]) new Object[(this.numRows * this.numRows - 1) / 2];
	}

	private int mapRowAndColumnToIndex(int row, int column) {
		if (row < column) {
			int temp = row;
			row = column;
			column = temp;
		}

		return row * (row - 1) / 2 + column;
	}

	public void setValue(int row, int column, T value) {
		this.storageArray[mapRowAndColumnToIndex(row, column)] = value;
	}

	public T getValue(int row, int column) {
		return this.storageArray[mapRowAndColumnToIndex(row, column)];
	}

}
