package inf112.bomberperson.model;

public class TimedEntity<N> {
    
    private N entity;
    private float time;

    public TimedEntity(N entity, float time){
        this.entity = entity;
        this.time = time;
    }

    public N getEntity() {
        return entity;
    }

    public float getTime() {
        return time;
    }
}
