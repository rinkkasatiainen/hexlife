package hexlife;

import java.util.function.Predicate;

class LivingCellRule implements CellRule {
    private final Cell cell;

    public LivingCellRule(Cell cell) {
        this.cell = cell;
    }

    @Override
    public void decide(CountOfFirstTierNeighbours first, CountOfSecondTierNeighbours second, OnLiving survives) {
        double weight = first.weight() + second.weight();
        if (2.0 <= weight && weight <= 3.3) {
            survives.accept(cell);
        }
    }

    @Override
    public void decide(Predicate<Cell> isLiving, OnLiving handler) {
        decide(firstTierNeighboursOf(cell, isLiving), secondTierNeighboursOf(cell, isLiving), handler);
    }

}
