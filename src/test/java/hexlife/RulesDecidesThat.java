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
        FirstTierNeighbours firstTierNeighbours = new FirstTierNeighbours(2);
        SecondTierNeighbours secondTierNeighbours = new SecondTierNeighbours(1);
        CellBornInEmptySpace isBorn = rules.bornInEmptySpace(firstTierNeighbours, secondTierNeighbours);

        assertThat(isBorn, equalTo(new CellIsBornInEmptySpace()));
    }

    @Test
    public void a_cell_is_not_born_if_too_few_first_tier_neighbours() {
        FirstTierNeighbours firstTierNeighbours = new FirstTierNeighbours(0);
        SecondTierNeighbours secondTierNeighbours = new SecondTierNeighbours(6);
        CellBornInEmptySpace isBorn = rules.bornInEmptySpace(firstTierNeighbours, secondTierNeighbours);

        assertThat(isBorn, equalTo(new CellIsNotBornInEmptySpace()));
    }

    @Test
    public void a_live_cell_survives_with_two_first_tier_neighbours() {
        FirstTierNeighbours firstTierNeighbours = new FirstTierNeighbours(2);
        SecondTierNeighbours secondTierNeighbours = new SecondTierNeighbours(0);
        CellSurvives hasSurvived = rules.survives(firstTierNeighbours, secondTierNeighbours);

        assertThat(hasSurvived, equalTo(new CellWillSurvive()));
    }

    private class Rules {
        public CellBornInEmptySpace bornInEmptySpace(FirstTierNeighbours firstTierNeighbours, SecondTierNeighbours secondTierNeighbours) {
            double weight = firstTierNeighbours.weight() + secondTierNeighbours.weight();
            if (2.3 <= weight && weight <= 2.9) {
                return new CellIsBornInEmptySpace();
            }
            return new CellIsNotBornInEmptySpace();
        }

        public CellSurvives survives(FirstTierNeighbours firstTierNeighbours, SecondTierNeighbours secondTierNeighbours) {
            double weight = firstTierNeighbours.weight() + secondTierNeighbours.weight();
            if (2.0 <= weight && weight <= 3.3) {
                return new CellWillSurvive();
            }
            return new CellWillNotSurvive();
        }
    }


    private class FirstTierNeighbours {

        private final int numberOfNeighbours;

        public FirstTierNeighbours(int numberOfNeighbours) {
            this.numberOfNeighbours = numberOfNeighbours;
        }

        public double weight() {
            return numberOfNeighbours * 1.0;
        }
    }

    private class SecondTierNeighbours {

        private final int numberOfNeighbours;

        public SecondTierNeighbours(int numberOfNeighbours) {
            this.numberOfNeighbours = numberOfNeighbours;
        }

        public double weight() {
            return numberOfNeighbours * 0.3;
        }
    }

    private class CellIsBornInEmptySpace implements CellBornInEmptySpace {
        @Override
        public boolean equals(Object obj) {
            return obj != null && getClass() == obj.getClass();
        }
    }

    private class CellIsNotBornInEmptySpace implements CellBornInEmptySpace {
        @Override
        public boolean equals(Object obj) {
            return obj != null && getClass() == obj.getClass();
        }
    }

    private class CellWillSurvive implements CellSurvives {
        @Override
        public boolean equals(Object obj) {
            return obj != null && getClass() == obj.getClass();
        }
    }

    private class CellWillNotSurvive implements CellSurvives {
        @Override
        public boolean equals(Object obj) {
            return obj != null && getClass() == obj.getClass();
        }
    }
}
