package homework7;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Set<String> fishHabits = new HashSet<String>();
        fishHabits.add("swim");
        fishHabits.add("dive");
        fishHabits.add("eat");
        Animal animal = Animal.FISH;
        Fish p1 = new Fish("Fishy", 5, 10, fishHabits);
        p1.respond();
        System.out.println(p1);
        System.out.println("\n==========================================" );
        Map<DaysOfWeek, String> mShedule = new HashMap<>();
        mShedule.put(DaysOfWeek.MONDAY, "run");
        mShedule.put(DaysOfWeek.TUESDAY, "jump");
        mShedule.put(DaysOfWeek.WEDNESDAY, "swim");
        mShedule.put(DaysOfWeek.THURSDAY, "jump, swim");
        mShedule.put(DaysOfWeek.FRIDAY, "run, jump");
        mShedule.put(DaysOfWeek.SATURDAY, "run, jump, swim");
        mShedule.put(DaysOfWeek.SUNDAY, "run, jump, swim");
        Man m = new Man("Tom", "Cruise", 1965, 70, mShedule);
        Woman w = new Woman("Naomi", "Campbell", 1970);

        System.out.println(m);
        Family family = new Family(w, m);
        family.bornChild("Kate", "Bill");
        System.out.println(family);

    }
}
