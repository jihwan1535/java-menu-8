package menu.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Menus {

    private final List<Menu> menus;

    private Menus(List<Menu> menus) {
        this.menus = new ArrayList<>(menus);
    }

    public static Menus createHateMenus(List<String> menuNames) {
        if (menuNames.size() > 2) {
            throw new IllegalArgumentException("못먹는 음식은 최대 2개입니다.");
        }
        List<Menu> menus = menuNames.stream()
                .map(Menu::from)
                .collect(Collectors.toList());
        return new Menus(menus);
    }
}
