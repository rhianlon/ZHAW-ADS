package ch.zhaw.rhiana.ads.Praktikum02;

import java.util.ArrayList;
import java.util.List;

import ch.zhaw.rhiana.ads.CommandExecutor;

/**
 * @author Rhiana Weber
 * <rhiana is the() best>
 */
public class BracketServer implements CommandExecutor {

	private List<Bracket> bracketList = new ArrayList<>();
	
	public BracketServer() {
		bracketList.add(new Bracket("<",">"));
		bracketList.add(new Bracket("(",")"));
		bracketList.add(new Bracket("{","}"));
		bracketList.add(new Bracket("[","]"));
		bracketList.add(new Bracket("<*","*>"));
	}
	
	private String filterNonBrackets(String command) {
		String onlyBrackets = "";
		for(int i= 0; i < command.length(); i++) {
			char currentChar = command.charAt(i);
			if(bracketList.contains(currentChar)) {
				
			}
		}
		
		return null;
		
	}
	private String filterBracketList(String s) {
		for (Bracket bracket : bracketList) {
			
		}
		return null;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
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
		
		command = command.replace("<*", "%");
		command = command.replace("*>", "&");

		String bracketsWithoutChar = nextChar(command);
		for (int i = 0; i < bracketsWithoutChar.length(); i++) {
			char currentChar = bracketsWithoutChar.charAt(i);
			if (currentChar == '{' || currentChar == '(' || currentChar == '[' || currentChar == '<' || currentChar == '%') {
				bracketListStack.push(currentChar);
			}
			if (currentChar == '}' || currentChar == ')' || currentChar == ']' || currentChar == '>' || currentChar == '&') {
				if (bracketListStack.isEmpty()) {
					return false;
				}

				char lastInStack = (char) bracketListStack.peek();
				if (currentChar == '}' && lastInStack == '{' || currentChar == ')' && lastInStack == '('
						|| currentChar == ']' && lastInStack == '[' || currentChar == '>' && lastInStack == '<' || currentChar == '&' && lastInStack == '%')  {
					bracketListStack.pop();
				} else {
					return false;
				}
			}

		}
		return bracketListStack.isEmpty();
	}

	private String nextChar(String command) {
		String bracketsWithoutChar = "";
		for (int i = 0; i < command.length(); i++) {
			char currentChar = command.charAt(i);
			if (currentChar == '{' || currentChar == '}' || currentChar == '[' || currentChar == ']'
					|| currentChar == '(' || currentChar == ')' || currentChar == '<' || currentChar == '>' || currentChar == '%' || currentChar == '&') {
				bracketsWithoutChar += Character.toString(currentChar);
			}

		}

		return bracketsWithoutChar;
	}
	private String nextCharAsSTring(String command) {
		String bracketsWithoutChar = "";
		for(int i = 0; i < command.length(); i++) {
			
		}
		return command;
		
	}
}
