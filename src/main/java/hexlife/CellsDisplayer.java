package hexlife;

public class CellsDisplayer {
    private final LivingCells livingCells;

    public CellsDisplayer(LivingCells livingCells) {
        this.livingCells = livingCells;
    }

    public void display(Display display) {
        BoundingBox areaToDisplay = livingCells.minimumCell().to(livingCells.maximumCell());
        areaToDisplay.eachRow(row -> displayRow(row, display));
    }

    private void displayRow(BoundingBox row, Display display) {
        display.startRow();
        row.eachColumn(cell -> displayCell(cell, display));
        display.nextRow();
    }

    private void displayCell(Cell cell, Display display) {
        if (livingCells.isLiving(cell)) {
            display.cell();
        } else {
            display.empty();
        }
    }

}
