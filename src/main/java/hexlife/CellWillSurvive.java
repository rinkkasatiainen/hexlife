package hexlife;

class CellWillSurvive implements CellSurvives {
    @Override
    public boolean equals(Object obj) {
        return obj != null && getClass() == obj.getClass();
    }
}
