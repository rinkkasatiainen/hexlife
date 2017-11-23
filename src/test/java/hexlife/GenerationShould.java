package hexlife;

import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
//            List<Cell> nextLivingCells = x.stream().flatMap(this::xx).collect(Collectors.toList());
//
//
            return null;
        }
//
        private Stream<Cell> xx(Cell cell) {
            List<Cell> nextLivingCells = new ArrayList<>();
            CountOfFirstTierNeighbours a = livingCells.firstTierNeighboursOf(cell);
            CountOfSecondTierNeighbours b = livingCells.secondTierNeighboursOf(cell);

            if (livingCells.isLiving(cell)) {
                CellSurvives survives = rules.survives(a, b);
                survives.onSurvival(cell, (c) -> nextLivingCells.add(c));
            } else {
                CellBornInEmptySpace cellBornInEmptySpace = rules.bornInEmptySpace(a, b);
                cellBornInEmptySpace.onBirth(cell, (c) -> nextLivingCells.add(c));
            }
            return nextLivingCells.stream();
        }

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
