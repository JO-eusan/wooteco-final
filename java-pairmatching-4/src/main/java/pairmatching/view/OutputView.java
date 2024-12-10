package pairmatching.view;

import java.io.FileNotFoundException;
import java.util.List;

import pairmatching.model.Course;
import pairmatching.model.Level;
import pairmatching.model.MissionManager;
import pairmatching.model.Pair;

public class OutputView {

	private static final String ERROR_PREFIX = "[ERROR] ";
	private static final String SEPARATE_LINE = "#############################################";
	private static final String COURSE_MESSAGE = "과정: %s";
	private static final String MISSION_MESSAGE = "미션:";
	private static final String LEVEL_MESSAGE = "  - %s: %s";
	private static final String DELIMITER = " | ";
	private static final String PAIR_RESULT_MESSAGE = "페어 매칭 결과입니다.";

	public void printErrorMessage(IllegalArgumentException e) {
		System.out.println(ERROR_PREFIX + e.getMessage());
	}

	public void printFileErrorMessage(FileNotFoundException e) {
		System.out.println(ERROR_PREFIX + e.getMessage());
	}

	public void printCourse(MissionManager missionManager) {
		System.out.println();
		System.out.println(SEPARATE_LINE);
		System.out.printf(COURSE_MESSAGE + "\n", String.join(DELIMITER, Course.getNames()));
		System.out.println(MISSION_MESSAGE);
		for(Level level : Level.values()) {
			System.out.printf(LEVEL_MESSAGE + "\n", level, String.join(DELIMITER, missionManager.findByLevel(level)));
		}
		System.out.println(SEPARATE_LINE);
	}

	public void printPairs(List<Pair> pairs) {
		System.out.println();
		System.out.println(PAIR_RESULT_MESSAGE);
		for(Pair pair : pairs) {
			System.out.println(pair);
		}
		System.out.println();
	}
}
