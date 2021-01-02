package homework12;



import java.util.Set;

public class Fish extends Pet {
    private final Animal species = Animal.FISH;
    Fish(){
        super();
    }
    Fish(String nickname){
        super(nickname);
    }
    public Fish(String nickname, int age, int trickLevel, Set<String> habits){
        super(nickname, age, trickLevel, habits);
    }
    public Animal getSpecies(){return this.species;}

    @Override
    public void respond() {
        System.out.printf("Hi! Boss. I am %s. I missed you\n", getNickname());
    }

}
