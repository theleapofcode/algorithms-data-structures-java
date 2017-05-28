package com.theleapofcode.algosandds.backtracking;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class EightQueensV3 extends JComponent {

	private static final long serialVersionUID = 1L;

	private static final Dimension DEFAULT_SIZE = new Dimension(360, 360);

	// The board dimensions.
	private int numRows = 8;
	private int numCols = 8;
	private int numQueens = 8;

	// The board.
	private boolean[][] spotTaken;

	private int[][] numAttacks;

	@Override
	public void paintComponent(Graphics g) {
		clearBoard(g);
		drawBoard(g);

		this.spotTaken = new boolean[numRows][numCols];
		this.numAttacks = new int[numRows][numCols];

		if (solve(this.spotTaken, this.numAttacks, 0)) {
			drawQueens(g);
		}
	}

	private void drawQueen(Graphics g, int row, int col) {

		// starting point in screen X, Y coordinates
		int startX = col * 40 + 2;
		int startY = row * 40 + 2;

		// build a polygon in the shape of an 18 pixel by 18 pixel crown
		Polygon crown = new Polygon();
		crown.addPoint(startX, startY);
		crown.addPoint(startX + 16, startY + 16);
		crown.addPoint(startX + 36, startY);
		crown.addPoint(startX + 36, startY + 36);
		crown.addPoint(startX, startY + 36);
		// polygons are automatically closed, so don't need to
		// add starting point again

		// and draw it
		g.drawPolygon(crown);
		g.fillPolygon(crown);
	}

	void drawQueens(Graphics g) {
		for (int row = 0; row < numRows; row++) {
			for (int col = 0; col < numCols; col++) {
				if (spotTaken[row][col]) {
					drawQueen(g, row, col);
				}
			}
		}
	}

	private void drawBoard(Graphics g) {
		// draw column lines
		for (int col = 0; col <= 8; col++) {
			g.drawLine(0, 40 * col, 320, 40 * col);
		}

		// draw row lines
		for (int row = 0; row <= 8; row++) {
			g.drawLine(40 * row, 0, 40 * row, 320);
		}
	}

	public void clearBoard(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, 320, 320);
		g.setColor(Color.black);
	}

	private boolean solve(boolean[][] spotTaken, int[][] numAttacks, int numQueensPositioned) {
		// See if we have positioned all of the queens.
		if (numQueensPositioned == numQueens)
			return true;

		// Try all positions for the next queen.
		int row = numQueensPositioned;
		for (int col = 0; col < numCols; col++) {
			// See if we can put a queen here.
			if (!spotTaken[row][col] && (numAttacks[row][col] == 0)) {
				// Put a queen here.
				spotTaken[row][col] = true;

				// Mark the spots this queen can attack.
				markAttackedSpots(numAttacks, row, col, +1);

				// Recursively try other assignments.
				if (solve(spotTaken, numAttacks, numQueensPositioned + 1))
					return true;

				// Unmark the spots this queen can attack.
				markAttackedSpots(numAttacks, row, col, -1);
				spotTaken[row][col] = false;
			}
		}

		// If we get here, we could not find a valid solution.
		return false;
	}

	// Add "amount" to the number of attacks on the
	// squares that this queen can attack.
	private void markAttackedSpots(int[][] numAttacks, int row, int col, int amount) {
		// Mark the row and column.
		for (int c = 0; c < numCols; c++)
			numAttacks[row][c] += amount;
		for (int r = 0; r < numRows; r++)
			numAttacks[r][col] += amount;

		// Mark the upper left/lower right diagonal.
		int minDx1 = -Math.min(row, col);
		int maxDx1 = Math.min(numRows - row - 1, numCols - col - 1);
		for (int dx = minDx1; dx <= maxDx1; dx++)
			numAttacks[row + dx][col + dx] += amount;

		// Mark the upper right/lower left diagonal.
		int minDx2 = -Math.min(row, numCols - col - 1);
		int maxDx2 = Math.min(numRows - row - 1, col);
		for (int dx = minDx2; dx <= maxDx2; dx++)
			numAttacks[row + dx][col - dx] += amount;
	}

	public static void main(String[] args) {
		EightQueens eq = new EightQueens();

		JFrame frame = new JFrame();
		frame.getContentPane().add(eq);
		frame.setTitle("EightQueens Demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setMinimumSize(DEFAULT_SIZE);
		frame.pack();
		frame.setVisible(true);
	}
}
