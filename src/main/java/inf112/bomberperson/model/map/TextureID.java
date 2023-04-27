package inf112.bomberperson.model.map;

import java.util.concurrent.ThreadLocalRandom;

public enum TextureID {
    GRASS(484),
    SOLID_WALL(386),
    BRICK_WALL(106),
    BOMB(174),
    BOMB_RED(175),
    EXPLOSION(176),
    POWERUP_SPEEDBOOST(206),
    POWERUP_BOMB_RANGE(207),
    POWERUP_BOMB_POWER(208),
    POWERUP_MORE_BOMBS(209),
    PLACEHOLDER(545);

    public final int id;
    
    private TextureID(int id){
        this.id = id;
    }

    public static final int getRandomPowerup(){
        int powerup = ThreadLocalRandom.current().nextInt(0, 4);
        return (powerup + 206);
    }
}
