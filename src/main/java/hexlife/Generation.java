package hexlife;

import java.util.HashSet;
import java.util.Set;

class Generation {
    private final Rules rules = new Rules();
    private final LivingCells livingCells;

    public Generation(LivingCells seed) {
        this.livingCells = seed;
    }

    public static Generation withSeed(LivingCells seed) {
        return new Generation(seed);
    }

    public Generation tick() {
        Neighbours allNeighbours = livingCells.neighbours();
        Set<Cell> cells = new HashSet<>();
        allNeighbours.forEach((c) -> xx(c, cells));
        LivingCells nextLivingCells = new LivingCells(cells);
        return new Generation(nextLivingCells);
    }

    private void xx(Cell cell, Set<Cell> nextLivingCells) {
        CountOfFirstTierNeighbours first = livingCells.firstTierNeighboursOf(cell);
        CountOfSecondTierNeighbours second = livingCells.secondTierNeighboursOf(cell);

        if (livingCells.isLiving(cell)) {
            CellSurvives survives = rules.survives(first, second);
            survives.onSurvival(cell, (c) -> nextLivingCells.add(c));
        } else {
            CellBornInEmptySpace cellBornInEmptySpace = rules.bornInEmptySpace(first, second);
            cellBornInEmptySpace.onBirth(cell, (c) -> nextLivingCells.add(c));
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Generation that = (Generation) obj;
        return livingCells.equals(that.livingCells);
    }

    @Override
    public int hashCode() {
        return livingCells.hashCode();
    }


    @Override
    public String toString() {
        return "Generation{" + livingCells + '}';
    }
}
