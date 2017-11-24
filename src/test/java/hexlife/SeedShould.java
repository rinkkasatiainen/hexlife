package hexlife;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class SeedShould {

    @Test
    public void parse_empty_seed() {
        Seed seed = Seed.from("");
        LivingCells livingCells = seed.toLivingCells();
        assertThat(livingCells, equalTo(LivingCells.of()));
    }

    @Test
    public void parse_many_cells() {
        Seed seed = Seed.from("c3,c2,b2,b1,b3,d3");

        LivingCells seedCells = seed.toLivingCells();
        LivingCells expected = LivingCells.of(
                // original three
                new Cell('c', 3),
                new Cell('c', 2),
                new Cell('b', 2),
                // new ones
                new Cell('b', 1),
                new Cell('b', 3),
                new Cell('d', 3)
        );
        assertThat(seedCells, equalTo(expected));
    }

    static class Seed {
        CollectNextLivingCells collect = new CollectNextLivingCells();

        public Seed(String seed) {
            if (!seed.isEmpty()) {
                Arrays.stream(seed.split(",")). //
                        map(s -> new Cell(s.charAt(0), Integer.parseInt(s.substring(1)))). //
                        forEach(collect::add);
            }
        }

        public static Seed from(String seed) {
            return new Seed(seed);
        }

        public LivingCells toLivingCells() {
            return collect.asLiving();
        }
    }
}
