package hexlife;

import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class GenerationShould {


    @Ignore
    @Test
    public void generationThatStaysTheSame() {

        LivingCells seed = LivingCells.of(
                new Cell('c', 3),new Cell('c', 2),new Cell('b', 2)
        );
        Generation generation = Generation.withSeed(seed);

        Generation next = generation.tick( );

        LivingCells secondGeneration = LivingCells.of(
                new Cell('b', 1),new Cell('b', 3),new Cell('d', 3)
        );
        Generation expected = Generation.withSeed(secondGeneration);
        assertThat(next, equalTo(expected));
    }

    static class Generation {
        private final LivingCells livingCells;
        Rules rules = new Rules();

        public Generation(LivingCells seed) {
            this.livingCells = seed;
        }

        public static Generation withSeed(LivingCells seed) {
            return new Generation(seed);
        }

        public Generation tick() {
            // Cell upperLeft = livingCells.upperLeftCorner();
            // Cell lowerRight = livingCells.lowerRightCorner();

//            List<Cell> x = livingCells.neighbours();
//            x.stream().forEach(cell ->xx(cell));
//            return new Generation(nextLivingCells);

            return null;
        }
//
//        private void xx(Cell cell) {
//            CountOfFirstTierNeighbours a = livingCells.firstTierNeighboursOf(cell);
//            CountOfSecondTierNeighbours b = livingCells.secondTierNeighboursOf(cell);
//
//            if (livingCells.isLiving(cell)) {
//                CellSurvives survives = rules.survives(a, b);
//                survives.x(() -> nextLivingCells.add(cell));
//            } else {
//                CellBornInEmptySpace cellBornInEmptySpace = rules.bornInEmptySpace(a, b);
//                cellBornInEmptySpace.x(cell, nextLivingCells);
//            }
//        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Generation that = (Generation) o;
            return livingCells.equals(that.livingCells);
        }

        @Override
        public int hashCode() {
            return livingCells.hashCode();
        }


        @Override
        public String toString() {
            return "Generation{" +
                    "livingCells=" + livingCells +
                    '}';
        }
    }
}
