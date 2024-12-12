package store.model.domain;

public class PurchasedProduct {
	private Product product;
	private int generalQuantity;
	private int promotionQuantity;

	public PurchasedProduct(Product product, int generalQuantity, int promotionQuantity) {
		this.product = product;
		this.generalQuantity = generalQuantity;
		this.promotionQuantity = promotionQuantity;
	}
}
