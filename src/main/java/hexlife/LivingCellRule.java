package hexlife;

class LivingCellRule extends CellRule {

    public LivingCellRule(Cell cell) {
        super(cell);
    }

    @Override
    public void decide(CountOfFirstTierNeighbours first, CountOfSecondTierNeighbours second, OnLiving survives) {
        double weight = first.weight() + second.weight();
        if (2.0 <= weight && weight <= 3.3) {
            survives.accept(this.cell);
        }
    }


}
