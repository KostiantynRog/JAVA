package homework6;

public class DomesticCat extends Pet implements PetFoul {
    private final Animal species = Animal.DOMESTICCAT;
    DomesticCat(){
        super();
    }
    DomesticCat(String nickname){
        super(nickname);
    }
    DomesticCat(String nickname, int age, int trickLevel, String[] habits){
        super(nickname, age, trickLevel, habits);
    }
    public Animal getSpecies(){return species;}

    @Override
    void respond() {
        System.out.printf("Hi! Boss. I am %s. I missed you\n", getNickname());
    }

    @Override
    public void foul() {
        System.out.println("I have to hide somewhere...");
    }
}
