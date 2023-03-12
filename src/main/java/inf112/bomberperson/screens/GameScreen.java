package inf112.bomberperson.screens;

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
import inf112.bomberperson.game.BombermanGame;
import inf112.bomberperson.model.Model;
import com.badlogic.gdx.utils.ScreenUtils;


public class GameScreen implements Screen {
    public BombermanGame game;
    public OrthographicCamera camera;
    public Model model;
    
    public GameScreen (BombermanGame game){
        camera = new OrthographicCamera();
        this.model = new Model(game, camera);
    }

    @Override
    public void render(float v) {
        //clear screen
        ScreenUtils.clear(0,0,0,1);
        //update camera
        camera.update();
        //compute model
            // handle all game logic and input and update the model
            model.update();
            // render all the model components
            model.render();

    }

    @Override
    public void show() {

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


        //clear screen
        ScreenUtils.clear(0,0,0,1);
        //update camera
        camera.update();
        //computeModel
            // handle all game logic and input and update the model
            model.update();
            // render all model components
            model.render();
        
    }
}
