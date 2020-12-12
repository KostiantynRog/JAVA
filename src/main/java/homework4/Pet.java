package homework4;
import  java.util.Arrays;

public class Pet {
    private final String nickname;
    private final String species;
    private final int age;
    private final int trickLevel;
    private final String[] habits;


  public  Pet(String nickname, String species, int age, int trickLevel, String[] habits){
       this.nickname = nickname;
       this.species = species;
       this.age = age;
       this.trickLevel = trickLevel;
       this.habits = habits;
    }
    void displayInfo() {
        System.out.printf("Name: %s \tSpecies: %s\n Age: %d\tTricklevel: %d\nHabits: %s", nickname, species,age,trickLevel, Arrays.toString(habits));
    }

     void eat(){
        System.out.println("I am eating");
    }
     void respond(){
        System.out.printf("Hi! Boss. I am %s. I missed you", nickname);
    }
     void foul(){
        System.out.println("I have to hide somewhere...");
    }

    @Override
    public String toString() {
        return "Pet{" +
                "nickname='" + nickname + '\'' +
                ", species='" + species + '\'' +
                ", age=" + age +
                ", trickLevel=" + trickLevel +
                ", habits=" + Arrays.toString(habits) +
                '}';
    }
}
