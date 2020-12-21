package homework4;

import java.util.Arrays;
import java.util.Objects;

public class Human{
    private String name;
    private String surname;
    private int birthYear;
    private int iq;


    private String[][] shedule = new String[0][0];
    private Family family;

    public Human(){};

    public Human(String name, String surname, int birthYear)  {
        this.name = name;
        this.surname = surname;
        this.birthYear = birthYear;
    }

    public Human(String name, String surname, int birthYear, int iq, String[][] shedule)  {
        this(name, surname, birthYear);
        this.iq = iq;
        this.shedule = shedule;
    }

    public String getName(){ return name; }
    public void setName(String name){ this.name = name; }
    public String getSurname(){ return surname;}
    public void setSurname(String surname){ this.surname = surname;}
    public int getBirthYear(){ return birthYear;}
    public void setBirthYear(int birthYear){ this.birthYear = birthYear;}
    public int getIq(){ return iq;}
    public void setIq(int iq){ this.iq = iq;}
    public String[][] getShedule(){return shedule;}
    public void setShedule(String[][] shedule){ this.shedule = shedule;}
    public Family getFamily(){return family;}
    public void setFamily(Family family){this.family = family;}



    void greetPet(){
        if(this.getFamily() != null && this.getFamily().getPet() != null){
            System.out.printf("Hi, %s! ", this.getFamily().getPet().getNickname());
        }

    }
    void describePet() {
        if (this.getFamily() != null && this.getFamily().getPet() != null) {
            System.out.printf("I have a %s, its nickname  %s, it is %d years old and Bobby is %s ! ", this.getFamily(). getPet().getSpecies(),
                    this.getFamily().getPet().getNickname(), this.getFamily().getPet().getAge(), this.getFamily().getPet().getTrickLevel() > 50 ? "tricky" : "not tricky");
        }
    }

    @Override
    public String toString() {
        return "Human{" + "name=" + this.getName() + '\'' + ", surname=" + this.getSurname() + '\'' +
                ", birthYear=" + this.getBirthYear() + ", iq=" + this.getIq() +
                 ", shedule= " + Arrays.deepToString(this.getShedule()) + "}";
    }
    @Override
    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if (!(obj instanceof Human))
            return false;
        Human human = (Human)obj;
        return (Objects.equals(getName(), human.getName()) && Objects.equals(getSurname(), human.getSurname()));
    }
}