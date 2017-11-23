package hexlife;

class CellIsBornInEmptySpace implements CellBornInEmptySpace {
    @Override
    public boolean equals(Object obj) {
        return obj != null && getClass() == obj.getClass();
    }

}
