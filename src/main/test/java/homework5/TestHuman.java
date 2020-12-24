package homework5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestHuman {
    Human h = new Human();
    Human h2 = new Human("John", "Bourbon", 45);
    Human h1 = new Human("Luiza", "Bourbon", 34);
    Human h3 = h;
    @Test
    void testToString(){
        String result = "Human{name=null, surname=null, birthYear=0, iq=0, shedule=null}";
        assertEquals(result, h.toString());
        String result1 = "Human{name=John, surname=Bourbon, birthYear=45, iq=0, shedule=null}";
        assertEquals(result1, h2.toString());
        String result2 = "Human{name=Luiza, surname=Bourbon, birthYear=34, iq=0, shedule=null}";
        assertEquals(result2, h1.toString());
    }
    @Test
    void testEquals(){
        assertEquals(h3, h);
        assertNotEquals(h1, h2);
    }
    @Test
    void testHashCode(){
        assertNotEquals(h1.hashCode(), h2.hashCode());
        assertEquals(h.hashCode(), h3.hashCode());
    }

}
