package oncall.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import oncall.model.domain.OneDay;

public class SequenceManager {
	private List<String> orderResult;

	public SequenceManager() {
		this.orderResult = new ArrayList<>();
	}

	public List<String> getOrderResult() {
		return orderResult;
	}

	public void addWorkers(CalenderGenerator calenderGenerator, DayWork dayWork, DayOffWork dayOffWork) {
		for (OneDay day : calenderGenerator.getAllDay()) {
			if (day.isDayOffWork()) {
				orderResult.add(dayOffWork.pickWorker());
				continue;
			}
			orderResult.add(dayWork.pickWorker());
		}
	}

	public void changeDuplicate() {
		for (int i = 0; i < orderResult.size() - 2; i++) {
			if (isDuplicate(orderResult.get(i), orderResult.get(i + 1))) {
				Collections.swap(orderResult, i + 1, i + 2);
			}
		}
	}

	private boolean isDuplicate(String name1, String name2) {
		if (name1.equals(name2)) {
			return true;
		}
		return false;
	}

}
