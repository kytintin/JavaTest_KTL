import java.util.*;

class TwoCircles
{
    public static void main(String[] args)
    {
        System.out.println("Number of test cases");
        
        ArrayList<int[]> tests = new ArrayList<int[]>();

        Scanner scanner = new Scanner(System.in);
        int numb_tests = scanner.nextInt();
         int[][] testscase = new int[numb_tests][6];
        int[] two_circle = new int[6];

        for (int i = 0; i < numb_tests; i++)
        {
            System.out.println("Enter X-index, Y-index and radius for test "+(i+1));
        
            for (int j = 0; j < 6; j++)
            {
                two_circle[j] = scanner.nextInt();
                testscase[i][j] = two_circle[j];
            }
        }     

        //System.out.println(Arrays.toString(testscase[0]));

        System.out.println(Arrays.toString(circles(testscase)));

        scanner.close();
    }

    static String[] circles(int[][] info)
    {
        String cir_actions = "";
        String[] result = new String[info.length];

        int first_cir = 0;
        int second_cir = 0;
        int radius_diff = 0;
        
        for(int j = 0; j < info.length; j ++)
        {
            //System.out.println(result.length);

            radius_diff = Math.abs(info[j][2] - info[j][5]);
            
            //System.out.println("Radius Difference " + radius_diff);

            for(int i = 0; i < info.length; i++)
            {
                if(i < 3)
                {
                    first_cir += info[j][i];
                }
                else
                    second_cir += info[j][i];

                if(Math.abs(info[j][0] - info[j][3]) == radius_diff || 
                Math.abs(info[j][1] - info[j][4]) == radius_diff)
                {
                    cir_actions = "Touching";
                }

                else if( Math.abs(first_cir - second_cir) < info[j][2] && 
                        (info[j][0] != info[j][3] || info[j][1] != info[j][4]))
                {
                    cir_actions = "Intersecting";
                }

                else if(info[j][0] == info[j][3] && info[j][1] == info[j][4])
                {
                    cir_actions = "Concentric";
                }

                else if(Math.abs(first_cir - second_cir) > info[j][2])
                {
                    cir_actions = "Disjoint-outside";
                }

                else if(first_cir < info[j][5] || second_cir < info[j][2])
                {
                    cir_actions = "Disjoint-inside";
                }
            }

            result[j] = cir_actions;
        }

        return result;
    }
}