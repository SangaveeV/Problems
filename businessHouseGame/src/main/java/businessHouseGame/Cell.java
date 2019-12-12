package businessHouseGame;

import java.util.Objects;

public class Cell {
    private final int cellPosition;
    private final CellType cellType;

    public Cell(int cellPosition, CellType cellType) {
        this.cellPosition = cellPosition;
        this.cellType = cellType;
    }

    public int getCellPosition() {
        return cellPosition;
    }

    public CellType getCellType() {
        return cellType;
    }

    @Override
    public boolean equals(Object object) {
        Cell that = (Cell) object;
        if (this.cellPosition == that.cellPosition && this.cellType == that.cellType)
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cellPosition, cellType);
    }


}
