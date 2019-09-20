package ch.zhaw.rhiana.ads.Praktikum01;

public class Help {

	public static void main(String[] args) {
		String hallo = getNextToken("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + 
				"<note>\r\n" + 
				"<to>Tove</to>\r\n" + 
				"<from>Jani</from> \r\n" + 
				"<heading>Reminder</heading>\r\n" + 
				"<body>Don't forget me this weekend!</body>\r\n" + 
				"</note>");
		System.out.println(hallo);
	}
	
	public static String getNextToken(String xmlFile) {
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

}
