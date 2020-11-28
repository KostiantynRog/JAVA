package homework1;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class Programm {
    public static void main(String[] args) {

        int GuessNumber, UserNumber, Counter = 0;
        int [] UserArray = new int [100];
        Scanner in = new Scanner(System.in);
        System.out.println("Let the game begin!");
        System.out.print("Please, input your name: ");
        String name = in.nextLine();
        Random random = new Random();
        GuessNumber = random.nextInt(100) + 1;

        do {
            Counter++;
            System.out.println("Input your number: ");
            UserNumber = in.nextInt();
            for (int i = 0; i < 100; i++){
                UserArray [i] = UserNumber;
            }
            if (UserNumber > GuessNumber)
                System.out.println("Your number is too big. Try again");

            else if (UserNumber < GuessNumber)
                System.out.println("Your number is too small. Try again");
            else
                System.out.printf("Congrats, " + name);

        } while (GuessNumber != UserNumber);

   }
}
