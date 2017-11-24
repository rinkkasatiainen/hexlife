package hexlife;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class LivingCellRuleDecidesThat {

    private LivingCellRule rule;
    private Cell lastCell;

    private void setLastCell(Cell cell) {
        lastCell = cell;
    }

    @Before
    public void createRule() {
        Cell aCell = new Cell('b', 2);
        this.rule = new LivingCellRule(aCell);
    }

    @Test
    public void a_live_cell_survives_with_two_first_tier_neighbours() {
        CountOfFirstTierNeighbours countOfFirstTierNeighbours = new CountOfFirstTierNeighbours(2);
        CountOfSecondTierNeighbours countOfSecondTierNeighbours = new CountOfSecondTierNeighbours(0);
        rule.onLiving(countOfFirstTierNeighbours, countOfSecondTierNeighbours, this::setLastCell);

        assertThat(lastCell, equalTo(new Cell('b', 2)));
    }

}
