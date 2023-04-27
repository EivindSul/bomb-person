package inf112.bomberperson.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.Vector2;
import inf112.bomberperson.model.Model;

public class MyInputProcessor implements InputProcessor{
    private Model model;
    Sound sound;
    Sound dropBombsound;
    Sound bombSound;
    public MyInputProcessor(Model model){
        this.model = model;
        this.sound = Gdx.audio.newSound(Gdx.files.internal("doc/assets/Sounds/zapsplat_foley_footstep_single_on_dirty_stone_step_flip_flop_004_30440.mp3"));
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
        Vector2 velocityPlayer1 = model.player1.getVelocity();
        Vector2 velocityPlayer2 = model.player2.getVelocity();
        switch (keycode){
            case Input.Keys.W:
                velocityPlayer1.y += model.player1.getSpeed();
                playSound();
                model.player1.setVelocity(velocityPlayer1);
                break;
            case Input.Keys.S:
                velocityPlayer1.y -= model.player1.getSpeed();
                playSound();
                model.player1.setVelocity(velocityPlayer1);
                break;
            case Input.Keys.A:
                velocityPlayer1.x -= model.player1.getSpeed();
                playSound();
                model.player1.setVelocity(velocityPlayer1);
                break;
            case Input.Keys.D:
                velocityPlayer1.x += model.player1.getSpeed();
                playSound();
                model.player1.setVelocity(velocityPlayer1);
                break;
            case Input.Keys.SPACE:
                model.addBomb(model.player1);
                break;
            case Input.Keys.Q:
                stopSound();
                model.gameState = false;
            
            case Input.Keys.UP:
                velocityPlayer2.y += model.player2.getSpeed();
                playSound();
                model.player2.setVelocity(velocityPlayer2);
                break;
            case Input.Keys.DOWN:
                velocityPlayer2.y -= model.player2.getSpeed();
                playSound();
                model.player2.setVelocity(velocityPlayer2);
                break;
            case Input.Keys.LEFT:
                velocityPlayer2.x -= model.player2.getSpeed();
                playSound();
                model.player2.setVelocity(velocityPlayer2);
                break;
            case Input.Keys.RIGHT:
                velocityPlayer2.x += model.player2.getSpeed();
                playSound();
                model.player2.setVelocity(velocityPlayer2);
                break;
            case Input.Keys.ENTER:
                model.addBomb(model.player2);
                break;
        }
        return true;
    }
    void stopSound(){
        sound.stop();
    }

    void playSound(){
        long id = sound.loop();
        sound.setVolume(id, 0.6f );
    }

    @Override
    public boolean keyUp(int keycode) {
        switch (keycode){
            case Input.Keys.A, Input.Keys.D:
                stopSound();
                model.player1.setVelocity(new Vector2((model.player1.velocity.x = 0),model.player1.velocity.y = model.player1.getVelocity().y));
            case Input.Keys.W, Input.Keys.S:
                stopSound();
                model.player1.setVelocity(new Vector2((model.player1.velocity.x = model.player1.getVelocity().x),model.player1.velocity.y = 0));
            case Input.Keys.LEFT, Input.Keys.RIGHT:
                stopSound();
                model.player2.setVelocity(new Vector2((model.player2.velocity.x = 0),model.player2.velocity.y = model.player2.getVelocity().y));
            case Input.Keys.UP, Input.Keys.DOWN:
                stopSound();
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