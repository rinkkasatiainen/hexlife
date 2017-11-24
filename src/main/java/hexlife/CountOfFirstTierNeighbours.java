package hexlife;

class CountOfFirstTierNeighbours {

    private final int numberOfNeighbours;

    CountOfFirstTierNeighbours(int numberOfNeighbours) {
        this.numberOfNeighbours = numberOfNeighbours;
    }

    public double weight() {
        return numberOfNeighbours * 1.0;
    }


    // only for test, is this good? now we have the weight and could delete this code again
    // on the other hand a value object by definition would need that because of "value"

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
        return "CountOfFirstTierNeighbours{" + numberOfNeighbours + '}';
    }
}
