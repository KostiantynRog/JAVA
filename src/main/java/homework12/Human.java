package homework12;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Human implements Serializable {
    private String name;
    private String surname;
    private long birthDate;
    private int iq;
    private Map<DaysOfWeek, String> shedule = new HashMap<>();
    private Family family;
    public Pet pet;

    public Human(){};

    public Human(String name, String surname, long birthDate)  {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }
    public Human(String name, String surname, String birth, int iq) {
        setName(name);
        setSurname(surname);
        setIq(iq);
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        try {
            Date date = dateFormat.parse(birth);
            setBirthDate(date.getTime());
        } catch (ParseException e){
            System.out.println("Cannot parse date. " + e.getMessage());
        }
    }

    public Human(String name, String surname, long birthDate, int iq, Map<DaysOfWeek, String> shedule)  {
        this(name, surname, birthDate);
        this.iq = iq;
        this.shedule = shedule;
    }

    public String getName(){ return name; }
    public void setName(String name){ this.name = name; }
    public String getSurname(){ return surname;}
    public void setSurname(String surname){ this.surname = surname;}
    public long getBirthDate(){return birthDate;}
    public void setBirthDate(long birthDate){ this.birthDate = birthDate;}
    public int getIq(){return iq;}
    public void setIq(int iq) {
        if (iq > 100 || iq < 0) {
            System.out.println("Wrong iq");
            return;
        }
//            try {
//                throw new IOException();
//            } catch (IOException e) {
//                System.out.println("Incorrect iq, try again");
//            }
            this.iq = iq;
//        }
    }
    public Map<DaysOfWeek, String> getDaysOfWeek(){return shedule;}
    public void setDaysOfWeek(Map<DaysOfWeek, String> shedule){this.shedule = shedule;}
    public Family getFamily(){return family;}
    public void setFamily(Family family){this.family = family;}

    public String describeAge(){
        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.ofEpochDay(this.getBirthDate());
        Period p = Period.between(birthday, today);

        return "лет: " + p.getYears() + " месяцев: " + p.getMonths() + " дней: " + p.getDays();
    }

    void greetPet(){
        if(this.pet != null){
            System.out.printf("Hi, %s! ", this.pet.getNickname());
        }
    }
    void describePet() {
        if (this.pet != null) {
            System.out.printf("I have a %s, its nickname  %s, it is %d years old and it is %s ! ",
                    this.pet.getSpecies(), this.pet.getNickname(),
                    this.pet.getAge(), this.pet.getTrickLevel() > 50 ? "tricky" : "not tricky");
        }
    }
    public String prettyFormat(){
        return this.toString() + "\n";
    }


    @Override
    public  String toString() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date birthDay = new Date(this.getBirthDate());
        return "Human{" + "name=" + this.getName()  + ", surname=" + this.getSurname()  +
                ", birthDate=" + dateFormat.format(birthDay) + ", iq=" + this.getIq() +
                ", shedule=" + this.getDaysOfWeek() + "}";
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
    @Override
    protected void finalize() throws Throwable {
        System.out.printf("Deleted: %s", this.toString());
    }

}
