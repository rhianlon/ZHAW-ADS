package ch.zhaw.rhiana.ads.Praktikum08;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import ch.zhaw.rhiana.ads.CommandExecutor;

public class LabrynthServer implements CommandExecutor {
	
	private ServerGraphics myCanvas = new ServerGraphics();
	private String start = "0-6";
	private String end = "3-0";

//	private static final String command = "0-6 4-6\n" + "4-6 7-6\n" + "7-6 9-6\n" + "7-6 7-4\n" + "7-4 6-4\n"
//			+ "7-4 9-4\n" + "9-4 9-1\n" + "7-4 7-1\n" + "7-1 5-1\n" + "4-6 4-4\n" + "4-4 4-3\n" + "4-4 1-4\n"
//			+ "1-4 1-1\n" + "1-1 3-1\n" + "3-1 3-2\n" + "3-1 3-0";
//
//	public static void main(String[] args) throws Exception {
//		new LabrynthServer().execute(command);
//	}

	@Override
	public String execute(String command) throws Exception {

		Graph<LabyrinthNode, Edge<LabyrinthNode>> labyrinthGraph = parseCordinates(command);

		myCanvas.setColor(Color.BLACK);
		myCanvas.fillRect(0, 0, 5, 5);

		for (LabyrinthNode node : labyrinthGraph.getNodes()) {
			for (Edge<LabyrinthNode> edge : node.getEdges()) {
				drawPath(node.getName(), edge.getDest().getName(), false);
			}
		}

		LabyrinthNode labyrinthStart = labyrinthGraph.findNode(start);
		LabyrinthNode labyrinthTarget = labyrinthGraph.findNode(end);
		
		if(findpath(labyrinthStart, labyrinthTarget)) {
		do {
			drawPath(labyrinthTarget.getName(), labyrinthTarget.getPrev().getName(), true);
			labyrinthTarget = labyrinthTarget.getPrev();
		} while (labyrinthTarget.getPrev() != null);
		}
		
		return myCanvas.getTrace();
	}

	public Graph<LabyrinthNode, Edge<LabyrinthNode>> parseCordinates(String coordinates)
			throws NumberFormatException, IOException {
		Graph<LabyrinthNode, Edge<LabyrinthNode>> result = new AdjListGraph<>(LabyrinthNode.class, Edge.class);
		BufferedReader br = new BufferedReader(new StringReader(coordinates));
		String line = null;
		while ((line = br.readLine()) != null) {
			String[] twoNodes = line.split(" ");

			String[] nodeCoordinates1 = twoNodes[0].split("-");
			int x1 = Integer.valueOf(nodeCoordinates1[0]);
			int y1 = Integer.valueOf(nodeCoordinates1[1]);
			LabyrinthNode node1 = result.addNode(x1 + "-" + y1);

			String[] nodeCoordinates2 = twoNodes[1].split("-");
			int x2 = Integer.valueOf(nodeCoordinates2[0]);
			int y2 = Integer.valueOf(nodeCoordinates2[1]);
			LabyrinthNode node2 = result.addNode(x2 + "-" + y2);

			int weight = 0;

			if (x1 == x2) {
				weight = Math.abs(y2 - y1);
			} else if (y1 == y2) {
				weight = Math.abs(x2 - x1);
			} else {
				throw new IllegalArgumentException("Invalid Coordinates");
			}

			result.addEdge(node1.getName(), node2.getName(), weight);
			result.addEdge(node2.getName(), node1.getName(), weight);

		}
		return result;

	}

	public boolean findpath(LabyrinthNode currentNode, LabyrinthNode exitNode) {

		currentNode.setMark(true);
		if (currentNode == exitNode) {
			return true;
		}
		for (Edge<LabyrinthNode> edge : currentNode.getEdges()) {
			LabyrinthNode nextNode = edge.getDest();
			if (!nextNode.getMark()) {
				nextNode.setPrev(currentNode);
				if (findpath(nextNode, exitNode)) {
					return true;
				}
			}

		}
		currentNode.setMark(false);
		return false;

	}

	final double SCALE = 15;

	private void drawPath(String from, String to, boolean mouse) {
		double offsetX = 0.0;
		double offsetY = 0.0;
		double xh0 = from.charAt(0) - '0';
		double yh0 = from.charAt(2) - '0';
		double xh1 = to.charAt(0) - '0';
		double yh1 = to.charAt(2) - '0';
		double x0 = Math.min(xh0, xh1) / SCALE;
		double y0 = Math.min(yh0, yh1) / SCALE;
		double x1 = Math.max(xh0, xh1) / SCALE;
		double y1 = Math.max(yh0, yh1) / SCALE;
		double w = 1 / SCALE;
		if (mouse) {
			myCanvas.setColor(Color.RED);
			myCanvas.drawLine(x0 + offsetX + w / 2, y0 + offsetY + w / 2, x1 + w / 2, y1 + w / 2);
		} else if (y0 == y1) {
			myCanvas.setColor(Color.WHITE);
			myCanvas.fillRect(x0 + offsetX, y0 + offsetY, x1 - x0 + w, w);
		} else {
			myCanvas.setColor(Color.WHITE);
			myCanvas.fillRect(x0 + offsetX, y0 + offsetY, w, y1 - y0 + w);
		}
	}

}
