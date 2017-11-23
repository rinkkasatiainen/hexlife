package hexlife;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

class LivingCells {
    private final List<Cell> cells;

    private LivingCells(List<Cell> cells) {
        this.cells = cells;
    }

    public static LivingCells of(Cell... cells) {
        return new LivingCells(Arrays.asList(cells));
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
        return neighbours.count(this::isLiving);
    }

    boolean isLiving(Cell cell) {
        return cells.contains(cell);
    }

    public Neighbours neighbours() {
        return cells.stream(). //
                map(c -> c.firstTierNeighbours()). //
                reduce(Neighbours.none(), (n1, n2) -> n1.merge(n2));
    }

    // this class gets long. we say this is because of the Java verbose methods we need below this line

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
