package homework8;

import homework7.Family;
import homework7.Human;
import homework7.Pet;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

public class FamilyService {
    private final FamilyDao familyDao = new CollectionFamilyDao();

    public List<Family> getAllFamilies(){
        return this.familyDao.getAllFamilies();
    }
    public void displayAllFamilies() {
        for (Family family : this.familyDao.getAllFamilies()) {
            System.out.println(family.toString());
        }
    }
    public List<Family> getFamiliesBiggerThen(int member){
        List<Family> result = new ArrayList<>();
        for(Family family : this.familyDao.getAllFamilies()){
            if(family.countFamily() > member){
                result.add(family);
                System.out.println(family.toString());
            }
        }
        return result;
    }
    public List<Family> getFamiliesLessThen(int member){
        List<Family> result = new ArrayList<>();
        for(Family family : this.familyDao.getAllFamilies()){
            if(family.countFamily() < member){
                result.add(family);
                System.out.println(family.toString());
            }
        }
        return result;
    }
    public int countFamiliesWithMemberNumber(int number){
        int result = 0;
        for(Family family : this.familyDao.getAllFamilies()){
            if(family.countFamily() == number){
                result++;
            }
        }
        return result;
    }
    public void createNewFamily(Human mother, Human father){
        Family family = new Family(mother, father);
        this.familyDao.saveFamily(family);
    }
    public boolean deleteFamilyByIndex(int index){
        return this.familyDao.deleteFamily(index);
    }

    public Family bornChild(Family family, String boysName, String girlsName){
        family.bornChild(girlsName, boysName);
        this.familyDao.saveFamily(family);
        return family;
    }
    public Family adoptChild(Family family, Human child){
        family.addChild(child);
        this.familyDao.saveFamily(family);
        return family;
    }
    public void deleteAllChildrenOlderThen(int age){
        for(Family family : this.familyDao.getAllFamilies()){
            for(Human child : family.getChildren()){
                if(Calendar.getInstance().get(Calendar.YEAR) - child.getBirthYear() > age){
                    family.deleteChild(child);
                    this.familyDao.saveFamily(family);
                }
            }
        }
    }
    public int count(){
        return this.familyDao.getAllFamilies().size();
    }
    public Family getFamilyById(int index){
        return this.familyDao.getFamilyByIndex(index);
    }
    public Set<Pet> getPets(int index){
        return this.familyDao.getFamilyByIndex(index).getPet();
    }
    public void addPet(int index, Pet pet){
        Family family = this.familyDao.getFamilyByIndex(index);
        family.addPet(pet);
        this.familyDao.saveFamily(family);
    }
}
