package pairmatching.view;

import java.util.Scanner;

import pairmatching.model.Course;
import pairmatching.model.Level;
import pairmatching.model.MissionManager;

public class InputView {
	private Scanner scanner = new Scanner(System.in);
	private static final String SELECT_FUNCTION_MESSAGE = "기능을 선택하세요.";
	public static final String FUNCTION_1 = "1. 페어 매칭";
	public static final String FUNCTION_2 = "2. 페어 조회";
	public static final String FUNCTION_3 = "3. 페어 초기화";
	public static final String FUNCTION_Q = "Q. 종료";
	private static final String SELECT_COURSE_MESSAGE = "과정, 레벨, 미션을 선택하세요.\nex) 백엔드, 레벨1, 자동차경주";
	private static final String EXIST_MATCHING_MESSAGE = "매칭 정보가 있습니다. 다시 매칭하시겠습니까?\n네 | 아니오";

	public String readFunction() {
		System.out.println(SELECT_FUNCTION_MESSAGE);
		System.out.println(FUNCTION_1);
		System.out.println(FUNCTION_2);
		System.out.println(FUNCTION_3);
		System.out.println(FUNCTION_Q);

		String input = scanner.nextLine();
		validateFunction(input);
		return input;
	}

	public String readCourse(MissionManager missionManager) {
		System.out.println(SELECT_COURSE_MESSAGE);
		String input = scanner.nextLine();
		validateCourse(input, missionManager);

		return input;
	}

	public String readYesOrNo() {
		System.out.println();
		System.out.println(EXIST_MATCHING_MESSAGE);

		String input = scanner.nextLine();
		validateAnswer(input);

		return input;
	}

	private void validateFunction(String input) {
		if(!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("Q")) {
			throw new IllegalArgumentException("제공하지 않는 기능입니다.");
		}
	}

	private void validateCourse(String input, MissionManager missionManager) {
		String[] tokens = input.split(", ");
		if(tokens.length != 3) {
			throw new IllegalArgumentException("과정, 레벨, 미션을 모두 입력하세요.");
		}
		if(!Course.validateInclusion(tokens[0]) || !Level.validateInclusion(tokens[1])
			|| !missionManager.findByLevel(Level.getLevel(tokens[1])).contains(tokens[2])) {
			throw new IllegalArgumentException("제공하는 과정, 레벨, 미션을 입력하세요.");
		}
	}

	private void validateAnswer(String input) {
		if(!input.equals("네") && !input.equals("아니오")) {
			throw new IllegalArgumentException("예, 아니오만 가능합니다.");
		}
	}
}
