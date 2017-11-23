package hexlife;

import org.junit.Test;

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

}
