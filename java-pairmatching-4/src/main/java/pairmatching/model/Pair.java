package pairmatching.model;

import java.util.ArrayList;
import java.util.List;

public class Pair {
	private List<String> pairedCrew;

	public Pair(String name1, String name2) {
		this.pairedCrew = new ArrayList<>();
		this.pairedCrew.add(name1);
		this.pairedCrew.add(name2);
	}

	public void addExtraCrew(String name) {
		pairedCrew.add(name);
	}

	@Override
	public String toString() {
		return String.join(" : ", pairedCrew);
	}
}
