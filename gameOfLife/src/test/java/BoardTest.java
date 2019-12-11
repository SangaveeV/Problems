import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {

    @Test
    void getNoOfNeighboursForACell() {
        Board board = new Board( initialState());
        Cell cell = new Cell(1, 1);
        Cell cell1 = new Cell(0, 0);
        assertEquals(3, board.aliveNeighbours(cell));
        assertEquals(1, board.aliveNeighbours(cell1));
    }

    @Test
    void cellStateIs0IfAliveNeighboursIsLessThan2AndMoreThan3() {
        Board board = new Board(initialState());
        Cell cell = new Cell(0, 2);
        int aliveNeighbours = board.aliveNeighbours(cell);
        CellState state = board.nextGeneration(aliveNeighbours, cell);
        assertEquals(CellState.DEAD, state);
    }

    @Test
    void deadCellWith3LiveNeighboursBecomeAlive() {
        Board board = new Board(initialState());
        Cell cell = new Cell(2, 1);
        int aliveNeighbours = board.aliveNeighbours(cell);
        CellState state = board.nextGeneration(aliveNeighbours, cell);

        assertEquals(CellState.ALIVE, state);
    }

    @Test
    void liveCellWith2or3NeighboursStayAlive() {
        Board board = new Board(initialState());
        Cell cell = new Cell(1, 1);
        int aliveNeighbours = board.aliveNeighbours(cell);
        CellState state = board.nextGeneration(aliveNeighbours, cell);

        assertEquals(CellState.ALIVE, state);
    }

    @Test
    void checkEachCellStatus() {
        Board board = new Board( initialState());
        board.nextState();

        assertEquals(nextState(), board.displayNextState());
    }

    private HashMap<Cell, CellState> initialState() {
        HashMap<Cell, CellState> initialState = new HashMap<>();
        initialState.put(new Cell(0, 0), CellState.DEAD);
        initialState.put(new Cell(0, 1), CellState.DEAD);
        initialState.put(new Cell(0, 2), CellState.ALIVE);
        initialState.put(new Cell(1, 0), CellState.DEAD);
        initialState.put(new Cell(1, 1), CellState.ALIVE);
        initialState.put(new Cell(1, 2), CellState.DEAD);
        initialState.put(new Cell(2, 0), CellState.ALIVE);
        initialState.put(new Cell(2, 1), CellState.DEAD);
        initialState.put(new Cell(2, 2), CellState.ALIVE);
        return initialState;
    }

    private HashMap<Cell, CellState> nextState() {
        HashMap<Cell, CellState> nextState = new HashMap<>();

        nextState.put(new Cell(0, 0), CellState.DEAD);
        nextState.put(new Cell(0, 1), CellState.DEAD);
        nextState.put(new Cell(0, 2), CellState.DEAD);
        nextState.put(new Cell(1, 0), CellState.DEAD);
        nextState.put(new Cell(1, 1), CellState.ALIVE);
        nextState.put(new Cell(1, 2), CellState.ALIVE);
        nextState.put(new Cell(2, 0), CellState.DEAD);
        nextState.put(new Cell(2, 1), CellState.ALIVE);
        nextState.put(new Cell(2, 2), CellState.DEAD);
        return nextState;
    }


}
