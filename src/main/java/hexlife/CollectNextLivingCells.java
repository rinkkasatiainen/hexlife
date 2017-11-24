package hexlife;

import java.util.HashSet;
import java.util.Set;

public class CollectNextLivingCells {
    private final Set<Cell> cells = new HashSet<>();

    public void add(Cell cell) {
        cells.add(cell);
    }

    public LivingCells asLiving() {
        return new LivingCells(cells);
    }
}
