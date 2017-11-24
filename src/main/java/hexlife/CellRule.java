package hexlife;

interface CellRule {

    @FunctionalInterface
    interface OnLiving {
        void accept(Cell cell);
    }

    void decide(CountOfFirstTierNeighbours first, CountOfSecondTierNeighbours second, OnLiving handler);

}
