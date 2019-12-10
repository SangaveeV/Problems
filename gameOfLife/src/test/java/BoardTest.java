import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    @Test
    void getNoOfNeighboursForACell() {
        Board board = new Board(3, 3, initialState());
        Cell cell = new Cell(1, 1, CellState.ALIVE);
        Cell cell1 = new Cell(0, 0, CellState.DEAD);
        assertEquals(3, board.aliveNeighbours(cell));
        assertEquals(1, board.aliveNeighbours(cell1));
    }

    @Test
    void cellStateIs0IfAliveNeighboursIsLessThan2AndMoreThan3() {
        Board board = new Board(3, 3, initialState());
        Cell cell = initialState().get(2);
        int aliveNeighbours = board.aliveNeighbours(cell);
        CellState state = board.nextGeneration(aliveNeighbours, cell);
        assertEquals(CellState.DEAD, state);
    }

    @Test
    void deadCellWith3LiveNeighboursBecomeAlive() {
        Board board = new Board(3, 3, initialState());
        Cell cell = initialState().get(7);
        int aliveNeighbours = board.aliveNeighbours(cell);
        CellState state = board.nextGeneration(aliveNeighbours, cell);

        assertEquals(CellState.ALIVE, state);
    }

    @Test
    void liveCellWith2or3NeighboursStayAlive() {
        Board board = new Board(3, 3, initialState());
        Cell cell = initialState().get(4);
        int aliveNeighbours = board.aliveNeighbours(cell);
        CellState state = board.nextGeneration(aliveNeighbours, cell);

        assertEquals(CellState.ALIVE, state);
    }

    @Test
    void checkEachCellStatus() {
        Board board = new Board(3, 3, initialState());
        board.nextState();
        List<Cell> expected=nextState().stream().collect(Collectors.toList());
        List<Cell> actual=board.displayNextState().stream().collect(Collectors.toList());

        assertEquals(expected,actual);
    }

    @Test
    void checkAliveOrDead() {
        Board board = new Board(3, 3, initialState());
        board.nextState();
        Object[] expected=nextState().toArray();
        Object[] actual=board.displayNextState().toArray();

        assertArrayEquals(expected,actual);
    }

    private List<Cell> initialState() {
        List<Cell> state = new ArrayList<>();
        state.add(new Cell(0, 0, CellState.DEAD));
        state.add(new Cell(0, 1, CellState.DEAD));
        state.add(new Cell(0, 2, CellState.ALIVE));
        state.add(new Cell(1, 0, CellState.DEAD));
        state.add(new Cell(1, 1, CellState.ALIVE));
        state.add(new Cell(1, 2, CellState.DEAD));
        state.add(new Cell(2, 0, CellState.ALIVE));
        state.add(new Cell(2, 1, CellState.DEAD));
        state.add(new Cell(2, 2, CellState.ALIVE));
        return state;
    }

    private List<Cell> nextState() {
        List<Cell> state = new ArrayList<>();
        state.add(new Cell(0, 0, CellState.DEAD));
        state.add(new Cell(0, 1, CellState.DEAD));
        state.add(new Cell(0, 2, CellState.DEAD));
        state.add(new Cell(1, 0, CellState.DEAD));
        state.add(new Cell(1, 1, CellState.ALIVE));
        state.add(new Cell(1, 2, CellState.ALIVE));
        state.add(new Cell(2, 0, CellState.DEAD));
        state.add(new Cell(2, 1, CellState.ALIVE));
        state.add(new Cell(2, 2, CellState.DEAD));
        return state;
    }


}
