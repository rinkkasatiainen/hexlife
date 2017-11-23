package hexlife;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class RulesShould {

    @Test
    public void a_cell_is_born() throws Exception {
        Rules rules = new Rules();

        FirstTierNeighbours firstTierNeighbours = new FirstTierNeighbours(2);
        SecondTierNeighbours secondTierNeighbours = new SecondTierNeighbours(1);
        boolean isAlive = rules.isBornInEmptySpace(firstTierNeighbours, secondTierNeighbours);

        assertThat(isAlive, equalTo(true));
    }

    private class Rules {
        public boolean isBornInEmptySpace(FirstTierNeighbours firstTierNeighbours, SecondTierNeighbours secondTierNeighbours) {
            return true;
        }
    }

    private class FirstTierNeighbours {
        public FirstTierNeighbours(int numberOfNeighbours) {
        }
    }

    private class SecondTierNeighbours {
        public SecondTierNeighbours(int numberOfNeighbours) {
        }
    }
}
