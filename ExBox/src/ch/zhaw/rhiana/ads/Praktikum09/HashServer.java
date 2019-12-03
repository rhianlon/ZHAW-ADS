package ch.zhaw.rhiana.ads.Praktikum09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.text.ParseException;

import ch.zhaw.rhiana.ads.CommandExecutor;

public class HashServer implements CommandExecutor {
	public static final int INDEX_START_NR = 0;
	public static final int INDEX_NAME = 1;
	public static final int INDEX_JAHRGANG = 2;
	public static final int INDEX_COUNTRY = 3;
	public static final int INDEX_TIME = 4;

	
	// Aufgabe 3 - HashMap
//	HashMap<String, Competitor> competitorsMap = new HashMap<>();
	// Aufgabe 4 - MyHashTable
	private final MyHashtable<String, Competitor> competitorsMap = new MyHashtable<>(5000);

	@Override
	public String execute(String command) throws Exception {
		String ausgabe = null;
		String[] commands = command.split(" ");

		if (commands[0].toUpperCase().startsWith("GET")) {
			if (competitorsMap == null || competitorsMap.isEmpty()) {
				ausgabe = "\nCompetitors are not loaded yet!";
			} else {
				String key = commands[1] + " " + commands[2];
				System.out.println();
				ausgabe = "\n" + key.replaceAll(";", " ") + " -> " + competitorsMap.get(key).toString();
			}
		} else {
			readCompetitorsFromCSVString(command);
			ausgabe = "\nCompetitors are loaded!";
		}
		return ausgabe;
	}

	/**
	 * Read in competitors from a comma-separated string
	 * 
	 * @param competitorsCSV the comma-separated string with competitors
	 * @throws NumberFormatException
	 * @throws ParseException
	 * @throws IOException 
	 */
	private void readCompetitorsFromCSVString(String competitorsCSV) throws NumberFormatException, ParseException, IOException {
		BufferedReader br = new BufferedReader(new StringReader(competitorsCSV));
		
		String line = null;
		while ((line = br.readLine()) != null) {
			Competitor competitorToAdd = csvToCompetitor(line);
			competitorsMap.put(getKeyFromCompetitor(competitorToAdd), competitorToAdd);
		}
		
		// you never know
		br.close();
	}

	/**
	 * Make a competitor object from comma-separated data
	 * 
	 * @param csv the competitor data
	 * @return the competitor
	 * @throws NumberFormatException
	 * @throws ParseException
	 */
	private Competitor csvToCompetitor(String csv) throws NumberFormatException, ParseException {
		String[] csvData = csv.split(";");
		return new Competitor(
			Integer.parseInt(csvData[INDEX_START_NR]), 
			csvData[INDEX_NAME], 
			Integer.parseInt(csvData[INDEX_JAHRGANG]), 
			csvData[INDEX_COUNTRY],
			csvData[INDEX_TIME]
		);
	}

	/**
	 * Return a key for a hashmap with competitors
	 * 
	 * @param competitor the competitor from which the key should be generated
	 * @return the key
	 */
	private String getKeyFromCompetitor(Competitor competitor) {
		return String.format("%s;%s", competitor.getName(), competitor.getJg());
	}
}
