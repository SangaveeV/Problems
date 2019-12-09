import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {

    @Test
    void getNoOfNeighboursforACell() {
        Board board = new Board(3, 3, initialState());
        Cell cell = new Cell(1, 1);
        Cell cell1=new Cell(0,0);
        assertEquals(3,board.aliveNeighbours(cell1));
        assertEquals(8, board.aliveNeighbours(cell));
    }

    @Test
    void checkAliveOrDead(){
        Board board=new Board(3,3,initialState());
        board.nextState();
        Cell cell = new Cell(1, 1);
        assertEquals(nextState().get(cell),board.displayNextState().get(cell));
    }

    private HashMap<Cell,Integer> initialState() {
        HashMap<Cell,Integer> state=new HashMap<>();
        state.put(new Cell(0,0),0);
        state.put(new Cell(0,1),0);
        state.put(new Cell(0,2),1);
        state.put(new Cell(1,0),0);
        state.put(new Cell(1,1),1);
        state.put(new Cell(1,2),0);
        state.put(new Cell(2,0),1);
        state.put(new Cell(2,1),0);
        state.put(new Cell(2,2),1);
        return state;
    }

    private HashMap<Cell,Integer> nextState() {
        HashMap<Cell,Integer> state=new HashMap<>();
        state.put(new Cell(0,0),0);
        state.put(new Cell(0,1),0);
        state.put(new Cell(0,2),0);
        state.put(new Cell(1,0),0);
        state.put(new Cell(1,1),1);
        state.put(new Cell(1,2),0);
        state.put(new Cell(2,0),0);
        state.put(new Cell(2,1),1);
        state.put(new Cell(2,2),0);
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
