package pairmatching.view;

import java.util.Scanner;

public class InputView {
	private Scanner scanner = new Scanner(System.in);
	private static final String SELECT_FUNCTION_MESSAGE = "기능을 선택하세요.";
	public static final String FUNCTION_1 = "1. 페어 매칭";
	public static final String FUNCTION_2 = "2. 페어 조회";
	public static final String FUNCTION_3 = "3. 페어 초기화";
	public static final String FUNCTION_Q = "Q. 종료";
	private static final String WINNING_NUMBER_MESSAGE = "";

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

	public String readWinningNumber() {
		System.out.println(WINNING_NUMBER_MESSAGE);

		return scanner.nextLine();
	}

	private void validateFunction(String input) {
		if(!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("Q")) {
			throw new IllegalArgumentException("제공하지 않는 기능입니다.");
		}
	}
}
