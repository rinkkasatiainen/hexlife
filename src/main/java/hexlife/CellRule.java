package hexlife;

interface CellRule {

    @FunctionalInterface
    interface OnLiving {
        void accept(Cell cell);
    }

    void onLiving(CountOfFirstTierNeighbours first, CountOfSecondTierNeighbours second, OnLiving handler);

}
