package oncall.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private static final String START_MONTH_MESSAGE = "비상 근무를 배정할 월과 시작 요일을 입력하세요> ";
	private static final String DAY_WORKER_MESSAGE = "평일 비상 근무 순번대로 사원 닉네임을 입력하세요> ";
	private static final String DAY_OFF_WORKER_MESSAGE = "휴일 비상 근무 순번대로 사원 닉네임을 입력하세요> ";

	public String readMonth() {
		System.out.print(START_MONTH_MESSAGE);

		return Console.readLine();
	}

	public String readDayWorker() {
		System.out.print(DAY_WORKER_MESSAGE);

		return Console.readLine();
	}

	public String readDayOffWorker() {
		System.out.print(DAY_OFF_WORKER_MESSAGE);

		return Console.readLine();
	}
}
