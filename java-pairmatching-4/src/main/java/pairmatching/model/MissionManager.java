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

	public List<Mission> getMissions() {
		return missions;
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
