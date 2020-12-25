package homework6;

public class Fish extends Pet{
    private final Animal species = Animal.FISH;
    Fish(){
        super();
    }
    Fish(String nickname){
        super(nickname);
    }
    Fish(String nickname, int age, int trickLevel, String[] habits){
        super(nickname, age, trickLevel, habits);
    }
    public Animal getSpecies(){return this.species;}

    @Override
    void respond() {
        System.out.printf("Hi! Boss. I am %s. I missed you\n", getNickname());
    }

}
