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
        Generation emptyGeneration = new Generation(Collections.emptyList());

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
        List<Cell> seed = Arrays.asList(aCell, cell2, cell3);
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
    }

    private class Generation {

        private final List<Cell> cells;

        public Generation(List<Cell> seed) {
            this.cells = seed;
        }

        public FirstTierNeighbours firstTierNeighboursOf(Cell cell) {
            List<Cell> neighbours = Arrays.asList(new Cell('b', 2), new Cell('c', 2));
            int count = (int) neighbours.stream().filter( c -> this.cells.contains(c)).count();
            return new FirstTierNeighbours(count);
        }
    }
}
