package com.theleapofcode.algosandds.network;

import java.util.LinkedList;
import java.util.List;

public class Network {

	private List<NetworkNode> nodes;

	public List<NetworkNode> getNodes() {
		return nodes;
	}

	public void setNodes(List<NetworkNode> nodes) {
		this.nodes = nodes;
	}

	public Network() {
	}

	public Network(List<NetworkNode> nodes) {
		super();
		this.nodes = nodes;
	}

	public NetworkNode getNetworkNodeByLabel(String label) {
		return this.nodes.stream().filter(node -> node.getLabel().equals(label)).findFirst().get();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (NetworkNode node : nodes) {
			sb.append(node.getLabel());

			// Save information about this node's links.
			for (NetworkLink link : node.getLinks()) {
				NetworkNode neighbour = link.getNeighbour(node);
				sb.append(",").append(neighbour.getLabel()).append(",").append(link.getCost());
			}

			sb.append(System.lineSeparator());
		}

		return sb.toString();
	}

	// FIXME - Add error handling and checks
	public static Network fromString(String networkStr) {
		String[] nodesStr = networkStr.split("[\\r?\\n]+");
		Network network = new Network();
		String[][] nodeComponentsStr = new String[nodesStr.length][];
		for (int i = 0; i < nodesStr.length; i++) {
			nodeComponentsStr[i] = nodesStr[i].split(",");
		}

		for (int i = 0; i < nodeComponentsStr.length; i++) {
			NetworkNode node = new NetworkNode(nodeComponentsStr[i][0]);
			if (network.getNodes() == null) {
				network.setNodes(new LinkedList<>());
			}
			network.getNodes().add(node);
		}

		for (int i = 0; i < nodeComponentsStr.length; i++) {
			NetworkNode node = network.getNetworkNodeByLabel(nodeComponentsStr[i][0]);
			for (int j = 1; j < nodeComponentsStr[i].length; j = j + 2) {
				NetworkNode neighbour = network.getNetworkNodeByLabel(nodeComponentsStr[i][j]);
				if (!node.isNeighbour(neighbour)) {
					node.addLink(neighbour, Integer.parseInt(nodeComponentsStr[i][j + 1]));
				}
			}
		}

		return network;
	}

	public void resetNetwork() {
		for (NetworkNode node : nodes) {
			node.setVisited(false);

			for (NetworkLink link : node.getLinks()) {
				link.setVisited(false);
			}
		}
	}

	public List<NetworkNode> depthFirstTraversal() {
		resetNetwork();
		List<NetworkNode> traversedNodes = new LinkedList<>();
		for (NetworkNode node : this.nodes) {
			if (!node.isVisited()) {
				node.setVisited(true);
				traversedNodes.add(node);

				for (NetworkLink link : node.getLinks()) {
					if (!link.isVisited()) {
						link.setVisited(true);
						NetworkNode neighbour = link.getNeighbour(node);
						if (!neighbour.isVisited()) {
							neighbour.setVisited(true);
							traversedNodes.add(neighbour);
						}
					}
				}
			}
		}

		return traversedNodes;
	}

	public void depthFirstTraversal(NetworkNode node, List<NetworkNode> traversedNodes) {
		if (!node.isVisited()) {
			node.setVisited(true);
			traversedNodes.add(node);

			for (NetworkLink link : node.getLinks()) {
				if (!link.isVisited()) {
					link.setVisited(true);
					NetworkNode neighbour = link.getNeighbour(node);
					depthFirstTraversal(neighbour, traversedNodes);
				}
			}
		}
	}

	public void breadthFirstTraversal(NetworkNode node, List<NetworkNode> traversedNodes) {
		resetNetwork();
		LinkedList<NetworkNode> queue = new LinkedList<>();
		queue.addFirst(node);
		while (!queue.isEmpty()) {
			NetworkNode lastNodeInQueue = queue.removeLast();
			if (!lastNodeInQueue.isVisited()) {
				lastNodeInQueue.setVisited(true);
				traversedNodes.add(lastNodeInQueue);
			}

			for (NetworkLink lastNodeInQueueslink : lastNodeInQueue.getLinks()) {
				if (!lastNodeInQueueslink.isVisited()) {
					lastNodeInQueueslink.setVisited(true);
					NetworkNode neighbour = lastNodeInQueueslink.getNeighbour(lastNodeInQueue);
					if (!neighbour.isVisited()) {
						queue.addFirst(neighbour);
					}
				}
			}
		}
	}

	public int minimalSpanningTree(NetworkNode node, List<NetworkNode> traversedNodes) {
		resetNetwork();

		// The total cost of the links in the spanning tree.
		int totalCost = 0;

		// Add the root node's links to the link candidate list.
		List<NetworkLink> candidateLinks = new LinkedList<>();
		for (NetworkLink link : node.getLinks())
			candidateLinks.add(link);

		// Visit the root node.
		node.setVisited(true);
		traversedNodes.add(node);

		// Process the list until it's empty.
		while (!candidateLinks.isEmpty()) {
			// Find the link with the lowest cost.
			NetworkLink bestLink = candidateLinks.get(0);
			int bestCost = bestLink.getCost();
			for (int i = 1; i < candidateLinks.size(); i++) {
				if (candidateLinks.get(i).getCost() < bestCost) {
					// Save this improvement.
					bestLink = candidateLinks.get(i);
					bestCost = bestLink.getCost();
				}
			}

			// Remove the link from the list.
			candidateLinks.remove(bestLink);

			// Get the node at the other end of the link.
			NetworkNode toNode = bestLink.getNodes()[1];

			// See if the link's node is still unmarked.
			if (!toNode.isVisited()) {
				// Use the link.
				bestLink.setVisited(true);
				totalCost += bestLink.getCost();
				toNode.setVisited(true);
				traversedNodes.add(toNode);

				// Process toNode's links.
				for (NetworkLink newLink : toNode.getLinks()) {
					// If the node hasn't been visited,
					// add the link to the list.
					if (!newLink.getNodes()[1].isVisited())
						candidateLinks.add(newLink);
				}
			}

		}

		return totalCost;
	}

}
