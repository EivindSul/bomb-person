package inf112.bomberperson.model.animations;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public interface Animated {
    /**
     * Returns the animation of the object given a state.
     * @param state current state of object.
     * @return Animation<TextureRegion> according to state
     */
    public Animation<TextureRegion> getActiveAnimation();
}
