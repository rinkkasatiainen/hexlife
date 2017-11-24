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

        livingCells.forEachNeighbour(cell -> livingCells.evolveCell(cell, nextLivingCells::add)); // NOPMD

        return new Generation(nextLivingCells.asLiving());
    }

    public void displayOn(Display display) {
        livingCells.display(display);
    }

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
