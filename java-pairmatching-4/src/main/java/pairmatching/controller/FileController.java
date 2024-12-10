package pairmatching.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import pairmatching.model.Course;
import pairmatching.model.Crew;
import pairmatching.model.MissionManager;
import pairmatching.model.crewManager.BackendManager;
import pairmatching.model.crewManager.FrontendManager;
import pairmatching.view.OutputView;

public class FileController {
	private OutputView outputView;
	private BackendManager backendManager;
	private FrontendManager frontendManager;
	private MissionManager missionManager;

	public FileController(BackendManager backendManager, FrontendManager frontendManager, MissionManager missionManager) {
		this.outputView = new OutputView();
		this.backendManager = backendManager;
		this.frontendManager = frontendManager;
		this.missionManager = missionManager;
	}

	public void initializeData(String backendPath, String frontendPath) {
		try {
			createBackendCrew(Course.BACKEND, loadFile(backendPath));
			createFrontendCrew(Course.FRONTEND, loadFile(frontendPath));
		} catch (FileNotFoundException e) {
			outputView.printFileErrorMessage(e);
		}
	}

	private Scanner loadFile(String filePath) throws FileNotFoundException {
		File file = new File(filePath);
		Scanner scanner = new Scanner(file);

		return scanner;
	}

	private void createBackendCrew(Course course, Scanner scanner) {
		while(scanner.hasNext()) {
			backendManager.addCrew(new Crew(course, scanner.next()));
		}
	}

	private void createFrontendCrew(Course course, Scanner scanner) {
		while(scanner.hasNext()) {
			frontendManager.addCrew(new Crew(course, scanner.next()));
		}
	}
}
