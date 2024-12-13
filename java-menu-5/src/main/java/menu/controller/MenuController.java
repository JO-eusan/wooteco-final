package menu.controller;

import menu.model.CategoryManager;
import menu.model.CoachManager;
import menu.model.domain.Coach;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {
	private InputView inputView;
	private OutputView outputView;
	private CoachManager coachManager;
	private CategoryManager categoryManager;

	public MenuController() {
		this.inputView = new InputView();
		this.outputView = new OutputView();
	}

	public void startRecommend() {
		createCoaches();
		enterHateMenus();
		recommend();
	}

	private void createCoaches() {
		try {
			String names = inputView.readNames();
			this.coachManager = new CoachManager(names);
		} catch(IllegalArgumentException e) {
			outputView.printErrorMessage(e);
			createCoaches();
		}
	}

	private void enterHateMenus() {
		for(Coach coach : coachManager.getCoaches()) {
			try {
				String menus = inputView.readMenus(coach.getName());
				coach.addHateMenus(menus);
			} catch (IllegalArgumentException e) {
				outputView.printErrorMessage(e);
				enterHateMenus();
			}
		}
	}

	private void recommend() {
		this.categoryManager = new CategoryManager();


	}

}
