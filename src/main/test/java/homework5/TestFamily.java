package homework5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestFamily {
    Human h2 = new Human("John", "Bourbon", 45);
    Human h1 = new Human("Luiza", "Bourbon", 34);
    Human h3 = new Human();
    Human h4 = new Human("Son", "Son", 1);
    Human h5 = new Human("Daughter", "Daughter", 2);


    Family family = new Family(h1, h2);
    Family family1 = new Family(h1, h3);
    Family family2 = new Family(h4, h5);
    Family family3 = new Family(h2, h5);
    Family family4 = family;
    @Test
    void testToString(){
        String result = "Family{mother=Human{name=Luiza, surname=Bourbon, birthYear=34, iq=0, shedule= null}, " +
                "father=Human{name=John, surname=Bourbon, birthYear=45, iq=0, shedule= null}, " +
                "children=[], " + "pet=null}";
        assertEquals(result, family.toString());
        String result1 = "Family{mother=Human{name=Luiza, surname=Bourbon, birthYear=34, iq=0, shedule= null}, " +
                "father=Human{name=null, surname=null, birthYear=0, iq=0, shedule= null}, " +
                "children=[], " + "pet=null}";
        assertEquals(result1, family1.toString());
    }
    @Test
    void testDeleteChild(){
        family.addChild(h3);
        family.addChild(h4);
        family.addChild(h5);
        family.deleteChild(h3);
        assertEquals(2,  family.getChildren().length);
         family.deleteChild(h1);
        assertEquals(2, family.getChildren().length);
    }
    @Test
    void testDeleteChildByIndex(){
        family.addChild(h3);
        family.addChild(h4);
        family.addChild(h5);
        System.out.println(family);
        assertTrue(family.deleteChild(0));
        System.out.println(family);
        assertFalse(family.deleteChild(3));
    }
    @Test
    void testAddChild(){
        family.addChild(h3);
        assertEquals(1, family.getChildren().length);
        assertEquals(h3, family.getChildren()[family.getChildren().length - 1]);
        family.addChild(h4);
        assertEquals(2, family.getChildren().length);
        assertEquals(h4, family.getChildren()[family.getChildren().length -1]);
    }
    @Test
    void testCountFamily(){
        family.addChild(h4);
        family.addChild(h5);
        assertEquals(4, family.countFamily());
        family.deleteChild(h4);
        assertEquals(3, family.countFamily());
    }
    @Test
    void testEquals(){
        assertNotEquals(family1, family4);
        assertEquals(family, family4);
        assertNotEquals(family3, family2);
    }
    @Test
    void testHashCode(){
        assertNotEquals(family1.hashCode(), family4.hashCode());
        assertEquals(family.hashCode(), family4.hashCode());
    }
}
