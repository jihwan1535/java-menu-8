package menu.view;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import menu.model.Category;
import menu.model.Coach;
import menu.model.Menu;
import menu.model.Menus;
import menu.model.Recommender;

public class OutputView {

    private static void printRecommendedCategories(List<Category> categories) {
        List<String> categoryNames = categories.stream().map(Category::getName).collect(Collectors.toList());
        String categoryNameFormat = String.join(" | ", categoryNames);
        System.out.printf("[ 카테고리 | %s ]%n", categoryNameFormat);
    }

    public void printError(String message) {
        System.out.printf("[ERROR] %s%n", message);
    }

    public void printIntro() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public void printRecommendResult(Recommender recommender) {
        System.out.println();
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        printRecommendedCategories(recommender.getCategories());
        printRecommendedMenuByCoach(recommender.getRecommendedMenus());
        System.out.println();
        System.out.println("추천을 완료했습니다.");
    }

    private void printRecommendedMenuByCoach(Map<Coach, Menus> recommendedMenus) {
        for (Coach coach : recommendedMenus.keySet()) {
            Menus menus = recommendedMenus.get(coach);
            List<String> menuNames = menus.menus().stream().map(Menu::menu).collect(Collectors.toList());
            String menusFormat = String.join(" | ", menuNames);
            System.out.printf("[ %s | %s ]%n", coach.getName(), menusFormat);
        }
    }
}
