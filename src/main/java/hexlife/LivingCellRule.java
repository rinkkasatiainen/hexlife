package hexlife;

class LivingCellRule implements CellRule {
    private final Cell cell;

    public LivingCellRule(Cell cell) {
        this.cell = cell;
    }

    @Override
    public void onLiving(CountOfFirstTierNeighbours first, CountOfSecondTierNeighbours second, OnLiving survives) {
        double weight = first.weight() + second.weight();
        if (2.0 <= weight && weight <= 3.3) {
            survives.accept(cell);
        }
    }

}
