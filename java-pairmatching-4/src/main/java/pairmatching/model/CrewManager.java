package pairmatching.model;

import java.util.ArrayList;
import java.util.List;

public class CrewManager {
	private List<Crew> crews;

	public CrewManager() {
		this.crews = new ArrayList<>();
	}

	public List<Crew> getCrews() {
		return crews;
	}

	public void addCrew(Crew crew) {
		crews.add(crew);
	}
}
