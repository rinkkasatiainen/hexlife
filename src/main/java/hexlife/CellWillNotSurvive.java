package hexlife;


import java.util.function.Consumer;

class CellWillNotSurvive implements CellSurvives {
    @Override
    public void onSurvival(Cell cell, Consumer<Cell> handler) {
        // empty by design
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && getClass() == obj.getClass();
    }
}
