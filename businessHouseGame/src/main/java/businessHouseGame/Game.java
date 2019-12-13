package businessHouseGame;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Game {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("/Users/in-vapasi/Desktop/vapasi/problems/businessHouseGame/src/main/resources/cellType.txt"));
        String input = reader.readLine();
        String[] cells = input.split(",");
        List<Cell> cellsList = new ArrayList<>();
        int index = 0;
       // cellsList.add(new Cell(index,CellType.EMPTY));
        for (String str : cells) {
            index+=1;
            CellType cellType = CellType.valueOf(str);
            cellsList.add(new Cell(index, cellType));
        }


        String dice = "4,4,4,6,7,8,5,11,10,12,2,3,5,6,7,8,5,11,10,12,2,3,5,6,7,8,5,11,10,12";
        List<Integer> diceOutput = Stream.of(dice.split(","))
                .map(Integer::parseInt).collect(toList());

        List<Player> playersList = new ArrayList<>();
        playersList.add(new Player(1));
        playersList.add(new Player(2));
        playersList.add(new Player(3));

        BusinessGame businessGame=new BusinessGame(playersList,cellsList,diceOutput);
        businessGame.game();

    }
}
