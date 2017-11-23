package hexlife;

import java.util.function.Consumer;

class DeadCellRule implements CellRule {
    private final Cell cell;

    public DeadCellRule(Cell cell) {
        this.cell = cell;
    }

    @Override
    public void onLiving(Rules rules, CountOfFirstTierNeighbours first, CountOfSecondTierNeighbours second, Consumer<Cell> handler) {
        CellBornInEmptySpace cellBornInEmptySpace = rules.bornInEmptySpace(first, second);
        cellBornInEmptySpace.onBirth(cell, handler);
    }
}
