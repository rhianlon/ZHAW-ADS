package ch.zhaw.rhiana.ads.Praktikum01;

import java.util.ArrayList;
import java.util.List;

public class Help {

	public static void main(String[] args) {
		boolean hallo = checkWellformed("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + "<note>\r\n"
				+ "<to>Tove</to>\r\n" + "<from>Jani</from> \r\n" + "<heading>Reminder</heading>\r\n"
				+ "<body>Don't forget me this weekend!</body>\r\n" + "</note>");
		System.out.println(hallo);
	}
	
	private static boolean checkWellformed(String xmlFile) {
		List<String> tokenListToBeChecked = getTokenAsStringInList(xmlFile);
		StackLinkedList xmlStack = new StackLinkedList();
		
		
		for (int i = 0; i < tokenListToBeChecked.size(); i++) {
			String currentString = tokenListToBeChecked.get(i);
			if(currentString.contains("</")) {
				if(xmlStack.isEmpty()) {
					return false;
				}
				
				String lastInStack = (String) xmlStack.peek();
				String modifiedClosingTag = currentString.substring(2);
				String modiefiedOpeningTag = lastInStack.substring(1);
				if(modifiedClosingTag.equals(modiefiedOpeningTag)){
					xmlStack.pop();
					
				} else {
					return false;
				}
			} else if(currentString.startsWith("<")) {
				xmlStack.push(currentString);
			}
		}
		return true;
	}

	public static String getNextToken(String xmlFile) {
		String tagsWithoutChars = "";

		for (int i = 0; i < xmlFile.length(); i++) {
			char currentChar = xmlFile.charAt(i);
			char currentCharMakesSureNoQuestionmark = xmlFile.charAt(i + 1);
			if (currentChar == '<' && currentCharMakesSureNoQuestionmark != '?') {
				tagsWithoutChars += Character.toString(currentChar);

				for (int i1 = i + 1; i1 < xmlFile.length(); i1++) {
					char currentChar1 = xmlFile.charAt(i1);
					if (currentChar1 != '>') {
						tagsWithoutChars += Character.toString(currentChar1);
					} else {
						tagsWithoutChars += Character.toString(currentChar1);
						i = i1;
						break;
					}
				}
			}
		}
		return tagsWithoutChars;

	}

	private static List getTokenAsStringInList(String xmlFile) {
		String tagsWithoutChars = getNextToken(xmlFile);
		String oneTokenString = "";
		List<String> tokenList = new ArrayList<>();

		for (int i = 0; i < tagsWithoutChars.length(); i++) {
			char currentChar = tagsWithoutChars.charAt(i);
			if (currentChar != '>') {
				oneTokenString += Character.toString(currentChar);
			} else {
				oneTokenString += Character.toString(currentChar);
				tokenList.add(oneTokenString);
				oneTokenString = "";
			}
		}
		return tokenList;
	}

}
