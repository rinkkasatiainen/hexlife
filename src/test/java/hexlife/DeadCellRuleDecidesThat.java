package hexlife;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class DeadCellRuleDecidesThat {

    private DeadCellRule rule;

    private Cell lastCell;

    private void setLastCell(Cell cell) {
        lastCell = cell;
    }

    @Before
    public void createRule() {
        Cell aCell = new Cell('a', 1);
        this.rule = new DeadCellRule(aCell);
    }

    @Test
    public void a_cell_is_born_on_lower_range() {
        CountOfFirstTierNeighbours countOfFirstTierNeighbours = new CountOfFirstTierNeighbours(2);
        CountOfSecondTierNeighbours countOfSecondTierNeighbours = new CountOfSecondTierNeighbours(1);
        rule.onLiving(countOfFirstTierNeighbours, countOfSecondTierNeighbours, this::setLastCell);

        assertThat(lastCell, equalTo(new Cell('a', 1)));
    }


    @Test
    public void a_cell_is_not_born_if_too_few_first_tier_neighbours() {
        CountOfFirstTierNeighbours countOfFirstTierNeighbours = new CountOfFirstTierNeighbours(0);
        CountOfSecondTierNeighbours countOfSecondTierNeighbours = new CountOfSecondTierNeighbours(6);
        rule.onLiving(countOfFirstTierNeighbours, countOfSecondTierNeighbours, this::setLastCell);

        assertThat(lastCell, nullValue());
    }

}
