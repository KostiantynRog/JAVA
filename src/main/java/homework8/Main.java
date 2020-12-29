package homework8;

import homework7.*;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Set<String> petHabits = new HashSet<String>();
        petHabits.add("play");
        petHabits.add("sleep");
        petHabits.add("eat");
        Dog dog = new Dog("Wolf", 5, 90, petHabits);
        dog.respond();
        dog.foul();
        System.out.println(dog);
        System.out.println("\n==========================================" );

        Man m = new Man("Tom", "Cruise", 1965);
        Woman w = new Woman("Naomi", "Campbell", 1970);
        Man m1 =  new Man("Jack", "Smith", 1985);
        Woman w1 = new Woman("Lil", "Kim", 1985);
        Man m2 = new Man("Bill", "Clinton", 1956);
        Woman w2 = new Woman("Monica", "Lewinsky", 1974);

        FamilyController familyController = new FamilyController();
        familyController.createNewFamily(w, m);
        familyController.createNewFamily(w1, m1);
        familyController.createNewFamily(w2, m2);
        System.out.println(familyController.getAllFamilies());

        familyController.bornChild(familyController.getFamilyById(2), "Sam", "Joan");
        familyController.adoptChild(familyController.getFamilyById(1), m1);
        familyController.addPet(0, dog);
        System.out.println(familyController.getPets(0));

        familyController.displayAllFamilies();
        System.out.println(familyController.getFamiliesLessThen(3));
        System.out.println(familyController.countFamiliesWithMemberNumber(3));
        System.out.println(familyController.deleteFamilyByIndex(1));

        familyController.deleteAllChildrenOlderThen(2);
        familyController.displayAllFamilies();
        System.out.println(familyController.count());



    }
}
