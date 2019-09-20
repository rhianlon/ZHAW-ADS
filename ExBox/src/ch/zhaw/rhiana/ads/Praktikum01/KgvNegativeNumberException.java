package ch.zhaw.rhiana.ads.Praktikum01;

public class KgvNegativeNumberException extends Exception {
	public KgvNegativeNumberException() {
		super("Negative number used as an argument, please provide only positive numbers.");
	}
}
