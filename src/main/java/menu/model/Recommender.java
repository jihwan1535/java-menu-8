package menu.model;

public class Recommender {

    private final Coach coach;
    private final Menus hateMenus;

    public Recommender(Coach coach, Menus hateMenus) {
        this.coach = coach;
        this.hateMenus = hateMenus;
    }
}
