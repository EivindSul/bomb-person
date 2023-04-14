package inf112.bomberperson.controller;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import inf112.bomberperson.model.Model;

public class MyInputProcessor implements InputProcessor{
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
                model.player1.setVelocity(new Vector2(model.player1.getVelocity().x,model.player1.getVelocity().y += model.player1.getSpeed()));
                break;
            case Input.Keys.S:
                model.player1.setVelocity(new Vector2(model.player1.getVelocity().x,model.player1.getVelocity().y -= model.player1.getSpeed()));
                break;
            case Input.Keys.A:
                model.player1.setVelocity(new Vector2(model.player1.getVelocity().x -= model.player1.getSpeed(), model.player1.getVelocity().y));
                break;
            case Input.Keys.D:
                model.player1.setVelocity(new Vector2(model.player1.getVelocity().x += model.player1.getSpeed(), model.player1.getVelocity().y));
                break;
            case Input.Keys.SPACE:
                model.addBomb(model.player1);
                break;
            case Input.Keys.Q:
                model.gameState = false;
            
            case Input.Keys.UP:
                model.player2.setVelocity(new Vector2(model.player2.getVelocity().x,model.player2.getVelocity().y += model.player2.getSpeed()));
                break;
            case Input.Keys.DOWN:
                model.player2.setVelocity(new Vector2(model.player2.getVelocity().x,model.player2.getVelocity().y -= model.player2.getSpeed()));
                break;
            case Input.Keys.LEFT:
                model.player2.setVelocity(new Vector2(model.player2.getVelocity().x -= model.player2.getSpeed(), model.player2.getVelocity().y));
                break;
            case Input.Keys.RIGHT:
                model.player2.setVelocity(new Vector2(model.player2.getVelocity().x += model.player2.getSpeed(), model.player2.getVelocity().y));
                break;
            case Input.Keys.ENTER:
                model.addBomb(model.player2);
                break;
        }
        return true;
    }
    @Override
    public boolean keyUp(int keycode) {
        switch (keycode){
            case Input.Keys.A, Input.Keys.D:
                model.player1.setVelocity(new Vector2((model.player1.velocity.x = 0),model.player1.velocity.y = model.player1.getVelocity().y));
            case Input.Keys.W, Input.Keys.S:
                model.player1.setVelocity(new Vector2((model.player1.velocity.x = model.player1.getVelocity().x),model.player1.velocity.y = 0));
            case Input.Keys.LEFT, Input.Keys.RIGHT:
                model.player2.setVelocity(new Vector2((model.player2.velocity.x = 0),model.player2.velocity.y = model.player2.getVelocity().y));
            case Input.Keys.UP, Input.Keys.DOWN:
                model.player2.setVelocity(new Vector2((model.player2.velocity.x = model.player2.getVelocity().x),model.player2.velocity.y = 0));
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