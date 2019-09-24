package ch.zhaw.rhiana.ads.Praktikum01;

import ch.zhaw.rhiana.ads.CommandExecutor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rhiana Weber
 */
public class XMLServer implements CommandExecutor {

	public String execute(String xmlFile) {
		return checkWellformed(xmlFile) + "\n";

	}

	public boolean checkWellformed(String xmlFile) {
		List<String> tokenListToBeChecked = getTokenAsStringInList(xmlFile);
		StackLinkedList xmlStack = new StackLinkedList();

		for (int i = 0; i < tokenListToBeChecked.size(); i++) {
			String currentString = tokenListToBeChecked.get(i);
			if (currentString.contains("</")) {
				if (xmlStack.isEmpty()) {
					return false;
				}

				String lastInStack = (String) xmlStack.peek();
				String modifiedClosingTag = currentString.substring(2);
				String modiefiedOpeningTag = lastInStack.substring(1);
				if (modifiedClosingTag.equals(modiefiedOpeningTag)) {
					xmlStack.pop();

				} else {
					return false;
				}
			} else if (currentString.startsWith("<")) {
				xmlStack.push(currentString);
			}
		}
		return true;
	}

	private List<String> getTokenAsStringInList(String xmlFile) {
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

	private String getNextToken(String xmlFile) {
		String tagsWithoutChars = "";

		for (int i = 0; i < xmlFile.length(); i++) {
			char currentChar = xmlFile.charAt(i);
			if (currentChar == '<') {
				char currentCharMakesSureNoQuestionmark = xmlFile.charAt(i + 1);
				if (currentCharMakesSureNoQuestionmark != '?') {
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
		}
		return tagsWithoutChars;
	}

}
