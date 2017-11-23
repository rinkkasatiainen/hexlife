package hexlife;

import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class GenerationShould {

    @Test
    public void generationThatStaysTheSame() {
        LivingCells seed = LivingCells.of(
                new Cell('c', 3),
                new Cell('c', 2),
                new Cell('b', 2)
        );
        Generation generation = Generation.withSeed(seed);

        Generation nextGeneration = generation.tick();

        LivingCells nextGenerationCells = LivingCells.of(
                // original three
                new Cell('c', 3),
                new Cell('c', 2),
                new Cell('b', 2),
                // new ones
                new Cell('b', 1),
                new Cell('b', 3),
                new Cell('d', 3)
        );
        Generation expected = Generation.withSeed(nextGenerationCells);
        assertThat(nextGeneration, equalTo(expected));
    }

    static class Generation {
        private final Rules rules = new Rules();
        private final LivingCells livingCells;

        public Generation(LivingCells seed) {
            this.livingCells = seed;
        }

        public static Generation withSeed(LivingCells seed) {
            return new Generation(seed);
        }

        public Generation tick() {
            Neighbours neighbours = livingCells.neighbours();
            Set<Cell> nextLivingCells = new HashSet<>();
            neighbours.forEach((c) -> xx(c, nextLivingCells));

            LivingCells livingCells = new LivingCells(nextLivingCells);
            return new Generation(livingCells);
        }

        private void xx(Cell cell, Set<Cell> nextLivingCells) {
            CountOfFirstTierNeighbours a = livingCells.firstTierNeighboursOf(cell);
            CountOfSecondTierNeighbours b = livingCells.secondTierNeighboursOf(cell);

            if (livingCells.isLiving(cell)) {
                CellSurvives survives = rules.survives(a, b);
                survives.onSurvival(cell, (c) -> nextLivingCells.add(c));
            } else {
                CellBornInEmptySpace cellBornInEmptySpace = rules.bornInEmptySpace(a, b);
                cellBornInEmptySpace.onBirth(cell, (c) -> nextLivingCells.add(c));
            }
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
            return "Generation{" + livingCells + '}';
        }
    }
}
