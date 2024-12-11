package oncall.model.domain;

public enum Holiday {
	SINJUNG("신정", 1, 1),
	SAMILJUL("삼일절", 3, 1),
	CHILDDAY("어린이날", 5, 5),
	HYUNCHUNGDAY("현충일", 6, 6),
	GWANGBOKJUL("광복절", 8, 15),
	GAECHUNJUL("개천절", 10, 3),
	HANGULNAL("한글날", 10, 9),
	CHRISTMAS("성탄절", 12, 25);

	private String name;
	private int month;
	private int dayOfMonth;

	private Holiday(String name, int month, int dayOfMonth) {
		this.name = name;
		this.month = month;
		this.dayOfMonth = dayOfMonth;
	}

	public static boolean isHoliday(int month, int dayOfMonth) {
		for (Holiday holiday : values()) {
			if(holiday.month == month && holiday.dayOfMonth == dayOfMonth) {
				return true;
			}
		}
		return false;
	}
}
