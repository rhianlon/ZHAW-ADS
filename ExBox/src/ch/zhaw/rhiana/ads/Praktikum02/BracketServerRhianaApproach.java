package ch.zhaw.rhiana.ads.Praktikum02;

import java.util.ArrayList;
import java.util.List;

import ch.zhaw.rhiana.ads.CommandExecutor;

public class BracketServerRhianaApproach implements CommandExecutor {
	
	private Stack bracketStack = new StackLinkedList();
	private List<String> openingBrackets = new ArrayList<String>();
	private List<String> closingBrackets = new ArrayList<String>();

	public BracketServerRhianaApproach() {
		openingBrackets.add("<");
		openingBrackets.add("<*");
		openingBrackets.add("(");
		openingBrackets.add("{");
		openingBrackets.add("[");

		closingBrackets.add(">");
		closingBrackets.add("*>");
		closingBrackets.add(")");
		closingBrackets.add("}");
		closingBrackets.add("]");
	}
	
	private List<String> nextString(String command) {
		List<String> modifiedList = new ArrayList<>();
		for(int i = 0; i<command.length(); i++) {
			String currentString = Character.toString(command.charAt(i));
			if(openingBrackets.contains(currentString)) {
				
			}
		}
		return modifiedList ;
		
	}
	

	@Override
	public String execute(String command) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
