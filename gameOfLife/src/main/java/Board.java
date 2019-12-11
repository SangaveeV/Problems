import java.util.HashMap;
import java.util.Objects;

public class Board {

    int rows;
    int columns;
    private HashMap<Cell, CellState> nextState;
    private HashMap<Cell, CellState> initialState;

    public Board(int rows, int columns, HashMap<Cell, CellState> initialState) {
        this.rows = rows;
        this.columns = columns;
        this.initialState = initialState;
        nextState = new HashMap<>();
    }

    int aliveNeighbours(Cell cell) {
        int noOfAliveNeighbours = 0;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (isValid(cell.getX() + i, cell.getY() + j)) {
                    noOfAliveNeighbours += initialState.get(
                            new Cell(cell.getX() + i, cell.getY() + j)).state;
                }
            }
        }
        noOfAliveNeighbours -= initialState.get(cell).state;
        return noOfAliveNeighbours;
    }

    void nextState() {
        for (Cell cell : initialState.keySet()) {
            int noOfAliveNeighbours = aliveNeighbours(cell);
            CellState state = nextGeneration(noOfAliveNeighbours, cell);
            nextState.put(cell, state);
        }
    }

    CellState nextGeneration(int noOfAliveNeighbours, Cell cell) {
        if (noOfAliveNeighbours < 2 || noOfAliveNeighbours > 3) {
            return CellState.DEAD;
        }
        if (noOfAliveNeighbours == 3 && initialState.get(cell) == CellState.DEAD) {
            return CellState.ALIVE;
        }
        if (noOfAliveNeighbours == 2 || noOfAliveNeighbours == 3 && initialState.get(cell) == CellState.ALIVE) {
            return initialState.get(cell);
        }
        return initialState.get(cell);
    }

    private boolean isValid(int xCell, int yCell) {
        if (xCell >= 0 && yCell >= 0 && xCell < columns && yCell < columns) {
            return true;
        }
        return false;
    }

    HashMap<Cell, CellState> displayNextState() {
        return nextState;
    }

    @Override
    public boolean equals(Object object) {
        HashMap<Cell, CellState> that = (HashMap<Cell, CellState>) object;
        if (this.nextState == that)
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nextState);
    }

}
