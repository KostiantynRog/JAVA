package homework12;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class Console {
    public static void start() throws IOException {
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        while (run){
            printMenuItems();
            String input = scanner.nextLine();
            switch (input){
                case "1":
                    FamilyContext.familyController.loadDataFromDB();
                    break;
                case "2":
                    FamilyContext.familyController.displayAllFamilies();
                    break;
                case "3":
                    System.out.println(FamilyContext.familyController.getFamiliesBiggerThen(readNumber(scanner)));
                    break;
                case "4":
                    System.out.println(FamilyContext.familyController.getFamiliesLessThen(readNumber(scanner)));
                    break;
                case "5":
                    System.out.println(FamilyContext.familyController.countFamiliesWithMemberNumber(readNumber(scanner)));
                    break;
                case "6":
                    System.out.println("Enter mother name:");
                    String motherName = scanner.nextLine();
                    System.out.println("Enter mother surname:");
                    String motherSurname = scanner.nextLine();
                    System.out.println("Enter mother birth year:");
                    String motherBirthYear = scanner.nextLine();
                    System.out.println("Enter mother birth month:");
                    String motherBirthMonth = scanner.nextLine();
                    System.out.println("Enter mother birth day:");
                    String motherBirthDay = scanner.nextLine();
                    System.out.println("Enter mother iq");
                    int motherIq = readNumber(scanner);


                    System.out.println("Enter father name:");
                    String fatherName = scanner.nextLine();
                    System.out.println("Enter father surname:");
                    String fatherSurname = scanner.nextLine();
                    System.out.println("Enter father birth year:");
                    String fatherBirthYear = scanner.nextLine();
                    System.out.println("Enter father birth month:");
                    String fatherBirthMonth = scanner.nextLine();
                    System.out.println("Enter father birth day:");
                    String fatherBirthDay = scanner.nextLine();
                    System.out.println("Enter father iq");
                    int fatherIq = readNumber(scanner);


                    FamilyContext.familyController.createNewFamily(new Human(motherName, motherSurname, motherBirthDay + "." + motherBirthMonth + "." + motherBirthYear, motherIq),
                            new Human(fatherName, fatherSurname, fatherBirthDay + "." + fatherBirthMonth + "." + fatherBirthYear, fatherIq));
                        break;
                case "7":
                    System.out.println("Family id");
                    FamilyContext.familyController.deleteFamilyByIndex(readNumber(scanner));
                    break;
                case "8":
                    boolean subRun = true;
                    while (subRun){
                        printSubMenuItems();
                        String submenuItem = scanner.nextLine();
                        switch (submenuItem){
                            case "1":
                                System.out.println("Family id");
                                int subFamilyNumber = readNumber(scanner);
                                System.out.println("Enter girl name:");
                                String subFamilyGirlName = scanner.nextLine();
                                System.out.println("Enter boy name:");
                                String subFamilyBoyName = scanner.nextLine();
                                FamilyContext.familyController.bornChild(FamilyContext.familyController.getFamilyByIndex(subFamilyNumber), subFamilyBoyName, subFamilyGirlName);
                                break;
                            case "2":
                                System.out.println("Family id");
                                int subFamilyNumber2 = readNumber(scanner);
                                System.out.println("Enter child name:");
                                String childName = scanner.nextLine();
                                System.out.println("Enter child surname:");
                                String childSurname = scanner.nextLine();
                                System.out.println("Enter child birth year:");
                                String childBirthYear = scanner.nextLine();
                                System.out.println("Enter child birth month:");
                                String childBirthMonth = scanner.nextLine();
                                System.out.println("Enter child birth day:");
                                String childBirthDay = scanner.nextLine();
                                System.out.println("Child iq");
                                int childIq = readNumber(scanner);
                                FamilyContext.familyController.adoptChild(FamilyContext.familyController.getFamilyByIndex(subFamilyNumber2), new Human(childName, childSurname, childBirthDay + "." + childBirthMonth + "." + childBirthYear, childIq));
                                break;
                            case "3":
                                subRun = false;
                                break;
                            default:
                                System.out.println("Unknown command");
                                break;
                        }
                    }
                    break;
                case "9":
                    FamilyContext.familyController.deleteAllChildrenOlderThen(readNumber(scanner));
                    break;
                case "10":
                    FamilyContext.familyController.loadDataToDB(FamilyContext.familyController.getAllFamilies());
                    break;
                case "exit":
                    run = false;
                    break;
                default:
                    System.out.println("Unknown command");
                    break;
            }
        }
    }

    private static int readNumber(Scanner scanner) {
        int result = 0;
        while (result == 0){
            System.out.println("Enter number:");
            String number = scanner.nextLine();
            try {
                result = Integer.parseInt(number);
            } catch (Exception e) {
                FamilyLogger.error("reading the input number");
                System.out.println("This is not a number.");
            }
        }
        return result;
    }

    public static void printMenuItems(){
        System.out.println("Please enter command");
        System.out.println("1. Load families from DataBase");
        System.out.println("2. Display all families");
        System.out.println("3. Display families with family members more than defined");
        System.out.println("4. Display families with family members less than defined");
        System.out.println("5. Count families with family members equal to defined");
        System.out.println("6. Create new family");
        System.out.println("7. Delete family by index");
        System.out.println("8. Edit family by index ");
        System.out.println("9. Delete children older then defined");
        System.out.println("10. Save all families to DataBase");
    }
    private static void printSubMenuItems(){
        System.out.println("Please enter command");
        System.out.println("1. Born child");
        System.out.println("2. Adopt child");
        System.out.println("3. Back to main menu");
    }
}
