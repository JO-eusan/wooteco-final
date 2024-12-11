package oncall;

import oncall.controller.WorkingController;

public class Application {
	public static void main(String[] args) {
		WorkingController workingController = new WorkingController();
		workingController.startAssignment();
	}
}
