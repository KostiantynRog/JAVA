package homework3;

import java.util.Scanner;

public class Timetable {
   public static void main (String[] args){
       String[][] shedule = new String[7][2];
       shedule[0][0] = "SUNDAY";
       shedule[0][1] = "go to the park";
       shedule[1][0] = "MONDAY";
       shedule[1][1] = "go to the courses";
       shedule[2][0] = "TUESDAY";
       shedule[2][1] = "go to the doctor";
       shedule[3][0] = "WEDNESDAY";
       shedule[3][1] = "go to the office";
       shedule[4][0] = "THURSDAY";
       shedule[4][1] = "go to the cinema";
       shedule[5][0] = "FRIDAY";
       shedule[5][1] = "go to the stadium";
       shedule[6][0] = "SATURDAY";
       shedule[6][0] = "stay at home";
       Scanner sc = new Scanner(System.in);
       do {
         System.out.print("\nPlease, input the day of the week:\n");
         String userInput = sc.nextLine();
           switch (userInput.toUpperCase()) {
               case "SUNDAY":
                   System.out.printf("Your tasks for %s: %s", userInput, shedule[0][1]);
                   break;
               case "MONDAY":
                   System.out.printf("Your tasks for %s: %s", userInput, shedule[1][1]);
                   break;
               case "TUESDAY":
                   System.out.printf("Your tasks for %s: %s", userInput, shedule[2][1]);
                   break;
               case "WEDNESDAY":
                   System.out.printf("Your tasks for %s: %s", userInput, shedule[3][1]);
                   break;
               case "THURSDAY":
                   System.out.printf("Your tasks for %s: %s", userInput, shedule[4][1]);
                   break;
               case "FRIDAY":
                   System.out.printf("Your tasks for %s: %s", userInput, shedule[5][1]);
                   break;
               case "SATURDAY":
                   System.out.printf("Your tasks for %s: %s", userInput, shedule[6][1]);
                   break;
               case "EXIT":
                   return;
               default:
                   System.out.println("Sorry, I don't understand you, please try again.");
           }
      }while (true);
   }
}

