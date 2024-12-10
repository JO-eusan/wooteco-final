package pairmatching.model.crewManager;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.model.Crew;
import pairmatching.model.Pair;

public class FrontendManager {
	private List<Crew> crews;

	public FrontendManager() {
		this.crews = new ArrayList<>();
	}

	public List<String> getCrewNames() {
		List<String> result = new ArrayList<>();

		for(Crew crew : crews) {
			result.add(crew.getName());
		}
		return result;
	}

	public void addCrew(Crew crew) {
		crews.add(crew);
	}

	public List<Pair> matchPair() {
		List<Pair> pairs = new ArrayList<>();
		List<String> shuffledCrew = Randoms.shuffle(getCrewNames());

		for(int i=0; i<crews.size()/2; i++) {
			pairs.add(new Pair(shuffledCrew.get(0), shuffledCrew.get(1)));
			shuffledCrew.remove(0);
			shuffledCrew.remove(0);
		}
		if(shuffledCrew.size() != 0) {
			pairs.get(pairs.size()-1).addExtraCrew(shuffledCrew.get(0));
		}
		return pairs;
	}
}
