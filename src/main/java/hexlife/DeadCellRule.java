package hexlife;

class DeadCellRule extends CellRule {

    public DeadCellRule(Cell cell) {
        super(cell);
    }

    @Override
    public void decide(CountOfFirstTierNeighbours first, CountOfSecondTierNeighbours second, OnLiving isBorn) {
        double weight = first.weight() + second.weight();
        if (2.3 <= weight && weight <= 2.9) {
            isBorn.accept(cell);
        }
    }

}
