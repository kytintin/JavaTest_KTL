import java.util.Scanner;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.io.*;


class FindTheWinner
{
    public static void main(String[] args) throws IOException, InputMismatchException
    {
        System.out.println("Program Starts here"+"\n");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Game Mode: ");
        String game_mode = scanner.nextLine().toUpperCase();

        System.out.println("Enter the Number of Dice Amount ");
        int num_dice = scanner.nextInt();

        int[] andreaArr = new int[num_dice];
        int[] mariaArr = new int[num_dice];

        for (int i = 0; i < num_dice; i++)
        {
            System.out.println("Enter Dice Value for Andrea ");
            int andrea_value = scanner.nextInt();
            andreaArr[i] = andrea_value;
        }

        for (int i = 0; i < num_dice; i++)
        {
            System.out.println("Enter Dice Value for Maria ");
            int maria_value = scanner.nextInt();
            mariaArr[i] = maria_value;
        }

        String theWinner = winner(andreaArr, mariaArr, game_mode);
        System.out.println("The Winner is : " + theWinner);

        scanner.close();
    }


    static String winner(int[] andreaArr, int[] mariaArr, String s)
    {
        int sum_andrea = 0, sum_maria = 0;
        int total_sum_andrea = 0, total_sum_maria = 0;

        if (s.equals("EVEN") || s.equals("ODD"))
        {
            for (int i = 0; i < andreaArr.length; i++)
            {
                if(s.equals("EVEN") && (i%2) == 0)
                {
                    sum_andrea = andreaArr[i] - mariaArr[i];
                    total_sum_andrea += sum_andrea;

                    sum_maria = mariaArr[i] - andreaArr[i];
                    total_sum_maria += sum_maria;

                    System.out.println(total_sum_andrea+" "+total_sum_maria);
                }
                else if(s.equals("ODD") && (i%2) == 1)
                {
                    sum_andrea = andreaArr[i] - mariaArr[i];
                    total_sum_andrea += sum_andrea;

                    sum_maria = mariaArr[i] - andreaArr[i];
                    total_sum_maria += sum_maria;

                    System.out.println(total_sum_andrea+" "+total_sum_maria);
                }
            }

            System.out.println(total_sum_andrea+" Vs "+total_sum_maria);

            String winnerIs = total_sum_andrea == total_sum_maria ? "Tied" :
                                total_sum_andrea > total_sum_maria ? "Andrea" : "Maria";
            return winnerIs;
        }

        return "Invalid Mode. Retype the game-mode: Even or Odd";
    }

  

}