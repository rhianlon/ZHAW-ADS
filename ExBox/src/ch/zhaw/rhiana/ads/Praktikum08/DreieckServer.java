package ch.zhaw.rhiana.ads.Praktikum08;

import java.awt.Color;
import java.io.ByteArrayInputStream;
import java.util.Scanner;

import ch.zhaw.rhiana.ads.CommandExecutor;


public class DreieckServer implements CommandExecutor {
	private ServerGraphics myCanvas = new ServerGraphics();
	

	@Override
	public String execute(String command) throws Exception {
		Scanner scanner = new Scanner(new ByteArrayInputStream(command.getBytes()));
		double myTriangleX = scanner.nextDouble();
		double myTriangleY = scanner.nextDouble();
		double myTriangleLength = scanner.nextDouble();
		
		drawTriangle(myTriangleX,myTriangleY,myTriangleLength);
		
		double myRecX = scanner.nextDouble();
		double myRecY = scanner.nextDouble();
		double myRecWidth = scanner.nextDouble();
		double myRecHeight = scanner.nextDouble();
		
		scanner.close();
		
		myCanvas.setColor(Color.RED);
		//myCanvas.drawRect(myRecX, myRecY, myRecWidth, myRecHeight);
		myCanvas.fillRect(myRecX, myRecY, myRecWidth, myRecHeight);
		return myCanvas.getTrace();
	}

	public void drawTriangle(double x , double y, double length) {
		
		double halfLength = length/2;
		
		double x1 = x;
		double y1 = y;
		
		double x2 = x1 + length;
		double y2 = y;
		
		double x3 = x + halfLength;
		double y3 = y + Math.sqrt(length*length - halfLength*halfLength);
		
		myCanvas.setColor(Color.BLUE);
		myCanvas.drawLine(x1, y1, x2, y2);
		myCanvas.setColor(Color.GREEN);
		myCanvas.drawLine(x2, y2, x3, y3);
		myCanvas.setColor(Color.YELLOW);
		myCanvas.drawLine(x3, y3, x1, y1);

		
	}
	
	

}
