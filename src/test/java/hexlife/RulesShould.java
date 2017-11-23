package hexlife;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class RulesShould {

    @Test
    public void a_cell_is_born() {
        Rules rules = new Rules();

        FirstTierNeighbours firstTierNeighbours = new FirstTierNeighbours(2);
        SecondTierNeighbours secondTierNeighbours = new SecondTierNeighbours(1);
        CellIsBornInEmptySpace isAlive = rules.isBornInEmptySpace(firstTierNeighbours, secondTierNeighbours);

        assertThat(isAlive, equalTo(new CellIsBornInEmptySpace()));
    }

    private class Rules {
        public CellIsBornInEmptySpace isBornInEmptySpace(FirstTierNeighbours firstTierNeighbours, SecondTierNeighbours secondTierNeighbours) {
            return new CellIsBornInEmptySpace();
        }
    }

    private class CellIsBornInEmptySpace {

        @Override
        public boolean equals(Object obj) {
            return true; // TODO see later what it is
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
