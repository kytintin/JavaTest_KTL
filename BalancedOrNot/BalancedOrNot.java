import java.util.Arrays;
import java.util.Scanner;

class BalancedOrNot
{
    public static void main(String[] args)
    {
        System.out.println("Program Starts");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements in expression");
        int num = scanner.nextInt();

        String[] expressions = new String[num];
        String express = "";
        int [] maxReplacements = new int[num];

        for(int k =0; k < num; k++)
        {
            System.out.println("Type Elements for expression");
            express = scanner.next();
            expressions[k] = express;
        }

        for(int j =0; j < maxReplacements.length; j++)
        {
            System.out.println("Type Elements for Replacements ["+(j+1)+"]");
            maxReplacements[j] = scanner.nextInt();
        }

        int[] balance = new int[num];

        balance = balancedOrNot(expressions, maxReplacements);
        System.out.println(Arrays.toString(balance));
        //System.out.println(wordCount("<>>>"));

        scanner.close();
    } 

    static int[] balancedOrNot(String[] expressions,int[] maxReplacements)
    {
        int[] results = new int[maxReplacements.length];
        System.out.println(Arrays.toString(expressions)+" "+Arrays.toString(maxReplacements));
        int to_replace = 0;
        
        for(int i = 0; i < maxReplacements.length; i++)
        {
            to_replace = wordCount(expressions[i]);
            if(to_replace == maxReplacements[i])
                results[i] = 1;
            else
                results[i] = 0;    
        }

        return results;
    }

    static int wordCount(String s)
    {   
        char[] words = s.toCharArray();
        int numb_greater =0, numb_less = 0;
        int to_be_replace =0;

        if(words[0] == '<' && words[(words.length-1)] == '>')
        {
            for (int i = 0; i < words.length; i++)
            {
                if(words[i] == '<')
                    numb_less++;
                if(words[i] == '>')
                    numb_greater++;    
            }

            to_be_replace = numb_greater - numb_less;

            return to_be_replace;
        }
        
        return -1;
    }
}