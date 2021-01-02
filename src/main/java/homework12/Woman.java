package homework12;


import java.io.Serializable;
import java.util.Map;

public final class Woman extends Human implements Serializable {
    Woman(){
        super();
    }
    public Woman(String name, String surname, long birthDate){
        super(name, surname, birthDate);
    }
    public Woman(String name, String surname, long birthDate, int iq, Map<DaysOfWeek, String> shedule){
        super(name, surname, birthDate, iq, shedule);
    }
    @Override
    void greetPet(){
        if(this.pet != null){
            System.out.printf("Hi, %s! ", this.pet.getNickname());
        }
    }
    void makeUp(){
        System.out.println("I always do perfect makeup!");
    }
}
