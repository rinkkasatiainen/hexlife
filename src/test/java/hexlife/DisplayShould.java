package hexlife;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class DisplayShould {

    @Test
    public void should_sketch_to_console() {
        Generation generation = Generation.withSeed(Seed.from("a1,b2,a2").toLivingCells());
        AsciiDisplay display = new AsciiDisplay();

        generation.displayOn(display);

        assertThat(display.output(), equalTo(" * *\n_ * \n"));
    }

}
