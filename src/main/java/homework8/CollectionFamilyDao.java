package homework8;

import homework7.Family;

import java.util.ArrayList;
import java.util.List;

public class CollectionFamilyDao implements FamilyDao{
    private final List<Family> allFamilies = new ArrayList<>();

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
        if(index > -1) {
            this.allFamilies.set(index, family);
        } else {
            this.allFamilies.add(family);
        }
    }
}
