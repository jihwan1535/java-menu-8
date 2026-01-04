package menu.model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CoacheNames {

    private final List<CoachName> coachNames;

    private CoacheNames(List<CoachName> coachNames) {
        if (coachNames.size() < 2) {
            throw new IllegalArgumentException("코치는 최소 2명 이상 입력해야 합니다.");
        }
        if (coachNames.size() > 5) {
            throw new IllegalArgumentException("코치는 최대 5명 이하로 입력해야 합니다.");
        }
        this.coachNames = new ArrayList<>(coachNames);
    }

    public static CoacheNames from(List<String> coachNames) {
        List<CoachName> coaches = coachNames.stream()
                .map(CoachName::new)
                .collect(Collectors.toList());
        return new CoacheNames(coaches);
    }

    public <R> List<R> map(Function<CoachName, R> mapper) {
        return coachNames.stream()
                .map(mapper)
                .collect(Collectors.toList());
    }
}
