package spojProblems;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Stack;

/**
 * Class which has the solution for classical problems
 * @author Li Huang
 * @version 1.7.2017
 */
public class ClassicalOne {

    /**
     * Solution for classical -> Life, Universe, and Everything
     */
    public static void lifeUniverseAndEverything() throws NumberFormatException, IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(reader.readLine());

        while (input != 42)
        {
            System.out.println(input);
            input = Integer.parseInt(reader.readLine());
        }
    }

    /**
     * Solution for classical -> Prime Generator
     * @throws NumberFormatException
     * @throws IOException
     */
    public static void primeGenerator () throws NumberFormatException, IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numOfInput = Integer.parseInt(reader.readLine());

        int[][] array = new int[numOfInput][2];

        for (int x = 0; x < array.length; x++) 
        {
            String[] placeHolder = reader.readLine().split(" ");

            LOOP1: for (int i = Integer.parseInt(placeHolder[0]); i <= Integer.parseInt(placeHolder[1]); i++)
                if (i == 2)
                    System.out.println(i);
                else if (i % 2 == 0)
                    continue;
                else if(i > 2)
                {
                    for (int j = 3; j <= Math.sqrt(i); j += 2)
                        if (i % j == 0)
                            continue LOOP1;

                    System.out.println(i);
                }

            System.out.println();
        }
    }

    /**
     * Solution for classical -> Transform the Expression, ID 4
     * @throws NumberFormatException
     * @throws IOException
     */
    public static void transformTheExpression () throws NumberFormatException, IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numInput = Integer.parseInt(reader.readLine());
        Stack<String> stack = new Stack<String>();

        for (int i = 0; i < numInput; i++)
        {
            String[] expression = reader.readLine().split("");
            for (int j = 0; j < expression.length; j++)
            {
                if (expression[j].matches("[A-Za-z]{1}"))
                    System.out.print(expression[j]);
                else if (expression[j].equals("("))
                {
                    stack.push(expression[j]);
                }
                else if (expression[j].equals(")"))
                {
                    while (!stack.peek().equals("("))
                        System.out.print(stack.pop());
                    stack.pop();
                }
                else
                    while (!stack.isEmpty())
                        if (stack.peek().equals("(") || ProblemHelper.getPriority(stack.peek()) < ProblemHelper.getPriority(expression[j]))
                        {
                            stack.push(expression[j]);
                            break;
                        }
                        else
                            System.out.print(stack.pop());
            }
            while (!stack.isEmpty())
                System.out.print(stack.pop());

            System.out.println("");
        }
    }

    /**
     * Solution for classical -> Factorial, ID 11
     * @throws NumberFormatException
     * @throws IOException
     */
    public static void factorial () throws NumberFormatException, IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numOfInput = Integer.parseInt(reader.readLine());
        boolean condition = false;
        double power = 1; 
        int currentInput = 0;
        int currentOutput = 0;

        for (int i = 0; i < numOfInput; i++)
        {
            currentInput = Integer.parseInt(reader.readLine());
            while (!condition)
            {
                if (currentInput / Math.pow(5.0, power) >= 1)
                {
                    currentOutput += (int)(currentInput / Math.pow(5.0, power));
                    power++;
                }
                else
                    condition = true;
            }
            System.out.println(currentOutput);
            condition = false;
            power = 1;
            currentOutput = 0;
        }
    }

    /**
     * Solution for classical -> Small Factorials, ID 24
     * @throws NumberFormatException
     * @throws IOException
     */
    public static void smallFactorial () throws NumberFormatException, IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numInput = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numInput; i++)
        {
            int currentInput = Integer.parseInt(reader.readLine());
            BigInteger value = BigInteger.valueOf(1);
            for (int j = 1; j <= currentInput; j++)
                value = value.multiply(BigInteger.valueOf(j));

            System.out.println(value);
        }
    }

    /**
     * Solution for classical -> Adding Reversed Numbers, ID 42
     * @throws NumberFormatException
     * @throws IOException
     */
    public static void addingReversedNumbers () throws NumberFormatException, IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numInput = Integer.parseInt(reader.readLine());

        for (int i = 0; i < numInput; i++)
        {
            String[] placeHolder = reader.readLine().split(" ");
            System.out.println(ProblemHelper.reverseInt(ProblemHelper.reverseInt(Integer.parseInt(placeHolder[0]))
                    + ProblemHelper.reverseInt(Integer.parseInt(placeHolder[1]))));
        }
    }

    /**
     * Solution for classical -> Number Steps, ID 1112
     * @throws NumberFormatException
     * @throws IOException
     */
    public static void numberSteps () throws NumberFormatException, IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numInput = Integer.parseInt(reader.readLine());
        
        for (int i = 0; i <numInput; i++)
        {
            String[] placeHolder = reader.readLine().split(" ");
            int x = Integer.parseInt(placeHolder[0]);
            int y = Integer.parseInt(placeHolder[1]);
            if (x == y)
            {
                if (x == 0 || x == 1)
                    System.out.println(x);
                else if (x % 2 == 0)
                    System.out.println(x * 2);
                else
                    System.out.println(x * 2 - 1);
            }
            else if (x % 2 == 0 && ((x - 2) == y))
                System.out.println(x + y);
            else if (x % 2 == 1 && ((x - 2) == y))
                System.out.println(x + y - 1);
            else
                System.out.println("No Number");
        }
    }
    
    /**
     * Solution for classical -> Feynman, ID 3410
     * Use sum of first N squares
     * @throws NumberFormatException
     * @throws IOException
     */
    public static void feynman () throws NumberFormatException, IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));        
        
        int n = Integer.parseInt(reader.readLine());
        
        while (n != 0)
        {   
            System.out.println(ProblemHelper.sumFirstNSquares(n));
            n = Integer.parseInt(reader.readLine());
        }
    }
}
