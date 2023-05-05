package inf112.bomberperson.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import inf112.bomberperson.game.BombermanGame;

public class PowerupsScreen implements Screen{
    BombermanGame game;

    Label.LabelStyle font;
    protected Skin skin;
    protected final Stage stage;


    public PowerupsScreen(BombermanGame game){
        this.game = game;
        this.skin = new Skin(Gdx.files.internal("doc/assets/UI/uiskin.json"));
        this.stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void show() {
        // Font for the screen
        font = new Label.LabelStyle(new BitmapFont(), Color.WHITE); 
        Label text;
        Image image;

        // Setting up table to stage
        Table table = new Table();
        stage.addActor(table);

        // Adding contents, go down a row, then continue
        table.setFillParent(true);
        Label title = new Label("Powerups", font);
        title.setFontScale(3f);
        table.add(title).colspan(2).center();

        table.row();
        image = new Image(new Texture(Gdx.files.internal("doc/assets/bombcountboost.png")));
        table.add(image).size(50, 50).pad(20);

        text = new Label("Player can drop one more bomb", font);
        text.setFontScale(1.5f);
        table.add(text).pad(20);

        table.row();
        image = new Image(new Texture(Gdx.files.internal("doc/assets/speedboost.png")));
        table.add(image).size(50, 50).pad(20);

        text = new Label("Buffs the speed of the player", font);
        text.setFontScale(1.5f);
        table.add(text).pad(20);

        table.row();
        image = new Image(new Texture(Gdx.files.internal("doc/assets/powerboost.png")));
        table.add(image).size(50, 50).pad(20);

        text = new Label("Buffs the power of the bomb", font);
        text.setFontScale(1.5f);
        table.add(text).pad(20);

        table.row();
        image = new Image(new Texture(Gdx.files.internal("doc/assets/rangeboost.png")));
        table.add(image).size(50, 50).pad(20);

        text = new Label("Buffs the range of the bomb", font);
        text.setFontScale(1.5f);
        table.add(text).pad(20);

        // Button for going back to menu
        TextButton goBack = new TextButton("Back to menu", skin);

        // Adding in button
        table.row();
        table.add(goBack).padTop(20).minWidth(250).minHeight(50).colspan(2).center();

        // Setting listener on button to respond to being clicked
        goBack.addListener(new InputListener(){
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                dispose();
                game.setScreen(new MenuScreen(game));
                return true;
            }
        });
    }

    @Override
    public void render(float delta) {
        // Setting up backgroun colour
        Gdx.gl.glClearColor(0.1f, 0.14f, 0.1f, 1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);

        //renders the stage with the table from show
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

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
