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
            return Neighbours.of(new Cell('b', 2), new Cell('c', 2));
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
            int count = countLivingOf(cell.firstTierNeighbours());
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

        public static Neighbours of(Cell... cells) {
            // TODO Add constraint that there must be 6 neighbours
            return new Neighbours(Arrays.asList(cells));
        }

        int count(Predicate<Cell> predicate) {
            return (int) cells.stream().filter(predicate).count();
        }
    }
}
