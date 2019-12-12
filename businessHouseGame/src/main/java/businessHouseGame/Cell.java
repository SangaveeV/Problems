package businessHouseGame;

import java.util.Objects;

public class Cell {
    private final int cellPosition;
    private final CellState cellState;

    public Cell(int cellPosition, CellState cellState) {
        this.cellPosition = cellPosition;
        this.cellState = cellState;
    }

    public int getCellPosition() {
        return cellPosition;
    }

    public CellState getCellState() {
        return cellState;
    }

    @Override
    public boolean equals(Object object) {
        Cell that = (Cell) object;
        if (this.cellPosition == that.cellPosition && this.cellState == that.cellState)
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cellPosition, cellState);
    }


}
