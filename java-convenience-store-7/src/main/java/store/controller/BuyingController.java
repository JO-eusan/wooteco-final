package store.controller;

import store.model.Inventory;
import store.model.MembershipManager;
import store.model.PromotionManager;
import store.view.InputView;
import store.view.OutputView;

public class BuyingController {
	private InputView inputView;
	private OutputView outputView;
	private MembershipManager membershipManager;
	private Inventory inventory;
	private PromotionManager promotionManager;

	public BuyingController(Inventory inventory, PromotionManager promotionManager) {
		this.inputView = new InputView();
		this.outputView = new OutputView();
		this.membershipManager = new MembershipManager();

		this.inventory = inventory;
		this.promotionManager = promotionManager;
	}

	public void startPurchase() {
		outputView.printStartMessage();
		outputView.printInventory(inventory);


	}


}
