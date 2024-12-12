package store.model;

import java.util.ArrayList;
import java.util.List;

import store.model.domain.Promotion;

public class PromotionManager {
	private List<Promotion> promotions;

	public PromotionManager() {
		this.promotions = new ArrayList<>();
	}

	public void addPromotion(Promotion promotion) {
		promotions.add(promotion);
	}

	public Promotion findByName(String name) {
		for(Promotion promotion : promotions) {
			if(name.equals(promotion.getName())) {
				return promotion;
			}
		}
		return null;
	}

}
