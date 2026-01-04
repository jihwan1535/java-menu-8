package menu.view;

public class OutputView {

    public void printError(String message) {
        System.out.printf("[ERROR] %s%n", message);
    }

    public void printIntro() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }
}
