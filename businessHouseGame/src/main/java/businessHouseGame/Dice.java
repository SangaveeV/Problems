package businessHouseGame;

import java.util.List;

public class Dice {

    List<Integer> diceOutput;

    public Dice(List<Integer> diceOutput){
        this.diceOutput=diceOutput;
    }

    public int diceValue() {
        int diceValue=diceOutput.get(0);
        diceOutput.remove(0);
        return diceValue;
    }
}
