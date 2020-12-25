package homework6;

public class Main {
    public static void main(String[] args) {

        String [] fishHabits = {"swim", "eat", "dive"};
        Animal animal = Animal.FISH;
        Fish p1 = new Fish("Fishy", 5, 10, fishHabits);
        p1.respond();
        System.out.println(p1);
        System.out.println("\n==========================================" );
        Man m = new Man("Tom", "Cruise", 1965);
        Woman w = new Woman("Naomi", "Campbell", 1970);
        System.out.println(w);
        Family family = new Family(w, m);
        System.out.println(family);

    }
}
