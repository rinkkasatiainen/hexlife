package hexlife;

class Rules {
    public CellBornInEmptySpace bornInEmptySpace(CountOfFirstTierNeighbours countOfFirstTierNeighbours, CountOfSecondTierNeighbours countOfSecondTierNeighbours) {
        double weight = countOfFirstTierNeighbours.weight() + countOfSecondTierNeighbours.weight();
        if (2.3 <= weight && weight <= 2.9) {
            return new CellIsBornInEmptySpace();
        }
        return new CellIsNotBornInEmptySpace();
    }

    public CellSurvives survives(CountOfFirstTierNeighbours countOfFirstTierNeighbours, CountOfSecondTierNeighbours countOfSecondTierNeighbours) {
        double weight = countOfFirstTierNeighbours.weight() + countOfSecondTierNeighbours.weight();
        if (2.0 <= weight && weight <= 3.3) {
            return new CellWillSurvive();
        }
        return new CellWillNotSurvive();
    }
}
