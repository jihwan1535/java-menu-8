package menu.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Recommender {

    private static final int WEEKDAY_COUNT = 5;

    private final Categories categories;
    private final Coaches coaches;

    private Recommender(Categories categories, Coaches coaches) {
        this.categories = categories;
        this.coaches = coaches;
    }

    public static Recommender from(Coaches coaches) {
        return new Recommender(Categories.creatEmpty(), coaches);
    }

    public void choiceWeekCategories() {
        while (categories.size() < WEEKDAY_COUNT) {
            Category category = createNewCategory();
            categories.add(category);
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
}
