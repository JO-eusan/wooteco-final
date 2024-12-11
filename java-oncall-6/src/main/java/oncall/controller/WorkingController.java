package oncall.controller;

import oncall.model.CalenderGenerator;
import oncall.view.InputView;
import oncall.view.OutputView;

public class WorkingController {
	private InputView inputView;
	private OutputView outputView;
	private CalenderGenerator calenderGenerator;

	public WorkingController() {
		this.inputView = new InputView();
		this.outputView = new OutputView();
	}

	public void startAssignment() {
		createCalender();

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

}
