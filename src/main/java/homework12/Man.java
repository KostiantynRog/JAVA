package homework12;

import java.io.Serializable;
import java.util.Map;

public final class Man extends Human implements Serializable {
    Man(){
        super();
    }
    public Man(String name, String surname, long birthDate){
        super(name, surname, birthDate);
    }
    public Man(String name, String surname, long birthDate, int iq, Map<DaysOfWeek, String> shedule){
        super(name, surname, birthDate, iq, shedule);
    }
    @Override
    void greetPet(){
        if(this.pet != null){
            System.out.printf("Hi, %s! ", this.pet.getNickname());
        }
    }
    void repairCar(){
        System.out.println("I always repair my car myself");
    }
}
