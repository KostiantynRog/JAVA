package homework5;

import java.util.Arrays;
import java.util.Objects;

public class Family {
    private Human mother;
    private Human father;
    private Human[] children = new Human[0];
    private Pet pet;

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
    public Human[] getChildren(){return children;}
    public void setChildren(Human[] children){this.children = children;}
    public Pet getPet(){return pet;}
    public void setPet(Pet pet){this.pet = pet;}

    void addChild(Human child){
        Human[] children = Arrays.copyOf(this.getChildren(), this.getChildren().length +1);
        children[this.getChildren().length] = child;
        this.setChildren(children);
        child.setFamily(this);
    }
    boolean deleteChild(int index){
        if(index > -1 && index < this.getChildren().length){
            Human[] children = new Human[this.getChildren().length - 1];
            for (int i = 0; i < children.length; i++) {
                if (i < index) children[i] = this.getChildren()[i];
                else children[i] = this.getChildren()[i + 1];
            }

            this.setChildren(children);
            this.getChildren()[index].setFamily(null);
            return true;
        } else return false;
    }
    boolean deleteChild(Human child){
        int index=-1;
        for (int i=0; i<this.getChildren().length; i++) {
            if(child.hashCode() == this.getChildren()[i].hashCode() && this.getChildren()[i].equals(child)) index = i;
        }
        return this.deleteChild(index);
    }


    int countFamily(){
        return this.getChildren().length + 2;
    }
    @Override
    public String toString(){
        return "Family{" + "mother=" + this.getMother()  + ", father=" + this.getFather()  +
                ", children=" + Arrays.toString(this.getChildren()) + ", pet=" + this.getPet() + "}";
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if (!(obj instanceof homework4.Family))
            return false;
        homework4.Family family = (homework4.Family)obj;
        return (Objects.equals(this.getMother(), family.getMother()) && Objects.equals(this.getFather(), family.getFather()));
    }
    @Override
    protected void finalize() throws Throwable {
        System.out.printf("Deleted: %s", this.toString());
    }

}
