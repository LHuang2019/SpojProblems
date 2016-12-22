package spojProblems;

import java.util.Scanner;

/**
 * Class which has the solution for basic problems
 * @author Li Huang
 * @version 12.21.2016
 */
public class BasicsProblems {
    
    /**
     * Method for Test 1, written for reference
     */
    public static void testOne()
    {
        Scanner sc = new Scanner(System.in);
        int firstInput = sc.nextInt();
        int secondInput = sc.nextInt();
        System.out.println(firstInput + secondInput);
    }
    
    public static void halfOfTheHalf()
    {
        Scanner sc = new Scanner(System.in);
        int numOfInput = sc.nextInt();
        String currentInput = "";
        String output = "";
        
        for (int i = 0; i < numOfInput; i++)
        {
            currentInput = sc.next();
            for (int j = 0; j < currentInput.length() / 2; j+=2)
                output += currentInput.charAt(j);
            System.out.println(output);
            output = "";
        }
    }

}