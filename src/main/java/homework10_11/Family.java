package homework10_11;

import java.util.*;

public class Family implements HumanCreator {
    private Human mother;
    private Human father;
    private List<Human> children = new ArrayList<>();
    private Set<Pet> pets = new HashSet<>();
    protected long id;

    public Family(Human mother, Human father){
        setMother(mother);
        setFather(father);
        mother.setFamily(this);
        father.setFamily(this);
    }

    public Human getMother(){return mother;}
    public void setMother(Human mother){this.mother = mother;}
    public Human getFather(){return father;}
    public void setFather(Human father){this.father = father;}
    public List<Human> getChildren(){return children;}
    public void setChildren(List<Human> children){this.children = children;}
    public Set<Pet> getPet(){return pets;}
    public void setPet(Set<Pet>pets){this.pets = pets;}
    public long getId(){return id;}
    public  void setId(long id){this.id = id;}

    public void addPet(Pet pet){
        this.pets.add(pet);
    }
    public void deletePet(Pet pet){
        this.pets.remove(pet);
    }
    public void addChild(Human child){
        this.children.add(child);
        child.setFamily(this);
    }
    boolean deleteChild(int index){
        if(index < 0 || index < this.children.size() - 1){
            return false;
        }
        return deleteChild(this.children.get(index));
    }
    public boolean deleteChild(Human child){
        child.setFamily(null);
        return this.children.remove(child);
    }

    public int countFamily(){
        return this.children.size() + 2;
    }

    public String prettyFormat(){
        return "family:\n"
                + "      mother: " + this.mother.prettyFormat()
                + "      father: " + this.father.prettyFormat()
                + "      children: " + this.getChildren().stream().map(Human::prettyFormat).reduce("", (x, y) -> x + y)
                + "      pets: " + this.getPet().stream().map(Pet::prettyFormat).reduce("", (x, y) -> x + y);
    }
    @Override
    public String toString(){
        return "Family{" + "mother=" + this.getMother()  + ", father=" + this.getFather()  +
                ", children=" + this.getChildren() + ", pet=" + this.getPet() + "}";
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if (!(obj instanceof Family))
            return false;
        Family family = (Family)obj;
        return (Objects.equals(this.getMother(), family.getMother()) && Objects.equals(this.getFather(), family.getFather()));
    }
    @Override
    protected void finalize() throws Throwable {
        System.out.printf("Deleted: %s", this.toString());
    }


    @Override
    public Human bornChild(String girlsName, String boysName) {
        Random random = new Random();
        int gender = random.nextInt(2);
        String childName = gender == 0 ? boysName:girlsName;
        int childIq = (this.mother.getIq() + this.father.getIq()) / 2;
        int year = Calendar.getInstance().get(Calendar.YEAR);
        Map<DaysOfWeek, String> childSchedule= new HashMap<>();
//        childSchedule.put(DaysOfWeek.MONDAY, "play, cry, sleep");
//        childSchedule.put(DaysOfWeek.TUESDAY, "play, cry, sleep");
//        childSchedule.put(DaysOfWeek.WEDNESDAY, "play, cry, sleep");
//        childSchedule.put(DaysOfWeek.THURSDAY, "play, cry, sleep");
//        childSchedule.put(DaysOfWeek.FRIDAY, "play, cry, sleep");
//        childSchedule.put(DaysOfWeek.SATURDAY, "play, cry, sleep");
//        childSchedule.put(DaysOfWeek.SUNDAY, "play, cry, sleep");
        Human child;
        if(gender == 0){
            child = new Man(childName, this.father.getSurname(), year, childIq, childSchedule);
        } else {
            child = new Woman(childName, this.father.getSurname(), year, childIq, childSchedule);
        }
        this.addChild(child);
        child.setFamily(this);

        return child;
    }
}
