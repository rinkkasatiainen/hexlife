package hexlife;

import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;

import static jdk.internal.dynalink.support.Guards.isNull;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class DeadCellRuleShould {

    private DeadCellRule rules;
    private Cell lastCell;

    @Before
    public void createRules() {
        this.rules = new DeadCellRule(new Cell('a', 1));
    }

    @Test
    public void a_cell_is_born_on_lower_range() {
        CountOfFirstTierNeighbours countOfFirstTierNeighbours = new CountOfFirstTierNeighbours(2);
        CountOfSecondTierNeighbours countOfSecondTierNeighbours = new CountOfSecondTierNeighbours(1);
        rules.onLiving(countOfFirstTierNeighbours, countOfSecondTierNeighbours,
                cell -> lastCell = cell);

        assertThat(lastCell, equalTo(new Cell('a', 1)));
    }

    @Test
    public void a_cell_is_not_born_if_too_few_first_tier_neighbours() {
        CountOfFirstTierNeighbours countOfFirstTierNeighbours = new CountOfFirstTierNeighbours(0);
        CountOfSecondTierNeighbours countOfSecondTierNeighbours = new CountOfSecondTierNeighbours(6);
        rules.onLiving(countOfFirstTierNeighbours, countOfSecondTierNeighbours,
                cell -> lastCell = cell);

        assertThat(lastCell, nullValue());
    }

}
