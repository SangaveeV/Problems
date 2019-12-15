package businessHouseGame;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class BusinessGame {
    Board board;
    Dice dice;

    public BusinessGame(List<Player> players,List<Cell> cells,List<Integer> diceOutput){
        board=new Board(players,cells);
        dice=new Dice(diceOutput);
    }

    void game(){
        while (playerHasChance() && dice.diceOutput.size()>0){
            board.move(board.currentPlayer());
           // board.nextPlayer();
        }
        playerDetails();
    }

    void playerDetails() {
        HashMap<Player,Double> playersTotalWorth=new HashMap<>();

        for (Player player : board.playersList) {
            double amount=player.money.amount + (player.hotelsOwned.size() *200);
            playersTotalWorth.put(player,amount);
        }
        playersTotalWorth.keySet().stream().
                sorted(Comparator.comparing(player -> playersTotalWorth.get(player)).reversed()).
                collect(Collectors.toList());
        for (Player player :playersTotalWorth.keySet()) {
            System.out.println("Player " + player.playerNo + ": " + playersTotalWorth.get(player));
        }
    }

    boolean playerHasChance(){
        for (Player player :board.playersList) {
            if(player.turn>10){
                return false;
            }
        }
        return true;
    }
}
