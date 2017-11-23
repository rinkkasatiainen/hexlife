package hexlife;

import java.util.function.Consumer;

public interface CellSurvives {
    void onSurvival(Cell cell, Consumer<Cell> handler);
}
