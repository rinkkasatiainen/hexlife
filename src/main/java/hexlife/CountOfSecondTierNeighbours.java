package hexlife;

class CountOfSecondTierNeighbours {

    private final int numberOfNeighbours;

    public CountOfSecondTierNeighbours(int numberOfNeighbours) {
        this.numberOfNeighbours = numberOfNeighbours;
    }

    public double weight() {
        return numberOfNeighbours * 0.3;
    }
}
