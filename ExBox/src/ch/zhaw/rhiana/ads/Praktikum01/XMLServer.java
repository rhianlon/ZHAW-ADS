package ch.zhaw.rhiana.ads.Praktikum01;

import ch.zhaw.rhiana.ads.CommandExecutor;

import java.util.ArrayList;
import java.util.List;

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
	
	private List<String> getTheSingleTagsAsSingleObjectsInAList(String xmlFile) {
		List<String> listWithTags = new ArrayList<>();
		return null;
		
	}
	
	private String getTokenAsString(String xmlFile) {
		String tagsWithoutChars = getNextToken(xmlFile);
		String oneTokenString = "";
		
		for(int i = 0; i < tagsWithoutChars.length(); i++) {
			char currentChar = tagsWithoutChars.charAt(i);
			if(currentChar != '>') {
				oneTokenString += Character.toString(currentChar);
				tagsWithoutChars = tagsWithoutChars.substring(0, tagsWithoutChars.length()-1);
			} else {
				oneTokenString += Character.toString(currentChar);
				break;
			}
			
		}
		return oneTokenString;
	}

}