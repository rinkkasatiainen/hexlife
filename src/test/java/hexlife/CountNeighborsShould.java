package hexlife;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class CountNeighborsShould {

    @Test
    public void find_0_first_tier_neighbours_for_any_cell() {

        Cell anyCell = new Cell();
        Generation emptyGeneration = new Generation();

        FirstTierNeighbours firstTierNeighbours = emptyGeneration.firstTierNeighboursOf(anyCell);

        assertThat( firstTierNeighbours, equalTo(new FirstTierNeighbours(0)) );
    }

    private class Cell {
    }

    private class Generation {
        public FirstTierNeighbours firstTierNeighboursOf(Cell cell) {
            return new FirstTierNeighbours(0);
        }
    }
}
