package hexlife;

@FunctionalInterface
interface OnLiving {
    void accept(Cell cell);
}

interface CellRule {
    void onLiving(CountOfFirstTierNeighbours first, CountOfSecondTierNeighbours second, OnLiving handler);
}
