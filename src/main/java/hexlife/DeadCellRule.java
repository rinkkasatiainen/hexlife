package hexlife;

import java.util.function.Consumer;

class DeadCellRule implements CellRule {
    private final Cell cell;

    public DeadCellRule(Cell cell) {
        this.cell = cell;
    }

    @Override
    public void onLiving(CountOfFirstTierNeighbours first, CountOfSecondTierNeighbours second, Consumer<Cell> handler) {
        CellBornInEmptySpace cellBornInEmptySpace = bornInEmptySpace(first, second);
        cellBornInEmptySpace.onBirth(cell, handler);
    }

    private CellBornInEmptySpace bornInEmptySpace(CountOfFirstTierNeighbours countOfFirstTierNeighbours, CountOfSecondTierNeighbours countOfSecondTierNeighbours) {
        double weight = countOfFirstTierNeighbours.weight() + countOfSecondTierNeighbours.weight();
        if (2.3 <= weight && weight <= 2.9) {
            return new CellIsBornInEmptySpace();
        }
        return new CellIsNotBornInEmptySpace();
    }

}
