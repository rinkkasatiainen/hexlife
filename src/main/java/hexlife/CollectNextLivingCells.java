package hexlife;

import java.util.HashSet;
import java.util.Set;

// only place which is mutable, all else is immutable
public class CollectNextLivingCells {
    private final Set<Cell> cells = new HashSet<>();

    public void add(Cell cell) {
        cells.add(cell);
    }

    public LivingCells asLiving() {
        return new LivingCells(cells);
    }
}
