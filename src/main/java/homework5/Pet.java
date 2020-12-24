package homework5;



import java.util.Arrays;
import java.util.Objects;

public class Pet {
    private String nickname;
    private Animal species;
    private int age;
    private int trickLevel;
    private String[] habits;

    public Pet(){};

    public Pet(Animal species, String nickname){
        this.species = species;
        this.nickname = nickname;
    }

    public  Pet(String nickname, Animal species, int age, int trickLevel, String[] habits){
        this(species, nickname);
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }
    public String getNickname(){return nickname;}
    public void setNickname(String nickname){ this.nickname = nickname;}
    public Animal getSpecies(){return species;}
    public void setSpecies(Animal species){ this.species = species;}
    public int getAge(){return age;}
    public void setAge(int age){ this.age = age;}
    public int getTrickLevel(){return trickLevel;}
    public void setTrickLevel(int trickLevel){
        if(trickLevel > 100 || trickLevel < 0){
            System.out.println("Wrong input");
        }
        this.trickLevel = trickLevel;
    }
    public String[] getHabits(){return habits;}
    public void setHabits(String[] habits){this.habits = habits;}

    void eat(){
        System.out.println("I am eating");
    }
    void respond(){
        System.out.printf("Hi! Boss. I am %s. I missed you\n", this.getNickname());
    }
    void foul(){ System.out.println("I have to hide somewhere...");}

    @Override
    public String toString() {
        return "Pet{" + "nickname=" + this.getNickname()  + ", species=" + this.getSpecies() +
                ", age=" + this.getAge() + ", trickLevel=" + this.getTrickLevel() + ", habits=" + Arrays.toString(this.getHabits()) +
                "}";
    }
    @Override
    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if (!(obj instanceof homework4.Pet))
            return false;
        homework4.Pet pet = (homework4.Pet)obj;
        return (Objects.equals(this.getSpecies(), pet.getSpecies()) && Objects.equals(this.getNickname(), pet.getNickname()));
    }
    @Override
    protected void finalize() throws Throwable {
        System.out.printf("Deleted: %s", this.toString());
    }

}
