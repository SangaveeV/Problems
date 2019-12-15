package businessHouseGame;

import java.util.HashMap;
import java.util.List;

public class Board {
    List<Player> playersList;
    List<Cell> cells;
    Cell currentCell;
    int currentPlayer;

    HashMap<Player, Cell> playerPosition = new HashMap<>();
    HashMap<Cell, Player> hotels = new HashMap<>();

    public Board(List<Player> players, List<Cell> cells) {
        this.playersList = players;
        this.cells = cells;
        playerPosition();
    }

    void move(Player player) {
        int diceValue = player.play();
        if (diceValue > 0) {
            movePlayer(player, diceValue);
            player.turn();
        }
        nextPlayer();
    }

    Player currentPlayer() {
        return playersList.get(currentPlayer);
    }

    void nextPlayer() {
        currentPlayer += 1;
        if (currentPlayer >= playersList.size()) {
            currentPlayer = 0;
        }
    }

    Player movePlayer(Player player, int diceValue) {
        int index = cells.indexOf(playerPosition.get(player));
        int playerNextCell= index+diceValue;
        while(playerNextCell>=cells.size()){
            playerNextCell=playerNextCell-cells.size();
        }
        this.currentCell = cells.get(playerNextCell);
        currentCell.getCellType().cellAction(player,currentCell);
        playerPosition.replace(player,currentCell);
        return player;
    }

    void playerPosition() {
        playersList.stream().forEach(player -> playerPosition.put(player, new Cell(0, CellType.EMPTY)));
    }

    public Cell displayCurrentCell() {
        return currentCell;
    }

}
