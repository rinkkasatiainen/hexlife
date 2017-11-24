package hexlife;

import java.util.function.Predicate;

abstract class CellRule {
    protected final Cell cell;

    public CellRule(Cell cell) {
        this.cell = cell;
    }

    @FunctionalInterface
    interface OnLiving {
        void accept(Cell cell);
    }

    public void decide(Predicate<Cell> isLiving, OnLiving handler) {
        CountOfFirstTierNeighbours first = countFirstTierNeighboursOf(cell, isLiving);
        CountOfSecondTierNeighbours second = countSecondTierNeighboursOf(cell, isLiving);
        decide(first, second, handler);
    }

    private CountOfFirstTierNeighbours countFirstTierNeighboursOf(Cell cell, Predicate<Cell> isLiving) {
        int count = countLivingOf(cell.firstTierNeighbours(), isLiving); // hiding the usage of return value. is this LoD?
        return new CountOfFirstTierNeighbours(count);
    }

    private CountOfSecondTierNeighbours countSecondTierNeighboursOf(Cell cell, Predicate<Cell> isLiving) {
        int count = countLivingOf(cell.secondTierNeighbours(), isLiving);
        return new CountOfSecondTierNeighbours(count);
    }

    private int countLivingOf(Neighbours neighbours, Predicate<Cell> isLiving) {
        return neighbours.count(isLiving);
    }

    protected abstract void decide(CountOfFirstTierNeighbours first, CountOfSecondTierNeighbours second, OnLiving handler);

}
