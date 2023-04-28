package inf112.bomberperson.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import inf112.bomberperson.game.BombermanGame;
import inf112.bomberperson.model.Model;
import com.badlogic.gdx.utils.ScreenUtils;


public class GameScreen implements Screen {
    public BombermanGame game;
    public OrthographicCamera camera;
    public Model model;
    public PlayerRenderer playerRenderer;
    public Batch batch;
    public OrthographicCamera mapCamera;
    public OrthogonalTiledMapRenderer mapRenderer;
    
    public GameScreen (BombermanGame game){
        camera = new OrthographicCamera();
        this.model = new Model(game);
        playerRenderer = new PlayerRenderer(model.player1, model.player2);
        batch = game.batch;
        mapCamera = model.map.getCamera();
        // Create the map renderer
        mapRenderer = new OrthogonalTiledMapRenderer(model.map.getMap());
        mapRenderer.setView(mapCamera);



    }

    @Override
    public void render(float v) {
        //clear screen
        ScreenUtils.clear(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        mapCamera.update();

        //update camera
        camera.update();
        //compute model
        // handle all game logic and input and update the model
        model.update();



        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        mapRenderer.render();
        playerRenderer.draw(batch);

        batch.end();
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
        batch.dispose();
        model.map.getMap().dispose();
        mapRenderer.dispose();
        game.dispose();

        //clear screen
        ScreenUtils.clear(0,0,0,1);
    }
}
