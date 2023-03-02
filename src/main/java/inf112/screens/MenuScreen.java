package inf112.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.Texture;
import inf112.skeleton.app.BombermanGame;

public class MenuScreen implements Screen {
    public static final int PLAY_WIDTH= 200;
    public static final int PLAY_HEIGHT= 100;
    public static final int PLAY_BUTTON_Y= 260;

    public static final int EXIT_WIDTH= 200;
    public static final int EXIT_HEIGHT= 100;
    public static final int EXIT_BUTTON_Y= 100;

    BombermanGame game;
    Texture exitButtonActive;
    Texture exitButtonInactive;
    Texture playButtonActive;
    Texture playButtonInactive;



    public MenuScreen(BombermanGame game){
        this.game = game;
        playButtonActive = new Texture("doc/assets/play_active.png");
        playButtonInactive = new Texture("doc/assets/play_inactive.png");

        exitButtonActive = new Texture("doc/assets/exit_active.png");
        exitButtonInactive = new Texture("doc/assets/exit_inactive.png");
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float v) {
        Gdx.gl.glClearColor(0.1f, 0.14f, 0.1f, 1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);

        game.batch.begin();

        int x = BombermanGame.WIDTH/2 - EXIT_WIDTH/2;
        int play_x = BombermanGame.WIDTH/2 - PLAY_WIDTH/2;
        if(Gdx.input.getX() < x + PLAY_WIDTH && Gdx.input.getX()> x && BombermanGame.HEIGHT - Gdx.input.getY() < PLAY_BUTTON_Y + PLAY_HEIGHT && BombermanGame.HEIGHT- Gdx.input.getY() > PLAY_BUTTON_Y ){
            game.batch.draw(playButtonActive,x, PLAY_BUTTON_Y,PLAY_WIDTH, PLAY_HEIGHT);
            if (Gdx.input.isTouched()){
                this.dispose();
                game.setScreen(new GameScreen(game));

            }
        }else{
            game.batch.draw(playButtonInactive,x, PLAY_BUTTON_Y,PLAY_WIDTH, PLAY_HEIGHT);
        }


        if(Gdx.input.getX() < x + EXIT_WIDTH && Gdx.input.getX()> x && BombermanGame.HEIGHT - Gdx.input.getY() < EXIT_BUTTON_Y + EXIT_HEIGHT && BombermanGame.HEIGHT- Gdx.input.getY() > EXIT_BUTTON_Y ){
            game.batch.draw(exitButtonActive,x, EXIT_BUTTON_Y,EXIT_WIDTH, EXIT_HEIGHT);
            if (Gdx.input.isTouched()){
                Gdx.app.exit();
            }
        }else{
            game.batch.draw(exitButtonInactive,x, EXIT_BUTTON_Y,EXIT_WIDTH, EXIT_HEIGHT);
        }

        game.batch.end();

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
    public void hide() {  }

    @Override
    public void dispose() {

    }
}
