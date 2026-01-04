package menu.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Coaches {

    private final List<Coach> coaches;

    private Coaches(List<Coach> coaches) {
        if (coaches.size() < 2) {
            throw new IllegalArgumentException("코치는 최소 2명 이상 입력해야 합니다.");
        }
        if (coaches.size() > 5) {
            throw new IllegalArgumentException("코치는 최대 5명 이하로 입력해야 합니다.");
        }
        this.coaches = new ArrayList<>(coaches);
    }

    public static Coaches from(List<String> coachNames) {
        List<Coach> coaches = coachNames.stream()
                .map(Coach::new)
                .collect(Collectors.toList());
        return new Coaches(coaches);
    }
}
