package oncall.controller;

import oncall.model.CalenderGenerator;
import oncall.model.domain.DayOffWork;
import oncall.model.domain.DayWork;
import oncall.view.InputView;
import oncall.view.OutputView;

public class WorkingController {
	private InputView inputView;
	private OutputView outputView;
	private CalenderGenerator calenderGenerator;
	private DayWork dayWork;
	private DayOffWork dayOffWork;

	public WorkingController() {
		this.inputView = new InputView();
		this.outputView = new OutputView();
	}

	public void startAssignment() {
		createCalender();
		createWorker();

	}

	private void createCalender() {
		String input = inputView.readMonth();
		try {
			this.calenderGenerator = new CalenderGenerator(input);
		} catch (IllegalArgumentException e) {
			outputView.printErrorMessage(e);
			createCalender();
		}
	}

	private void createWorker() {
		String dayWorker = inputView.readDayWorker();
		String dayOffWorker = inputView.readDayOffWorker();

		try {
			this.dayWork = new DayWork(dayWorker);
			this.dayOffWork = new DayOffWork(dayOffWorker);
			this.dayOffWork.validateSize(this.dayWork.getNames());
		} catch (IllegalArgumentException e) {
			outputView.printErrorMessage(e);
			createWorker();
		}
	}

}
