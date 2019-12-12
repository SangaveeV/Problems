package businessHouseGame;

import java.util.HashMap;
import java.util.List;

public class Board {
    List<Player> playersList;
    List<Cell> cells;
    Cell currentCell;
    Cell nextCell;
    HashMap<Player, Cell> playerPosition = new HashMap<>();
    HashMap<Cell, Player> hotels = new HashMap<>();

    public Board(List<Player> players, List<Cell> cells) {
        this.playersList = players;
        this.cells = cells;
        playerPosition();
    }

    void move() {
            for (Player player : playersList) {
                int diceValue=player.play();
                movePlayer(player, diceValue);
        }
    }

    public Player movePlayer(Player player, int diceValue) {
        int index = cells.indexOf(playerPosition.get(player));
        this.currentCell = cells.get(index + diceValue);
        cellAction(player, currentCell);
        nextCell=currentCell;
        return player;
    }

    void cellAction(Player player, Cell currentCell) {
        if (currentCell.getCellType() == CellType.JAIL) {
            player.money.amountDeduction(150);
        }
        if (currentCell.getCellType() == CellType.TREASURE) {
            player.money.amountAddition(200);
        }
        if (currentCell.getCellType() == CellType.HOTEL) {
            playerOnHotel(player);
        }
    }

    private void playerOnHotel(Player player) {
        if (!isHotelOwned(currentCell) && player.money.amount >= 200) {
            player.money.amountDeduction(200);
            player.hotelsOwned.add(currentCell);
            hotels.put(currentCell, player);
        } else {
            player.money.amountDeduction(50);
        }
    }

    private boolean isHotelOwned(Cell currentCell) {
        if (hotels.containsKey(currentCell)) {
            return true;
        }
        return false;
    }

    void playerPosition() {
        playersList.stream().forEach(player -> playerPosition.put(player, new Cell(0, CellType.EMPTY)));
    }

    public Cell displayCurrentCell() {
        return currentCell;
    }

}
