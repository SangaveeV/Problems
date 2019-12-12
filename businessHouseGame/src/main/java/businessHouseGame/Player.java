package businessHouseGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Player {

    private final int playerNo;
    List<Cell> hotelsOwned;
    Money money = new Money(1000);
    Dice dice;

    public Player(int playerNo) {
        this.playerNo = playerNo;
        hotelsOwned = new ArrayList<>();
    }

    public int play() {
        int diceValue = dice.diceValue();
        return diceValue;
    }

    @Override
    public boolean equals(Object object) {
        Player that = (Player) object;
        if (this.playerNo == that.playerNo)
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerNo);
    }

}
