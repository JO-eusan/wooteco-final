package oncall.model.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DayWork {
	private List<String> names;

	public DayWork(String input) {
		String[] names = input.split(",");
		validateName(names);
		validateDuplicate(names);

		this.names = Arrays.asList(names);
	}

	public List<String> getNames() {
		return names;
	}

	private void validateName(String[] names) {
		for(String name : names) {
			if(name.length() < 1 || name.length() > 5) {
				throw new IllegalArgumentException("이름의 길이는 1~5 사이어야 합니다.");
			}
		}
	}

	private void validateDuplicate(String[] names) {
		List<String> result = new ArrayList<>();
		for(String name : names) {
			if(result.contains(name)) {
				throw new IllegalArgumentException("중복된 이름은 불가능합니다.");
			}
			result.add(name);
		}
	}
}
