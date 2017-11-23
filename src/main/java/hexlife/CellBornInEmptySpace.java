package hexlife;

import java.util.function.Consumer;

public interface CellBornInEmptySpace {
    void onBirth(Cell cell, Consumer<Cell> callback);
}
