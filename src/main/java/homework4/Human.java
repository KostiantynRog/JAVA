package homework4;

public class Human{
   private final String name;
   private final String surname;
   private final int birthYear;
   private final int iq;
    private  Human mother;
    private  Human father;
    private  Pet pet;
    String[][] shedule = new String[7][2];


    public void setPet(Pet p){
        this.pet = p;
    }
//    public void setMother(Human m){
//        this.mother = m;
//    }

    public Human(String name, String surname, int birthYear, int iq)  {
        this.name = name;
        this.surname = surname;
        this.birthYear = birthYear;
        this.iq = iq;

    }

    public Human(String name, String surname, int birthYear, int iq, Human mother, Human father)  {
        this(name, surname,birthYear,iq);
        this.mother = mother;
        this.father = father;
    }
    public Human(String name, String surname, int birthYear, int iq, Human mother, Human father, Pet pet)  {
        this(name, surname, birthYear, iq, mother, father);
        this.pet = pet;
    }
   static void greetPet(String nickname){
        System.out.printf("Hi, %s", nickname );
    }


    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthYear=" + birthYear +
                ", iq=" + iq +
                ", mother=" + mother +
                ", father=" + father +
                ", pet=" + pet +
                '}';
    }


}