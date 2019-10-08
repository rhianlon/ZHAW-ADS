package ch.zhaw.rhiana.ads.Praktikum03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import ch.zhaw.rhiana.ads.CommandExecutor;

public class CompetitorServer implements CommandExecutor {
	
	private static final Comparator<Competitor> COMPARATOR_TIME = 
			Comparator.comparing(Competitor::getTime);
	private static final Comparator<Competitor> COMPARATOR_NAME =
			Comparator
				.comparing(Competitor::getName)
				.thenComparing(Competitor::getJg);
	
	
	/**
	 * @param rangliste einzulesene .csv Datei
	 * @return Resultierende Rangliste entweder nach Zeit oder Name sortiert
	 */
	@Override
	public String execute(String rangliste) throws Exception {
		List<Competitor> competitorList = parseRangliste(rangliste);
		Collections.sort(competitorList, COMPARATOR_TIME);
		

		for (int i = 0; i<competitorList.size();i++) {
			Competitor competitor = competitorList.get(i);
			competitor.setRank(i + 1);
			
		}
		Collections.sort(competitorList, COMPARATOR_NAME); // change to COMPARATOR_TIME for sorting for time 
		String result = "";
		for (int i = 0; i<competitorList.size();i++) {
			Competitor competitor = competitorList.get(i);
			result += competitor.toString()+"\n";
		
		}
		return "RANG:STARTNr:NAME:JAHRG:ORT:ZEIT \n" + result + "\n";
	}
	/**
	 * 
	 * @param rangliste einzulesene .csv Datei
	 * @return List of competitors added
	 * @throws IOException
	 * @throws NumberFormatException
	 * @throws ParseException
	 */
	public List<Competitor> parseRangliste(String rangliste) throws IOException, NumberFormatException, ParseException{
		List<Competitor> competitorList = new ArrayList<>();
		BufferedReader br = new BufferedReader(new StringReader(rangliste));
		String line = null;
		while ((line = br.readLine()) != null) {
			String[] oneCompetitor = line.split(";");
			Competitor comp = new Competitor(
				Integer.valueOf(oneCompetitor[0]), //StartNr
				oneCompetitor[1], //Name
				Integer.valueOf(oneCompetitor[2]), //Jahrgang
				oneCompetitor[3], // Country
				oneCompetitor[4] //time
						
			);
					
			competitorList.add(comp);
		}
		return competitorList;
		
	}
}
