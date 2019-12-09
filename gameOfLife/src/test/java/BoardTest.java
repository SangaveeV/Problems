import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BoardTest {

    @Test
    void getNoOfNeighboursforACell() {
        Board board = new Board(3, 3, initialState());
        Cell cell = new Cell(1, 1,1);
        Cell cell1=new Cell(0,0,0);
        assertEquals(3,board.aliveNeighbours(cell));
        assertEquals(1, board.aliveNeighbours(cell1));
    }

    @Test
    void checkAliveOrDead(){
        Board board=new Board(3,3,initialState());
        board.nextState();
        List<Cell> expected=nextState();
        List<Cell> actual=board.displayNextState();
        System.out.println(expected);
        System.out.println(actual);

        assertTrue(expected.equals(actual));
    }

    private List<Cell> initialState() {
        List<Cell> state=new ArrayList<>();
        state.add(new Cell(0,0,0));
        state.add(new Cell(0,1,0));
        state.add(new Cell(0,2,1));
        state.add(new Cell(1,0,0));
        state.add(new Cell(1,1,1));
        state.add(new Cell(1,2,0));
        state.add(new Cell(2,0,1));
        state.add(new Cell(2,1,0));
        state.add(new Cell(2,2,1));
        return state;
    }
    private List<Cell> nextState() {
        List<Cell> state=new ArrayList<>();
        state.add(new Cell(0,0,0));
        state.add(new Cell(0,1,0));
        state.add(new Cell(0,2,0));
        state.add(new Cell(1,0,0));
        state.add(new Cell(1,1,1));
        state.add(new Cell(1,2,1));
        state.add(new Cell(2,0,0));
        state.add(new Cell(2,1,1));
        state.add(new Cell(2,2,0));
        return state;
    }




    /*@Test
    void checkAliveAndDeadCells(){
        Board1 board1=new Board1(3,3,boardState());

      //  assertEquals(nextState(),board.nextState());
        assertArrayEquals(nextState(),board1.nextState());
    }

      int[][] boardState(){
        int[][] boardState=new int[3][3];
        boardState[0][0]=0;
        boardState[0][1]=0;
        boardState[0][2]=1;
        boardState[1][0]=0;
        boardState[1][1]=1;
        boardState[1][2]=0;
        boardState[2][0]=1;
        boardState[2][1]=0;
        boardState[2][2]=1;
        return boardState;
    }

    int[][] nextState(){
        int[][] boardState=new int[3][3];
        boardState[0][0]=0;
        boardState[0][1]=0;
        boardState[0][2]=0;
        boardState[1][0]=0;
        boardState[1][1]=1;
        boardState[1][2]=0;
        boardState[2][0]=0;
        boardState[2][1]=0;
        boardState[2][2]=0;
        return boardState;
    }*/


}
