package ch.zhaw.rhiana.ads.Praktikum09;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.text.*;

public class Competitor implements Comparable<Competitor> {
	private static final String TABLE_FORMAT = "%-5s\t%-25s\t%-4s\t%-20s\t%-10s\n";
	
	private String name;
	private String country;
	private long time;
	private int jg;
	private int startNr;
	private int rank;

	public Competitor(int startNr, String name, int jg, String country, String time) throws ParseException {
		this.name = name;
		this.country = country;
		this.time = parseTime(time);
		this.jg = jg;
		this.startNr = startNr;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public long getTime() {
		return time;
	}

	public String getName() {
		return name;
	}

	public String getCountry() {
		return country;
	}

	public int getJg() {
		return jg;
	}

	public int getStartNr() {
		return startNr;
	}

	/**
	 * Parse a given time string to milliseconds
	 * @param s the time string
	 * @return the milliseconds
	 * @throws ParseException
	 */
	private static long parseTime(String s) throws ParseException {
		DateFormat sdf = new SimpleDateFormat("HH:mm:ss.S");
		Date date = sdf.parse(s);
		return date.getTime();
	}
	
	/**
	 * Parse the competitors time (milliseconds) into hh:mm:ss format
	 * @return the time in hh:mm:ss format
	 */
	public String parseMilliseconds() {
		return String.format("%02d:%02d:%02d", 
				TimeUnit.MILLISECONDS.toHours(time),
				TimeUnit.MILLISECONDS.toMinutes(time) -  
				TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(time)),
				TimeUnit.MILLISECONDS.toSeconds(time) - 
				TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(time)));   
	}

	@Override
	public int compareTo(Competitor o) {
		if (this.getName().equals(o.getName())) {
			// if names are the same, check for birth year
			if (this.getJg() < o.getJg()) {
				return -1;
			} else if (this.getJg() > o.getJg()) {
				return 1;
			} else {
				return 0;
			}
		} else {
			// if names are not the same
			return this.getName().compareTo(o.getName());
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + jg;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + rank;
		result = prime * result + startNr;
		result = prime * result + (int) (time ^ (time >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Competitor other = (Competitor) obj;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (jg != other.jg)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (rank != other.rank)
			return false;
		if (startNr != other.startNr)
			return false;
		if (time != other.time)
			return false;
		return true;
	}

	
	public String toTableString() {
		return String.format(TABLE_FORMAT, startNr, name, jg, country, parseMilliseconds());
	}
	
	@Override
	public String toString() {
		return "Rank: " + rank + " Start Nr: "  + startNr + " Name: " + name + " Jahrgang: " + jg + " Ort: " + country;
	}
}
