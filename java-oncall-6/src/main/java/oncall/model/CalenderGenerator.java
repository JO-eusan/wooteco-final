package oncall.model;

import java.util.ArrayList;
import java.util.List;

import oncall.model.domain.DayOfWeek;
import oncall.model.domain.LastDayOfMonth;
import oncall.model.domain.OneDay;

public class CalenderGenerator {
	private int month;
	private String startDayOfWeek;
	private List<OneDay> allDay;

	public CalenderGenerator(String input) {
		String[] tokens = input.split(",");
		validateSize(tokens);
		validateMonth(tokens[0]);
		validateDayOfWeek(tokens[1]);

		this.month = Integer.parseInt(tokens[0]);
		this.startDayOfWeek = tokens[1];
		this.allDay = createDays();
	}

	public List<OneDay> getAllDay() {
		return allDay;
	}

	private List<OneDay> createDays() {
		List<OneDay> days = new ArrayList<>();
		int lastDayOfMonth = LastDayOfMonth.getLastDayOfMonth(month);
		String currentDayOfWeek = startDayOfWeek;
		for (int i = 1; i <= lastDayOfMonth; i++) {
			days.add(new OneDay(month, i, currentDayOfWeek));
			currentDayOfWeek = DayOfWeek.getNextDay(currentDayOfWeek);
		}
		return days;
	}

	private void validateSize(String[] input) {
		if (input.length != 2) {
			throw new IllegalArgumentException("월(숫자)와 요일 모두 입력하세요");
		}
	}

	private void validateMonth(String month) {
		try {
			int monthNumber = Integer.parseInt(month);
			if (monthNumber < 1 || monthNumber > 12) {
				throw new IllegalArgumentException("1~12만 입력 가능합니다.");
			}
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("월은 숫자여야 합니다.");
		}
	}

	private void validateDayOfWeek(String dayOfWeek) {
		if (!DayOfWeek.isDayOfWeek(dayOfWeek)) {
			throw new IllegalArgumentException("일~월만 입력 가능합니다.");
		}
	}
}
