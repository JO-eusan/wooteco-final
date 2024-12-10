package pairmatching.controller;

import pairmatching.model.Crew;
import pairmatching.model.CrewManager;
import pairmatching.model.Mission;
import pairmatching.model.MissionManager;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MatchingController {
	private InputView inputView;
	private OutputView outputView;
	private CrewManager crewManager;
	private MissionManager missionManager;

	public MatchingController(CrewManager crewManager, MissionManager missionManager) {
		this.inputView = new InputView();
		this.outputView = new OutputView();
		this.crewManager = crewManager;
		this.missionManager = missionManager;
	}

	public void startMatching() {
		while(true) {
			String function = selectFunction();
			if(function.equals("Q")) {
				break;
			}

			executeFunction(Integer.parseInt(function));
		}
	}

	private String selectFunction() {
		try {
			String function = inputView.readFunction();
			return function;
		} catch(IllegalArgumentException e) {
			outputView.printErrorMessage(e);
			selectFunction();
		}
		return "";
	}

	private void executeFunction(int functionNumber) {
		if(functionNumber == 1) {
			pairMatching();
		}
		if(functionNumber == 2) {
			pairCheck();
		}
		if(functionNumber == 3) {
			pairReset();
		}
	}

	private void pairMatching() {

	}

	private void pairCheck() {

	}

	private void pairReset() {

	}
}
