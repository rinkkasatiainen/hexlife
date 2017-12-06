package hexlife;

class CountOfFirstTierNeighbours {

    private final int numberOfNeighbours;

    CountOfFirstTierNeighbours(int numberOfNeighbours) {
        this.numberOfNeighbours = numberOfNeighbours;
    }

    public double weight() {
        return numberOfNeighbours * 1.0;
    }

}
