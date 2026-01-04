package menu.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Recommender {

    private static final int WEEKDAY_COUNT = 5;

    private final Map<Coach, Menus> recommendedMenus;
    private final Categories categories;
    private final Coaches coaches;

    private Recommender(Categories categories, Coaches coaches) {
        this.recommendedMenus = new LinkedHashMap<>();
        this.categories = categories;
        this.coaches = coaches;
    }

    public static Recommender from(Coaches coaches) {
        return new Recommender(Categories.creatEmpty(), coaches);
    }

    private static Menu recommendMenu(Coach coach, List<Menu> menus) {
        Menu recommendedMenu = Randoms.shuffle(menus).get(0);
        while (coach.hateMenu(recommendedMenu)) {
            recommendedMenu = Randoms.shuffle(menus).get(0);
        }
        return recommendedMenu;
    }

    public void choiceWeekCategories() {
        while (categories.size() < WEEKDAY_COUNT) {
            Category category = createNewCategory();
            categories.add(category);
        }
    }

    public void recommendMenus() {
        for (Coach coach : coaches.coaches()) {
            Menus menus = recommendMenu(coach);
            recommendedMenus.put(coach, menus);
        }
    }

    private Menus recommendMenu(Coach coach) {
        Menus recommendedMenus = new Menus(new ArrayList<>());
        for (Category category : categories.categories()) {
            List<Menu> menus = Menu.getMenusByCategory(category);
            Menu recommendedMenu = recommendMenu(coach, menus);
            recommendedMenus.add(recommendedMenu);
        }
        return recommendedMenus;
    }

    private Category createNewCategory() {
        Category category = Category.from(Randoms.pickNumberInRange(1, 5));
        while (this.categories.count(category) == 2) {
            category = Category.from(Randoms.pickNumberInRange(1, 5));
        }
        return category;
    }

    public List<Category> getCategories() {
        return categories.categories();
    }

    public Map<Coach, Menus> getRecommendedMenus() {
        return recommendedMenus;
    }
}
