package inf112.bomberperson.model;

/**
 * A Collision interface asking implementing objects for these four attributes:
 * x-position, y-position, object witdh and object height.
 * If the object implementing collidable provides these four attributes,
 * the object can collide with map using the collision handler in model
 */

public interface Collidable {


    // Get the x-position
    float getX();

    // Get the y-position
    float getY();

    // Get the width
    float getWidth();

    // Get the height
    float getHeight();
}
