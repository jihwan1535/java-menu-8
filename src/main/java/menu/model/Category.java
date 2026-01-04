package menu.model;

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
}
