package store.model.domain;

public class Product {
	private String name;
	private int price;
	private int quantity;
	private Promotion promotion;

	public Product(String name, int price, int quantity, Promotion promotion) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.promotion = promotion;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public Promotion getPromotion() {
		return promotion;
	}

	@Override
	public String toString() {
		String quantityStr = String.valueOf(quantity) + "개";
		if(quantity == 0) {
			quantityStr = "재고 없음";
		}

		if(promotion != null) {
			return String.format("- %s %,d원 %s %s", name, price, quantityStr, promotion.getName());
		}
		return String.format("- %s %,d원 %s", name, price, quantityStr);
	}
}
