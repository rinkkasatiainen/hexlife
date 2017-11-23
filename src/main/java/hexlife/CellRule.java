package hexlife;

import java.util.function.Consumer;

interface CellRule {
    // TODO: 4 parameters is waaaay to many.
    void onLiving(Rules rules, CountOfFirstTierNeighbours first, CountOfSecondTierNeighbours second, Consumer<Cell> handler);
}
