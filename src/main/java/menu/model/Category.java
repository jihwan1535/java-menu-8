package menu.model;

import java.util.Arrays;

public enum Category {
    JAPANESE(1, "일식"),
    KOREAN(2, "한식"),
    CHINESE(3, "중식"),
    ASIAN(4, "아시안"),
    WESTERN(5, "양식");

    private final int option;
    private final String name;

    Category(int option, String name) {
        this.option = option;
        this.name = name;
    }

    public static Category from(int option) {
        return Arrays.stream(values())
                .filter(category -> category.option == option)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("카테고리는 1번부터 5번까지 존재합니다."));
    }

    public String getName() {
        return name;
    }
}
