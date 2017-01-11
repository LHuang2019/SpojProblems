package spojProblems;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class which has the solution for classical problems
 * @author Li Huang
 * @version 1.7.2017
 */
public class ClassicalOne {
	
	/**
	 * Solution for classical -> Life, Universe, and Everything
	 */
	public static void LifeUniverseAndEverything() throws NumberFormatException, IOException
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
	public static void PrimeGenerator () throws NumberFormatException, IOException
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
}
