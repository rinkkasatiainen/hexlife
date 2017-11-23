package hexlife;

class Rules {
    public CellBornInEmptySpace bornInEmptySpace(FirstTierNeighbours firstTierNeighbours, SecondTierNeighbours secondTierNeighbours) {
        double weight = firstTierNeighbours.weight() + secondTierNeighbours.weight();
        if (2.3 <= weight && weight <= 2.9) {
            return new CellIsBornInEmptySpace();
        }
        return new CellIsNotBornInEmptySpace();
    }

    public CellSurvives survives(FirstTierNeighbours firstTierNeighbours, SecondTierNeighbours secondTierNeighbours) {
        double weight = firstTierNeighbours.weight() + secondTierNeighbours.weight();
        if (2.0 <= weight && weight <= 3.3) {
            return new CellWillSurvive();
        }
        return new CellWillNotSurvive();
    }
}
