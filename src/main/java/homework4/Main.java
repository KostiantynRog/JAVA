package homework4;

public class Main {

    public static void main(String[] args) {
        Human mother1 = new Human("Daria", "Corleone", 1960);
        Human father1 = new Human("Elon", "Mask",1959);
        Family f1 = new Family(mother1, father1);
        Human mother2= new Human("Maria", "Leone", 1970);
        Human father2 = new Human("Phil", "Collins",1969);
        Family f2 = new Family(mother2, father2);

        String [][] h1Shedule = {{"monday", "tennis"},{"tuesday", "swimming pool"}, {"wednesday", "running"}, {"thursday", "walking"},
                {"friday", "boxing"},{"saturday", "cinema"}, {"sunday", "go to the park"}};
        String [] petHabits = {"play", "bark", "bite"};

        Pet p1 = new Pet("Bobby","dog", 3, 60, petHabits);
        p1.respond();
        System.out.println(p1);

//        Human h1 = new Human("Bill", "Smith", 1975, 90, p1, h1Shedule);
        Human son1 = new Human("John", "Mask", 1990);
        Human son2 = new Human("Mick", "Jagger", 1993);
        Human daughter1 = new Human("Mini", "Collins",1995);

        f1.addChild(son1);
        f2.addChild(daughter1);
        f2.addChild(son2);
        f1.setPet(p1);


        son1.greetPet();
        System.out.println();
        son1.describePet();
        System.out.println("\n==========================================" );
        System.out.println(son1.toString());
        System.out.println();
        System.out.println(f1);
        System.out.println(f2);
        System.out.println(f2.countFamily());
    }
}
