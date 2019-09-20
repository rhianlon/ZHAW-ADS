package ch.zhaw.rhiana.ads.Praktikum01;

import ch.zhaw.rhiana.ads.CommandExecutor;

public class XMLServer implements CommandExecutor {

	public String execute(String xmlFile) {
		return getNextToken(xmlFile) + "\n";

	}

	private boolean checkWellformed(String xmlFile) {
		String tagsWithoutChars = getNextToken(xmlFile);
		
		

		return false;

	}

	private String getNextToken(String xmlFile) {
		String tagsWithoutChars = "";

		for (int i = 0; i < xmlFile.length(); i++) {
			char currentChar = xmlFile.charAt(i);
			char currentCharMakesSureNoQuestionmark = xmlFile.charAt(i+1);
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
	
	private String comparisonOfTags(String xmlFile) {
		String tagsWithoutChars = getNextToken(xmlFile);
		
		for(int i = 0; i < tagsWithoutChars.length(); i++) {
			char currentChar = tagsWithoutChars.charAt(i);
		}
		return xmlFile;
		
	}

}