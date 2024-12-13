package menu.model.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import menu.model.CategoryManager;

public class Coach {
	private String name;
	private List<String> hateMenus;
	private List<String> pickedMenus;

	public Coach(String name) {
		validateName(name);
		this.name = name;
		this.pickedMenus = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public List<String> getPickedMenus() {
		return pickedMenus;
	}

	public void addHateMenus(String menus) {
		validateHateMenus(menus);
		this.hateMenus = Arrays.asList(menus.split(","));
	}

	public void addPickedMenus(Category category) {
		pickedMenus.add(pickMenu(category));
	}

	private String pickMenu(Category category) {
		String menu = Category.pickMenu(category);
		while(pickedMenus.contains(menu) || hateMenus.contains(menu)) {
			menu = Category.pickMenu(category);
		}
		return menu;
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
