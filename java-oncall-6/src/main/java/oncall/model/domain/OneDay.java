package oncall.model.domain;

public class OneDay {
	private int month;
	private int dayOfMonth;
	private String dayOfWeek;
	private boolean isHoliday;

	public OneDay(int month, int dayOfMonth, String dayOfWeek) {
		this.month = month;
		this.dayOfMonth = dayOfMonth;
		this.dayOfWeek = dayOfWeek;
		this.isHoliday = Holiday.isHoliday(month, dayOfMonth);
	}

	public boolean isDayOffWork() {
		if (isHoliday || DayOfWeek.isWeekend(dayOfWeek)) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		if (isHoliday && !DayOfWeek.isWeekend(dayOfWeek)) {
			return String.format("%d월 %d일 %s(휴일)", month, dayOfMonth, dayOfWeek);
		}
		return String.format("%d월 %d일 %s", month, dayOfMonth, dayOfWeek);
	}
}
