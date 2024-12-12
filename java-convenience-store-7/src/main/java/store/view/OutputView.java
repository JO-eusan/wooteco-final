package store.view;

import java.io.FileNotFoundException;

import store.model.Inventory;
import store.model.domain.Product;

public class OutputView {

	private static final String ERROR_PREFIX = "[ERROR] ";
	private static final String START_MESSAGE = "안녕하세요. W편의점입니다.";
	private static final String INVENTORY_MESSAGE = "현재 보유하고 있는 상품입니다.";

	public void printErrorMessage(IllegalArgumentException e) {
		System.out.println(ERROR_PREFIX + e.getMessage());
	}

	public void printFileErrorMessage(FileNotFoundException e) {
		System.out.println(ERROR_PREFIX + e.getMessage());
	}

	public void printStartMessage() {
		System.out.println(START_MESSAGE);
	}

	public void printInventory(Inventory inventory) {
		System.out.println(INVENTORY_MESSAGE);
		System.out.println();

		for(Product product : inventory.getProducts()) {
			System.out.println(product);
		}
		System.out.println();
	}
}
