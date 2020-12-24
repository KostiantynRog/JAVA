package homework5;

public class Main {
    public static void main(String[] args) {

        DaysOfWeek day = DaysOfWeek.SUNDAY;
        System.out.println(DaysOfWeek.MONDAY.name());
        switch (day){
            case MONDAY:
                System.out.println("Play tennis");
                break;
            case TUESDAY:
                System.out.println("Swimming pool");
            case WEDNESDAY:
                System.out.println("Running");
                break;
            case THURSDAY:
                System.out.println("Walking");
                break;
            case FRIDAY:
                System.out.println("Boxing");
                break;
            case SATURDAY:
                System.out.println("Go to the cinema");
                break;
            case SUNDAY:
                System.out.println("Go to the park");
                break;
        }

//        int i=0;
//        while(i < 100_000_000){Human h = new Human(); i++;}

        Human mother1 = new Human("Daria", "Corleone", 1960);
        Human father1 = new Human("Elon", "Mask",1959);
        Family f1 = new Family(mother1, father1);
        Human mother2= new Human("Maria", "Leone", 1970);
        Human father2 = new Human("Phil", "Collins",1969, 102, day);
        Family f2 = new Family(mother2, father2);

        String [] petHabits = {"play", "bark", "bite"};
        Animal animal = Animal.DOG;
        Pet p1 = new Pet("Bobby", animal, 3, 60, petHabits);
        p1.respond();
        System.out.println(p1);

        Human son1 = new Human("John", "Mask", 1990);
        Human son2 = new Human("Mick", "Jagger", 1993);
        Human daughter1 = new Human("Mini", "Collins",1995);
        Human daughter2 = new Human("Aisha", "Collins",1998);


        f1.addChild(son1);
        f2.addChild(daughter1);
        f2.addChild(son2);
        f2.addChild(daughter2);
        f2.deleteChild(son2);
        f2.deleteChild(daughter1);
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
