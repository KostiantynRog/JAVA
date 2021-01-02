package homework12;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CollectionFamilyDao implements FamilyDao {
    private List<Family> allFamilies = new ArrayList<>();
    private long idCounter = 1;

    @Override
    public List<Family> getAllFamilies() {
        FamilyLogger.info("getting list of families");
        return this.allFamilies;
    }

    @Override
    public Family getFamilyByIndex(int index) {
        if(index < 0 || index > this.allFamilies.size() - 1){
            FamilyLogger.info("getting family by index: no family with such index");
            return null;
        }else {
            FamilyLogger.info("getting family by index");
            return this.allFamilies.get(index);
        }
    }
    @Override
    public Family getFamilyById(long id) {
        Family result = null;
        for (Family f : this.allFamilies) {
            if (f.getId() == id) result = f;
        }
        FamilyLogger.info("getting family by id");
        return result;
    }


    @Override
    public boolean deleteFamily(int index) {
        if (index < 0 || index > this.allFamilies.size() - 1) {
            FamilyLogger.info("deleting family: no family with such index");
            return false;
        } else {
            FamilyLogger.info("deleting family");
            return deleteFamily(this.allFamilies.get(index));
        }
    }

    @Override
    public boolean deleteFamily(Family family) {
        return this.allFamilies.remove(family);
    }

    @Override
    public void saveFamily(Family family) {
        int index = this.allFamilies.indexOf(family);

        if(index > -1){
            FamilyLogger.info("changing family");
            this.allFamilies.set(index, family);
        } else {
            FamilyLogger.info("adding new family");
            family.setId(idCounter++);
            this.allFamilies.add(family);
        }

    }

    @Override
    public void loadDataToDB(List<Family> families) throws IOException {
        FamilyLogger.info("loading families from DB");
        DataBase.write(families);
    }

    @Override
    public void loadDataFromDB() throws IOException {
        FamilyLogger.info("saving families to DB");
        this.allFamilies = DataBase.read();

    }

}
