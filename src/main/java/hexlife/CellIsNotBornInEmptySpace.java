package hexlife;

import java.util.function.Consumer;

class CellIsNotBornInEmptySpace implements CellBornInEmptySpace {
    @Override
    public void onBirth(Cell cell, Consumer<Cell> handler) {
        //empty by design
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && getClass() == obj.getClass();
    }
}
