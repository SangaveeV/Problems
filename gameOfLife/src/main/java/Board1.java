public class Board1 {
    private int rows;
    private int columns;
    private int[][] board;
    private int[][] newState;

    public Board1(int rows, int columns, int[][] cells) {
        this.rows = rows;
        this.columns = columns;
        newState = new int[rows][columns];
        this.board = cells;
    }


    int[][] nextState() {
        for (int m = 0; m < rows; m++) {
            for (int n = 0; n < columns; n++) {
                int noOfAliveNeighbours = 0;
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        int mCell = m + i;
                        int nCell = n + j;
                        if (mCell >= 0 && nCell >= 0 && mCell<rows && nCell<columns) {
                            noOfAliveNeighbours += board[mCell][nCell];
                        }
                    }
                }
                noOfAliveNeighbours -= board[m][n];
                if (noOfAliveNeighbours < 2 || noOfAliveNeighbours > 3) {
                    newState[m][n] = 0;
                }
                if (noOfAliveNeighbours == 3 && board[m][n]==0) {
                    newState[m][n] = 1;
                }
                if (noOfAliveNeighbours == 2 || noOfAliveNeighbours == 3) {
                    newState[m][n] = board[m][n];
                }
            }
        }
        return newState;
    }


}
