package ch.zhaw.rhiana.ads.Praktikum02;

import ch.zhaw.rhiana.ads.CommandExecutor;

/**
 * @author Rhiana Weber
 */
public class BracketServer implements CommandExecutor {

	private StackLinkedList bracketListStack = new StackLinkedList();

	public String execute(String command) {
		if (checkBrackets(command) == true) {
			return "Brackets are set correctly \n";
		} else {
			return "Brackets are not set correctly! Try again";
		}
	}

	boolean checkBrackets(String command) {
		// Zurücksetzen des Bracket-Server.
		bracketListStack.removeAll();

		String bracketsWithoutChar = nextChar(command);
		for (int i = 0; i < bracketsWithoutChar.length(); i++) {
			char currentChar = bracketsWithoutChar.charAt(i);
			if (currentChar == '{' || currentChar == '(' || currentChar == '[') {
				bracketListStack.push(currentChar);
			}
			if (currentChar == '}' || currentChar == ')' || currentChar == ']') {
				if (bracketListStack.isEmpty()) {
					return false;
				}

				char lastInStack = (char) bracketListStack.peek();
				if (currentChar == '}' && lastInStack == '{' || currentChar == ')' && lastInStack == '('
						|| currentChar == ']' && lastInStack == '[') {
					bracketListStack.pop();
				} else {
					return false;
				}
			}

		}

		return true;
	}

	private String nextChar(String command) {
		String bracketsWithoutChar = "";
		for (int i = 0; i < command.length(); i++) {
			char currentChar = command.charAt(i);
			if (currentChar == '{' || currentChar == '}' || currentChar == '[' || currentChar == ']'
					|| currentChar == '(' || currentChar == ')') {
				bracketsWithoutChar += Character.toString(currentChar);
			}

		}

		return bracketsWithoutChar;
	}
}
