package ch.zhaw.rhiana.ads.Praktikum07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.PriorityQueue;
import java.util.Queue;

import ch.zhaw.rhiana.ads.CommandExecutor;

public class RouteServer implements CommandExecutor {

	public static final String SEPARATOR = "[ ]";

	public static final int INDEX_FROM = 0;
	public static final int INDEX_TO = 0;
	public static final int INDEX_DISTANCE = 0;

	@Override
	public String execute(String command) throws Exception {
		return null;
	}

	private Graph<DijkstraNode<String>, Edge> parse(String content) throws IOException {
		Graph<DijkstraNode<String>, Edge> graph = new AdjListGraph<>(DijkstraNode.class, Edge.class);

		BufferedReader br = new BufferedReader(new StringReader(content));
		String line = null;
		while ((line = br.readLine()) != null) {
			String[] parts = line.split(SEPARATOR);
			String source = parts[INDEX_FROM];
			String destination = parts[INDEX_TO];
			int weight = Integer.valueOf(parts[INDEX_DISTANCE]);

			graph.addEdge(source, destination, weight);
		}

		return graph;
	}

	public void findShortestDistance(AdjListGraph<DijkstraNode<Edge>, Edge> adj, String start, String dest) {
		Queue<DijkstraNode<Edge>> pq = new PriorityQueue<>();
		 DijkstraNode<Edge> current = adj.findNode(start);
		 DijkstraNode<Edge> destNode = adj.findNode(dest);
		 current.dist = 0;
		 pq.offer(current);
		 
		 while(!pq.isEmpty()) {
			 current = pq.poll();
			 current.mark = true;

			 for(Edge edge :  current.edges) {
				 DijkstraNode<Edge> n = edge.dest;
				 if(!n.getMark()) {
					 double dist = edge.weight + current.dist;
					 if((n.prev == null) || (dist < n.dist)) {
						 n.dist = dist;
						 n.prev = current;
						 pq.offer(n);
					 }
				 }
			 }
		 }
	}
}
