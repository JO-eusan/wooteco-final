package oncall.model.domain;

public enum LastDayOfMonth {
	JANUARY(1, 31),
	FEBRUARY(2, 28),
	MARCH(3, 31),
	APRIL(4, 30),
	MAY(5, 31),
	JUNE(6, 30),
	JULY(7, 31),
	AUGUST(8, 31),
	SEPTEMBER(9, 30),
	OCTOBER(10, 31),
	NOVEMBER(11, 30),
	DECEMBER(12, 31);

	private int month;
	private int lastDayOfMonth;

	private LastDayOfMonth(int month, int lastDayOfMonth) {
		this.month = month;
		this.lastDayOfMonth = lastDayOfMonth;
	}

	public static int getLastDayOfMonth(int month) {
		for (LastDayOfMonth lastDayOfMonth : values()) {
			if (lastDayOfMonth.month == month) {
				return lastDayOfMonth.lastDayOfMonth;
			}
		}
		return 0;
	}
}
