package inf112.bomberperson.controller;


// Based on the solution to INF101 tetris
public interface Controllable{


    public boolean movePlayer(int deltaRow, int deltaCol);
    public boolean dropBomb(int row, int col);
    public boolean checkLegalMove();

    public int getInterval();
    public void clockTick();

    // public GameScreen getGameScreen();

}
