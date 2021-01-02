package homework12;


import java.io.IOException;
import java.util.List;

public interface FamilyDao {
    List<Family> getAllFamilies();
    Family getFamilyByIndex(int index);
    Family getFamilyById(long id);
    boolean deleteFamily(int index);
    boolean deleteFamily(Family family);
    void saveFamily(Family family);
    void loadDataToDB(List<Family> families) throws IOException;
    void loadDataFromDB() throws IOException;
}
