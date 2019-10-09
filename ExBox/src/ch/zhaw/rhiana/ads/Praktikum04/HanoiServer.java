package ch.zhaw.rhiana.ads.Praktikum04;

import ch.zhaw.rhiana.ads.CommandExecutor;

public class HanoiServer implements CommandExecutor {
	
	public static String moveDisk(int numberOfDisks, char fromTower, char toTower, char helpTower) {
		return moveDisk(numberOfDisks, fromTower, toTower, helpTower, "");
	}
	
	private static String moveDisk(int numberOfDisks, char fromTower, char toTower, char helpTower, String result) {
		if( numberOfDisks > 0 ) {
			result = moveDisk(numberOfDisks-1, fromTower, helpTower, toTower, result);
			result = result + ("Move " +fromTower+ " to " +toTower + "\n"); 
			result = moveDisk(numberOfDisks-1, helpTower, toTower, fromTower, result);
		}
		return result;
	}
	public static void main(String[] args) {
		String result = moveDisk(3, 'A', 'C', 'B');
		System.out.println(result);
	}
	

	@Override
	public String execute(String command) throws Exception {
		// TODO Auto-generated method stub
		int numberOfDisks = Integer.valueOf(command);
		return moveDisk(numberOfDisks, 'A', 'C', 'B');
		
	}
	
}
