package hexlife;

class Generation {
    private final LivingCells livingCells;

    public Generation(LivingCells seed) {
        this.livingCells = seed;
    }

    public static Generation withSeed(LivingCells seed) {
        return new Generation(seed);
    }

    public Generation evolve() {
        Neighbours allNeighbours = livingCells.neighbours();
        CollectNextLivingCells nextLivingCells = new CollectNextLivingCells();
        allNeighbours.forEach(cell -> livingCells.evolve(cell, nextLivingCells::add));
        return new Generation(nextLivingCells.asLiving());
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
