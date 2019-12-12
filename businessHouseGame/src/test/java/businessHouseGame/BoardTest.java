package businessHouseGame;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BoardTest {

    @Test
    void aPlayerMovesFourCellsWhenDiceOutputIsFour() {
        List<Cell> cells = cellType();
        Board board = new Board(players(), cells);
        int diceValue=diceOutput().get(0);
        board.movePlayer(players().get(0),diceValue);
        Cell nextCell = board.displayCurrentCell();

        assertEquals(CellType.HOTEL, nextCell.getCellType());
        assertEquals(4, nextCell.getCellPosition());
    }

    @Test
    void aPlayerMovesToJailAndAmount150IsDeducted() {
        List<Cell> cells = cellType();
        Board board = new Board(players(), cells);
        int diceValue=diceOutput().get(1);
        Player player= board.movePlayer(players().get(0),diceValue);

        assertEquals(850, player.money.amount);
    }

    @Test
    void aPlayerMovesToTreasureAndAmount150IsAdded() {
        List<Cell> cells = cellType();
        Board board = new Board(players(), cells);
        int diceValue=diceOutput().get(2);
        Player player= board.movePlayer(players().get(0),diceValue);

        assertEquals(1200, player.money.amount);
    }

    @Test
    void aPlayerMovesToHotelAndAmount200IsDeducted() {
        List<Cell> cells = cellType();
        Board board = new Board(players(), cells);
        int diceValue=diceOutput().get(0);
        Player player= board.movePlayer(players().get(0),diceValue);
       // board.move(diceOutput().get(0));
        assertEquals(800, player.money.amount);
    }

    @Test
    void aPlayerMovesToHotelBuysIfHotelIsNotPreOwned() {
        List<Cell> cells = cellType();
        Board board = new Board(players(), cells);
        int diceValue=diceOutput().get(0);
        Player player=board.movePlayer(players().get(0),diceValue);

        assertTrue( board.hotels.containsKey(cells.get(4)));
        assertTrue(player.hotelsOwned.contains(cells.get(4)));
    }


    List<Cell> cellType() {
        List<Cell> cells = new ArrayList<>();
        cells.add(new Cell(0, CellType.EMPTY));
        cells.add(new Cell(1, CellType.EMPTY));
        cells.add(new Cell(2, CellType.EMPTY));
        cells.add(new Cell(3, CellType.JAIL));
        cells.add(new Cell(4, CellType.HOTEL));
        cells.add(new Cell(5, CellType.EMPTY));
        cells.add(new Cell(6, CellType.TREASURE));
        cells.add(new Cell(7, CellType.EMPTY));
        return cells;
    }

    List<Player> players() {
        List<Player> playersList = new ArrayList<>();
        playersList.add(new Player(1));
        return playersList;
    }

    List<Integer> diceOutput() {
        List<Integer> diceValue = new ArrayList<>();
        diceValue.add(4);
        diceValue.add(3);
        diceValue.add(6);
        return diceValue;
    }

}
