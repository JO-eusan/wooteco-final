package pairmatching.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import pairmatching.model.Course;
import pairmatching.model.Crew;
import pairmatching.model.CrewManager;
import pairmatching.model.MissionManager;
import pairmatching.view.OutputView;

public class FileController {
	OutputView outputView;
	CrewManager crewManager;
	MissionManager missionManager;

	public FileController(CrewManager crewManager, MissionManager missionManager) {
		this.outputView = new OutputView();
		this.crewManager = crewManager;
		this.missionManager = missionManager;
	}

	public void initializeData(String backendPath, String frontendPath) {
		try {
			createCrew(Course.BACKEND, loadFile(backendPath));
			createCrew(Course.FRONTEND, loadFile(frontendPath));
		} catch (FileNotFoundException e) {
			outputView.printFileErrorMessage(e);
		}
	}

	private Scanner loadFile(String filePath) throws FileNotFoundException {
		File file = new File(filePath);
		Scanner scanner = new Scanner(file);

		return scanner;
	}

	private void createCrew(Course course, Scanner scanner) {
		while(scanner.hasNext()) {
			crewManager.addCrew(new Crew(course, scanner.next()));
		}
	}
}
