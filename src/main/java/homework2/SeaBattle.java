package homework2;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SeaBattle {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("All set. Get ready to rumble!");

           public static void print (char[][] generateField){
                System.out.println(Arrays.deepToString(generateField));
            }
//         generateField();

        }
    public static void generateField() {
                char[][] field = new char[5][5];
                for (char[] chars : field) {
                    Arrays.fill(chars, '-');
                }
                System.out.println("\t" + 1 + "\t" + 2 + "\t" + 3 + "\t" + 4 + "\t" + 5);

                for (int i = 0; i < 5; i++) {
                    System.out.print(i + 1 + "\t");
                    for (int j = 0; j < 5; j++) {
                        System.out.print(field[i][j] + "\t");
                    }
                }
    }
    public static void editField (generateField, int targetRow, int targetColumn){
        Random random = new Random();
        targetRow = random.nextInt(4);
        targetColumn = random.nextInt(4);
        int[][] target = new int[2][2];

    }
}