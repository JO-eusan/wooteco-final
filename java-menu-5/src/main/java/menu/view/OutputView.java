package menu.view;

import menu.model.CategoryManager;
import menu.model.CoachManager;
import menu.model.domain.Coach;

public class OutputView {

	private static final String ERROR_PREFIX = "[ERROR] ";
	private static final String RESULT_MESSAGE = "메뉴 추천 결과입니다.";
	private static final String WEEK_MESSAGE = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";
	private static final String CATEGORY_MESSAGE = "[ 카테고리 | %s ]";
	private static final String COACH_FORMAT_MESSAGE = "[ %s | %s ]";
	private static final String RESULT_END_MESSAGE = "추천을 완료했습니다.";
	private static final String DELIMITER = " | ";

	public void printErrorMessage(IllegalArgumentException e) {
		System.out.println(ERROR_PREFIX + e.getMessage());
	}

	public void printResult(CategoryManager categoryManager, CoachManager coachManager) {
		System.out.println();
		System.out.println(RESULT_MESSAGE);
		System.out.println(WEEK_MESSAGE);
		System.out.println(String.format(CATEGORY_MESSAGE, String.join(DELIMITER, categoryManager.getCategoryNames())));

		for(Coach coach : coachManager.getCoaches()) {
			System.out.println(String.format(COACH_FORMAT_MESSAGE, coach.getName(), String.join(DELIMITER, coach.getPickedMenus())));
		}
		System.out.println();
		System.out.println(RESULT_END_MESSAGE);
	}
}
