package inf112.bomberperson.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import inf112.bomberperson.game.BombermanGame;

public class MenuScreen implements Screen {
    BombermanGame game;

    BitmapFont font;
    protected Skin skin;
    protected final Stage stage;


    public MenuScreen(BombermanGame game){
        this.game = game;
        this.skin = new Skin(Gdx.files.internal("doc/assets/UI/uiskin.json")); // Skin used for buttons
        this.stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void show() {
        // Screen font
        Label.LabelStyle font = new Label.LabelStyle(new BitmapFont(), Color.WHITE);

        // Table to draw on
        Table table = new Table();
        stage.addActor(table);

        // Screen title
        table.setFillParent(true);
        Label title = new Label("Bomber Man", font);
        title.setFontScale(6f);
        table.add(title);

        // Buttons for starting a game, the rules and closing the game
        TextButton newGame = new TextButton("New game", skin);
        TextButton rules = new TextButton("Settings", skin);
        TextButton exitGame = new TextButton("Exit game", skin);

        // Adding buttons
        table.row();
        table.add(newGame).padTop(20).minWidth(250).minHeight(50);
        table.row();
        table.add(rules).padTop(20).minWidth(250).minHeight(50);
        table.row();
        table.add(exitGame).padTop(20).minWidth(250).minHeight(50);

        // Listeners for buttons, activated when the button is clicked
        newGame.addListener(new InputListener(){
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                dispose();
                game.setScreen(new GameScreen(game));
                return true;
            }
        });

        rules.addListener(new InputListener(){
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                dispose();
                game.setScreen(new RulesScreen(game));
                return true;
            }
        });

        exitGame.addListener(new InputListener(){
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.exit();
                return true;
            }
        });
    }

    @Override
    public void render(float v) {
        // Set background colour
        Gdx.gl.glClearColor(0.1f, 0.14f, 0.1f, 1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);

        // Draw the stage
        stage.draw();
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
        stage.dispose();
        game.dispose();
    }
}