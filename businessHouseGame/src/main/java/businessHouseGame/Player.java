package businessHouseGame;

import java.util.Objects;

public class Player {

    private final int playerNo;
    private final double amount;
    private final int hotelsOwned;
    Cell currentPosition;

    public Player(int playerNo,int amount,int hotelsOwned){
        this.playerNo=playerNo;
        this.amount=amount;
        this.hotelsOwned=hotelsOwned;
        currentPosition=new Cell(0,CellState.EMPTY);
    }

    public int getPlayerNo() {
        return playerNo;
    }

    public double getAmount() {
        return amount;
    }

    public int getHotelsOwned() {
        return hotelsOwned;
    }

    @Override
    public boolean equals(Object object) {
        Player that = (Player) object;
        if (this.playerNo==that.playerNo && this.amount==that.amount &&
                this.hotelsOwned==that.hotelsOwned && this.currentPosition==that.currentPosition)
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerNo,amount,hotelsOwned);
    }





}
