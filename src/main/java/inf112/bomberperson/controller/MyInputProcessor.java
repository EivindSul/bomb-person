package inf112.bomberperson.controller;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

import inf112.bomberperson.model.Model;

public class MyInputProcessor implements InputProcessor{
    private Model model;
    public MyInputProcessor(Model model){
        this.model = model;
    }

    private Map<Integer,ICallable<Void>> keyPressedHandlers = new HashMap<Integer, ICallable<Void>>();
    private Map<Integer,ICallable<Void>> keyUpHandlers = new HashMap<Integer, ICallable<Void>>();

    public void mapInputs(){
        // Set up player controllers
        PlayerController controller1 = new PlayerController(model.player1, model);
        PlayerController controller2 = new PlayerController(model.player2, model);
        
        // Map keys to player controllers
        // Player 1 moves up on W, player 2 moves up on Arrow up
        keyPressedHandlers.put(Input.Keys.W, controller1.playerUp);
        keyPressedHandlers.put(Input.Keys.UP, controller2.playerUp);

        // Player 1 moves down on S, player 2 moves down on Arrow down
        keyPressedHandlers.put(Input.Keys.S, controller1.playerDown);
        keyPressedHandlers.put(Input.Keys.DOWN, controller2.playerDown);
        
        // Player 1 moves right on D, player 2 moves right on Arrow right
        keyPressedHandlers.put(Input.Keys.D, controller1.playerRight);
        keyPressedHandlers.put(Input.Keys.RIGHT, controller2.playerRight);
        
        // Player 1 moves left on A, player 2 moves left on Arrow left
        keyPressedHandlers.put(Input.Keys.A, controller1.playerLeft);
        keyPressedHandlers.put(Input.Keys.LEFT, controller2.playerLeft);
        
        // Player 1 drops bomb on Spacebar, player 2 drops bomb on Enter
        keyPressedHandlers.put(Input.Keys.SPACE, controller1.playerDrop);
        keyPressedHandlers.put(Input.Keys.ENTER, controller2.playerDrop);
        
        // Stop vertical movement of players
        keyUpHandlers.put(Input.Keys.W, controller1.playerStopVert);
        keyUpHandlers.put(Input.Keys.UP, controller2.playerStopVert);
        keyUpHandlers.put(Input.Keys.S, controller1.playerStopVert);
        keyUpHandlers.put(Input.Keys.DOWN, controller2.playerStopVert);

        // Stop horizontal movement of players
        keyUpHandlers.put(Input.Keys.D, controller1.playerStopHori);
        keyUpHandlers.put(Input.Keys.RIGHT, controller2.playerStopHori);
        keyUpHandlers.put(Input.Keys.A, controller1.playerStopHori);
        keyUpHandlers.put(Input.Keys.LEFT, controller2.playerStopHori);
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.Q) {
            model.gameState = false;
        }
        else if(keyPressedHandlers.containsKey(keycode)){
            keyPressedHandlers.get(keycode).call();
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        if(keyUpHandlers.containsKey(keycode)){
            keyUpHandlers.get(keycode).call();
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