package businessHouseGame;

import java.util.List;

public class Board {
    List<Player> playersList;
    List<Cell> cells;
    Player player;
    int diceOutput;
    Cell nextCell;
    Cell currentCell;

    public Board(Player player, List<Cell> cells, int diceOutput) {
        this.player = player;
        this.cells = cells;
        this.diceOutput = diceOutput;

    }

    public void move() {
        int index = cells.indexOf(player.currentPosition);
        this.currentCell = cells.get(index + diceOutput);
    }

    public Cell displayCurrentCell(){
        return currentCell;
    }
}
