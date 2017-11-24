package hexlife;

import java.util.function.Predicate;

class DeadCellRule implements CellRule {
    private final Cell cell;

    public DeadCellRule(Cell cell) {
        this.cell = cell;
    }

    @Override
    public void decide(CountOfFirstTierNeighbours first, CountOfSecondTierNeighbours second, OnLiving isBorn) {
        double weight = first.weight() + second.weight();
        if (2.3 <= weight && weight <= 2.9) {
            isBorn.accept(cell);
        }
    }

    @Override
    public void decide(Predicate<Cell> isLiving, OnLiving handler) {
        decide(firstTierNeighboursOf(cell, isLiving), secondTierNeighboursOf(cell, isLiving), handler);
    }

}
