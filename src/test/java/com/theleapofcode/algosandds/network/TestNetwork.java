package com.theleapofcode.algosandds.network;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;

public class TestNetwork {

	@Test
	public void testCreate() {
		NetworkNode nodeA = new NetworkNode("A");
		NetworkNode nodeB = new NetworkNode("B");
		NetworkNode nodeC = new NetworkNode("C");
		NetworkNode nodeD = new NetworkNode("D");

		nodeA.addLink(nodeB, 10);
		nodeA.addLink(nodeC, 20);
		nodeB.addLink(nodeC, 30);
		nodeB.addLink(nodeD, 30);
		nodeC.addLink(nodeD, 20);

		List<NetworkNode> nodes = new LinkedList<>();
		nodes.add(nodeA);
		nodes.add(nodeB);
		nodes.add(nodeC);
		nodes.add(nodeD);

		Network network = new Network(nodes);

		System.out.println(network);

		System.out.println(network.getNetworkNodeByLabel("C"));
	}

	@Test
	public void testFromString() {
		NetworkNode nodeA = new NetworkNode("A");
		NetworkNode nodeB = new NetworkNode("B");
		NetworkNode nodeC = new NetworkNode("C");
		NetworkNode nodeD = new NetworkNode("D");

		nodeA.addLink(nodeB, 10);
		nodeA.addLink(nodeC, 20);
		nodeB.addLink(nodeC, 30);
		nodeB.addLink(nodeD, 30);
		nodeC.addLink(nodeD, 20);

		List<NetworkNode> nodes = new LinkedList<>();
		nodes.add(nodeA);
		nodes.add(nodeB);
		nodes.add(nodeC);
		nodes.add(nodeD);

		Network network = new Network(nodes);

		String networkStr = network.toString();
		System.out.println(networkStr);

		Network network2 = Network.fromString(networkStr);
		System.out.println(network2);

		Assert.assertEquals(network.toString(), network2.toString());
	}

	@Test
	public void testDepthFirstTraversal() {
		NetworkNode nodeA = new NetworkNode("A");
		NetworkNode nodeB = new NetworkNode("B");
		NetworkNode nodeC = new NetworkNode("C");
		NetworkNode nodeD = new NetworkNode("D");

		nodeA.addLink(nodeB, 10);
		nodeA.addLink(nodeC, 20);
		nodeB.addLink(nodeC, 30);
		nodeB.addLink(nodeD, 30);
		nodeC.addLink(nodeD, 20);

		List<NetworkNode> nodes = new LinkedList<>();
		nodes.add(nodeA);
		nodes.add(nodeB);
		nodes.add(nodeC);
		nodes.add(nodeD);

		Network network = new Network(nodes);

		List<NetworkNode> traversedNodes = network.depthFirstTraversal();
		System.out.println(traversedNodes);
	}

	@Test
	public void testDepthFirstTraversalWithStartNode() {
		NetworkNode nodeA = new NetworkNode("A");
		NetworkNode nodeB = new NetworkNode("B");
		NetworkNode nodeC = new NetworkNode("C");
		NetworkNode nodeD = new NetworkNode("D");

		nodeA.addLink(nodeB, 10);
		nodeA.addLink(nodeC, 20);
		nodeB.addLink(nodeC, 30);
		nodeB.addLink(nodeD, 30);
		nodeC.addLink(nodeD, 20);

		List<NetworkNode> nodes = new LinkedList<>();
		nodes.add(nodeA);
		nodes.add(nodeB);
		nodes.add(nodeC);
		nodes.add(nodeD);

		Network network = new Network(nodes);
		List<NetworkNode> traversedNodes = new LinkedList<>();
		network.depthFirstTraversal(nodeA, traversedNodes);
		System.out.println(traversedNodes);
	}

	@Test
	public void testBreadthFirstTraversalWithStartNode() {
		StringBuilder sb = new StringBuilder();
		sb.append("A").append(",").append("B").append(",").append(1).append(",").append("D").append(",").append(2)
				.append(",").append("E").append(",").append(3).append(System.lineSeparator());
		sb.append("B").append(",").append("A").append(",").append(1).append(",").append("C").append(",").append(2)
				.append(",").append("E").append(",").append(3).append(System.lineSeparator());
		sb.append("C").append(",").append("B").append(",").append(2).append(",").append("F").append(",").append(1)
				.append(System.lineSeparator());

		sb.append("D").append(",").append("A").append(",").append(2).append(",").append("E").append(",").append(1)
				.append(",").append("G").append(",").append(3).append(System.lineSeparator());
		sb.append("E").append(",").append("A").append(",").append(3).append(",").append("B").append(",").append(3)
				.append(",").append("D").append(",").append(1).append(",").append("F").append(",").append(2).append(",")
				.append("H").append(",").append(1).append(System.lineSeparator());
		sb.append("F").append(",").append("C").append(",").append(1).append(",").append("E").append(",").append(2)
				.append(",").append("I").append(",").append(3).append(System.lineSeparator());

		sb.append("G").append(",").append("D").append(",").append(3).append(",").append("H").append(",").append(2)
				.append(System.lineSeparator());
		sb.append("H").append(",").append("E").append(",").append(1).append(",").append("G").append(",").append(2)
				.append(",").append("I").append(",").append(3).append(System.lineSeparator());
		sb.append("I").append(",").append("F").append(",").append(3).append(",").append("H").append(",").append(3)
				.append(System.lineSeparator());

		String networkStr = sb.toString();
		Network network = Network.fromString(networkStr);
		NetworkNode nodeA = network.getNetworkNodeByLabel("A");
		List<NetworkNode> traversedNodes = new LinkedList<>();
		network.breadthFirstTraversal(nodeA, traversedNodes);
		System.out.println(traversedNodes);
	}
	
	@Test
	public void testMinimalSpanningTree() {
		StringBuilder sb = new StringBuilder();
		sb.append("A").append(",").append("B").append(",").append(1).append(",").append("D").append(",").append(2)
				.append(",").append("E").append(",").append(3).append(System.lineSeparator());
		sb.append("B").append(",").append("A").append(",").append(1).append(",").append("C").append(",").append(2)
				.append(",").append("E").append(",").append(3).append(System.lineSeparator());
		sb.append("C").append(",").append("B").append(",").append(2).append(",").append("F").append(",").append(1)
				.append(System.lineSeparator());

		sb.append("D").append(",").append("A").append(",").append(2).append(",").append("E").append(",").append(1)
				.append(",").append("G").append(",").append(3).append(System.lineSeparator());
		sb.append("E").append(",").append("A").append(",").append(3).append(",").append("B").append(",").append(3)
				.append(",").append("D").append(",").append(1).append(",").append("F").append(",").append(2).append(",")
				.append("H").append(",").append(1).append(System.lineSeparator());
		sb.append("F").append(",").append("C").append(",").append(1).append(",").append("E").append(",").append(2)
				.append(",").append("I").append(",").append(3).append(System.lineSeparator());

		sb.append("G").append(",").append("D").append(",").append(3).append(",").append("H").append(",").append(2)
				.append(System.lineSeparator());
		sb.append("H").append(",").append("E").append(",").append(1).append(",").append("G").append(",").append(2)
				.append(",").append("I").append(",").append(3).append(System.lineSeparator());
		sb.append("I").append(",").append("F").append(",").append(3).append(",").append("H").append(",").append(3)
				.append(System.lineSeparator());

		String networkStr = sb.toString();
		Network network = Network.fromString(networkStr);
		NetworkNode nodeA = network.getNetworkNodeByLabel("A");
		List<NetworkNode> traversedNodes = new LinkedList<>();
		int totalCost = network.minimalSpanningTree(nodeA, traversedNodes);
		System.out.println(traversedNodes);
		System.out.println(totalCost);
	}

}
