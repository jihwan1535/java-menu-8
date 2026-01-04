package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.model.CoachName;
import menu.model.CoacheNames;
import menu.model.Menus;

public class InputView {

    private static String[] parseTokens(String text) {
        return text.split(",");
    }

    public CoacheNames readCoaches() {
        System.out.println();
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        List<String> coachNames = Arrays.stream(parseTokens(Console.readLine()))
                .collect(Collectors.toList());
        return CoacheNames.from(coachNames);
    }

    public Menus readHateMenuByCoach(CoachName coachName) {
        System.out.println();
        System.out.printf("%s(이)가 못 먹는 메뉴를 입력해 주세요.%n", coachName.name());
        List<String> menuNames = Arrays.stream(parseTokens(Console.readLine()))
                .map(String::strip)
                .collect(Collectors.toList());
        return Menus.createHateMenus(menuNames);
    }
}
