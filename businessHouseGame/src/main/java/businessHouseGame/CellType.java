package businessHouseGame;

import java.util.HashMap;

public enum CellType {
    EMPTY('E') {
        @Override
        public void cellAction(Player player,Cell currentCell) {

        }
    }, JAIL('J') {
        @Override
        public void cellAction(Player player,Cell currentCell) {
            player.money.amountDeduction(150);
        }
    }, TREASURE('T') {
        @Override
        public void cellAction(Player player,Cell currentCell) {
            player.money.amountAddition(200);
        }
    }, HOTEL('H') {
        @Override
        public void cellAction(Player player,Cell currentCell) {
            playerOnHotel(player,currentCell);
        }
    };

    char value;
    HashMap<Cell, Player> hotels = new HashMap<>();

    CellType(char value) {
        this.value = value;
    }

    public abstract void cellAction(Player player,Cell currentCell);

    void playerOnHotel(Player player,Cell currentCell) {
        if (!isHotelOwned(currentCell) && player.money.amount >= 200) {
            player.money.amountDeduction(200);
            player.hotelsOwned.add(currentCell);
            hotels.put(currentCell, player);
        } else {
            player.money.amountDeduction(50);
        }
    }

    boolean isHotelOwned(Cell currentCell) {
        if (hotels.containsKey(currentCell)) {
            return true;
        }
        return false;
    }
}
