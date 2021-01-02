package homework12;



import java.io.IOException;
import java.util.List;
import java.util.Set;

public class FamilyController {
    private  FamilyService familyService;
    public FamilyController(FamilyService familyService){
        this.familyService = familyService;
    }

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
        int limit = 4;
        if(family.countFamily() > limit){
            throw new FamilyOverflowException(limit);
        }else {
            return this.familyService.bornChild(family, boysName, girlsName);
        }
    }
    public Family adoptChild(Family family, Human child){
        int limit = 5;
        if(family.countFamily() > limit){
            throw new FamilyOverflowException(limit);
        }else {
            return this.familyService.adoptChild(family, child);
        }
    }
    public void deleteAllChildrenOlderThen(int age){
        this.familyService.deleteAllChildrenOlderThen(age);
    }
    public int count(){
        return this.familyService.count();
    }
    public Family getFamilyByIndex(int index){
        return this.familyService.getFamilyByIndex(index);
    }
    public Family getFamilyById(long id){ return this.familyService.getFamilyById(id); }


    public Set<Pet> getPets(int index){
        return this.familyService.getPets(index);
    }
    public void addPet(int index, Pet pet){
        this.familyService.addPet(index, pet);
    }
    public void loadDataToDB(List<Family> families) throws IOException {
        this.familyService.loadDataToDB(families);
    }
    public void loadDataFromDB() throws IOException{
        this.familyService.loadDataFromDB();
    }
}
