import java.util.HashMap;

public class Board {
    int rows;
    int columns;
    HashMap<Cell, Integer> initialState;
    HashMap<Cell, Integer> nextState;

    public Board(int rows, int columns, HashMap<Cell, Integer> initialState) {
        this.rows = rows;
        this.columns = columns;
        this.initialState = initialState;
        nextState = new HashMap<>();
    }

    int aliveNeighbours(Cell cell) {
        int noOfAliveNeighbours = 0;
        HashMap<Cell, Integer> neighboursList = neighbours(cell);
        for (Cell neighbour : neighboursList.keySet()) {
            noOfAliveNeighbours += neighboursList.get(neighbour);
        }
        return noOfAliveNeighbours;
    }

    void nextState() {
        for (Cell cell : initialState.keySet()) {
            int noOfAliveNeighbours = aliveNeighbours(cell);
            if (noOfAliveNeighbours < 2 || noOfAliveNeighbours > 3) {
                nextState.put(cell, 0);
            }
            if (noOfAliveNeighbours == 3 && initialState.get(cell) == 0) {
                nextState.put(cell, 1);
            }
            if (noOfAliveNeighbours == 2 || noOfAliveNeighbours == 3) {
                nextState.put(cell, initialState.get(cell));
            }
        }
    }

    HashMap<Cell, Integer> neighbours(Cell cell) {
        HashMap<Cell, Integer> neighboursMap = new HashMap<>();
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int xCell = cell.x + i;
                int yCell = cell.y + j;
                if (xCell >= 0 && yCell >= 0 && xCell < columns && yCell < columns) {
                    Cell neighbourCell = new Cell(xCell, yCell);
                    int value = this.initialState.get(neighbourCell);
                    neighboursMap.put(neighbourCell, value);
                }
            }
        }
        neighboursMap.remove(cell);
        return neighboursMap;
    }

    HashMap<Cell, Integer> displayNextState() {
        return nextState;
    }


}
