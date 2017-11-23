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
            Neighbours allNeighbours = livingCells.neighbours();
            Set<Cell> cells = new HashSet<>();
            allNeighbours.forEach((c) -> xx(c, cells));
            LivingCells nextLivingCells = new LivingCells(cells);
            return new Generation(nextLivingCells);
        }

        private void xx(Cell cell, Set<Cell> nextLivingCells) {
            CountOfFirstTierNeighbours first = livingCells.firstTierNeighboursOf(cell);
            CountOfSecondTierNeighbours second = livingCells.secondTierNeighboursOf(cell);

            if (livingCells.isLiving(cell)) {
                CellSurvives survives = rules.survives(first, second);
                survives.onSurvival(cell, (c) -> nextLivingCells.add(c));
            } else {
                CellBornInEmptySpace cellBornInEmptySpace = rules.bornInEmptySpace(first, second);
                cellBornInEmptySpace.onBirth(cell, (c) -> nextLivingCells.add(c));
            }
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }

            Generation that = (Generation) obj;
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
