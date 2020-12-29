package homework7;

import org.junit.jupiter.api.Test;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class TestPet {
    Set<String> catHabits = new HashSet<>();
    DomesticCat cat = new DomesticCat();
    DomesticCat cat1 = new DomesticCat("Tom");
    DomesticCat cat2 = new DomesticCat("Puss", 3, 80, catHabits);
    DomesticCat cat3 = cat;

    @Test
    void testToString(){
        String result = "DOMESTICCAT{nickname=null, age=0, trickLevel=0, habits=[], canFly=false, numberOfLegs=4, hasFur=true}";
        assertEquals(result, cat.toString());
        String result1 = "DOMESTICCAT{nickname=Tom, age=0, trickLevel=0, habits=[], canFly=false, numberOfLegs=4, hasFur=true}";
        assertEquals(result1, cat1.toString());
        String result2 = "DOMESTICCAT{nickname=Puss, age=3, trickLevel=80, habits=[], canFly=false, numberOfLegs=4, hasFur=true}";
        assertEquals(result2, cat2.toString());
    }
    @Test
    void testEquals(){
    assertEquals(cat, cat3);
    assertNotEquals(cat1, cat2);
    }
    @Test
    void testHashCode(){
        assertNotEquals(cat1.hashCode(), cat2.hashCode());
        assertEquals(cat.hashCode(), cat3.hashCode());
    }
}
