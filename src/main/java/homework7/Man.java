package homework7;

import java.util.Map;

public final class Man extends Human {
    Man(){
        super();
    }
    public Man(String name, String surname, int birthYear){
        super(name, surname, birthYear);
    }
    public Man(String name, String surname, int birthYear, int iq, Map<DaysOfWeek, String> shedule){
        super(name, surname, birthYear, iq, shedule);
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
