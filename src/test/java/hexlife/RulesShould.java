package hexlife;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class RulesShould {

    @Test
    public void a_cell_is_born() throws Exception {
        Rules rules = new Rules();

        boolean isAlive = rules.isBornInEmptySpace(2, 1);

        assertThat(isAlive, equalTo(true));
    }

    private class Rules {
        public boolean isBornInEmptySpace(int firstTierNeighbours, int secondTierNeighbours) {
            return true;
        }
    }
}
