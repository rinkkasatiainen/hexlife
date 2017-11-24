package hexlife;

import java.util.*;
import java.util.function.Consumer;

class LivingCells {
    private final Set<Cell> cells;

    public LivingCells(Set<Cell> cells) {
        this.cells = new HashSet<>(cells); // defensive copy
    }

    public static LivingCells of(Cell... cells) {
        return new LivingCells(new HashSet<>(Arrays.asList(cells)));
    }

    private boolean isLiving(Cell cell) {
        return cells.contains(cell);
    }

    public void evolveCell(Cell cell, CellRule.OnLiving onLiving) {
        ruleFor(cell).decide(this::isLiving, onLiving); // NOPMD, LoD does not like method handles?
    }

    private CellRule ruleFor(Cell cell) {
        if (isLiving(cell)) {
            return new LivingCellRule(cell);
        }
        return new DeadCellRule(cell);
    }

    public void forEachNeighbour(Consumer<Cell> handler) {
        neighbours().forEach(handler); // NOPMD
    }

    private Neighbours neighbours() {
        return cells.stream(). // NOPMD
                map(Cell::firstTierNeighbours). //
                reduce(Neighbours.none(), Neighbours::merge);
    }

    public void display(Display display) {
        BoundingBox areaToDisplay = minimumCell().to(maximumCell());
        areaToDisplay.eachRow(row -> displayRow(row, display));
    }

    private void displayRow(BoundingBox row, Display display) {
        display.startRow();
        row.eachColumn(cell -> displayCell(cell, display));
        display.nextRow();
    }

    private Cell minimumCell() {
        return new Cell('a', 1); // TODO later cells.reduce, with Cell::min
    }

    private Cell maximumCell() {
        return new Cell('b', 2); // TODO later cells.reduce, with Cell::max
    }

    private void displayCell(Cell cell, Display display) {
        if (isLiving(cell)) {
            display.cell();
        } else {
            display.empty();
        }
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
