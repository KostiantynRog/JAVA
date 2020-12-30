package homework10_11;

import java.text.ParseException;
import java.util.Scanner;

public class Console {
    public static void start() throws ParseException {
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        FamilyController familyController = new FamilyController();
        while (run){
            printMenuItems();
            String input = scanner.nextLine();
            switch (input){
                case "1":
                    createBD(familyController);
                    break;
                case "2":
                    familyController.displayAllFamilies();
                    break;
                case "3":
                    System.out.println(familyController.getFamiliesBiggerThen(readNumber(scanner)));
                    break;
                case "4":
                    System.out.println(familyController.getFamiliesLessThen(readNumber(scanner)));
                    break;
                case "5":
                    System.out.println(familyController.countFamiliesWithMemberNumber(readNumber(scanner)));
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


                    familyController.createNewFamily(new Human(motherName, motherSurname, motherBirthDay + "." + motherBirthMonth + "." + motherBirthYear, motherIq),
                            new Human(fatherName, fatherSurname, fatherBirthDay + "." + fatherBirthMonth + "." + fatherBirthYear, fatherIq));
                        break;
                case "7":
                    System.out.println("Family id");
                    familyController.deleteFamilyByIndex(readNumber(scanner));
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
                                familyController.bornChild(familyController.getFamilyByIndex(subFamilyNumber), subFamilyBoyName, subFamilyGirlName);
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
                                familyController.adoptChild(familyController.getFamilyByIndex(subFamilyNumber2), new Human(childName, childSurname, childBirthDay + "." + childBirthMonth + "." + childBirthYear, childIq));
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
                    familyController.deleteAllChildrenOlderThen(readNumber(scanner));
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
                System.out.println("This is not a number.");
            }
        }
        return result;
    }

    public static void printMenuItems(){
        System.out.println("Please enter command");
        System.out.println("1. Fill in test data");
        System.out.println("2. Display all families");
        System.out.println("3. Display families with family members more than defined");
        System.out.println("4. Display families with family members less than defined");
        System.out.println("5. Count families with family members equal to defined");
        System.out.println("6. Create new family");
        System.out.println("7. Delete family by index");
        System.out.println("8. Edit family by index ");
        System.out.println("9. Delete children older then defined");
    }
    private static void printSubMenuItems(){
        System.out.println("Please enter command");
        System.out.println("1. Born child");
        System.out.println("2. Adopt child");
        System.out.println("3. Back to main menu");
    }
    private static void createBD(FamilyController familyController) throws ParseException {
        familyController.createNewFamily(new Human("Kate", "Smith", "12.04.1974", 75),
                new Human("Demos", "Russo", "19.08.1976", 80));
        familyController.createNewFamily(new Human("Iren", "Crow", "01.11.1996", 95),
                new Human("Phil", "Collins", "11.09.1998", 80));
        familyController.createNewFamily(new Human("Sam", "Brown", "29.01.1986", 70),
                new Human("Bill", "Clinton", "25.02.1995", 86));
        familyController.createNewFamily(new Human("Jane", "Yer", "12.09.2003", 83),
                new Human("Alex", "Remo", "02.08.2000", 82));
        familyController.bornChild(familyController.getFamilyByIndex(0), "Jhon", "liza");
        familyController.bornChild(familyController.getFamilyByIndex(0), "Elton", "Viki");
        familyController.bornChild(familyController.getFamilyByIndex(2), "Val", "Lucy");
        familyController.bornChild(familyController.getFamilyByIndex(2), "Jack", "Linda");
        familyController.bornChild(familyController.getFamilyByIndex(2), "Russel", "Helen");
        familyController.bornChild(familyController.getFamilyByIndex(3), "Andrew", "Kylie");
    }

}
