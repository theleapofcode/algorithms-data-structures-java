package com.theleapofcode.algosandds.network;

import java.util.LinkedList;
import java.util.List;

public class DirectedNetworkNode {

	private String label;

	private String value;

	private boolean visited;

	private List<DirectedNetworkLink> fromLinks;

	private List<DirectedNetworkLink> toLinks;

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

	public List<DirectedNetworkLink> getFromLinks() {
		return fromLinks;
	}

	public void setFromLinks(List<DirectedNetworkLink> fromLinks) {
		this.fromLinks = fromLinks;
	}

	public List<DirectedNetworkLink> getToLinks() {
		return toLinks;
	}

	public void setToLinks(List<DirectedNetworkLink> toLinks) {
		this.toLinks = toLinks;
	}

	public DirectedNetworkNode() {
	}

	public DirectedNetworkNode(String label, String value, boolean visited, List<DirectedNetworkLink> fromLinks,
			List<DirectedNetworkLink> toLinks) {
		super();
		this.label = label;
		this.value = value;
		this.visited = visited;
		this.fromLinks = fromLinks;
		this.toLinks = toLinks;
	}

	public DirectedNetworkNode(String value, boolean visited, List<DirectedNetworkLink> fromLinks,
			List<DirectedNetworkLink> toLinks) {
		super();
		this.label = value.toString();
		this.value = value;
		this.visited = visited;
		this.fromLinks = fromLinks;
		this.toLinks = toLinks;
	}

	public DirectedNetworkNode(String value, List<DirectedNetworkLink> fromLinks, List<DirectedNetworkLink> toLinks) {
		super();
		this.label = value.toString();
		this.value = value;
		this.fromLinks = fromLinks;
		this.toLinks = toLinks;
	}

	public DirectedNetworkNode(String value) {
		super();
		this.label = value.toString();
		this.value = value;
	}

	@Override
	public String toString() {
		return this.label;
	}

	public void addLinkTo(DirectedNetworkNode toNode, int cost) {
		DirectedNetworkLink addedLink = new DirectedNetworkLink(cost, this, toNode);
		if (this.toLinks == null) {
			this.toLinks = new LinkedList<>();
		}
		this.toLinks.add(addedLink);
		if (toNode.getFromLinks() == null) {
			toNode.setFromLinks(new LinkedList<>());
		}
		toNode.getFromLinks().add(addedLink);
	}

}
