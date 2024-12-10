package pairmatching.model;

import java.util.List;

public class Mission {
	private Level level;
	private String name;
	private List<Pair> pairs;

	public Mission(Level level, String name) {
		this.level = level;
		this.name = name;
		this.pairs = null;
	}

	public Level getLevel() {
		return level;
	}

	public String getName() {
		return name;
	}

	public List<Pair> getPairs() {
		return pairs;
	}

	public void setPairs(List<Pair> pairs) {
		this.pairs = pairs;
	}

	public void resetPairs() {
		this.pairs = null;
	}
}
