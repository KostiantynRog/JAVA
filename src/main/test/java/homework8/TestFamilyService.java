package homework8;

import homework7.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class TestFamilyService {
    Set<String> petHabits = new HashSet<>();
    Dog dog = new Dog("Bobby", 3, 80, petHabits);
    DomesticCat cat = new DomesticCat("Tom", 5, 90, petHabits);
    Map<DaysOfWeek, String> schedule = new HashMap<>();
    Man m = new Man("Tom", "Cruise", 1965, 70, schedule);
    Woman w = new Woman("Naomi", "Campbell", 1970, 60, schedule);
    Man m1 =  new Man("Jack", "Smith", 1985, 80, schedule);
    Woman w1 = new Woman("Lil", "Kim", 1985, 90, schedule);
    Man m2 = new Man("Bill", "Clinton", 1956, 85, schedule);
    Woman w2 = new Woman("Monica", "Lewinsky", 2004, 95, schedule);
    Family f = new Family(w, m);
    Family f1 = new Family(w1, m1);

    List<Family> familyList = new ArrayList<>();
    @Test
    void testGetAllFamilies(){
    FamilyService familyService = new FamilyService();
    familyList.add(f);
    familyService.createNewFamily(w, m);
    assertEquals(familyList.size(), familyService.getAllFamilies().size());
    assertEquals(familyList.get(0), familyService.getAllFamilies().get(0));
    familyList.add(f1);
    familyService.createNewFamily(w1, m1);
    assertEquals(familyList.size(), familyService.getAllFamilies().size());
    assertEquals(familyList.get(1), familyService.getAllFamilies().get(1));
    }
    @Test
    void testGetFamiliesBiggerThen(){
        FamilyService familyService = new FamilyService();
        familyService.createNewFamily(w, m);
        familyService.createNewFamily(w1, m1);
        familyService.createNewFamily(w2, m2);
        assertEquals(0, familyService.getFamiliesBiggerThen(2).size());
        assertNotEquals(0, familyService.getFamiliesBiggerThen(1).size());
        assertEquals(3, familyService.getFamiliesBiggerThen(1).size());
    }
    @Test
    void testGetFamiliesLessThen(){
        FamilyService familyService = new FamilyService();
        familyService.createNewFamily(w, m);
        familyService.createNewFamily(w1, m1);
        assertEquals(0, familyService.getFamiliesLessThen(2).size());
        assertNotEquals(1, familyService.getFamiliesLessThen(2).size());
    }
    @Test
    void testCountFamiliesWithMemberNumber(){
        FamilyService familyService = new FamilyService();
        familyService.createNewFamily(w, m);
        familyService.createNewFamily(w1, m1);
        assertEquals(2, familyService.countFamiliesWithMemberNumber(2));
        assertNotEquals(1, familyService.countFamiliesWithMemberNumber(2));
    }
    @Test
    void testDeleteFamilyByIndex(){
        FamilyService familyService = new FamilyService();
        familyService.createNewFamily(w, m);
        familyService.createNewFamily(w1, m1);
        familyService.createNewFamily(w2, m2);
        assertTrue(familyService.deleteFamilyByIndex(2));
        assertFalse(familyService.deleteFamilyByIndex(3));
    }
    @Test
    void testBornChild(){
        FamilyService familyService = new FamilyService();
        familyService.createNewFamily(w, m);
        familyService.createNewFamily(w1, m1);
        assertEquals(w.getFamily(), familyService.bornChild(w.getFamily(), "Bill", "Kate"));
        assertNotEquals(w1.getFamily(), familyService.bornChild(w.getFamily(), "Adrian", "Liza"));
    }
    @Test
    void testAdoptChild(){
        FamilyService familyService = new FamilyService();
        familyService.createNewFamily(w, m);
        familyService.createNewFamily(w1, m1);
        assertEquals(w.getFamily(), familyService.adoptChild(w.getFamily(), m2));
        assertNotEquals(w1.getFamily(), familyService.adoptChild(w.getFamily(), w2));
    }
    @Test
    void testGetCount(){
        FamilyService familyService = new FamilyService();
        familyService.createNewFamily(w, m);
        assertNotEquals(2, familyService.count());
        familyService.createNewFamily(w1, m1);
        assertEquals(2, familyService.count());
    }
    @Test
    void testGetFamilyById(){
        FamilyService familyService = new FamilyService();
        familyService.createNewFamily(w, m);
        familyService.createNewFamily(w1, m1);
        familyService.createNewFamily(w2, m2);
        assertEquals(w1.getFamily(), familyService.getFamilyById(1));
        assertNotEquals(w.getFamily(), familyService.getFamilyById(2));
    }
    @Test
    void testGetPets(){
        FamilyService familyService = new FamilyService();
        familyService.createNewFamily(w, m);
        familyService.createNewFamily(w1, m1);
        familyService.getFamilyById(1).addPet(dog);
        Set<Pet> pets = new HashSet<>();
        pets.add(dog);
        assertEquals(pets, familyService.getPets(1));
        assertNotEquals(pets, familyService.getPets(0));
    }
    @Test
    void testAddPet(){
        FamilyService familyService = new FamilyService();
        familyService.createNewFamily(w, m);
        familyService.addPet(0, cat);
        assertEquals(1, w.getFamily().getPet().size());
        familyService.addPet(0, dog);
        assertNotEquals(1, w.getFamily().getPet().size());
    }
    @Test
    void testDeleteAllChildrenOlderThen(){
        FamilyService familyService = new FamilyService();
        familyService.createNewFamily(w, m);
        familyService.adoptChild(w.getFamily(), w2);
        familyService.bornChild(w.getFamily(), "Bill", "Kate");
        System.out.println(w.getFamily());
        familyService.deleteAllChildrenOlderThen(5);
        System.out.println(w.getFamily());


    }
}
