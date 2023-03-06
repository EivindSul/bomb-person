package inf112.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import inf112.bomberperson.model.Map;
import inf112.skeleton.app.BombermanGame;

public class GameScreen implements Screen {
    public static final float SPEED = 120;
    float x = 200;
    float y = 200;

    private OrthographicCamera camera;

    private Map bombermanMap;
    BombermanGame game;
    Texture bomb;

    public GameScreen (BombermanGame game){
        this.game = game;
        bomb = new Texture("doc/assets/bomb.png");
        camera = new OrthographicCamera();
    }



    @Override
    public void show() {
        bombermanMap = new Map();
        bombermanMap.create();

    }

    @Override
    public void render(float v) {

        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);

        // Render the BombermanGame
        bombermanMap.render();


    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        game.dispose();
        game.dispose();

    }

}
