package hexlife;

import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class CellSurvivesShould {

    private Cell lastCell;

    @Test
    public void create_a_new_cell_if_should_born() {
        CellSurvives cellWillSurvive = new CellWillSurvive();

        Cell cell = new Cell('a', 1);
        cellWillSurvive.onSurvival(cell, this::addToLivingCells);

        assertThat(lastCell, equalTo(cell));
    }

    private void addToLivingCells(Cell cell){
        lastCell = cell;
    }
}
