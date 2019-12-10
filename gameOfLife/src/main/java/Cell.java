public class Cell {
    int x;
    int y;
    CellState state;

    public Cell(int x, int y, CellState cellState) {
        this.x = x;
        this.y = y;
        this.state = cellState;
    }

    @Override
    public boolean equals(Object object) {
        Cell that = (Cell) object;
        if(this.x==that.x && this.y==that.y)
            return this.state == that.state;
        return false;
    }
}
