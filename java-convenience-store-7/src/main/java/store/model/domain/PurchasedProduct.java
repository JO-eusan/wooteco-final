package store.model.domain;

public class PurchasedProduct {
	private Product product;
	private int generalQuantity;
	private int promotionQuantity;
	private int dumQuantity;

	public PurchasedProduct(Product product, int generalQuantity, int promotionQuantity, int dumQuantity) {
		this.product = product;
		this.generalQuantity = generalQuantity;
		this.promotionQuantity = promotionQuantity;
		this.dumQuantity = dumQuantity;
	}
}
