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

public class RulesScreen implements Screen{
    BombermanGame game;

    BitmapFont font;
    protected Skin skin;
    protected final Stage stage;


    public RulesScreen(BombermanGame game){
        this.game = game;
        this.skin = new Skin(Gdx.files.internal("doc/assets/UI/uiskin.json"));
        this.stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void show() {
        Label.LabelStyle font = new Label.LabelStyle(new BitmapFont(), Color.WHITE);

        Table table = new Table();
        stage.addActor(table);

        table.setFillParent(true);
        Label title = new Label("Controls", font);
        title.setFontScale(3f);
        table.add(title).colspan(2).center();

        table.row();
        Label text = new Label("Player 1 Controls:\nUp: W\nLeft: A\nDown: S\nRight: D\nDrop bomb: Spacebar", font);
        text.setFontScale(1.5f);
        table.add(text).pad(20);

        text = new Label("Player 2 Controls:\nUp: ↑\nLeft: ←\nDown: ↓\nRight: →\nDrop bomb: Enter", font);      // Work in progress, arrows dont work, can work as placeholder until player 2 is implemented.
        text.setFontScale(1.5f);
        table.add(text).pad(20);

        table.row();
        table.setFillParent(true);
        title = new Label("Game features", font);
        title.setFontScale(3f);
        table.add(title).colspan(2).center();

        table.row();
        title = new Label("Walls:", font);
        title.setFontScale(1.5f);
        table.add(title).pad(20);

        title = new Label("Bombs:", font);
        title.setFontScale(1.5f);
        table.add(title).pad(20);

        table.row();
        text = new Label("Stone wall: Unbreakable, used as cover\nBrick wall: Breakable by bombs\nCan drop powerups (not implemented)", font);
        text.setFontScale(1.25f);
        table.add(text).pad(20);

        text = new Label("5 second timer\nExplodes in a cross\nExplotion breaks brick walls but is stopped", font);
        text.setFontScale(1.25f);
        table.add(text).pad(20);

        TextButton newGame = new TextButton("Back to menu", skin);

        table.row();
        table.add(newGame).padTop(20).minWidth(250).minHeight(50).colspan(2).center();

        newGame.addListener(new InputListener(){
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                dispose();
                game.setScreen(new MenuScreen(game));
                return true;
            }
        });
    }

    @Override
    public void render(float v) {
        Gdx.gl.glClearColor(0.1f, 0.14f, 0.1f, 1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
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
    public void hide() {  
        
    }

    @Override
    public void dispose() {
        stage.dispose();
        game.dispose();
    }
}