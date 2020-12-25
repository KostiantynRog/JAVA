package homework6;

public final class Woman extends Human {
    Woman(){
        super();
    }
    Woman(String name, String surname, int birthYear){
        super(name, surname, birthYear);
    }
    Woman(String name, String surname, int birthYear, int iq, DaysOfWeek day){
        super(name, surname, birthYear, iq, day);
    }
    @Override
    void greetPet(){
        if(this.getFamily() != null && this.getFamily().getPet() != null){
            System.out.printf("Hi, %s! ", this.getFamily().getPet().getNickname());
        }
    }
    void makeUp(){
        System.out.println("I always do perfect makeup!");
    }
}
