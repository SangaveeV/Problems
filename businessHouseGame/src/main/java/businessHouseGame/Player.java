package businessHouseGame;

import java.util.ArrayList;
import java.util.List;

public class Player {

    int playerNo;
    List<Cell> hotelsOwned;
    Money money = new Money(1000);
    int turn=0;


    public Player(int playerNo) {
        this.playerNo = playerNo;
        hotelsOwned = new ArrayList<>();
    }

    public int play() {
        int diceValue =Dice.diceValue();
        return diceValue;
    }

    void turn(){
        turn++;
    }

}
