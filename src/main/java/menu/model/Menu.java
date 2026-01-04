package menu.model;

import static menu.model.Category.ASIAN;
import static menu.model.Category.CHINESE;
import static menu.model.Category.JAPANESE;
import static menu.model.Category.KOREAN;
import static menu.model.Category.WESTERN;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Menu {
    GYUDON(JAPANESE, "규동"),
    UDON(JAPANESE, "우동"),
    MISO_SOUP(JAPANESE, "미소시루"),
    SUSHI(JAPANESE, "스시"),
    KATSUDON(JAPANESE, "가츠동"),
    ONIGIRI(JAPANESE, "오니기리"),
    HIGH_RICE(JAPANESE, "하이라이스"),
    RAMEN(JAPANESE, "라멘"),
    OKONOMIYAKI(JAPANESE, "오코노미야끼"),

    GIMBAP(KOREAN, "김밥"),
    KIMCHI_SOUP(KOREAN, "김치찌개"),
    SSAMBAP(KOREAN, "쌈밥"),
    SOY_BEAN_SOUP(KOREAN, "된장찌개"),
    BIBIMBAP(KOREAN, "비빔밥"),
    KALGUKSU(KOREAN, "칼국수"),
    BULGOGI(KOREAN, "불고기"),
    TTEOKBOKKI(KOREAN, "떡볶이"),
    STIR_FRIED_PORK(KOREAN, "제육볶음"),

    KKANPUNGGI(CHINESE, "깐풍기"),
    FRIED_NOODLES(CHINESE, "볶음면"),
    DONGPO_MEAT(CHINESE, "동파육"),
    JJAJANGMYEON(CHINESE, "짜장면"),
    JJAMBBONG(CHINESE, "짬뽕"),
    MAPO_TOFU(CHINESE, "마파두부"),
    SWEET_AND_SOUR_PORK(CHINESE, "탕수육"),
    STIR_FIRED_TOMATO_EGG(CHINESE, "토마토 달걀볶음"),
    RED_PEPPER_JAPCHAE(CHINESE, "고추잡채"),

    PAD_THAI(ASIAN, "팟타이"),
    KHAO_PHAT(ASIAN, "카오 팟"),
    NASI_GORENG(ASIAN, "나시고렝"),
    PINEAPPLE_FRIED_RICE(ASIAN, "파인애플 볶음밥"),
    RICE_NODDLE(ASIAN, "쌀국수"),
    TOM_YUM_GOONG(ASIAN, "똠얌꿍"),
    BANH_MI(ASIAN, "반미"),
    VIETNAMESE_SPRING_ROLL(ASIAN, "월남쌈"),
    BUNJJA(ASIAN, "분짜"),

    LASAGNA(WESTERN, "라자냐"),
    GRATIN(WESTERN, "그라탱"),
    GNOCCHI(WESTERN, "뇨끼"),
    QUICHE(WESTERN, "끼슈"),
    FRENCH_TOAST(WESTERN, "프렌치 토스트"),
    BAGUETTE(WESTERN, "바게트"),
    PASTA(WESTERN, "스파게티"),
    PIZZA(WESTERN, "피자"),
    PANINI(WESTERN, "파니니"),
    ;

    private final Category category;
    private final String menu;

    Menu(Category category, String menu) {
        this.category = category;
        this.menu = menu;
    }

    public static Menu from(String menuName) {
        return Arrays.stream(values())
                .filter(menu -> menu.menu.equals(menuName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 메뉴입니다."));
    }

    public static List<String> getMenuNamesByCategory(Category category) {
        return Arrays.stream(values())
                .filter(menu -> menu.category == category)
                .map(menu -> menu.menu)
                .collect(Collectors.toList());
    }

    public String menu() {
        return menu;
    }
}
