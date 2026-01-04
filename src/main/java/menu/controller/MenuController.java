package menu.controller;

import java.util.List;
import java.util.function.Consumer;
import menu.model.Coaches;
import menu.model.Menus;
import menu.model.Recommender;
import menu.util.ExceptionHandler;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {

    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    public void run() {
        outputView.printIntro();

        Coaches coaches = ExceptionHandler.handle(inputView::readCoaches, processError());
        List<Recommender> recommenders = coaches.map(coach -> {
            Menus hateMenus = ExceptionHandler.handle(() -> inputView.readHateMenuByCoach(coach), processError());
            return new Recommender(coach, hateMenus);
        });
    }

    private Consumer<IllegalArgumentException> processError() {
        return (e) -> outputView.printError(e.getMessage());
    }
}
