package homework4;

public class Main {

    public static void main(String[] args) {


        Human h1 = new Human("Jac", "Mik", 1978, 89);
        Pet p1 = new Pet("Bobby", "dog", 3, 50, new String[]{"swim", "jump", "bite"});
        Human m = new Human("Vik", "Rog", 1975, 89);
        h1.setPet(p1);

       System.out.println(h1.toString());



    }
}
