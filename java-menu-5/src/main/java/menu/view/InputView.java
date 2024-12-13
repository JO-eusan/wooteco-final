package menu.view;

import java.util.Scanner;

public class InputView {

	private Scanner scanner = new Scanner(System.in);
	private static final String START_MESSAGE = "점심 메뉴 추천을 시작합니다.";
	private static final String NAMES_MESSAGE = "코치의 이름을 입력해 주세요. (, 로 구분)";
	private static final String MENUS_MESSAGE = "%s(이)가 못 먹는 메뉴를 입력해 주세요.";

	public String readNames() {
		System.out.println(START_MESSAGE);
		System.out.println();
		System.out.println(NAMES_MESSAGE);

		return scanner.nextLine();
	}

	public String readMenus(String name) {
		System.out.println();
		System.out.printf(MENUS_MESSAGE + "\n", name);

		return scanner.nextLine();
	}
}
