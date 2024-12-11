package oncall.view;

import java.util.List;

import oncall.model.CalenderGenerator;
import oncall.model.SequenceManager;
import oncall.model.domain.OneDay;

public class OutputView {
	private static final String ERROR_PREFIX = "[ERROR] ";
	private static final String CALENDER_FORMAT = "%s %s";

	public void printErrorMessage(IllegalArgumentException e) {
		System.out.println(ERROR_PREFIX + e.getMessage());
	}

	public void printWorkingSheet(CalenderGenerator calenderGenerator, SequenceManager sequenceManager) {
		List<OneDay> allDay = calenderGenerator.getAllDay();
		List<String> names = sequenceManager.getOrderResult();

		System.out.println();
		for (int i = 0; i < allDay.size(); i++) {
			System.out.println(String.format(CALENDER_FORMAT, allDay.get(i), names.get(i)));
		}
	}
}
