package menu.view;

import java.util.List;
import java.util.stream.Collectors;
import menu.model.Category;
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
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        printRecommendedCategories(recommender.getCategories());

        System.out.println();
        System.out.println("추천을 완료했습니다.");
    }
}
