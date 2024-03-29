package ch.zhaw.rhiana.ads.Praktikum04;

import ch.zhaw.rhiana.ads.CommandExecutor;

/**
 * Represents the snowflake-server.
 * 
 * @author Rhiana Weber
 * @author Yanick Senn
 */
public class SnowFlakeServer implements CommandExecutor {

	@Override
	public String execute(String command) throws Exception {
		String[] myCommandString = command.split(" ");
		if (myCommandString.length != 2) {
			throw new IllegalArgumentException(
					"Illegal amount of arguments was presented, please give level and distance in int");
		}
		
		int level = Integer.valueOf(myCommandString[0]);
		double distance = Double.valueOf(myCommandString[1]);
		return renderSnowflake(level, distance);
	}

	/**
	 * Renders a snowflake by the given parameters.
	 * 
	 * @param level Level.
	 * @param distance Distance.
	 * 
	 * @return Instructions for a snowflake.
	 */
	public String renderSnowflake(int level, double distance) {
		Turtle turtle = new Turtle(0.25, 0.75);
		renderSnowflake(level, distance, turtle);
		turtle.turn(-120);
		renderSnowflake(level, distance, turtle);
		turtle.turn(-120);
		renderSnowflake(level, distance, turtle);
		return turtle.getTrace();
	}

	private String renderSnowflake(int level, double distance, Turtle turtle) {
		if (level == 0) {
			turtle.move(distance);
		} else {
			level--;
			distance = distance / 3;
			renderSnowflake(level, distance, turtle);
			turtle.turn(60);
			renderSnowflake(level, distance, turtle);
			turtle.turn(-120);
			renderSnowflake(level, distance, turtle);
			turtle.turn(60);
			renderSnowflake(level, distance, turtle);

		}
		return turtle.getTrace();
	}

}
