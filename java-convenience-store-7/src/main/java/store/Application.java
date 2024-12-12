package store;

import store.controller.BuyingController;
import store.controller.FileController;
import store.model.Inventory;
import store.model.PromotionManager;

public class Application {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        PromotionManager promotionManager = new PromotionManager();

        FileController fileController = new FileController(inventory, promotionManager);
        BuyingController buyingController = new BuyingController(inventory, promotionManager);

        fileController.initializeData("src/main/resources/promotions.md", "src/main/resources/products.md");
        buyingController.startPurchase();
    }
}
