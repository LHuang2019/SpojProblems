package spojProblemsJava;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Class which contains helper methods to help solve problems
 * @author Li Huang
 * @version 1.21.2017
 */
public class ProblemHelper {

	/**
	 * helper method which checks to see if a number is palindrome
	 * @param input the number that needs to be check
	 * @return true if the number is palindrome
	 */
	public static boolean palindromeIntChecker (int input)
	{
		int num = input;
		int placeHolder = 0;
		int rev = 0;

		while (num > 0)
		{
			placeHolder = num % 10;
			rev = rev * 10 + placeHolder;
			num = num / 10;
		}    
		return rev == input;
	}

	/**
	 * helper method which returns the reverse of the input number
	 * Discard all trailing zeros of the original input number
	 * @param input
	 * @return reverse number
	 */
	public static int reverseInt (int input)
	{
		int rev = 0;
		while (input > 0)
		{
			int currentDigit = input % 10;
			rev = rev * 10 + currentDigit;
			input /= 10;
		}

		return rev;
	}

	/**
	 * helper method which returns the priority of the function
	 * @param input
	 * @return priority of the input
	 */
	public static int getPriority (String input)
	{
		if (input.equals("^"))
			return 2;
		else if (input.equals("*") || input.equals("/"))
			return 1;
		else
			return 0;
	}

	/**
	 * helper method which returns sum of the first n squares
	 * @param n
	 * @return
	 */
	public static int sumFirstNSquares (int n)
	{
		return  (n * (n + 1) * (2 * n + 1)) / 6;
	}

	public static BigInteger bytelandianGoldCoinsHelper (int n, Map<Integer, BigInteger> map)
	{
		if (n < 12)
			return BigInteger.valueOf(n);

		if (map.containsKey(n))
			return map.get(n);
		else
		{
			map.put(n, 
					bytelandianGoldCoinsHelper(n / 4, map).
					add(bytelandianGoldCoinsHelper(n / 3, map)).
					add(bytelandianGoldCoinsHelper(n / 2, map))); 
			return map.get(n);
		}
	}
	
	/**
	 * helper method which convert a string array to int array
	 * @param array string array
	 * @return int array
	 */
	public static int[] parseIntArray (String[] array)
	{
		return Stream.of(array).mapToInt(Integer::parseInt).toArray();
	}
	
	/**
	 * helper method which given a string, return a HashMap that stores the occurrence of each character of the string.
	 * @param s string
	 * @return HashMap
	 */
	public static HashMap<Character, Integer> stringCharOccurance(String s)
	{
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		
		for (int i = 0; i < s.length(); i++)
			if (map.containsKey(s.charAt(i)))
				map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
			else
				map.put(s.charAt(i), 1);
				
		return map;
	}
	
	/**
	 * helper method that returns the sum of all squared digits inside the input integer
	 * example:
	 * 	input: abc
	 * 	output: a^2 + b^2 + c^2
	 * @param input the input number
	 * @return output the sum squared digits.
	 */
	public static int digitSquareSum (int input)
	{
		int output = 0;
		while (input != 0)
		{
			output += Math.pow(input % 10, 2);
			input /= 10;
		}
		
		return output;
	}
	
    /**
     * helper method which returns the gcd of x and y
     * @param x the x value
     * @param y the y value
     * @return gcd the gcd of x and y
     */
    public static int greatestCommonDivider(int x, int y)
    {
        int i;
        while (y != 0)
        {
            i = y;
            y = x % y;
            x = i;
        }
        return x;
    }
}
