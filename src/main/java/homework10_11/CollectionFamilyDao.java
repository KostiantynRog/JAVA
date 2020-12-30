package homework10_11;

import java.util.ArrayList;
import java.util.List;

public class CollectionFamilyDao implements FamilyDao {
    private final List<Family> allFamilies = new ArrayList<>();
    private long idCounter = 1;

    @Override
    public List<Family> getAllFamilies() {
        return this.allFamilies;
    }

    @Override
    public Family getFamilyByIndex(int index) {
        if(index < 0 || index > this.allFamilies.size() - 1){
            return null;
        }
        return this.allFamilies.get(index);
    }
    @Override
    public Family getFamilyById(long id) {
        Family result = null;
        for (Family f : this.allFamilies) {
            if (f.getId() == id) result = f;
        }
        return result;
    }


    @Override
    public boolean deleteFamily(int index) {
        if (index < 0 || index > this.allFamilies.size() - 1) {
            return false;
        } else {
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
            this.allFamilies.set(index, family);
        } else {
            family.setId(idCounter++);
            this.allFamilies.add(family);
        }

    }

}
