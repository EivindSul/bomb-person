package inf112.bomberperson.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import inf112.bomberperson.screens.*;

public class BombermanGame extends Game {
    public static final int WIDTH = 720;
    public static final int HEIGHT = 720;
    public SpriteBatch batch;

    @Override
    public void create() {
        batch = new SpriteBatch();
        this.setScreen(new MenuScreen(this));
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void resize(int width, int height) {super.resize(width,height);

    }

    @Override
    public void pause() {super.pause();
    }

    @Override
    public void resume() {super.resume();
    }
}
