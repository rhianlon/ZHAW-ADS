package ch.zhaw.rhiana.ads.Praktikum07;

import java.util.LinkedList;
import java.util.List;

public class Node<N extends Node> {
    protected String name; // Name
    protected List<Edge<N>> edges; // Kanten

    public Node() {
        edges = new LinkedList<>();
    }

    public Node(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Iterable<Edge<N>> getEdges() {
        return edges;
    }

	public void addEdge(Edge<N> edge) {
        edges.add(edge);
    }

	@Override
	public String toString() {
		return getName();
	}
}
