package ch.zhaw.rhiana.ads.Praktikum01;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import ch.zhaw.rhiana.ads.CommandExecutor;

/**
 * @author Rhiana Weber
 */
public class KgvServer implements CommandExecutor {
	private static final String NEW_LINE = "\n";

	@Override
	public String execute(String command) throws Exception {
		try {
			Scanner scanner = new Scanner(new ByteArrayInputStream(command.getBytes()));
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			scanner.close();
			return "The KgV of " + a + " & " + b + " is: " + Integer.toString(kgv(a, b)) + NEW_LINE;
		} catch (KgvNegativeNumberException e) {
			return e.getMessage() + NEW_LINE;
		}
	}
	
	/**
	 * Liefert das kleinste gemeinsame Vielfache zwischen den beiden 
	 * übergebenen Werten.
	 * 
	 * @param a Erster Wert.
	 * @param b Zweiter Wert.
	 * 
	 * @return Kleinstes gemeinsames Vielfaches.
	 * 
	 * @throws KgvNegativeNumberException Wenn eine der übergebenen Werte kleiner als null ist.
	 */
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
