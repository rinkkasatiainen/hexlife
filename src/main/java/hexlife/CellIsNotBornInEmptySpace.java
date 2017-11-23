package hexlife;

class CellIsNotBornInEmptySpace implements CellBornInEmptySpace {
    @Override
    public boolean equals(Object obj) {
        return obj != null && getClass() == obj.getClass();
    }
}
