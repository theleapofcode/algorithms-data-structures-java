package com.theleapofcode.algosandds.network;

import java.util.LinkedList;
import java.util.List;

public class NetworkNode {

	private String label;

	private String value;

	private boolean visited;

	private List<NetworkLink> links;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public List<NetworkLink> getLinks() {
		return links;
	}

	public void setLinks(List<NetworkLink> links) {
		this.links = links;
	}

	public NetworkNode() {
	}

	public NetworkNode(String label, String value, boolean visited, List<NetworkLink> links) {
		super();
		this.label = label;
		this.value = value;
		this.visited = visited;
		this.links = links;
	}

	public NetworkNode(String value, boolean visited, List<NetworkLink> links) {
		super();
		this.label = value.toString();
		this.value = value;
		this.visited = visited;
		this.links = links;
	}

	public NetworkNode(String value, List<NetworkLink> links) {
		super();
		this.label = value.toString();
		this.value = value;
		this.links = links;
	}

	public NetworkNode(String value) {
		super();
		this.label = value.toString();
		this.value = value;
	}

	@Override
	public String toString() {
		return this.label;
	}

	public void addLink(NetworkNode node, int cost) {
		NetworkLink addedLink = new NetworkLink(cost, new NetworkNode[] { this, node });
		if (this.links == null) {
			this.links = new LinkedList<>();
		}
		this.links.add(addedLink);
		if (node.getLinks() == null) {
			node.setLinks(new LinkedList<>());
		}
		node.getLinks().add(addedLink);
	}

	public boolean isNeighbour(NetworkNode node) {
		if (this.links == null) {
			return false;
		}

		for (NetworkLink link : this.links) {
			if (link.getNeighbour(this) == node) {
				return true;
			}
		}

		return false;
	}

}
