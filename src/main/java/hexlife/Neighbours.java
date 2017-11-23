package hexlife;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

class Neighbours {
    private final Set<Cell> cells;

    private Neighbours(Set<Cell> cells) {
        this.cells = cells;
    }

    public static Neighbours of(Cell c1, Cell c2, Cell c3, Cell c4, Cell c5, Cell c6) {
        return new Neighbours(new HashSet<>(Arrays.asList(c1, c2, c3, c4, c5, c6)));
        // asList is a function of [] which should be there, an extension methods
        // or it is a named constructor/factory which should be ok?
    }

    int count(Predicate<Cell> predicate) {
        return (int) cells.stream().filter(predicate).count(); // leave LoD violation, because loop is "stupid"
    }

    public Neighbours merge(Neighbours other) {
        return null;
    }
}
