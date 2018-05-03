import java.util.*;

class TwoCircles
{
    public static void main(String[] args)
    {
        System.out.println("Program Starting...\n");

        Scanner scanner = new Scanner(System.in);
        int numb_tests = scanner.nextInt();

        int[] two_circle = new int[6];

        for (int i = 0; i < numb_tests; i++)
        {
            System.out.println("Enter X-index, Y-index and radius for test "+(i+1));
        
            for (int j = 0; j < 6; j++)
            {
                two_circle[j] = scanner.nextInt();
            }
            // testLists.add(two_circle);
            System.out.println(circles(two_circle));
        }          
        scanner.close();
    }

    static String circles(int[] info)
    {
        String cir_actions = "";

        int first_cir = 0;
        int second_cir = 0;
        int radius_diff = Math.abs(info[2] - info[5]);

        for(int i = 0; i < info.length; i++)
        {
            if(i < 3)
            {
                first_cir += info[i];
            }
            else
                second_cir += info[i];
        }

        if(Math.abs(info[0] - info[3]) == radius_diff || 
            Math.abs(info[1] - info[4]) == radius_diff)
        {
            cir_actions = "Touching";
        }
        else if( Math.abs(first_cir - second_cir) < info[2] && (info[0] != info[3] || info[1] != info[4]))
        {
            cir_actions = "Intersecting";
        }
        else if(info[0] == info[3] && info[1] == info[4])
        {
            cir_actions = "Concentric";
        }
        else if(Math.abs(first_cir - second_cir) > info[2])
        {
            cir_actions = "Disjoint-outside";
        }else if(first_cir < info[5] || second_cir < info[2])
        {
            cir_actions = "Disjoint-inside";
        }

        return cir_actions;
    }
}