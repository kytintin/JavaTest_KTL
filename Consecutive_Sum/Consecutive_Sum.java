import java.util.Scanner;

class ConsecutiveSum
{
   
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        int result = consecutive(input);
        System.out.println(result);
    }

    static int consecutive(long n)
    {
        int sum = (int)n;
        int ConsecutiveTime = 0;
        int sumArr = 0;
        int total = 0;

        int[] consecutiveArr = buildArray(sum);

        for (int i = 0; i < consecutiveArr.length; i++)
        {
           for (int j = i + 1; j <= ((sum/2)+1); j++)
           {
               sumArr = sumArr + j;
              
               if(sumArr == sum)
                    total++;             
           }
           /* Reset the Sum of Arrays */ 
           sumArr = 0;
        }

        return total;
    }

    /*Build an array according to the Input*/
    static int[] buildArray(int n)
    {
        int[] consecutiveArr = new int[n - 1];
       
        for(int i = 1; i < n; i++)
        {
            consecutiveArr[i-1] = i;
        }

        return consecutiveArr;
    }
}