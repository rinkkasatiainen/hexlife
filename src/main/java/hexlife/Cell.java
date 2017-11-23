package hexlife;

class Cell {
    private final char x;
    private final int y;

    public Cell(char x, int y) {
        this.x = x;
        this.y = y;
    }

    public Neighbours firstTierNeighbours() {
        return Neighbours.of(
                new Cell((char) (x - 1), y - 1),
                new Cell(x, y - 1),
                new Cell((char) (x + 1), y),
                new Cell((char) (x + 1), y + 1),
                new Cell(x, y + 1),
                new Cell((char) (x - 1), y)
        );
    }

    public Neighbours secondTierNeighbours() {
        return Neighbours.of(
                new Cell((char) (x - 1), y - 2),
                new Cell((char) (x + 1), y - 1),
                new Cell((char) (x + 2), y + 2),
                new Cell((char) (x + 1), y + 2),
                new Cell((char) (x - 1), y + 1),
                new Cell((char) (x - 2), y - 1)
        );
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Cell that = (Cell) obj;
        return this.x == that.x && this.y == that.y;
    }

    @Override
    public int hashCode() {
        return 31 * x + y;
    }

    @Override
    public String toString() {
        return "Cell{" + "x=" + x + ", y=" + y + '}';
    }
}