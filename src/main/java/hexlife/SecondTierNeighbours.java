package hexlife;

class SecondTierNeighbours {

    private final int numberOfNeighbours;

    public SecondTierNeighbours(int numberOfNeighbours) {
        this.numberOfNeighbours = numberOfNeighbours;
    }

    public double weight() {
        return numberOfNeighbours * 0.3;
    }
}
