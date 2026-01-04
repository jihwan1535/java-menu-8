package menu.model;

import java.util.ArrayList;
import java.util.List;

public class Categories {

    private final List<Category> categories;

    private Categories(List<Category> categories) {
        this.categories = categories;
    }

    public static Categories creatEmpty() {
        return new Categories(new ArrayList<>());
    }

    public int count(Category candidate) {
        return (int) categories.stream()
                .filter(category -> category == candidate)
                .count();
    }

    public void add(Category category) {
        this.categories.add(category);
    }

    public int size() {
        return categories.size();
    }

    public List<Category> categories() {
        return categories;
    }
}
