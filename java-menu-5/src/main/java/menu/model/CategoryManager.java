package menu.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import menu.model.domain.Category;

public class CategoryManager {
	List<Category> pickedCategory;
	HashMap<Category, Integer> counter;

	public CategoryManager() {
		this.counter = new HashMap<>();
		for(Category category : Category.values()) {
			counter.put(category, 0);
		}
		this.pickedCategory = createCategories();
	}

	public List<Category> getPickedCategory() {
		return pickedCategory;
	}

	public List<String> getCategoryNames() {
		List<String> names = new ArrayList<>();
		for(Category category : pickedCategory) {
			names.add(category.name);
		}
		return names;
	}

	private List<Category> createCategories() {
		List<Category> categories = new ArrayList<>();
		for(int i=0; i<5; i++) {
			categories.add(pickCategory());
		}
		return categories;
	}

	private Category pickCategory() {
		Category category = Category.pickCategory(Randoms.pickNumberInRange(1, 5));
		while (counter.get(category) > 2) {
			category = Category.pickCategory(Randoms.pickNumberInRange(1, 5));
		}
		counter.put(category, counter.get(category) + 1);

		return category;
	}
}
