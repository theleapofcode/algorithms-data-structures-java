package com.theleapofcode.algosandds.network;

public class DirectedNetworkLink {

	private int cost;

	private DirectedNetworkNode fromNode;

	private DirectedNetworkNode toNode;

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public DirectedNetworkNode getFromNode() {
		return fromNode;
	}

	public void setFromNode(DirectedNetworkNode fromNode) {
		this.fromNode = fromNode;
	}

	public DirectedNetworkNode getToNode() {
		return toNode;
	}

	public void setToNode(DirectedNetworkNode toNode) {
		this.toNode = toNode;
	}

	public DirectedNetworkLink(int cost, DirectedNetworkNode fromNode, DirectedNetworkNode toNode) {
		super();
		this.cost = cost;
		this.fromNode = fromNode;
		this.toNode = toNode;
	}

}
