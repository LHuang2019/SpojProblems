package spojProblems;

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
}
