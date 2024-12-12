package store.model;

import java.util.ArrayList;
import java.util.List;

import store.model.domain.PurchasedProduct;

public class Consumer {
	List<PurchasedProduct> purchasedProducts;

	public Consumer(String productNames, Inventory inventory) {
		String[] tokens = productNames.split(",");
		validateSize(tokens);
		validateFormat(tokens);

		this.purchasedProducts = createProducts(tokens, inventory);
	}

	public List<PurchasedProduct> getPurchasedProducts() {
		return purchasedProducts;
	}

	private void validateSize(String[] tokens) {
		if(tokens.length == 0) {
			throw new IllegalArgumentException("상품을 하나 이상 입력하세요.");
		}
	}

	private void validateFormat(String[] tokens) {
		for(String token : tokens) {
			if(token.charAt(0) != '[' || token.charAt(token.length()-1) != ']') {
				throw new IllegalArgumentException("알맞은 형식이 아닙니다.");
			}
			if(!token.substring(1, token.length()-1).matches("(.*)-(.*)")) {
				throw new IllegalArgumentException("알맞은 형식이 아닙니다.");
			}
		}
	}

	private List<PurchasedProduct> createProducts(String[] tokens, Inventory inventory) {
		List<PurchasedProduct> purchasedProducts = new ArrayList<>();
		for(String token : tokens) {
			String[] productAndQuantity = token.substring(1, token.length()-1).split("-");
			purchasedProducts.add(new PurchasedProduct(inventory.findByName(productAndQuantity[0]), 0, 0, 0));
		}
		return purchasedProducts;
	}

}
