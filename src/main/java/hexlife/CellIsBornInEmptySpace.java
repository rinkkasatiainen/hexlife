package hexlife;

import java.util.function.Consumer;

class CellIsBornInEmptySpace implements CellBornInEmptySpace {
    @Override
    public void onBirth(Cell cell, Consumer<Cell> handler) {
        handler.accept(cell);
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && getClass() == obj.getClass();
    }
}
