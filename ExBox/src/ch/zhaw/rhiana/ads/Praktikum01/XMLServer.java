package ch.zhaw.rhiana.ads.Praktikum01;

import ch.zhaw.rhiana.ads.CommandExecutor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rhiana Weber
 */
public class XMLServer implements CommandExecutor {
	private static final String NEW_LINE = "\n";

	private static final char CHAR_QUESTIONMARK = '?';
	private static final char CHAR_OPEN = '<';
	private static final char CHAR_END = '>';

	private static final String TAG_OPEN = Character.toString(CHAR_OPEN);
	private static final String TAG_CLOSE = "</";

	public String execute(String xmlFile) {
		return checkWellformed(xmlFile) + NEW_LINE;
	}

	/**
	 * Checkt ob das xml File das �bergeben wurde "well formed" ist.
	 * 
	 * @param xmlFile Das �bergebene xmlFile das getestet werden soll
	 * @return ob "well formed"
	 */
	public boolean checkWellformed(String xmlFile) {
		List<String> tokenListToBeChecked = getTokenAsStringInList(xmlFile);
		StackLinkedList xmlStack = new StackLinkedList();

		for (int i = 0; i < tokenListToBeChecked.size(); i++) {
			String currentString = tokenListToBeChecked.get(i);
			if (currentString.contains(TAG_CLOSE)) {
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

			} else if (currentString.startsWith(TAG_OPEN)) {
				xmlStack.push(currentString);
			}
		}

		return true;
	}

	/**
	 * Liefert die Tokens in einer Liste
	 * 
	 * @param xmlFile Das �bergebene xmlFile das getestet werden soll
	 * @return Token in einer Liste
	 */
	private List<String> getTokenAsStringInList(String xmlFile) {
		String tagsWithoutChars = getNextToken(xmlFile);
		String oneTokenString = "";
		List<String> tokenList = new ArrayList<>();

		for (int i = 0; i < tagsWithoutChars.length(); i++) {
			char currentChar = tagsWithoutChars.charAt(i);
			if (currentChar != CHAR_END) {
				oneTokenString += Character.toString(currentChar);
			} else {
				oneTokenString += Character.toString(currentChar);
				tokenList.add(oneTokenString);
				oneTokenString = "";
			}
		}

		return tokenList;
	}

	/**
	 * Liefert nurnoch die Tags des xml Files werden zur�ckgegeben, der Text
	 * zwischen den Tags wird ignoriert
	 * 
	 * @param xmlFile Das �bergebene xmlFile das getestet werden soll
	 * @return Tags des xml Files.
	 */
	private String getNextToken(String xmlFile) {
		String tagsWithoutChars = "";

		for (int i = 0; i < xmlFile.length(); i++) {
			char currentChar = xmlFile.charAt(i);
			if (currentChar == CHAR_OPEN) {
				char currentCharMakesSureNoQuestionmark = xmlFile.charAt(i + 1);
				if (currentCharMakesSureNoQuestionmark != CHAR_QUESTIONMARK) {
					tagsWithoutChars += Character.toString(currentChar);

					for (int i1 = i + 1; i1 < xmlFile.length(); i1++) {
						char currentChar1 = xmlFile.charAt(i1);
						if (currentChar1 != CHAR_END) {
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
