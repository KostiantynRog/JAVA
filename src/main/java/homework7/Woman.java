package homework7;

import java.util.Map;

public final class Woman extends Human {
    Woman(){
        super();
    }
    public Woman(String name, String surname, int birthYear){
        super(name, surname, birthYear);
    }
    public Woman(String name, String surname, int birthYear, int iq, Map<DaysOfWeek, String> shedule){
        super(name, surname, birthYear, iq, shedule);
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

