package spojProblems;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
	 * Unfinished
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public static void transformTheExpression () throws NumberFormatException, IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int numOfInput = Integer.parseInt(reader.readLine());
		
		Stack<Character> stringStack = new Stack<Character>();
		boolean condition = false;
		
		for (int x = 0; x < numOfInput; x++)
		{
			String expression = reader.readLine();
			for (int i = 0; i < expression.length(); i++)
			{
				char currentChar = expression.charAt(i);
				if (Character.isLetter(currentChar))
					System.out.print(currentChar);
				else if (currentChar == ')' && !stringStack.isEmpty())
				{	
					condition = false;
					System.out.print(stringStack.pop());
				}
				else if (currentChar == '(')
					condition = true;
				else if (currentChar == '^')
					stringStack.push(currentChar);
				else if (currentChar == '/' || currentChar == '*')
				{
					if (condition && stringStack.peek() == '^')
						System.out.print(stringStack.pop());
					stringStack.push(currentChar);
				}
				else
				{
					if (condition && !(stringStack.peek() == '-' || stringStack.peek() == '+'))
						System.out.print(stringStack.pop());
					stringStack.push(currentChar);
				}	
			}
		}
	}
	
	/**
	 * Unfinished
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public static void theNextPalindromeNew () throws NumberFormatException, IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int numOfInput = Integer.parseInt(reader.readLine());
		
		for (int i = 0; i < numOfInput; i++)
		{
			int firstInt = 0;
			int secInt = 0;
			
			String currentNumString = reader.readLine();
			int[] currentNumArray = new int[currentNumString.length()];
			for (int x = 0; x < currentNumArray.length; x++)
				currentNumArray[x] = currentNumString.charAt(i) - '0';
			
			for (int j = 0; j < currentNumArray.length / 2; j++)
			{
				firstInt = firstInt * 10 + currentNumArray[j];
				secInt = secInt * 10 + currentNumArray[j + currentNumArray.length / 2];
			}
			if (firstInt > secInt)	
				for (int k = 0; k < currentNumArray.length / 2; k++)
					currentNumArray[currentNumArray.length - k - 1] = currentNumArray[k];
			else if (firstInt < secInt)
			{
				if (currentNumArray.length % 2 == 1)
				{
					firstInt = firstInt * 10 + currentNumArray[currentNumArray.length / 2 + 1];
					currentNumArray[currentNumArray.length / 2 + 1] = (currentNumArray[currentNumArray.length / 2 + 1] + 1) % 10;
				}
				firstInt += 1;
				for (int y = 0; y < currentNumArray.length / 2; y++)
				{
					currentNumArray[currentNumArray.length / 2 - y] = firstInt % 10;
					firstInt /= 10;
				}
				for (int z = 0; z < currentNumArray.length / 2; z++)
					currentNumArray[currentNumArray.length - z - 1] = currentNumArray[z];
			}
			
			for (int a = 0; a < currentNumArray.length; a++)
				System.out.print(currentNumArray[a]);
			System.out.println();
		}
	}
	
	/***
	 * Unfinished
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public static void theNextPalindrome () throws NumberFormatException, IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int numOfInput = Integer.parseInt(reader.readLine());
		boolean condition = false;
		
		for (int i = 0; i < numOfInput; i++)
		{
			condition = false;
			double currentDouble = Double.parseDouble(reader.readLine());
			if (currentDouble > Integer.MAX_VALUE)
				break;
			int currentNum = (int) currentDouble;
			
			while (!condition)
			{
				currentNum++;
				condition = ProblemHelper.palindromeIntChecker(currentNum);
			}
			
			System.out.println(currentNum);
		}
	}

}
