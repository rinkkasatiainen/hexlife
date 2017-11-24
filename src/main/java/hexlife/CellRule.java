package hexlife;

import java.util.function.Predicate;

interface CellRule {

    @FunctionalInterface
    interface OnLiving {
        void accept(Cell cell);
    }

    void decide(CountOfFirstTierNeighbours first, CountOfSecondTierNeighbours second, OnLiving handler);

    void decide(Predicate<Cell> predicate, OnLiving handler);


    default CountOfFirstTierNeighbours firstTierNeighboursOf(Cell cell, Predicate<Cell> isLiving) {
        int count = countLivingOf(cell.firstTierNeighbours(), isLiving); // hiding the usage of return value. is this LoD?
        return new CountOfFirstTierNeighbours(count);
    }

    default CountOfSecondTierNeighbours secondTierNeighboursOf(Cell cell, Predicate<Cell> isLiving) {
        int count = countLivingOf(cell.secondTierNeighbours(), isLiving);
        return new CountOfSecondTierNeighbours(count);
    }

    default int countLivingOf(Neighbours neighbours, Predicate<Cell> isLiving) {
        return neighbours.count(isLiving);
    }

}
