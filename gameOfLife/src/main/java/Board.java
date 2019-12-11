import java.util.HashMap;
import java.util.Objects;

public class Board {

    private HashMap<Cell, CellState> nextState;
    private HashMap<Cell, CellState> initialState;

    public Board(HashMap<Cell, CellState> initialState) {
        this.initialState = initialState;
        nextState = new HashMap<>();
    }

    int aliveNeighbours(Cell cell) {
        int noOfAliveNeighbours = 0;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                Cell neighbourCell = new Cell(cell.x + i, cell.y + j);
                noOfAliveNeighbours += initialState.keySet().stream().filter(cell1 -> cell1.equals(neighbourCell)).
                        filter(cell1 -> !cell1.equals(cell)).
                        filter(cell1 -> (initialState.get(cell1) == CellState.ALIVE)).count();
            }
        }
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
