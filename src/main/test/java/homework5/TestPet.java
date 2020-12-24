package homework5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestPet {
    Pet pet = new Pet();
    String [] petHabits = {"play", "bark", "bite"};
    Pet pet1 = new Pet("Bobby", Animal.DOG, 2, 70, petHabits);
    Pet pet2 = new Pet("Tom", Animal.CAT, 3, 90, petHabits);
    Pet pet3 = pet;
    @Test
    void testToString(){
        String result = "Pet{nickname=null, species=null, age=0, trickLevel=0, habits=null}";
        assertEquals(result, pet.toString());
        String result1 = "Pet{nickname=Bobby, species=DOG, age=2, trickLevel=70, habits=[play, bark, bite]}";
        assertEquals(result1, pet1.toString());
        String result2 = "Pet{nickname=Tom, species=CAT, age=3, trickLevel=90, habits=[play, bark, bite]}";
        assertEquals(result2, pet2.toString());
    }
    @Test
    void testEquals(){
        assertEquals(pet, pet3);
        assertNotEquals(pet1, pet2);
    }
    @Test
    void testHashCode(){
        assertNotEquals(pet1.hashCode(), pet2.hashCode());
        assertEquals(pet.hashCode(), pet3.hashCode());

    }
}
