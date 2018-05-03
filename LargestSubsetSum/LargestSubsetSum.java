/* This question is unclear for me. I don't see any sample or explanation */
import java.util.Arrays;


class LargestSubsetSum
{
    public static void main(String[] args)
    {
        System.out.println("Programme Start...\n");
        System.out.println(Arrays.toString(MaxSubsetSum(new int[]{2,4})));
    }

    static long[] MaxSubsetSum(int[] k)
    {
        long[] sum = new long[k.length];
        int first_sum = 0, second_sum = 0;

        for (int i = 1; i <= k[0]; i++)
        {
            first_sum += i;
            sum[0] = first_sum;
        }

        for (int i = k[0] + 1; i <= k[1]; i++)
        {
            second_sum += i;
            sum[1] = second_sum;
        }


        System.out.println(first_sum);

        return sum;
    }
}