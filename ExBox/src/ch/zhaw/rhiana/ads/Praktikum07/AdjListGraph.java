package ch.zhaw.rhiana.ads.Praktikum07;

import java.util.*;

public class AdjListGraph<N extends Node, E extends Edge> implements Graph<N, E> {
	private final List<N> nodes = new LinkedList<N>();
	private final Class nodeClazz;
	private final Class edgeClazz;

	public AdjListGraph(Class nodeClazz, Class edgeClazz) {
		this.nodeClazz = nodeClazz;
		this.edgeClazz = edgeClazz;
	}

	// füge Knoten hinzu, gebe alten zurück falls Knoten schon existiert
	@SuppressWarnings("unchecked")
	public N addNode(String name) {
		try {
			N node = findNode(name);
			if (node == null) {
				node = (N) nodeClazz.newInstance();
				node.setName(name);
				nodes.add(node);
			}
			return node;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	// füge gerichtete Kante hinzu
	@SuppressWarnings("unchecked")
	public void addEdge(String source, String dest, double weight) {
		N src = addNode(source);
		N dst = addNode(dest);

		try {
			E edge = (E) edgeClazz.newInstance();
			edge.setDest(dst);
			edge.setWeight(weight);
			src.addEdge(edge);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	// finde den Knoten anhand seines Namens
	public N findNode(String name) {
		for (N node : nodes) {
			if (node.getName().equals(name)) {
				return node;
			}
		}
		return null;
	}

	// Iterator über alle Knoten
	public Iterable<N> getNodes() {
		return nodes;
	}
}