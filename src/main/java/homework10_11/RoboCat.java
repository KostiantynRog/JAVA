package homework10_11;

import java.util.Set;

public class RoboCat extends Pet {
    private final Animal species = Animal.ROBOCAT;
    RoboCat(){
        super();
    }
    RoboCat(String nickname){
        super(nickname);
    }
    RoboCat(String nickname, int age, int trickLevel, Set<String> habits){
        super(nickname, age, trickLevel, habits);
    }
    public Animal getSpecies(){return this.species;}

    @Override
    void respond() {
        System.out.printf("Hi! Boss. I am %s. I missed you\n", getNickname());
    }

}
