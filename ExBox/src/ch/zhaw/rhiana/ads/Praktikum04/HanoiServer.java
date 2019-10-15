package ch.zhaw.rhiana.ads.Praktikum04;

import ch.zhaw.rhiana.ads.CommandExecutor;

/**
 * Represent the hanoi-server.
 * 
 * @author Rhiana Weber
 * @author Yanick Senn
 */
public class HanoiServer implements CommandExecutor {

	/**
	 * Outputs the instructions to move the disks from a tower to a different tower.
	 * 
	 * @param numberOfDisks Number of disks.
	 * @param fromTower Starting tower.
	 * @param toTower Target tower.
	 * @param helpTower Assisting tower.
	 * 
	 * @return The instructions as a string.
	 */
	public static String moveDisk(int numberOfDisks, char fromTower, char toTower, char helpTower) {
		return moveDisk(numberOfDisks, fromTower, toTower, helpTower, "");
	}

	private static String moveDisk(int numberOfDisks, char fromTower, char toTower, char helpTower, String result) {
		if (numberOfDisks > 0) {
			result = moveDisk(numberOfDisks - 1, fromTower, helpTower, toTower, result);
			result = result + ("Move " + fromTower + " to " + toTower + "\n");
			result = moveDisk(numberOfDisks - 1, helpTower, toTower, fromTower, result);
		}
		return result;
	}

	@Override
	public String execute(String command) throws Exception {
		int numberOfDisks = Integer.valueOf(command);
		return moveDisk(numberOfDisks, 'A', 'C', 'B');
	}

}
