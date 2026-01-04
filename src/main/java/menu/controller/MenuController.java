package menu.controller;

import java.util.List;
import java.util.function.Consumer;
import menu.model.Coach;
import menu.model.CoacheNames;
import menu.model.Coaches;
import menu.model.Menus;
import menu.model.Recommender;
import menu.util.ExceptionHandler;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {

    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    private static Recommender recommendMenu(Coaches coaches) {
        Recommender recommender = Recommender.from(coaches);
        recommender.choiceWeekCategories();
        return recommender;
    }

    public void run() {
        outputView.printIntro();

        Coaches coaches = createCoaches();
        Recommender recommender = recommendMenu(coaches);

        outputView.printRecommendResult(recommender);
    }

    private Coaches createCoaches() {
        CoacheNames coacheNames = ExceptionHandler.handle(inputView::readCoaches, processError());
        List<Coach> coaches = coacheNames.map(coach -> {
            Menus hateMenus = ExceptionHandler.handle(() -> inputView.readHateMenuByCoach(coach), processError());
            return new Coach(coach, hateMenus);
        });
        return new Coaches(coaches);
    }

    private Consumer<IllegalArgumentException> processError() {
        return (e) -> outputView.printError(e.getMessage());
    }
}
