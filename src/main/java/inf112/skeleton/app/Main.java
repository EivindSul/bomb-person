package inf112.skeleton.app;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import inf112.bomberperson.game.BombermanGame;

public class Main {
    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration cfg = new Lwjgl3ApplicationConfiguration();
        cfg.setTitle("Bomber Man");
        cfg.setWindowedMode(BombermanGame.WIDTH, BombermanGame.HEIGHT);
        cfg.setResizable(true);

        new Lwjgl3Application(new BombermanGame(), cfg);
    }
}