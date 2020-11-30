package homework2;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SeaBattle {

    public static void main(String[] args) {

        System.out.println("All set. Get ready to rumble!");
         generateField();
         editField();
        }
    public static void generateField() {
      char [][]  field = new char[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                field[i][j] = '_';
            }
        }
        System.out.println("\t" + 1 + "\t" + 2 + "\t" + 3 + "\t" + 4 + "\t" + 5);
        for (int i = 0; i < 5; i++) {
            System.out.print(i + 1 + "\t");
            for (int j = 0; j < 5; j++) {
                System.out.print(field[i][j] + "\t");
            }
            System.out.println();
        }
    }
    public static void print (char[][] generateField){
        System.out.print(Arrays.deepToString(generateField));
    }
    public static void editField (char generateField, int targetRow, int targetColumn){
        Random random = new Random();
        targetRow = random.nextInt(4);
        targetColumn = random.nextInt(4);
       int userRow;
       int userColumn;
      do {
          Scanner in = new Scanner(System.in);
          System.out.println("Enter your number of row from 1 to 5: ");
           userRow = in.nextInt();
          System.out.println("Enter your number of column from 1 to 5: ");
          userColumn = in.nextInt();
          System.out.println(userColumn);
          if (userRow - 1 != targetRow & userColumn -1 != targetColumn){
              System.out.println("You missed. Try again");
          } else if (userRow - 1 != targetRow & userColumn -1 == targetColumn){
              System.out.println("You missed. Try again");
          }else {
              System.out.println("You won!");
          }
      } while ( targetRow  ==  userRow & targetColumn ==  userColumn );
    }
}