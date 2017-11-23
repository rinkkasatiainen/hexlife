package hexlife;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class CountNeighborsShould {

    @Test
    public void find_0_first_tier_neighbours_for_any_cell() {
        Cell anyCell = getAnyCell();
        Generation emptyGeneration = new Generation(Cells.none());

        FirstTierNeighbours firstTierNeighbours = emptyGeneration.firstTierNeighboursOf(anyCell);

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
        Cells seed = Cells.of(aCell, cell2, cell3);
        Generation generation = new Generation(seed);

        FirstTierNeighbours firstTierNeighbours = generation.firstTierNeighboursOf(aCell);

        assertThat(firstTierNeighbours, equalTo(new FirstTierNeighbours(2)));
    }

    private class Cell {
        private final char x;
        private final int y;

        public Cell(char x, int y) {
            this.x = x;
            this.y = y;
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

        public List<Cell> firstTierNeighbour() {
            return Arrays.asList(new Cell('b', 2), new Cell('c', 2));
        }
    }

    private class Generation {

        private final Cells livingCells;

        public Generation(Cells seed) {
            this.livingCells = seed;
        }

        public FirstTierNeighbours firstTierNeighboursOf(Cell cell) {
            int count = (int) cell.firstTierNeighbour(). //
                    stream().filter(c -> livingCells.contains(c)). //
                    count();
            return new FirstTierNeighbours(count);
        }
    }

    private static class Cells {
        private final List<Cell> cells;

        private Cells(List<Cell> cells) {
            this.cells = cells;
        }

        public static Cells of(Cell... cells) {
            return new Cells(Arrays.asList(cells));
        }

        public static Cells none() {
            return Cells.of();
        }

        public boolean contains(Cell c) {
            return cells.contains(c);
        }
    }
}
