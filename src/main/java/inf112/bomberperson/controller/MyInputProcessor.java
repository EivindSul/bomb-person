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

    private Map<Integer, ICallable<Void>> keyPressedHandlers = new HashMap<Integer, ICallable<Void>>();
    public Map<Integer, ICallable<Void>> keyUpHandlers = new HashMap<Integer, ICallable<Void>>();

    /** 
     * Maps the actions of the different inputs to the correct keys in two hashmaps, one for pressing a key and one for releasing it.
     * Movment: P1 WASD, P2 arrows.
     * Drop Bomb: P1 SPACEBAR, P2 ENTER.
    */
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

        // Player 1 drops bomb on Spacebar, player 2 drops bomb on Enter
        keyPressedHandlers.put(Input.Keys.Q, controller1.endGame);
        keyPressedHandlers.put(Input.Keys.O, controller2.endGame);
        
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
            keyPressedHandlers.get(Input.Keys.O).call();
        }
        if(keyPressedHandlers.containsKey(keycode)){
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
        return false;
    }
    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }
    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }
    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }
    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }
    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }

}