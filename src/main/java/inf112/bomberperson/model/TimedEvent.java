package inf112.bomberperson.model;



public interface TimedEvent {

    /**
     * Activate the action for this object. This is a timed event, like exploding a bomb or decaying an explosion.
     */
    public void trigger();
}
