package hexlife;

class FirstTierNeighbours {

    private final int numberOfNeighbours;

    public FirstTierNeighbours(int numberOfNeighbours) {
        this.numberOfNeighbours = numberOfNeighbours;
    }

    public double weight() {
        return numberOfNeighbours * 1.0;
    }
}
