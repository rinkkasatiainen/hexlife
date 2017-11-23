package hexlife;

class FirstTierNeighbours {

    private final int numberOfNeighbours;

    public FirstTierNeighbours(int numberOfNeighbours) {
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
        FirstTierNeighbours that = (FirstTierNeighbours) o;
        return numberOfNeighbours == that.numberOfNeighbours;
    }

    @Override
    public int hashCode() {
        return numberOfNeighbours;
    }
}
