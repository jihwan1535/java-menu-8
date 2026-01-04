package menu.model;

public class Coach {

    private final CoachName name;
    private final Menus hateMenus;

    public Coach(CoachName name, Menus hateMenus) {
        this.name = name;
        this.hateMenus = hateMenus;
    }

    public boolean hateMenu(Menu recommendedMenu) {
        return hateMenus.contain(recommendedMenu);
    }

    public String getName() {
        return name.name();
    }
}
