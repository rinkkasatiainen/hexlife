package hexlife;

class Generation {
    private final LivingCells livingCells;

    private Generation(LivingCells seed) {
        this.livingCells = seed;
    }

    public static Generation withSeed(LivingCells seed) {
        return new Generation(seed);
    }

    public Generation evolve() {
        CollectNextLivingCells nextLivingCells = new CollectNextLivingCells();

        livingCells.forEachNeighbour(cell -> evolve(cell, nextLivingCells));

        return new Generation(nextLivingCells.asLiving());
    }

    private void evolve(Cell cell, CollectNextLivingCells nextLivingCells) {
        CellRule cellRule = livingCells.whenLiving(cell);
        CountOfFirstTierNeighbours first = livingCells.firstTierNeighboursOf(cell);
        CountOfSecondTierNeighbours second = livingCells.secondTierNeighboursOf(cell);

        cellRule.onLiving(first, second, nextLivingCells::add); // TODO LoD
    }

    // TODO later method with side effect to display

    // only for test

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
