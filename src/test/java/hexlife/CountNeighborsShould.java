package hexlife;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class CountNeighborsShould {

    @Test
    public void find_0_first_tier_neighbours_for_any_cell() {
        Cell anyCell = getAnyCell();
        LivingCells livingCells = LivingCells.none();

        FirstTierNeighbours firstTierNeighbours = livingCells.firstTierNeighboursOf(anyCell);

        assertThat(firstTierNeighbours, equalTo(new FirstTierNeighbours(0)));
    }

    private Cell getAnyCell() {
        return new Cell('a', 1);
    }

    @Test
    public void find_first_tier_neighbours_for_a_cell_in_initial_seed() {
        Cell aCell = new Cell('c', 3);
        Cell cell2 = new Cell('c', 2);
        Cell cell3 = new Cell('b', 2);
        LivingCells seed = LivingCells.of(aCell, cell2, cell3);

        FirstTierNeighbours firstTierNeighbours = seed.firstTierNeighboursOf(aCell);

        assertThat(firstTierNeighbours, equalTo(new FirstTierNeighbours(2)));
    }

    static class Cell {
        private final char x;
        private final int y;

        public Cell(char x, int y) {
            this.x = x;
            this.y = y;
        }

        public Neighbours firstTierNeighbours() {
            return Neighbours.of(
                    new Cell('b', 2),
                    new Cell('c', 2),
                    new Cell('d', 3),
                    new Cell('d', 4),
                    new Cell('c', 4),
                    new Cell('b', 3)
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

    static class LivingCells {
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

        public FirstTierNeighbours firstTierNeighboursOf(Cell cell) {
            int count = countLivingOf(cell.firstTierNeighbours()); // hiding the usage of return value. is this LoD?
            return new FirstTierNeighbours(count);
        }

        private int countLivingOf(Neighbours neighbours) {
            return neighbours.count(this::isLiving);
        }

        public boolean isLiving(Cell cell) {
            return cells.contains(cell);
        }

    }

    static class Neighbours {
        private final List<Cell> cells;

        private Neighbours(List<Cell> cells) {
            this.cells = cells;
        }

        public static Neighbours of(Cell c1, Cell c2, Cell c3, Cell c4, Cell c5, Cell c6) {
            return new Neighbours(Arrays.asList(c1, c2, c3, c4, c5, c6));
            // asList is a function of [] which should be there, an extension methods
            // or it is a named constructor/factory which should be ok?
        }

        int count(Predicate<Cell> predicate) {
            return (int) cells.stream().filter(predicate).count(); // leave LoD violation, because loop is "stupid"
        }
    }
}
