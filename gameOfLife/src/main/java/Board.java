import java.util.ArrayList;
import java.util.List;

public class Board {
    private int rows;
    private int columns;
    private List<Cell> initialState;
    private List<Cell> nextState;

    public Board(int rows, int columns, List<Cell> initialState) {
        this.rows = rows;
        this.columns = columns;
        this.initialState = initialState;
        nextState = new ArrayList<>();
    }

    int aliveNeighbours(Cell cell) {
        int noOfAliveNeigbours = 0;
        List<Cell> neighboursList = neighbours(cell);
        for (Cell neighbour : neighboursList) {
            if (neighbour.state == 1)
                noOfAliveNeigbours += 1;
        }
        if (cell.state == 0) {
            return noOfAliveNeigbours;
        }
        return noOfAliveNeigbours - 1;
    }

    void nextState() {
        for (Cell cell : initialState) {
            int noOfAliveNeighbours = aliveNeighbours(cell);
            if (noOfAliveNeighbours < 2 || noOfAliveNeighbours > 3) {
                nextState.add(new Cell(cell.x, cell.y, 0));
                continue;
            }
            if (noOfAliveNeighbours == 3 && cell.state == 0) {
                nextState.add(new Cell(cell.x, cell.y, 1));
                continue;
            }
            if (noOfAliveNeighbours == 2 || noOfAliveNeighbours == 3) {
                nextState.add(cell);
            }
        }

    }

    List<Cell> neighbours(Cell cell) {
        List<Cell> neighboursList = new ArrayList<>();
        List<Cell> neighbours=new ArrayList<>();
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int xCell = cell.x + i;
                int yCell = cell.y + j;
                if (isValid(xCell, yCell)) {
                    neighbours=findNeighbour(xCell,yCell);
                    neighboursList.addAll(neighbours);
                }
            }
        }
        return neighboursList;
    }

    private List<Cell> findNeighbour( int xCell, int yCell) {
        List<Cell> neighbours=new ArrayList<>();
        for (Cell cel : initialState) {
            if (cel.x == xCell && cel.y == yCell) {
                Cell neighbour = new Cell(cel.x, cel.y, cel.state);
                neighbours.add(neighbour);
            }
        }
        return neighbours;
    }

    private boolean isValid(int xCell, int yCell) {
        if (xCell >= 0 && yCell >= 0 && xCell < columns && yCell < columns) {
            return true;
        }
        return false;
    }


    List<Cell> displayNextState() {
        return nextState;
    }


}
