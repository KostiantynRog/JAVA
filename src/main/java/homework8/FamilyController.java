package homework8;

import homework7.Animal;
import homework7.Family;
import homework7.Human;
import homework7.Pet;

import java.util.List;
import java.util.Set;

public class FamilyController {
    private final FamilyService familyService = new FamilyService();


    public List<Family> getAllFamilies(){
        return this.familyService.getAllFamilies();
    }
    public void displayAllFamilies(){
        this.familyService.displayAllFamilies();
    }
    public List<Family> getFamiliesBiggerThen(int member){
       return this.familyService.getFamiliesBiggerThen(member);
    }
    public List<Family> getFamiliesLessThen(int member){
        return this.familyService.getFamiliesLessThen(member);
    }
    public int countFamiliesWithMemberNumber(int number){
        return this.familyService.countFamiliesWithMemberNumber(number);
    }
    public void createNewFamily(Human mother, Human father){
        this.familyService.createNewFamily(mother, father);
    }
    public boolean deleteFamilyByIndex(int index){
        return this.familyService.deleteFamilyByIndex(index);
    }
    public Family bornChild(Family family, String boysName, String girlsName){
        return this.familyService.bornChild(family, boysName, girlsName);
    }
    public Family adoptChild(Family family, Human child){
        return this.familyService.adoptChild(family, child);
    }
    public void deleteAllChildrenOlderThen(int age){
        this.familyService.deleteAllChildrenOlderThen(age);
    }
    public int count(){
        return this.familyService.count();
    }
    public Family getFamilyById(int index){
        return this.familyService.getFamilyById(index);
    }
    public Set<Pet> getPets(int index){
        return this.familyService.getPets(index);
    }
    public void addPet(int index, Pet pet){
        this.familyService.addPet(index, pet);
    }
}
