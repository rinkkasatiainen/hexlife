package hexlife;

class DeadCellRule implements CellRule {
    private final Cell cell;

    public DeadCellRule(Cell cell) {
        this.cell = cell;
    }

    @Override
    public void onLiving(CountOfFirstTierNeighbours first, CountOfSecondTierNeighbours second, OnLiving isBorn) {
        double weight = first.weight() + second.weight();
        if (2.3 <= weight && weight <= 2.9) {
            isBorn.accept(cell);
        }
    }

}
