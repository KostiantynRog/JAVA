package homework5;


import java.io.IOException;
import java.util.Objects;

public class Human {
    private String name;
    private String surname;
    private int birthYear;
    private int iq;
    private DaysOfWeek day;
    private Family family;

    public Human(){};

    public Human(String name, String surname, int birthYear)  {
        this.name = name;
        this.surname = surname;
        this.birthYear = birthYear;
    }

    public Human(String name, String surname, int birthYear, int iq, DaysOfWeek day)  {
        this(name, surname, birthYear);
        this.iq = iq;
        this.day = day;
    }

    public String getName(){ return name; }
    public void setName(String name){ this.name = name; }
    public String getSurname(){ return surname;}
    public void setSurname(String surname){ this.surname = surname;}
    public int getBirthYear(){ return birthYear;}
    public void setBirthYear(int birthYear){ this.birthYear = birthYear;}
    public int getIq(){ return iq;}
    public void setIq(int iq) {
        if (iq > 100 || iq < 0) {
            try {
                throw new IOException();
            } catch (IOException e) {
                System.out.println("Incorrect iq, try again");
            }
            this.iq = iq;
        }
    }
    public DaysOfWeek getDaysOfWeek(){return day;}
    public void setDaysOfWeek(DaysOfWeek day){this.day = day;}
    public Family getFamily(){return family;}
    public void setFamily(Family family){this.family = family;}



    void greetPet(){
        if(this.getFamily() != null && this.getFamily().getPet() != null){
            System.out.printf("Hi, %s! ", this.getFamily().getPet().getNickname());
        }
    }
    void describePet() {
        if (this.getFamily() != null && this.getFamily().getPet() != null) {
            System.out.printf("I have a %s, its nickname  %s, it is %d years old and Bobby is %s ! ",
                    this.getFamily(). getPet().getSpecies(), this.getFamily().getPet().getNickname(),
                    this.getFamily().getPet().getAge(), this.getFamily().getPet().getTrickLevel() > 50 ? "tricky" : "not tricky");
        }
    }

    @Override
    public  String toString() {
        return "Human{" + "name=" + this.getName()  + ", surname=" + this.getSurname()  +
                ", birthYear=" + this.getBirthYear() + ", iq=" + this.getIq() +
                ", shedule=" + this.getDaysOfWeek() + "}";
    }
    @Override
    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if (!(obj instanceof homework4.Human))
            return false;
        homework4.Human human = (homework4.Human)obj;
        return (Objects.equals(getName(), human.getName()) && Objects.equals(getSurname(), human.getSurname()));
    }
    @Override
    protected void finalize() throws Throwable {
        System.out.printf("Deleted: %s", this.toString());
    }

}
