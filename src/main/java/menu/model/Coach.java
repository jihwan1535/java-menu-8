package menu.model;

import java.util.Objects;

public class Coach {

    private final String name;

    public Coach(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("코치 이름은 비어있을 수 없습니다.");
        }
        if (name.length() < 2) {
            throw new IllegalArgumentException("코치 이름은 최소 2자 이상으로 입력해야 합니다.");
        }
        if (name.length() > 4) {
            throw new IllegalArgumentException("코치 이름은 최대 4자 이하로 입력해야 합니다.");
        }
        this.name = name;
    }

    public String name() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Coach coach = (Coach) o;
        return Objects.equals(name, coach.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
