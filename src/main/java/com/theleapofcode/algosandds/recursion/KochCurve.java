package com.theleapofcode.algosandds.recursion;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class KochCurve extends JComponent {
	private static final long serialVersionUID = 1L;

	private static final Dimension DEFAULT_SIZE = new Dimension(640, 480);

	private int level = 0;

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public void paintComponent(Graphics g) {
		Point pointOne = new Point(120, 320);
		Point pointTwo = new Point(440, 320);
		Point pointThree = new Point(280, 40);

		drawSnowflake(g, this.level, pointOne, pointTwo, pointThree);
	}

	private void drawSnowflake(Graphics g, int lev, Point p1, Point p2, Point p3) {
		// draw 3 lines to make a triangle
		drawSegment(g, lev, p1, p2);
		drawSegment(g, lev, p2, p3);
		drawSegment(g, lev, p3, p1);
	}

	// O(4^N)
	private void drawSegment(Graphics g, int lev, Point pOne, Point pTwo) {
		if (lev == 0) {
			g.drawLine(pOne.x, pOne.y, pTwo.x, pTwo.y);
		}
		if (lev >= 1) {
			Point distance = new Point((pTwo.x - pOne.x) / 3, (pTwo.y - pOne.y) / 3);
			Point pA = new Point(pOne.x + distance.x, pOne.y + distance.y);
			Point pB = new Point(pTwo.x - distance.x, pTwo.y - distance.y);
			double sin60 = Math.sin(Math.PI / 3) * -1;
			Point pTip = new Point(pA.x + (int) (distance.x * 0.5 + distance.y * sin60),
					pA.y + (int) (distance.y * 0.5 - distance.x * sin60));

			drawSegment(g, lev - 1, pOne, pA); // if level 1 or higher,
			drawSegment(g, lev - 1, pA, pTip); // recursively call self 4 times
			drawSegment(g, lev - 1, pTip, pB);
			drawSegment(g, lev - 1, pB, pTwo);
		}
	}

	public static void main(String[] args) {
		KochCurve kc = new KochCurve();

		String levelStr = JOptionPane.showInputDialog("Enter the recursion depth: ");
		kc.setLevel(Integer.parseInt(levelStr));

		JFrame frame = new JFrame();
		frame.getContentPane().add(kc);
		frame.setTitle("KochCurve Demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setMinimumSize(DEFAULT_SIZE);
		frame.pack();
		frame.setVisible(true);
	}
}
