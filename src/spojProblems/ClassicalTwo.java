package spojProblems;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Class which has the solution for the 25 solved classical problems after Classicalone
 * @author Li Huang
 * @version 6.4.2017
 */
public class ClassicalTwo {

	/**
	 * Attempt classical solution -> Complete The Series (Easy), ID 11063 due to TIME LIMIT EXCEEDED
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public static void completeTheSeriesEasy () throws NumberFormatException, IOException
	{	
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int numInput = Integer.parseInt(reader.readLine());

		while (numInput-- > 0)
		{
			StringTokenizer input = new StringTokenizer(reader.readLine());

			long f = Long.parseLong(input.nextToken());
			long l = Long.parseLong(input.nextToken());
			long sum = Long.parseLong(input.nextToken());

			long n = 2 * sum / (f + l);
			long d = (l - f) / (n - 5);
			long i = f - 3 * d;

			System.out.println(n);

			while (n-- > 0)
				System.out.print((i += d) + " ");

			System.out.println();
		}
	}

	/**
	 * Solved classical -> Street Parade, ID 95
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public static void streetParade () throws NumberFormatException, IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		outerloop:
			while(!reader.readLine().equals("0"))
			{
				StringTokenizer input = new StringTokenizer(reader.readLine());
				Stack<Integer> road = new Stack<Integer>();
				Stack<Integer> side = new Stack<Integer>();

				while(input.hasMoreTokens())
					road.add(0, Integer.parseInt(input.nextToken()));

				int order = 1;
				int max = road.size();

				while (order <= max)
				{
					if (road.isEmpty() && side.peek() != order)
					{
						System.out.println("no");
						continue outerloop;
					}
					else if (!road.isEmpty() && road.peek() == order)
					{
						road.pop();
						order++;
					}
					else if (!side.isEmpty() && side.peek() == order)
					{
						side.pop();
						order++;
					}
					else if (!road.isEmpty())
						side.push(road.pop());
				}

				System.out.println("yes");
			}
	}

	/**
	 * Solved classical -> Build a Fence, ID 4408
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public static void buildAFence () throws NumberFormatException, IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		for (double input = Double.parseDouble(reader.readLine()); input != 0;)
		{
			System.out.printf("%.2f\n", Math.pow(input, 2) / 2 / Math.PI);
			input = Double.parseDouble(reader.readLine());
		}
	}

	/**
	 * Solved classical -> Girls and Boys, ID 7424
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public static void girlsAndBoys () throws NumberFormatException, IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		for (int[] array = ProblemHelper.parseIntArray(reader.readLine().split(" ")); array[0] != -1 && array[1] != -1;)
		{
			if (array[0] == 0 && array[1] == 0)
				System.out.println(0);
			else if (array[0] == array[1])
				System.out.println(1);
			else
			{
				int answer =  (array[0] > array[1] ? array[0] : array[1]) 
						/ ((array[0] > array[1] ? array[1] : array[0]) + 1);
				int remainder = (array[0] > array[1] ? array[0] : array[1]) 
						% ((array[0] > array[1] ? array[1] : array[0]) + 1);

				System.out.println(answer + (remainder == 0 ? 0 : 1));
			}

			array = ProblemHelper.parseIntArray(reader.readLine().split(" "));
		}
	}

	/**
	 * Solved classical -> Cards, ID 10509
	 * reference: http://www.s-cool.co.uk/gcse/maths/sequences/revise-it/the-nth-term
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public static void cards () throws NumberFormatException, IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int numberInput = Integer.parseInt(reader.readLine());

		while (numberInput-- > 0)
		{
			long input = Long.parseLong(reader.readLine());
			System.out.println(((3 * input * input + input ) / 2) % 1000007);
		}
	}
	
	/**
	 * Solved classical -> Beehive Numbers, ID 7406
	 * reference: http://www.s-cool.co.uk/gcse/maths/sequences/revise-it/the-nth-term
	 * Formula for the sequence: nth number = 3n^2 - 3n + 1
	 * The method finds the root of the above formula given nth number, and see if root is whole number or not
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public static void beehiveNumbers () throws NumberFormatException, IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		for (double current = Integer.parseInt(reader.readLine()); current != -1; current = Integer.parseInt(reader.readLine()))
			System.out.println((Math.sqrt(9 - 12 * (1 - current)) + 3) / 6 % 1 == 0 ? "Y" : "N");
	}
}
