package menu.model;

import java.util.ArrayList;
import java.util.List;

public class Coaches {

    private final List<Coach> coaches;

    public Coaches(List<Coach> coaches) {
        this.coaches = new ArrayList<>(coaches);
    }

    public List<Coach> coaches() {
        return new ArrayList<>(coaches);
    }
}
