package pairmatching.model;

import java.util.ArrayList;
import java.util.List;

public enum Course {
	BACKEND("백엔드"),
	FRONTEND("프론트엔드");

	private String name;

	Course(String name) {
		this.name = name;
	}

	public static boolean validateInclusion(String input) {
		for(Course course : values()) {
			if(course.name.equals(input)) {
				return true;
			}
		}
		return false;
	}

	public static List<String> getNames() {
		List<String> names = new ArrayList<>();
		for(Course course : values()) {
			names.add(course.name);
		}

		return names;
	}
}
