package businessHouseGame;

import java.util.List;

public class Dice {

    static List<Integer> diceOutput;

    public Dice(List<Integer> diceOutput) {
        this.diceOutput = diceOutput;
    }

    public List<Integer> getDiceOutput() {
        return diceOutput;
    }

    static int diceValue() {
       if (diceOutput.size() > 0) {
            int diceValue = diceOutput.get(0);
            diceOutput.remove(0);
            return diceValue;
        }
        return 0;
    }
}
