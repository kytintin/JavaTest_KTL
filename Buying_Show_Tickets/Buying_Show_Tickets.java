import java.util.Arrays;
import java.util.Scanner;

class Buying_Show_Tickets
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Number of People Qeued : ");
        int num_ppl = scanner.nextInt();

        int[] tickets = new int[num_ppl];

        for (int i = 0; i < tickets.length; i++)
        {
            System.out.println("Enter amount of tickets to purchased by person " + (i+1));
            int num_tickets = scanner.nextInt();
            tickets[i]  =   num_tickets;
        }

        System.out.println("Enter your position: ");
        int position = scanner.nextInt();

        System.out.println("\n"+"Calculating your waitng time.....");

        long result = waitingTime(tickets,position);
        System.out.println("Your Estimated Waitng Time is "+result+" sec.");
    }


    static long waitingTime(int[] tickets, int p)
    {
        int totalSec = 0, waitingSec = 0;
        int numb_tickets = tickets[p];


        for (int i = 0; i < numb_tickets; i++)
        {
            System.out.println(Arrays.toString(tickets));
            for (int j = 0; j < tickets.length; j++)
            {
                if (tickets[j] != 0)
                {       
                        totalSec++;     // Increase the time
                        tickets[j] --;  // Tickets to purchase decrease 
                        if(j == p )
                        {
                            waitingSec = totalSec;
                        }
                }                  
            }
            System.out.println("Qeue Reset"); 
        }

        return waitingSec;
    }
}