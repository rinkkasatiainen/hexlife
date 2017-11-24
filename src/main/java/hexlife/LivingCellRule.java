package hexlife;

import java.util.function.Consumer;

class LivingCellRule implements CellRule {
    private final Cell cell;

    public LivingCellRule(Cell cell) {
        this.cell = cell;
    }

    @Override
    public void onLiving(CountOfFirstTierNeighbours first, CountOfSecondTierNeighbours second, Consumer<Cell> handler) {
        double weight = first.weight() + second.weight();
        if (2.0 <= weight && weight <= 3.3) {
            handler.accept(cell);
        }
    }

}
