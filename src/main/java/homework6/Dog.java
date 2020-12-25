package homework6;

public class Dog extends Pet implements PetFoul{
    private final Animal species = Animal.DOG;
    Dog(){
        super();
    }
    Dog(String nickname){
        super(nickname);
    }
    Dog(String nickname, int age, int trickLevel, String[] habits){
        super(nickname, age, trickLevel, habits);
    }
    public Animal getSpecies(){return this.species;}

    @Override
    void respond() {
        System.out.printf("Hi! Boss. I am %s. I missed you\n", getNickname());
    }
    @Override
    public void foul(){
        System.out.println("I have to hide somewhere...");
    }
}
