package hexlife;

import java.util.HashSet;
import java.util.Set;

class Generation {
    private final LivingCells livingCells;

    public Generation(LivingCells seed) {
        this.livingCells = seed;
    }

    public static Generation withSeed(LivingCells seed) {
        return new Generation(seed);
    }

    public Generation evolve() {
        Neighbours allNeighbours = livingCells.neighbours();
        Set<Cell> nextCells = new HashSet<>(); // Different level of abstraction
        allNeighbours.forEach(cell -> evolve(cell, nextCells));
        LivingCells nextLivingCells = new LivingCells(nextCells);
        return new Generation(nextLivingCells);
    }

    private void evolve(Cell cell, Set<Cell> nextLivingCells) {
        CellRule cellRule = livingCells.whenLiving(cell);
        CountOfFirstTierNeighbours first = livingCells.firstTierNeighboursOf(cell);
        CountOfSecondTierNeighbours second = livingCells.secondTierNeighboursOf(cell);
        cellRule.onLiving(first, second, nextLivingCells::add);
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
