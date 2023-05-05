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
import com.badlogic.gdx.utils.viewport.FitViewport;
import inf112.bomberperson.screens.animations.PlayerAnimations;


public class GameScreen implements Screen {
    public BombermanGame game;
    public OrthographicCamera camera;
    public Model model;
    public PlayerRenderer playerRenderer;
    public Batch batch;
    public OrthogonalTiledMapRenderer mapRenderer;
    private FitViewport viewport;
    
    public GameScreen (BombermanGame game){
        camera = new OrthographicCamera();
        this.model = new Model(game);
        playerRenderer = new PlayerRenderer(model.player1, model.player2);
        batch = game.batch;
        
        //creating map renderer and focusing camera to it
        mapRenderer = new OrthogonalTiledMapRenderer(model.map.getMap());
        mapRenderer.setView(camera);
    
        //getting values from map
        int mapHeight = ((int)(model.map.getHeight() * model.map.getTileSize())); 
        int mapWidth = ((int)(model.map.getWidth() * model.map.getTileSize()));

        //applying the values from map to focus viewport on map
        viewport = new FitViewport(mapWidth, mapHeight, camera);
        viewport.update(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.position.set(mapWidth / 2f, mapHeight / 2f, 0);
        camera.zoom = Gdx.graphics.getWidth() / (float) mapWidth;
        camera.update();

        new PlayerAnimations(model.player1);
        new PlayerAnimations(model.player2);
    }

    @Override
    public void render(float v) {
        //clear screen
        ScreenUtils.clear(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //update camera
        camera.update();

        mapRenderer.setView(camera);
		mapRenderer.render();
        
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

        //clear screen
        ScreenUtils.clear(0,0,0,1);
    }
}
