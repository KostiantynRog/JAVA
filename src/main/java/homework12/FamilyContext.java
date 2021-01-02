package homework12;

public class FamilyContext {
    public static FamilyController familyController;
    public static void init(){
        FamilyDao familyDao = new CollectionFamilyDao();
        FamilyService familyService = new FamilyService(familyDao);
        familyController = new FamilyController(familyService);
    }
}
