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

    private static Menu recommendMenuByCoach(Coach coach, List<String> menus, Menus recommendedMenus) {
        Menu recommendedMenu = Menu.from(Randoms.shuffle(menus).get(0));
        while (coach.hateMenu(recommendedMenu) || recommendedMenus.contain(recommendedMenu)) {
            recommendedMenu = Menu.from(Randoms.shuffle(menus).get(0));
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
        for (Category category : categories.categories()) {
            List<String> menus = Menu.getMenuNamesByCategory(category);
            recommendMenu(menus);
        }
    }

    private void recommendMenu(List<String> menus) {
        for (Coach coach : coaches.coaches()) {
            Menus recommendedMenus = this.recommendedMenus.getOrDefault(coach, new Menus(new ArrayList<>()));
            Menu recommendedMenu = recommendMenuByCoach(coach, menus, recommendedMenus);
            recommendedMenus.add(recommendedMenu);
            this.recommendedMenus.put(coach, recommendedMenus);
        }
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
