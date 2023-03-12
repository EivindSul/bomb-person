package inf112.bomberperson.controller;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import inf112.bomberperson.model.Model;
import inf112.bomberperson.model.Player;
import inf112.bomberperson.screens.GameScreen;

public class MyInputProcessor implements InputProcessor{
    private GameScreen gScreen;
    private Model model;
    public MyInputProcessor(Model model){
        this.model = model;
    }  
    /**
     * Very unreadable code, will refractor, but the concept is that when key is pressed down players velocity will change
     * And when key is released players velocity is set to 0
     */

    /*
    |1||1||1||1||1|
    |1||_||1||1||1|
    |1||x||1||1||1|
    |1||_||_||_||1|
    |1||1||1||1||1|
    When player is pressing W and D now, it collides and cannot move unless you release both W and D
    */

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode){
            case Input.Keys.W:
                model.player.setVelocity(new Vector2(model.player.getVelocity().x,model.player.getVelocity().y += model.player.getSpeed()));
                break;
            case Input.Keys.S:
                model.player.setVelocity(new Vector2(model.player.getVelocity().x,model.player.getVelocity().y -= model.player.getSpeed()));
                break;
            case Input.Keys.A:
                model.player.setVelocity(new Vector2(model.player.getVelocity().x -= model.player.getSpeed(), model.player.getVelocity().y));

                break;
            case Input.Keys.D:
                model.player.setVelocity(new Vector2(model.player.getVelocity().x += model.player.getSpeed(), model.player.getVelocity().y));
                break;
            case Input.Keys.SPACE:
                System.out.println("Dropping bomb");
                model.player.dropBomb();
                model.addBombToQueue(model.player);
                break;
            case Input.Keys.Q:
                model.gameState = false;
        }
        return true;
    }
    @Override
    public boolean keyUp(int keycode) {
        switch (keycode){
            case Input.Keys.A, Input.Keys.D:
                model.player.setVelocity(new Vector2((model.player.velocity.x = 0),model.player.velocity.y = model.player.getVelocity().y));
            case Input.Keys.W, Input.Keys.S:
                model.player.setVelocity(new Vector2((model.player.velocity.x = model.player.getVelocity().x),model.player.velocity.y = 0));
        }
        return true;
    }
    @Override
    public boolean keyTyped(char character) {
        // TODO Auto-generated method stub
        return false;
    }
    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        // TODO Auto-generated method stub
        return false;
    }
    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        // TODO Auto-generated method stub
        return false;
    }
    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        // TODO Auto-generated method stub
        return false;
    }
    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        // TODO Auto-generated method stub
        return false;
    }
    @Override
    public boolean scrolled(float amountX, float amountY) {
        // TODO Auto-generated method stub
        return false;
    }

}