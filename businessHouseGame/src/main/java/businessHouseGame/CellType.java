package businessHouseGame;

public enum CellType {EMPTY('E'),JAIL('J'),TREASURE('T'),HOTEL('H');
    char state;

    CellType(char state){
        this.state=state;
    }
}
