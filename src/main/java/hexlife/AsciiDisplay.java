package hexlife;

class AsciiDisplay implements Display {
    private final StringBuilder out = new StringBuilder();
    private int rows;

    @Override
    public void startRow() {
        rows++;
        if (rows % 2 == 1) {
            nextColumn();
        }
    }

    @Override
    public void cell() {
        out.append('*');
        nextColumn();
    }

    @Override
    public void empty() {
        out.append('_');
        nextColumn();
    }

    private void nextColumn() {
        out.append(' ');
    }

    @Override
    public void nextRow() {
        if (rows % 2 == 1) {
            out.setLength(out.length() - 1);
        }
        out.append('\n');
    }

    public String output() { // NOPMD mapping for boundary
        return out.toString();
    }
}
