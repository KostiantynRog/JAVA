package homework12;



import java.util.Set;

public class Dog extends Pet implements PetFoul {
    private final Animal species = Animal.DOG;
    Dog(){
        super();
    }
    Dog(String nickname){
        super(nickname);
    }
    public Dog(String nickname, int age, int trickLevel, Set<String> habits){
        super(nickname, age, trickLevel, habits);
    }
    public Animal getSpecies(){return this.species;}

    @Override
    public void respond() {
        System.out.printf("Hi! Boss. I am %s. I missed you\n", getNickname());
    }
    @Override
    public void foul(){
        System.out.println("I have to hide somewhere...");
    }
}
