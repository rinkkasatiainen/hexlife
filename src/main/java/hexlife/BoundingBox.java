package hexlife;

import java.util.function.Consumer;

public class BoundingBox {

    private final char top;
    private final int left;
    private final char bottom;
    private final int right;

    BoundingBox(char top, int left, char bottom, int right) {
        this.top = top;
        this.left = left;
        this.bottom = bottom;
        this.right = right;
    }

    void eachRow(Consumer<BoundingBox> rowHandler) {
        for (char x = top; x <= bottom; x++) {
            rowHandler.accept(new BoundingBox(x, left, x, right));
        }
    }

    void eachColumn(Consumer<Cell> cellHandler) {
        for (int y = left; y <= right; y++) {
            cellHandler.accept(new Cell(top, y));
        }
    }
}
