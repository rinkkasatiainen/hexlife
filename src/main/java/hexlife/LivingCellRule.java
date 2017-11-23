package hexlife;

import java.util.function.Consumer;

class LivingCellRule implements CellRule {
    private final Cell cell;

    public LivingCellRule(Cell cell) {
        this.cell = cell;
    }

    @Override
    public void onLiving(Rules rules, CountOfFirstTierNeighbours first, CountOfSecondTierNeighbours second, Consumer<Cell> handler) {
        CellSurvives survives = rules.survives(first, second);
        survives.onSurvival(cell, handler);
    }
}
