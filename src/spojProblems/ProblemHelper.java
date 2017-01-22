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
}
