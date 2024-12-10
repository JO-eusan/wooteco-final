package pairmatching.model;

import java.util.ArrayList;
import java.util.List;

public class MissionManager {
	private final String LEVEL1_MISSIONS = "자동차경주 로또 숫자야구게임";
	private final String LEVEL2_MISSIONS = "장바구니 결제 지하철노선도";
	private final String LEVEL4_MISSIONS = "성능개선 배포";

	private List<Mission> missions;

	public MissionManager() {
		this.missions = new ArrayList<>();
		setMissions();
	}

	public List<String> findByLevel(Level level) {
		List<String> result = new ArrayList<>();
		for(Mission mission : missions) {
			if(mission.getLevel() == level) {
				result.add(mission.getName());
			}
		}
		return result;
	}

	public Mission findByLevelAndName(String level, String missionName) {
		for(Mission mission : missions) {
			if(mission.getLevel() == Level.getLevel(level) && mission.getName().equals(missionName)) {
				return mission;
			}
		}
		return null;
	}

	public void matchPair(String level, String missionName, List<Pair> pairs) {
		for(Mission mission : missions) {
			if(mission.getLevel() == Level.getLevel(level) && mission.getName().equals(missionName)) {
				mission.setPairs(pairs);
			}
		}
	}

	public void resetAllPairs() {
		for(Mission mission : missions) {
			mission.resetPairs();
		}
	}

	private void setMissions() {
		createMission(Level.LEVEL1, LEVEL1_MISSIONS.split(" "));
		createMission(Level.LEVEL2, LEVEL2_MISSIONS.split(" "));
		createMission(Level.LEVEL4, LEVEL4_MISSIONS.split(" "));
	}

	private void createMission(Level level, String[] list) {
		for(String mission : list) {
			missions.add(new Mission(level, mission));
		}
	}
}
