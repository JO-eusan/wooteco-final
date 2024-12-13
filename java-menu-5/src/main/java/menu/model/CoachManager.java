package menu.model;

import java.util.ArrayList;
import java.util.List;

import menu.model.domain.Coach;

public class CoachManager {
	private List<Coach> coaches;

	public CoachManager(String names) {
		String[] tokens = names.split(",");
		validateSize(tokens);

		this.coaches = createCoaches(tokens);
	}

	public List<Coach> getCoaches() {
		return coaches;
	}

	private List<Coach> createCoaches(String[] tokens) {
		List<Coach> coaches = new ArrayList<>();

		for(String name : tokens) {
			coaches.add(new Coach(name));
		}
		return coaches;
	}

	private void validateSize(String[] tokens) {
		if(tokens.length < 2 || tokens.length > 5) {
			throw new IllegalArgumentException("총 인원은 2~5명이어야 합니다.");
		}
	}
}
