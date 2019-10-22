package ch.zhaw.rhiana.ads.Praktikum04;

import ch.zhaw.rhiana.ads.CommandExecutor;

/**
 * Represents the hilbert-server.
 * 
 * @author Rhiana Weber
 * @author Yanick Senn
 */
public class HilbertServer implements CommandExecutor {

	// Const-Parsing
	public static final int ARG_SIZE = 2;
	public static final int ARG_LEVEL = 0;
	public static final int ARG_DISTANCE = 1;

	// Const-Hilbert
	public static final int ANGLE = 90;

	@Override
	public String execute(String command) throws Exception {
		if (command == null) {
			throw new IllegalArgumentException("command should not be null");
		}
		
		if (command.isEmpty()) {
			throw new IllegalArgumentException("command should not be empty");
		}

		// Assert that the command contains the right amount of arguments.
		String[] parts = command.trim().split("[\\s]+");
		if (parts.length != ARG_SIZE) {
			throw new IllegalArgumentException(
				"command should contain exactly " + ARG_SIZE + " parameters");
		}

		// Parsing level
		String levelAsStr = parts[ARG_LEVEL].trim();
		int level;
		try {
			level = Integer.valueOf(levelAsStr);
		} catch (Exception e) {
			throw new IllegalArgumentException("level cannot be parsed to an integer: " + levelAsStr, e);
		}

		// Parsing distance
		String distanceAsStr = parts[ARG_DISTANCE].trim();
		double distance;
		try {
			distance = Double.valueOf(distanceAsStr);
		} catch (Exception e) {
			throw new IllegalArgumentException("distance cannot be parsed to a double: " + distanceAsStr, e);
		}

		return renderHilbert(level, distance);
	}

	/**
	 * Renders the hilbert-curve by the given parameters.
	 * 
	 * @param level    Level.
	 * @param distance Distance.
	 * 
	 * @return The coordinates of the curve.
	 */
	public String renderHilbert(int level, double distance) {
		if (level < 1) {
			throw new IllegalArgumentException("level cannot be smaller than 1");
		}

		if (distance <= 0) {
			throw new IllegalArgumentException("distance cannot be smaller or equal to 0");
		}

		return renderHilbert(level, distance, ANGLE, new Turtle(0.25, 0.75));
	}

	/**
	 * Renders the hilbert-curve by the given parameters.
	 * 
	 * @param level    Level.
	 * @param distance Distance.
	 * @param angle    Angle.
	 * @param turtle   Turtle.
	 * 
	 * @return The coordinates of the curve.
	 */
	private String renderHilbert(int level, double distance, double angle, Turtle turtle) {
		if (level > 0) {
			int newLevel = level - 1;
			turtle.turn(-angle);
			renderHilbert(newLevel, distance, -angle, turtle);
			turtle.move(distance);
			turtle.turn(angle);
			renderHilbert(newLevel, distance, angle, turtle);
			turtle.move(distance);
			renderHilbert(newLevel, distance, angle, turtle);
			turtle.turn(angle);
			turtle.move(distance);
			renderHilbert(newLevel, distance, -angle, turtle);
			turtle.turn(-angle);
		}

		return turtle.getTrace();
	}
}
