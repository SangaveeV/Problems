public enum CellState {ALIVE(1),DEAD(0);
    int state;

    CellState(int state) {
        this.state=state;
    }

    public int getState() {
        return state;
    }
}
