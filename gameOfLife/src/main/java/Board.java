import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Board {
    private int rows;
    private int columns;
    private Collection<Cell> initialState;
    private Collection<Cell> nextState;


    public Board(int rows, int columns, List<Cell> initialState) {
        this.rows = rows;
        this.columns = columns;
        this.initialState = initialState;
        nextState = new ArrayList<>();
    }

    int aliveNeighbours(Cell cell) {
        int noOfAliveNeighbours = 0;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (isValid(cell.x + i, cell.y + j) &&
                        findIfAlive(cell.x + i, cell.y + j)) {
                    noOfAliveNeighbours += 1;
                }
            }
        }
        return noOfAliveNeighbours - cell.state.getState();
    }

    void nextState() {
        for (Cell cell : initialState) {
            int noOfAliveNeighbours = aliveNeighbours(cell);
            CellState state = nextGeneration(noOfAliveNeighbours, cell);
            nextState.add(new Cell(cell.x, cell.y, state));
        }
    }

    CellState nextGeneration(int noOfAliveNeighbours, Cell cell) {
        if (noOfAliveNeighbours < 2 || noOfAliveNeighbours > 3) {
            return CellState.DEAD;
        }
        if (noOfAliveNeighbours == 3 && cell.state == CellState.DEAD) {
            return CellState.ALIVE;
        }
        if (noOfAliveNeighbours == 2 || noOfAliveNeighbours == 3 && cell.state == CellState.ALIVE) {
            return cell.state;
        }
        return cell.state;
    }

    private boolean findIfAlive(int xCell, int yCell) {
        long neighbour=initialState.parallelStream().filter(cell -> cell.x==xCell).
                filter(cell -> cell.y==yCell).
                filter(cell -> cell.state==CellState.ALIVE).count();
        if(neighbour>0)
            return true;
        return false;
    }

    private boolean isValid(int xCell, int yCell) {
        if (xCell >= 0 && yCell >= 0 && xCell < columns && yCell < columns) {
            return true;
        }
        return false;
    }

    Collection<Cell> displayNextState() {
        return nextState;
    }

}
