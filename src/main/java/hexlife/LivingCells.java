package hexlife;

import java.util.*;

class LivingCells {
    private final Set<Cell> cells;

    public LivingCells(Set<Cell> cells) {
        this.cells = new HashSet<>(cells); // defensive copy
    }

    public static LivingCells of(Cell... cells) {
        return new LivingCells(new HashSet<>(Arrays.asList(cells)));
    }

    public CountOfFirstTierNeighbours firstTierNeighboursOf(Cell cell) {
        int count = countLivingOf(cell.firstTierNeighbours()); // hiding the usage of return value. is this LoD?
        return new CountOfFirstTierNeighbours(count);
    }

    public CountOfSecondTierNeighbours secondTierNeighboursOf(Cell cell) {
        int count = countLivingOf(cell.secondTierNeighbours());
        return new CountOfSecondTierNeighbours(count);
    }

    private int countLivingOf(Neighbours neighbours) {
        return neighbours.count(this::isLiving); // ? LoD
    }

    private boolean isLiving(Cell cell) {
        return cells.contains(cell);
    }

    CellRule whenLiving(Cell cell) {
        if (isLiving(cell)) {
            return new LivingCellRule(cell);
        }
        return new DeadCellRule(cell);
    }

    public Neighbours neighbours() {
        return cells.stream(). //
                map(cell -> cell.firstTierNeighbours()). //
                reduce(Neighbours.none(), (n1, n2) -> n1.merge(n2));
    }

    // this class gets long. we say this is because of the Java verbose methods we need below this line

    // only for tests again

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        LivingCells that = (LivingCells) obj;
        return cells.equals(that.cells);
    }

    @Override
    public int hashCode() {
        return cells.hashCode();
    }

    @Override
    public String toString() {
        return "LivingCells{" + cells + '}';
    }
}
