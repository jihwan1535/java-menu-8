package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.model.Coaches;

public class InputView {

    private static String[] parseTokens(String text) {
        return text.split(",");
    }

    public Coaches readCoaches() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        List<String> coachNames = Arrays.stream(parseTokens(Console.readLine()))
                .collect(Collectors.toList());
        return Coaches.from(coachNames);
    }
}
