package inf112.bomberperson.model;

public class TimedEntity<N> {
    
    private N entity;
    private float time;
    private int owner;

    /**
     * Any object that could be coupled with a timer and/or owner.
     * Can be used to check who owns the explosion that kills someone, time at which a bomb should explode, etc. 
     * @param entity - Entity of choice.
     * @param time - Time at which something happens.
     * @param owner - 0 means no owner, 1 means player 1, etc.
     */
    public TimedEntity(N entity, float time, int owner){
        this.entity = entity;
        this.time = time;
        this.owner = owner;
    }

    public N getEntity() {
        return entity;
    }

    public float getTime() {
        return time;
    }

    public float getOwner() {
        return owner;
    }
}
