package hexlife;

public class CellsDisplayer {
    private final LivingCells livingCells;

    public CellsDisplayer(LivingCells livingCells) {
        this.livingCells = livingCells;
    }

    public void display(Display display) {
        livingCells.onEachRow(row -> displayRow(row, display));
    }

    private void displayRow(BoundingBox row, Display display) {
        display.startRow();
        row.eachColumn(cell -> displayCell(cell, display));
        display.nextRow();
    }

    private void displayCell(Cell cell, Display display) {
        if (livingCells.isLiving(cell)) { // NOPMD because we could add return but symmetry is better here
            display.cell();
        } else {
            display.empty();
        }
    }

}
