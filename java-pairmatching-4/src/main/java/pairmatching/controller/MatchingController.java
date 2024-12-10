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
		for(Crew crew : crewManager.getCrews()) {
			System.out.println(crew);
		}

		selectFunction();
	}

	private void selectFunction() {
		while(true) {
			String function = inputView.readFunction();
			try {
				validateFunction(function);
			} catch (IllegalArgumentException e) {
				outputView.printErrorMessage(e);
				selectFunction();
			}

			if(function.equals("Q")) {
				break;
			}

			/* 1~3번까지 동작 */



		}
	}

	private void validateFunction(String input) {
		if(!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("Q")) {
			throw new IllegalArgumentException("제공하지 않는 기능입니다.");
		}
	}



}
