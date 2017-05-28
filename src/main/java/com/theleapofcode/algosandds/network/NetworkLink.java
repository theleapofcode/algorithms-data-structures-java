package com.theleapofcode.algosandds.network;

public class NetworkLink {

	private int cost;

	private boolean visited;

	private NetworkNode[] nodes = new NetworkNode[2];

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public NetworkNode[] getNodes() {
		return nodes;
	}

	public void setNodes(NetworkNode[] nodes) {
		this.nodes = nodes;
	}

	public NetworkLink(int cost, NetworkNode[] nodes) {
		this.cost = cost;
		this.nodes = nodes;
	}

	public NetworkNode getNeighbour(NetworkNode node) {
		NetworkNode neighbour = null;
		for (int i = 0; i < 2; i++) {
			if (this.nodes[i] == node) {
				neighbour = this.nodes[(i + 1) % 2];
			}
		}

		return neighbour;
	}

}
