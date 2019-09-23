package ch.zhaw.rhiana.ads.Praktikum01;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import ch.zhaw.rhiana.ads.CommandExecutor;

/**
 * @author Rhiana Weber
 */
public class KgvServer implements CommandExecutor {

	@Override
	public String execute(String command) throws Exception {
		try {
			Scanner scanner = new Scanner(new ByteArrayInputStream(command.getBytes()));
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			scanner.close();
			return "The KgV of " +a+ " & " +b+ " is: " + Integer.toString(kgv(a, b)) + "\n";
		} catch (KgvNegativeNumberException e) {
			return e.getMessage() + "\n";
		}
	}

	public int kgv(int a, int b) throws KgvNegativeNumberException {
		if(a < 0 || b < 0 ) {
			throw new KgvNegativeNumberException();
		}
		if (a == 0 || b == 0) {
			return 0;
		} else {
			return (a * b) / ggT(a, b);
		}
	}

	private int ggT(int a, int b) {
		if (a > b) {
			return ggT(a - b, b);
		} else if (a < b) {
			return ggT(a, b - a);
		} else {
			return a;
		}
	}

}
