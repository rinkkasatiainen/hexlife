package hexlife;

import java.util.function.Consumer;

class CellWillSurvive implements CellSurvives {
    @Override
    public void onSurvival(Cell cell, Consumer<Cell> handler) {
        handler.accept(cell);
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && getClass() == obj.getClass();
    }
}
