package homework7;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

    public class Human {
        private String name;
        private String surname;
        private int birthYear;
        private int iq;
        private Map<DaysOfWeek, String> shedule = new HashMap<>();
        private Family family;
        public Pet pet;

        public Human(){};

        public Human(String name, String surname, int birthYear)  {
            this.name = name;
            this.surname = surname;
            this.birthYear = birthYear;
        }

        public Human(String name, String surname, int birthYear, int iq, Map<DaysOfWeek, String> shedule)  {
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
        public Map<DaysOfWeek, String> getDaysOfWeek(){return shedule;}
        public void setDaysOfWeek(Map<DaysOfWeek, String> shedule){this.shedule = shedule;}
        public Family getFamily(){return family;}
        public void setFamily(Family family){this.family = family;}



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
