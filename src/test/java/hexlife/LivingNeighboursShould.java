package hexlife;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;

public class LivingNeighboursShould {

    @Test
    public void return_list_of_neighbour_cell() {
        Cell centerCell = new Cell('c', 3);
        LivingCells livingCells = LivingCells.of(centerCell);

        List<Cell> exposedCells = new ArrayList<>();
        livingCells.forEachNeighbour(exposedCells::add);

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
