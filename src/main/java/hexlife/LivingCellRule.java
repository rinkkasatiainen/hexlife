package hexlife;

import java.util.function.Consumer;

class LivingCellRule implements CellRule {
    private final Cell cell;

    public LivingCellRule(Cell cell) {
        this.cell = cell;
    }

    @Override
    public void onLiving(CountOfFirstTierNeighbours first, CountOfSecondTierNeighbours second, Consumer<Cell> handler) {
        CellSurvives survives = survives(first, second);
        survives.onSurvival(cell, handler);
    }

    private CellSurvives survives(CountOfFirstTierNeighbours countOfFirstTierNeighbours, CountOfSecondTierNeighbours countOfSecondTierNeighbours) {
        double weight = countOfFirstTierNeighbours.weight() + countOfSecondTierNeighbours.weight();
        if (2.0 <= weight && weight <= 3.3) {
            return new CellWillSurvive();
        }
        return new CellWillNotSurvive();
    }

}
