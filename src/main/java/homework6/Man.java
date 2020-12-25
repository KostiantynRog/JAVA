package homework6;

public final class Man extends Human {
    Man(){
        super();
    }
    Man(String name, String surname, int birthYear){
        super(name, surname, birthYear);
    }
    Man(String name, String surname, int birthYear, int iq, DaysOfWeek day){
        super(name, surname, birthYear, iq, day);
    }
    @Override
    void greetPet(){
        if(this.getFamily() != null && this.getFamily().getPet() != null){
            System.out.printf("Hi, %s! ", this.getFamily().getPet().getNickname());
        }
    }
    void repairCar(){
        System.out.println("I always repair my car myself");
    }
}
