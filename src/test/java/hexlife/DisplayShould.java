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

    private class AsciiDisplay implements Display {
        StringBuilder out = new StringBuilder();
        int rows;

        @Override
        public void startRow() {
            rows++;
            if (rows % 2 == 1) {
                nextColumn();
            }
        }

        @Override
        public void nextColumn() {
            out.append(' ');
        }

        @Override
        public void cell() {
            out.append('*');
        }

        @Override
        public void empty() {
            out.append('_');
        }

        @Override
        public void nextRow() {
            if (rows % 2 == 1) {
                out.setLength(out.length() - 1);
            }
            out.append('\n');
        }

        public String output() {
            return out.toString();
        }
    }
}
