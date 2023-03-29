package inf112.bomberperson.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

public class TimedEntityTest {

    private String testEntity = "hallaien test 1 2 3";
    private float testTime = 15;
    private TimedEntity<String> timedEntity;

    public TimedEntityTest(){
        this.timedEntity = new TimedEntity<String>(testEntity, testTime);
    }

    @Test
    public void getEntityTest() {
        assertEquals(testTime, this.timedEntity.getTime());
    }    

    @Test
    public void getTimeTest() {
        assertEquals(testTime, this.timedEntity.getTime());
    }
}    
