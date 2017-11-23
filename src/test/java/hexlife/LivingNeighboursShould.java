package hexlife;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class LivingNeighboursShould {

    @Test
    public void find_0_first_tier_neighbours_for_any_cell() {
        Cell anyCell = getAnyCell();
        LivingCells livingCells = LivingCells.none();

        CountOfFirstTierNeighbours countOfFirstTierNeighbours = livingCells.firstTierNeighboursOf(anyCell);

        assertThat(countOfFirstTierNeighbours, equalTo(new CountOfFirstTierNeighbours(0)));
    }

    private Cell getAnyCell() {
        return new Cell('a', 1);
    }

    @Test
    public void find_first_tier_neighbours_for_a_cell_in_initial_seed() {
        Cell aCell = new Cell('c', 3);
        Cell cell2 = new Cell('c', 2);
        Cell cell3 = new Cell('b', 2);
        LivingCells livingCells = LivingCells.of(aCell, cell2, cell3);

        CountOfFirstTierNeighbours countOfFirstTierNeighbours = livingCells.firstTierNeighboursOf(aCell);

        assertThat(countOfFirstTierNeighbours, equalTo(new CountOfFirstTierNeighbours(2)));
    }

    @Test
    public void return_list_of_neighbour_cell() {
        Cell aCell = new Cell('c', 3);
        LivingCells livingCells = LivingCells.of(aCell);

        Neighbours neighbours = livingCells.neighbours();

        List<Cell> exposedCells = new ArrayList<>();
        neighbours.forEach(exposedCells::add);
        assertThat(exposedCells, hasItems(
                new Cell('b', 2),
                new Cell('b', 3),
                new Cell('c', 2),
                new Cell('c', 4),
                new Cell('d', 3),
                new Cell('d', 4)
        ));

    }
}
