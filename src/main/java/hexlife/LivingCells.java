package hexlife;

import java.util.Arrays;
import java.util.List;

class LivingCells {
    private final List<Cell> cells;

    private LivingCells(List<Cell> cells) {
        this.cells = cells;
    }

    public static LivingCells of(Cell... cells) {
        return new LivingCells(Arrays.asList(cells));
    }

    public static LivingCells none() {
        return LivingCells.of();
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

    private boolean isLiving(Cell cell) {
        return cells.contains(cell);
    }

}
