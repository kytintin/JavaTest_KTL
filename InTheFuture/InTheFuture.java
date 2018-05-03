import java.util.Scanner;

class InTheFuture
{
    public static void main(String[] args)
    {
        System.out.println("Program Strating ... \n");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Number problems solved of Asha/day ");
        int num_prob_asha = scanner.nextInt();

        System.out.println("Number problems solved of Kelly/day ");
        int num_prob_kelly = scanner.nextInt();

        System.out.println("Number problems ahead by Asha ");
        int num_prob_ahead = scanner.nextInt();

        if (num_prob_asha > num_prob_kelly)
        {
            System.out.println("Never...");
        }else
            System.out.println("Number of Days "+minNum(num_prob_asha,num_prob_kelly,num_prob_ahead));
        
        scanner.close();
    }

    static int minNum(int A, int K, int P)
    {
        int num_days = 0;

        if(A > 0 && A <= 100 && P >=0 && P<=100)
        {
            int a_prob = A + P, k_prob = K;

            while(true)
            {
                k_prob += K;    /* Problems solved by Kelly per day */
                a_prob += A;    /* Problems solved by Asha per day */
                System.out.println(k_prob+" "+a_prob);
                num_days++;

                if( k_prob > a_prob)
                    break;
            }
        }       

        return num_days;
    }
}