package homework7;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

public class TestFamily {
    Map<DaysOfWeek,String> shedule = new HashMap<>();
    Human h = new Human("Jenny", "Black", 1990);
    Human h1 = new Human("Joshua", "Reed", 1987);
    Human h2 = new Human();
    Human h3 = new Human("Gef", "Flick", 1979);
    Human h4 = new Human("Kate", "Sullivan", 1991);

    Family f = new Family(h, h1);
    Family f1 = new Family(h4, h3);
    Family f2 = f1;
    Family f3 = new Family(h1, h);
    Family f4 = new Family(h3, h2);

    @Test
    void testDeleteChild(){
    f.addChild(h2);
    f.addChild(h3);
    f.addChild(h4);
        assertTrue(f.deleteChild(h4));
        assertNotEquals(3, f.getChildren().size());
        assertTrue(f.deleteChild(h2));
        assertEquals(1, f.getChildren().size());
    }
    @Test
    void testDeleteChildByIndex(){
        f.addChild(h3);
        f.addChild(h4);
        f.addChild(h2);
        System.out.println(f);
        assertTrue(f.deleteChild(2));
        assertEquals(2, f.getChildren().size());
        System.out.println(f);
    }
    @Test
    void testAddChild(){
        f.addChild(h3);
        assertEquals(1, f.getChildren().size());
        assertEquals(h3, f.getChildren().get(f.getChildren().size()-1));
        f.addChild(h4);
        assertEquals(2, f.getChildren().size());
        assertEquals(h4, f.getChildren().get(f.getChildren().size()-1));
    }
    @Test
    void testCountFamily(){
        f.addChild(h3);
        f.addChild(h4);
        assertEquals(4, f.countFamily());
        f.deleteChild(1);
        assertEquals(3, f.countFamily());
    }
    @Test
    void testToString(){
       String result =  "Family{mother=Human{name=Jenny, surname=Black, birthYear=1990, iq=0, shedule={}}, father=Human{name=Joshua, surname=Reed, birthYear=1987, iq=0, shedule={}}, children=[], pet=[]}";
       assertEquals(result, f.toString());
    }
    @Test
    void testEquals() {
        assertNotEquals(f, f2);
        assertEquals(f1, f2);
    }
    @Test
    void testHashCode() {
        assertNotEquals(f.hashCode(), f2.hashCode());
        assertEquals(f1.hashCode(), f2.hashCode());
    }
    }
