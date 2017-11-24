package hexlife;

import java.util.Arrays;

class Seed {
    private final CollectNextLivingCells cells = new CollectNextLivingCells();

    public static Seed from(String cellCoordinates) { // NOPMD primitive on boundary
        return new Seed(cellCoordinates);
    }

    private Seed(String cellCoordinates) {
        if (!cellCoordinates.isEmpty()) {
            Arrays.stream(each(cellCoordinates)). //
                    map(this::parse). //
                    forEach(cells::add);
        }
    }

    private String[] each(String cellCoordinates) {
        return cellCoordinates.split(",");
    }

    private Cell parse(String coordinate) {
        char x = coordinate.charAt(0);
        int y = Integer.parseInt(coordinate.substring(1));
        return new Cell(x, y);
    }

    public LivingCells toLivingCells() {
        return cells.asLiving();
    }
}
