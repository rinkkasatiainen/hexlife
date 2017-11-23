package hexlife;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class RulesDecidesThat {

    private Rules rules;

    @Before
    public void createRules() {
        this.rules = new Rules();
    }

    @Test
    public void a_cell_is_born_on_lower_range() {
        CountOfFirstTierNeighbours countOfFirstTierNeighbours = new CountOfFirstTierNeighbours(2);
        CountOfSecondTierNeighbours countOfSecondTierNeighbours = new CountOfSecondTierNeighbours(1);
        CellBornInEmptySpace isBorn = rules.bornInEmptySpace(countOfFirstTierNeighbours, countOfSecondTierNeighbours);

        assertThat(isBorn, equalTo(new CellIsBornInEmptySpace()));
    }

    @Test
    public void a_cell_is_not_born_if_too_few_first_tier_neighbours() {
        CountOfFirstTierNeighbours countOfFirstTierNeighbours = new CountOfFirstTierNeighbours(0);
        CountOfSecondTierNeighbours countOfSecondTierNeighbours = new CountOfSecondTierNeighbours(6);
        CellBornInEmptySpace isBorn = rules.bornInEmptySpace(countOfFirstTierNeighbours, countOfSecondTierNeighbours);

        assertThat(isBorn, equalTo(new CellIsNotBornInEmptySpace()));
    }

    @Test
    public void a_live_cell_survives_with_two_first_tier_neighbours() {
        CountOfFirstTierNeighbours countOfFirstTierNeighbours = new CountOfFirstTierNeighbours(2);
        CountOfSecondTierNeighbours countOfSecondTierNeighbours = new CountOfSecondTierNeighbours(0);
        CellSurvives hasSurvived = rules.survives(countOfFirstTierNeighbours, countOfSecondTierNeighbours);

        assertThat(hasSurvived, equalTo(new CellWillSurvive()));
    }
}
