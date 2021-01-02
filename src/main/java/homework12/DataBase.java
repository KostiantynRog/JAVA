package homework12;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private static final String path = "D://JAVAHomework/database.txt";
    public static void write(List<Family> families){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))){
            oos.writeObject(families);
        }catch (Exception e){
            FamilyLogger.error("writing list of families into file");
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public static List<Family> read(){
        List<Family> families = new ArrayList<>();
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))){
            families = ((List<Family>)ois.readObject());
        }catch (Exception e){
            FamilyLogger.error("reading list of families from file");
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
        return families;
    }
}
