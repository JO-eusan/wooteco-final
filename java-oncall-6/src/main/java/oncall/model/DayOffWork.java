package oncall.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class DayOffWork {
	private List<String> names;
	private String nextWorker;

	public DayOffWork(String input) {
		String[] names = input.split(",");
		validateName(names);
		validateDuplicate(names);

		this.names = Arrays.asList(names);
		this.nextWorker = names[0];
	}

	public String pickWorker() {
		String pick = this.nextWorker;

		for (int i = 0; i < names.size(); i++) {
			if (pick.equals(names.get(i))) {
				this.nextWorker = names.get((i + 1) % names.size());
			}
		}
		return pick;
	}

	public void validateSize(List<String> dayWorker) {
		HashSet<String> allNames = new HashSet<>();
		for (String name : dayWorker) {
			allNames.add(name);
		}
		for (String name : names) {
			allNames.add(name);
		}

		if (allNames.size() < 5 || allNames.size() > 35) {
			throw new IllegalArgumentException("총 근무 인원은 최소 5명, 최대 35명 이어야 합니다.");
		}
	}

	private void validateName(String[] names) {
		for (String name : names) {
			if (name.length() < 1 || name.length() > 5) {
				throw new IllegalArgumentException("이름의 길이는 1~5 사이어야 합니다.");
			}
		}
	}

	private void validateDuplicate(String[] names) {
		List<String> result = new ArrayList<>();
		for (String name : names) {
			if (result.contains(name)) {
				throw new IllegalArgumentException("중복된 이름은 불가능합니다.");
			}
			result.add(name);
		}
	}
}