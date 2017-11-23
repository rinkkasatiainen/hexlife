package hexlife;

class CountOfFirstTierNeighbours {

    private final int numberOfNeighbours;

    CountOfFirstTierNeighbours(int numberOfNeighbours) {
        this.numberOfNeighbours = numberOfNeighbours;
    }

    public double weight() {
        return numberOfNeighbours * 1.0;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CountOfFirstTierNeighbours that = (CountOfFirstTierNeighbours) o;
        return numberOfNeighbours == that.numberOfNeighbours;
    }

    @Override
    public int hashCode() {
        return numberOfNeighbours;
    }

    @Override
    public String toString() {
        return "CountOfFirstTierNeighbours{" +
                "numberOfNeighbours=" + numberOfNeighbours +
                '}';
    }
}
