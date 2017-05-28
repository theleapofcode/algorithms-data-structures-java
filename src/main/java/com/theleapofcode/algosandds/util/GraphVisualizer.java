package com.theleapofcode.algosandds.util;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.jgraph.JGraph;
import org.jgraph.graph.AttributeMap;
import org.jgraph.graph.DefaultGraphCell;
import org.jgraph.graph.GraphConstants;
import org.jgrapht.DirectedGraph;
import org.jgrapht.ListenableGraph;
import org.jgrapht.ext.JGraphModelAdapter;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultListenableGraph;
import org.jgrapht.graph.DirectedMultigraph;

import com.theleapofcode.algosandds.tree.BinaryTree;
import com.theleapofcode.algosandds.tree.BinaryTreeNode;

public class GraphVisualizer {
	private static final Color DEFAULT_BG_COLOR = Color.WHITE;
	private static final Dimension DEFAULT_SIZE = new Dimension(720, 640);

	public static void main(String[] args) {
		BinaryTreeNode<String> lc = new BinaryTreeNode<>("N11");
		BinaryTreeNode<String> rc = new BinaryTreeNode<>("N12");
		BinaryTreeNode<String> rootNode = new BinaryTreeNode<>("N0", lc, rc);
		BinaryTree<String> bt = new BinaryTree<>(rootNode);
		visualizeBinaryTree(bt);
	}

	public static <T extends Comparable<T>> void visualizeBinaryTree(BinaryTree<T> bt) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				// create a JGraphT graph
				ListenableGraph<String, DefaultEdge> g = new ListenableDirectedMultigraph<>(DefaultEdge.class);

				// create a visualization using JGraph, via an adapter
				JGraphModelAdapter<String, DefaultEdge> jGraphAdapter = new JGraphModelAdapter<>(g);

				JGraph jgraph = new JGraph(jGraphAdapter);

				// Display settings
				//jgraph.setMinimumSize(DEFAULT_SIZE);
				jgraph.setBackground(DEFAULT_BG_COLOR);
				jgraph.setPreferredSize(DEFAULT_SIZE);
				jgraph.setLayout(new BorderLayout());

				int height = bt.height();
				double deltaY = DEFAULT_SIZE.getHeight() / (height + 2);
				int leafWidth = new Double(Math.pow(2, height)).intValue() + 1;
				double deltaX = DEFAULT_SIZE.getWidth() / leafWidth;
				int level = 0;

				traverseAndDrawTree(g, jGraphAdapter, bt.getRootNode(), deltaX, deltaY, deltaX, deltaY, deltaX, deltaY,
						level);

				JFrame frame = new JFrame("Visualizer");
				frame.getContentPane().add(jgraph, BorderLayout.CENTER);
				frame.setSize(DEFAULT_SIZE);
				//frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.pack();
				frame.setLayout(new BorderLayout());
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}

	private static <T extends Comparable<T>> void traverseAndDrawTree(ListenableGraph<String, DefaultEdge> g,
			JGraphModelAdapter<String, DefaultEdge> jGraphAdapter, BinaryTreeNode<T> node, double x, double y,
			double initX, double initY, double deltaX, double deltaY, int level) {
		if (node == null)
			return;

		// Draw Node
		g.addVertex(node.getLabel());
		positionVertex(jGraphAdapter, node.getLabel(), x, y);

		// Draw LeftChild
		if (node.getLeftChild() != null) {
			double leftChildX = initX - ((level + 1) * deltaX);
			double leftChildY = initY + ((level + 1) * deltaY);
			traverseAndDrawTree(g, jGraphAdapter, node.getLeftChild(), leftChildX, leftChildY, initX, initY, deltaX,
					deltaY, level + 1);
			g.addEdge(node.getLabel(), node.getLeftChild().getLabel());
		}

		// Draw RightChild
		if (node.getRightChild() != null) {
			double rightChildX = initX + ((level + 1) * deltaX);
			double rightChildY = initY + ((level + 1) * deltaY);
			traverseAndDrawTree(g, jGraphAdapter, node.getRightChild(), rightChildX, rightChildY, initX, initY, deltaX,
					deltaY, level + 1);
			g.addEdge(node.getLabel(), node.getRightChild().getLabel());
		}
	}

	@SuppressWarnings("unchecked")
	private static void positionVertex(JGraphModelAdapter<String, DefaultEdge> jGraphAdapter, Object vertex, double x,
			double y) {
		DefaultGraphCell cell = jGraphAdapter.getVertexCell(vertex);
		AttributeMap attr = cell.getAttributes();
		Rectangle2D bounds = GraphConstants.getBounds(attr);

		Rectangle2D newBounds = new Rectangle2D.Double(x, y, bounds.getWidth(), bounds.getHeight());

		GraphConstants.setBounds(attr, newBounds);

		AttributeMap cellAttr = new AttributeMap();
		cellAttr.put(cell, attr);
		jGraphAdapter.edit(cellAttr, null, null, null);
	}

	/**
	 * a listenable directed multigraph that allows loops and parallel edges.
	 */
	private static class ListenableDirectedMultigraph<V, E> extends DefaultListenableGraph<V, E>
			implements DirectedGraph<V, E> {
		private static final long serialVersionUID = 1L;

		ListenableDirectedMultigraph(Class<E> edgeClass) {
			super(new DirectedMultigraph<>(edgeClass));
		}
	}
}
