package store.model;

import java.util.ArrayList;
import java.util.List;

import store.model.domain.Product;
import store.model.domain.Promotion;

public class Inventory {
	private List<Product> products;

	public Inventory() {
		this.products = new ArrayList<>();
	}

	public List<Product> getProducts() {
		return products;
	}

	public void addProduct(Product product) {
		products.add(product);
	}

	public Product findByName(String name) {
		for(Product product : products) {
			if(name.equals(product.getName())) {
				return product;
			}
		}
		return null;
	}

	public void createGeneralProduct() {
		for(int i=0; i< products.size(); i++) {
			Product product = products.get(i);

			if(product.getPromotion() != null && !hasGeneralProduct(product.getName())) {
				products.add(i+1, new Product(product.getName(), product.getPrice(), 0, null));
			}
		}
	}

	private boolean hasGeneralProduct(String name) {
		for(Product product : products) {
			if(name.equals(product.getName()) && product.getPromotion() == null) {
				return true;
			}
		}
		return false;
	}
}
