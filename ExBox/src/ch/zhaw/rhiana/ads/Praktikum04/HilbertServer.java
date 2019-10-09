package ch.zhaw.rhiana.ads.Praktikum04;

import ch.zhaw.rhiana.ads.CommandExecutor;

public class HilbertServer implements CommandExecutor {

	@Override
	public String execute(String command) throws Exception {
		return null;
	}
	
	private String renderHilbert(int depth, double dist, double angle, Turtle turtle ) {
		turtle.turn(-angle);
		turtle.move(dist);
		turtle.turn(angle);
		turtle.move(dist);
		turtle.turn(angle);
		turtle.move(dist);
		turtle.turn(-angle);
		
		return turtle.getTrace();
		
		
	}

}
