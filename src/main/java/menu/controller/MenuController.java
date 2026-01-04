package menu.controller;

import java.util.List;
import java.util.function.Consumer;
import menu.model.Coach;
import menu.model.CoacheNames;
import menu.model.Coaches;
import menu.model.Menus;
import menu.util.ExceptionHandler;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {

    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    public void run() {
        outputView.printIntro();

        CoacheNames coacheNames = ExceptionHandler.handle(inputView::readCoaches, processError());
        Coaches coaches = createCoaches(coacheNames);
    }

    private Coaches createCoaches(CoacheNames coacheNames) {
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
