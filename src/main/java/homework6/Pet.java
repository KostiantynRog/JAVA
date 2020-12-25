package homework6;

import java.util.Arrays;
import java.util.Objects;

public abstract class Pet {
    private String nickname;
    private Animal species;
    private int age;
    private int trickLevel;
    private String[] habits;

     Pet(){};

     Pet(String nickname){
        setNickname(nickname);
    }

    Pet(String nickname, int age, int trickLevel, String[] habits){
        this(nickname);
        setAge(age);
        setTrickLevel(trickLevel);
        setHabits(habits);
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
    abstract void respond();
//    void foul(){ System.out.println("I have to hide somewhere...");}

    @Override
    public String toString() {
        return this.getSpecies()+"{nickname="+this.getNickname()+", age="+this.getAge()+", trickLevel="
                +this.getTrickLevel()+", habits="+ Arrays.toString(this.getHabits())+", canFly="
                +(this.getSpecies() !=null ? this.getSpecies().getCanFly():null)+", numberOfLegs="
                +(this.getSpecies() !=null ? this.getSpecies().getNumberOfLegs():null)+", hasFur="
                +(this.getSpecies() !=null ? this.getSpecies().getHasFur():null)+"}";
    }
    @Override
    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if (!(obj instanceof Pet))
            return false;
        Pet pet = (Pet)obj;
        return (Objects.equals(this.getSpecies(), pet.getSpecies()) && Objects.equals(this.getNickname(), pet.getNickname()));
    }
    @Override
    public int hashCode() {
        return Objects.hash(this.getSpecies(), this.getNickname());
    }
    @Override
    protected void finalize() throws Throwable {
        System.out.printf("Deleted: %s", this.toString());
    }
}
