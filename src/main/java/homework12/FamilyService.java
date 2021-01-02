package homework12;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FamilyService {
    private  FamilyDao familyDao;
    public FamilyService(FamilyDao familyDao){
        this.familyDao = familyDao;
    }

    public List<Family> getAllFamilies(){
        return this.familyDao.getAllFamilies();
    }

    public void displayAllFamilies() {
        this.familyDao.getAllFamilies().forEach(family -> System.out.println(family.prettyFormat()));
    }
    public List<Family> getFamiliesBiggerThen(int count){
        return this.familyDao.getAllFamilies()
                .stream()
                .filter(family -> family.countFamily() > count)
                .peek(f -> System.out.println(f.prettyFormat()))
                .collect(Collectors.toList());
    }
    public List<Family> getFamiliesLessThen(int count){
        return this.familyDao.getAllFamilies()
                .stream()
                .filter(family -> family.countFamily() < count)
                .peek(f -> System.out.println(f.prettyFormat()))
                .collect(Collectors.toList());
    }
    public int countFamiliesWithMemberNumber(int number){
        return (int) this.familyDao.getAllFamilies()
                .stream()
                .filter(family -> family.countFamily() == number)
                .count();
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
        LocalDate today = LocalDate.now();
        this.familyDao.getAllFamilies()
                .forEach(family -> family.setChildren(
                        family.getChildren()
                                .stream()
                                .filter(child -> {
                                    LocalDate birthday = LocalDate.ofEpochDay(child.getBirthDate()/1000/60/60/24);
                                    Period p = Period.between(birthday, today);
                                    return p.getYears() <= age;
                                })
                                .collect(Collectors.toList())));
    }
    public int count(){
        return this.familyDao.getAllFamilies().size();
    }
    public Family getFamilyByIndex(int index){
        return this.familyDao.getFamilyByIndex(index);
    }
    public Family getFamilyById(long id){
        return this.familyDao.getFamilyById(id);
    }
    public Set<Pet> getPets(int index){
        return this.familyDao.getFamilyByIndex(index).getPet();
    }
    public void addPet(int index, Pet pet){
        Family family = this.familyDao.getFamilyByIndex(index);
        family.addPet(pet);
        this.familyDao.saveFamily(family);
    }
    public void loadDataToDB(List<Family> families) throws IOException {
        this.familyDao.loadDataToDB(families);
    }
    public void loadDataFromDB() throws IOException {
        this.familyDao.loadDataFromDB();
    }
}
