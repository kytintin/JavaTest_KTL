import java.util.Arrays;
import java.util.Scanner;

class PsychometricTest
{
    public static void main(String[] args)
    {
        System.out.println("Program Start");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of Candidates: ");
        int numb_candidates = scanner.nextInt();

        System.out.println("Enter the Number of Limits ");
        int num_limits = scanner.nextInt();

        int[] upperlimitsArr = new int[num_limits];
        int[] lowerlimitsArr = new int[num_limits];
        int[] socresArr =  new int[numb_candidates];

        for (int i = 0; i < numb_candidates; i++)
        {
            System.out.println("Enter Socres for user "+ (i+1));
            int scores = scanner.nextInt();
            socresArr[i] = scores;
        }

        for (int i = 0; i < num_limits; i++)
        {
            System.out.println("Enter Lowerlimit Range ");
            int lowerlimits = scanner.nextInt();
            lowerlimitsArr[i] = lowerlimits;
        }

        for (int i = 0; i < num_limits; i++)
        {
            System.out.println("Enter UpperLimit Range ");
            int upperlimits = scanner.nextInt();
            upperlimitsArr[i] = upperlimits;
        }

        System.out.println(Arrays.toString(jobOffers(socresArr, lowerlimitsArr, upperlimitsArr)));

        scanner.close();
    }

    static int[] jobOffers(int[] scores, int[] lowerlimits, int[] upperlimits)
    {
        System.out.println(Arrays.toString(lowerlimits)+" "+Arrays.toString(upperlimits));

        int num_candidates = scores.length;
        int num_limits = lowerlimits.length;

        int[] offers = new int[num_limits];

        int qualified_candidates = 0;

        for(int i = 0; i<(num_limits); i++)
        {
            qualified_candidates = 0;
            for(int j = 0; j < num_candidates; j++)
            {
                if(scores[j] >= lowerlimits[i] && scores[j] <= upperlimits[i])
                {
                    qualified_candidates ++;
                    offers[i] = qualified_candidates;
                    System.out.println(qualified_candidates);
                }
            }
            //System.out.println("Another Loop");
        }

        return offers;
    }
}