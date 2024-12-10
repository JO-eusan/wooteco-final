package pairmatching.model;

public enum Course {
	BACKEND("백엔드"),
	FRONTEND("프론트엔드");

	private String name;

	Course(String name) {
		this.name = name;
	}

	public static void validateInclusion(String input) {
		for(Course course : values()) {
			if(course.name.equals(input)) {
				return;
			}
		}
		throw new IllegalArgumentException("존재하지 않는 코스입니다.");
	}
}
