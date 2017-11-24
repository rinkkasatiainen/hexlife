package hexlife;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class LivingCellRuleShould {

    private LivingCellRule rules;
    private Cell lastCell;

    @Before
    public void createRules() {
        this.rules = new LivingCellRule(new Cell('b', 2));
    }

    @Test
    public void a_live_cell_survives_with_two_first_tier_neighbours() {
        CountOfFirstTierNeighbours countOfFirstTierNeighbours = new CountOfFirstTierNeighbours(2);
        CountOfSecondTierNeighbours countOfSecondTierNeighbours = new CountOfSecondTierNeighbours(0);
        rules.onLiving(countOfFirstTierNeighbours, countOfSecondTierNeighbours,
                cell -> lastCell = cell);

        assertThat(lastCell, equalTo(new Cell('b', 2)));
    }

}
