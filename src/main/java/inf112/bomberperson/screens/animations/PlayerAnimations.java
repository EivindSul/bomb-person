package inf112.bomberperson.screens.animations;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import inf112.bomberperson.model.Player;
import inf112.bomberperson.model.Player.State;
import inf112.bomberperson.model.Player.Direction;;

public class PlayerAnimations {
    private Animation<TextureRegion> northWalkingAnim;
    private Animation<TextureRegion> eastWalkingAnim;
    private Animation<TextureRegion> southWalkingAnim;
    private Animation<TextureRegion> westWalkingAnim;
    
    /* Animantions for an idle state of the player, not implemented.
    private Animation<TextureRegion> idleNorth;
    private Animation<TextureRegion> idleEast;
    private Animation<TextureRegion> idleSouth;
    private Animation<TextureRegion> idleWest; */

    Player player;
    public PlayerAnimations(Player player){
        this.player = player;
        northWalkingAnim = createAnimation(new Texture("doc/assets/bombermanSheet.png"), 0, false, 16, 24);
        eastWalkingAnim = createAnimation(new Texture("doc/assets/bombermanSheet.png"), 1, false, 16, 24);
        southWalkingAnim = createAnimation(new Texture("doc/assets/bombermanSheet.png"), 2, false, 16, 24);
        westWalkingAnim = createAnimation(new Texture("doc/assets/bombermanSheet.png"), 1, true, 16, 24);
    }
    /**
     * takes a raw animation sheet and exstract (row) indexed animation
     * @param rawAnimationSheet raw texture of animations
     * @param row of animation in rawAnimationSheet
     * @return an Animation
     */
    private Animation<TextureRegion> createAnimation(Texture rawAnimationSheet, int row, boolean inverted, int textureWidht, int textureHeigh){
        TextureRegion[][] textureRegion2DArray = TextureRegion.split(rawAnimationSheet, textureWidht, textureHeigh);
        Animation<TextureRegion> anim = new Animation<TextureRegion>(1f/textureRegion2DArray[row].length, exstractAnimationFrames(textureRegion2DArray, row));
        // Flip the frames horizontally for left/right animation
        if (row == 1 && inverted) {
            for (TextureRegion frame : textureRegion2DArray[row]) {
                frame.flip(true, false);
            }
        }
        return anim;
    }
    private TextureRegion[] exstractAnimationFrames(TextureRegion[][] animationSheet,int row){
        TextureRegion[] animationFrames = new TextureRegion[animationSheet[row].length];
        for (int i = 0; i < animationSheet[row].length; i++) {
            animationFrames[i] = animationSheet[row][i];
        }
        return animationFrames;
    }
    public Animation<TextureRegion> getActiveAnimation() {
        Direction playerDirection = player.getCurrentDirection();
        State playerState = player.getCurrentState();
        
        if (playerState == State.WALKING) {
            switch (playerDirection) {
                case UP:
                return southWalkingAnim;
                
                case DOWN:
                return northWalkingAnim;

                case LEFT:
                return westWalkingAnim;

                case RIGHT:
                return eastWalkingAnim;

                default:
                break;
            }
        } /* else if (playerState == State.WALKING) {
            switch (playerDirection) {
                case UP:
                return idleNorth;

                case DOWN:
                return idleSouth;

                case LEFT:
                return idleWest;

                case RIGHT:
                return idleEast;

                default:
                break;
            } 
        } */
        return northWalkingAnim;
    }    
}
