package ch.zhaw.rhiana.ads.Praktikum04;

import ch.zhaw.rhiana.ads.CommandExecutor;

public class SnowFlakeServer implements CommandExecutor {

	@Override
	public String execute(String command) throws Exception {
		
		
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
