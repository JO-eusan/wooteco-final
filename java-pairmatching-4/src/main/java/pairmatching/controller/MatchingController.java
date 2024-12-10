package pairmatching.controller;

import pairmatching.model.MissionManager;
import pairmatching.model.crewManager.BackendManager;
import pairmatching.model.crewManager.FrontendManager;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MatchingController {
	private InputView inputView;
	private OutputView outputView;
	private BackendManager backendManager;
	private FrontendManager frontendManager;
	private MissionManager missionManager;

	public MatchingController(BackendManager backendManager, FrontendManager frontendManager, MissionManager missionManager) {
		this.inputView = new InputView();
		this.outputView = new OutputView();
		this.backendManager = backendManager;
		this.frontendManager = frontendManager;
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
		outputView.printCourse(missionManager);
		String[] selectedCourse = selectCourse();
		String course = selectedCourse[0];
		String level = selectedCourse[1];
		String mission = selectedCourse[2];


		if(missionManager.findByLevelAndName(level, mission).getPairs() != null &&
			selectAnswer().equals("아니오")) {
			return;
		}

		if(course.equals("백엔드")) {
			missionManager.matchPair(level, mission, backendManager.matchPair());
		}
		if(course.equals("프론트엔드")) {
			missionManager.matchPair(level, mission, frontendManager.matchPair());
		}
		outputView.printPairs(missionManager.findByLevelAndName(level, mission).getPairs());
	}

	private void pairCheck() {
		outputView.printCourse(missionManager);
		String[] selectedCourse = selectCourse();
		String course = selectedCourse[0];
		String level = selectedCourse[1];
		String mission = selectedCourse[2];

		outputView.printPairs(missionManager.findByLevelAndName(level, mission).getPairs());
	}

	private void pairReset() {
		missionManager.resetAllPairs();
	}

	private String[] selectCourse() {
		try {
			String course = inputView.readCourse(missionManager);
			return course.split(", ");
		} catch(IllegalArgumentException e) {
			outputView.printErrorMessage(e);
			selectCourse();
		}
		return null;
	}

	private String selectAnswer() {
		try {
			String answer = inputView.readYesOrNo();
			return answer;
		} catch(IllegalArgumentException e) {
			outputView.printErrorMessage(e);
			selectAnswer();
		}
		return "";
	}
}
