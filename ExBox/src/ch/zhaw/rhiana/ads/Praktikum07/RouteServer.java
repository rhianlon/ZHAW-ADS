package ch.zhaw.rhiana.ads.Praktikum07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import ch.zhaw.rhiana.ads.CommandExecutor;

public class RouteServer implements CommandExecutor {

	public static final String SEPARATOR = "[ ]";

	public static final int INDEX_FROM = 0;
	public static final int INDEX_TO = 1;
	public static final int INDEX_DISTANCE = 2;
	
	public static void main(String[] args) throws Exception {
		System.out.println(new RouteServer().execute(
				"Winterthur Zürich 25\n" + 
				"Zürich Bern 126\n" +
				"Zürich Genf 277\n" + 
				"Zürich Luzern 54\n" + 
				"Zürich Chur 121\n" + 
				"Zürich Berikon 16\n" + 
				"Bern Genf 155\n" + 
				"Genf Lugano 363\n" + 
				"Lugano Luzern 206\n" + 
				"Lugano Chur 152\n" + 
				"Chur Luzern 146\n" + 
				"Luzern Bern 97\n" + 
				"Bern Berikon 102\n" + 
				"Luzern Berikon 41\n"));
	}

	@Override
	public String execute(String command) throws Exception {
		Graph<DijkstraNode, Edge<DijkstraNode>> graph = parse(command);
		findShortestDistance(graph, "Lugano");/* , "Winterthur"); */
		
		List<DijkstraNode> nodes = dykestra(graph, "Winterthur");
		
		StringBuilder sb = new StringBuilder();
		for (DijkstraNode node : nodes) {
			//sb.append(" - ");
			sb.append(node.name);
			sb.append("\n");
		}
		sb.append("\n");

		double destDist = nodes.get(0).dist;
		sb.append("==========\n");
		sb.append("> ");
		sb.append(destDist);
		sb.append(" km");
		sb.append("\n");
		
		return sb.toString();
	}

	private Graph<DijkstraNode, Edge<DijkstraNode>> parse(String content) throws IOException {
		Graph<DijkstraNode, Edge<DijkstraNode>> graph = new AdjListGraph<>(DijkstraNode.class, Edge.class);

		BufferedReader br = new BufferedReader(new StringReader(content));
		String line = null;
		while ((line = br.readLine()) != null) {
			String[] parts = line.split(SEPARATOR);
			String source = parts[INDEX_FROM];
			String destination = parts[INDEX_TO];
			int weight = Integer.valueOf(parts[INDEX_DISTANCE]);

			// Ungerichteten graphen erstellen
			graph.addEdge(source, destination, weight);
			graph.addEdge(destination, source, weight);
		}

		return graph;
	}

	private List<DijkstraNode> dykestra(Graph<DijkstraNode, Edge<DijkstraNode>> graph, String start) {
		List<DijkstraNode> result = new ArrayList<>();
		
		DijkstraNode n = graph.findNode(start);
		double destDist = n.dist;
		while (n != null) {
			result.add(n);
			n = n.prev;
		}
		
		return result;
	}
	
	private void findShortestDistance(Graph<DijkstraNode, Edge<DijkstraNode>> graph, String name/* , String dest */) {
		Queue<DijkstraNode> pq = new PriorityQueue<>();
		DijkstraNode current = graph.findNode(name);
		// DijkstraNode destNode = adj.findNode(dest);
		current.dist = 0;
		pq.offer(current);

		while (!pq.isEmpty()) {
			current = pq.poll();
			current.mark = true;

			for (Edge<DijkstraNode> edge : current.edges) {
				DijkstraNode n = edge.dest;
				if (!n.getMark()) {
					double dist = edge.weight + current.dist;
					if ((n.prev == null) || (dist < n.dist)) {
						n.dist = dist;
						n.prev = current;
						pq.offer(n);
					}
				}
			}
		}
	}
}
