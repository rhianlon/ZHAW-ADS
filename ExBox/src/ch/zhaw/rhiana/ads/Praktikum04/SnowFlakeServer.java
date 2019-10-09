package ch.zhaw.rhiana.ads.Praktikum04;

import java.util.ArrayList;
import java.util.List;

import ch.zhaw.rhiana.ads.CommandExecutor;

public class SnowFlakeServer implements CommandExecutor {

	@Override
	public String execute(String command) throws Exception {
		String[] myCommandString = command.split(" ");
		if(myCommandString.length != 2) {
			throw new IllegalArgumentException("Illegal amount of arguments was presented, please give level and distance in int");
		}
		int level = Integer.valueOf(myCommandString[0]);
		double distance = Double.valueOf(myCommandString[1]);
		renderSnowflake(level, distance);
		
		return null;
	}
	
	private void renderSnowflake(int level, double distance) {
		Turtle turtle = new Turtle();

		if(level == 0) {
			turtle.move(distance);
		} else {
			level--;
			distance = distance / 3 ;
			renderSnowflake(level, distance);
			turtle.turn(60);
			renderSnowflake(level, distance);
			turtle.turn(-120);
			renderSnowflake(level, distance);
			turtle.turn(60);
			renderSnowflake(level, distance);
		}
	}
	

}
