package menu.model.domain;

import java.util.Arrays;
import java.util.List;

public class Coach {
	private String name;
	private List<String> hateMenus;

	public Coach(String name) {
		validateName(name);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void addHateMenus(String menus) {
		validateHateMenus(menus);
		this.hateMenus = Arrays.asList(menus.split(","));
	}

	private void validateName(String name) {
		if(name.length() < 2 || name.length() > 4) {
			throw new IllegalArgumentException("이름의 길이는 2~4이어야 합니다.");
		}
	}

	private void validateHateMenus(String hateMenus) {
		if(hateMenus.equals("")) {
			return;
		}
		String[] menus = hateMenus.split(",");

		if(menus.length < 0 || menus.length > 2) {
			throw new IllegalArgumentException("못 먹는 메뉴는 0~2개만 입력 가능합니다.");
		}
		for(String menu : menus) {
			if(!Category.isAvailable(menu)) {
				throw new IllegalArgumentException("존재하지 않는 메뉴입니다.");
			}
		}
	}
}
