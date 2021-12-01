package tud.ai2.solitaire.model.comparator;

import java.util.Comparator;

import tud.ai2.solitaire.model.HighscoreEntry;

public class TimeComparator implements Comparator<HighscoreEntry> {

	@Override
	public int compare(HighscoreEntry entry0, HighscoreEntry entry1) {
		// TODO Auto-generated method stub
		if (entry0.getTime() > entry1.getTime())
			return 1;
		else if (entry0.getTime() < entry1.getTime())
			return -1;
		else {
			return entry0.getName().compareToIgnoreCase(entry1.getName());
		}
	}


}
