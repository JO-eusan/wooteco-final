package oncall.model.domain;

public enum DayOfWeek {
	MONDAY("월"),
	TUESDAY("화"),
	WEDNESDAY("수"),
	THURSDAY("목"),
	FRIDAY("금"),
	SATURDAY("토"),
	SUNDAY("일");

	private String name;

	private DayOfWeek(String name) {
		this.name = name;
	}

	public static boolean isDayOfWeek(String str) {
		for (DayOfWeek dayOfWeek : values()) {
			if (str.equals(dayOfWeek.name)) {
				return true;
			}
		}
		return false;
	}

	public static boolean isWeekend(String str) {
		if (str.equals(SATURDAY.name) || str.equals(SUNDAY.name)) {
			return true;
		}
		return false;
	}

	public static String getNextDay(String currentDay) {
		for (int i = 0; i < values().length; i++) {
			if (currentDay.equals(values()[i].name)) {
				return values()[(i + 1) % values().length].name;
			}
		}
		return "";
	}
}
