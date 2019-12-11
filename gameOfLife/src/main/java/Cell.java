import java.util.Objects;

public class Cell {
    int x;
    int y;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object object) {
        Cell that = (Cell) object;
        if(this.x==that.x && this.y==that.y)
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x,y);
    }
}
