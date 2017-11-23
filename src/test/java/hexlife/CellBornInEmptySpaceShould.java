package hexlife;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class CellBornInEmptySpaceShould {

    private Cell lastCell;

    @Test
    public void create_a_new_cell_if_should_born() {
        CellBornInEmptySpace cellBornInEmptySpace = new CellIsBornInEmptySpace();

        Cell cell = new Cell('a', 1);
        cellBornInEmptySpace.onBirth(cell, this::addToLivingCells);

        assertThat(lastCell, equalTo(cell));
    }

    private void addToLivingCells(Cell cell){
        lastCell = cell;
    }

}
