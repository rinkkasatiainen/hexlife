package hexlife;

import java.util.function.Consumer;

class DeadCellRule implements CellRule {
    private final Cell cell;

    public DeadCellRule(Cell cell) {
        this.cell = cell;
    }

    @Override
    public void onLiving(CountOfFirstTierNeighbours first, CountOfSecondTierNeighbours second, Consumer<Cell> handler) {
        double weight = first.weight() + second.weight();
        if (2.3 <= weight && weight <= 2.9) {
            handler.accept(cell);
        }
    }

}
