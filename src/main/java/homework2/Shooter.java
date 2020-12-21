package homework2;

import java.util.Random;
import java.util.Scanner;

public class Shooter {
    public static int ship;
    public static char[][] field = new char[5][5];
    public static void main(String[] args){
        System.out.println("All set. Get ready to rumble!!!");
        createField();
        setShip();

        do {
            battle();
        }while(Shooter.ship != 0 );
        gameOver();
    }

    public static void createField(){
        System.out.print("  ");
        for(int i = 0; i < 5; i++)
            System.out.print(i);
        System.out.println();

        for(int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = ' ';
                if (j == 0)
                    System.out.print(i + "|" + field[i][j]);
                else if (j == field[i].length - 1)
                    System.out.print(field[i][j] + "|" + i);
                else
                    System.out.print(field[i][j]);
            }
            System.out.println();
        }
        System.out.print("  ");
        for(int i = 0; i < 4; i++)
            System.out.print(i);
           System.out.println();
    }

    public static void setShip(){
        Shooter.ship = 1;

            Random random = new Random();
            int x = random.nextInt(4);
            int y = random.nextInt(4);

            if(x < 5 && y < 5)   field[x][y] = 'x'; //'x'
        printField();
    }

    public static void battle(){
        playerShoot();
        printField();
        System.out.println();
    }

    public static void playerShoot(){
        int x, y;
        do {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter row number from 0 to 4: ");
            x = input.nextInt();
            System.out.print("Enter column number from 0 to 4: ");
            y = input.nextInt();

            if ((x >= 0 && x < 5) && (y >= 0 && y < 5))
            {
                if (field[x][y] == 'x')   --Shooter.ship;

                else if (field[x][y] == ' ') {
                    field[x][y] = '*';
                }
            }
        }while((x < 0 || x >= 4) || (y < 0 || y >= 4));
    }
    public static void gameOver(){
        if(Shooter.ship < 1 )
            System.out.println("You have won!");
    }

    public static void printField(){
        System.out.println();
        System.out.print("  ");
        for(int i = 0; i < 4; i++)
            System.out.print(i);
        System.out.println();

        for(int x = 0; x < field.length; x++) {
            System.out.print(x + "|");

            for (int y = 0; y < field[x].length; y++){
                System.out.print(field[x][y]);
            }
            System.out.println("|" + x);
        }
        System.out.print("  ");
        for(int i = 0; i < 4; i++)
            System.out.print(i);
        System.out.println();
    }
}


