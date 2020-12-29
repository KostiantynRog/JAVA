package homework7;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

public class TestHuman {
    Map<DaysOfWeek, String> shedule = new HashMap<>();
    Human h = new Human();
    Human h1 = new Human("Al", "Bl", 1975);
    Human h2 = new Human("Cb", "Db", 1978, 70, shedule);
    Human h3 = h;

     @Test
    void testToString(){
         String result = "Human{name=null, surname=null, birthYear=0, iq=0, shedule={}}";
         assertEquals(result, h.toString());
         String result1 = "Human{name=Al, surname=Bl, birthYear=1975, iq=0, shedule={}}";
         assertEquals(result1, h1.toString());
         String result2 = "Human{name=Cb, surname=Db, birthYear=1978, iq=70, shedule={}}";
         assertEquals(result2, h2.toString());
     }
     @Test
    void testEquals(){
         assertEquals(h, h3);
         assertNotEquals(h, h1);
         assertNotEquals(h1, h2);
     }
     @Test
    void testHashCode(){
         assertNotEquals(h1.hashCode(), h2.hashCode());
         assertEquals(h.hashCode(), h3.hashCode());
     }
}
