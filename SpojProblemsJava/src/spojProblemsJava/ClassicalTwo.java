package spojProblemsJava;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

import spojProblemsJava.FastIO.FastReader;

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

	/**
	 * Solved classical -> A Game with Numbers, ID 1419
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public static void aGameWithNumbers () throws NumberFormatException, IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int input = Integer.parseInt(reader.readLine());
		System.out.println(input % 10 == 0 ? 2 :1 +"\n" + (input % 10));
	}

	/**
	 * Solved classical -> Hangover, ID 902
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public static void hangOver () throws NumberFormatException, IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		for (double input = Double.parseDouble(reader.readLine()); input != 0.00; input = Double.parseDouble(reader.readLine()))
		{
			int n = 1;
			double sum = 0;

			while (sum < input)
				sum = sum + 1 / (double)++n;

			System.out.println(n - 1 + " card(s)");
		}
	}

	/**
	 * Solved classical -> Philosophers Stone, ID 3923
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public static void philosophersStone () throws NumberFormatException, IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int numInput = Integer.parseInt(reader.readLine());

		while(numInput-- > 0)
		{
			int[] rowcol = ProblemHelper.parseIntArray(reader.readLine().split(" "));
			int[][] array = new int[rowcol[0]][rowcol[1]];

			StringTokenizer input = new StringTokenizer(reader.readLine());

			for (int i = 0; i < array.length; i++)
				for (int j = 0; j < array[i].length; j++)
				{
					if (!input.hasMoreTokens())
						input = new StringTokenizer(reader.readLine());
					array[i][j] = Integer.parseInt(input.nextToken());
				}	

			if (rowcol[1] == 1)
			{
				int answer = 0;
				for (int i = 0; i < rowcol[0]; i++)
					answer += array[i][0];

				System.out.println(answer);
				continue;
			}

			if (rowcol[0] == 1)
				Arrays.sort(array[0]);
			else
			{
				for (int k = rowcol[0] - 2; k > -1; k--)
					for (int x = 0; x < rowcol[1]; x++)
						if (x == 0)
							array[k][x] += array[k + 1][x] > array[k + 1][x + 1] ? array[k + 1][x] : array[k + 1][x + 1];
							else if (x == rowcol[1] - 1)
								array[k][x] += array[k + 1][x] > array[k + 1][x - 1] ? array[k + 1][x] : array[k + 1][x - 1];
								else
									array[k][x] += Math.max(array[k + 1][x], Math.max(array[k + 1][x - 1], array[k + 1][x + 1]));

				Arrays.sort(array[0]);
			}

			System.out.println(array[0][rowcol[1] - 1]);
		}
	}

	/**
	 * Solved classical -> Count on Cantor, ID 302
	 * The formula for top part: 2n^2 - 3n + 2
	 * The formula for bottom part: 2n^2 - n + 1
	 * reference: http://www.biology.arizona.edu/biomath/tutorials/Quadratic/Roots.html
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public static void countOnCantor () throws NumberFormatException, IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int numInput = Integer.parseInt(reader.readLine());

		while (numInput-- > 0)
		{
			int term = Integer.parseInt(reader.readLine());

			//use quadratic formula to find the nearest positive root, which represents the nearest term
			int nearestTerm = (int) Math.round((Math.sqrt(9 - 8 * (2 - term)) + 3) / 4);
			int nearestNum = 2 * nearestTerm * nearestTerm - 3 * nearestTerm + 2;
			int top = (2 * nearestTerm - 1) - Math.abs(term - nearestNum);

			//use quadratic formula to find the nearest positive root, which represents the nearest term
			nearestTerm = (int) Math.round((Math.sqrt(1 - 8 * (1 - term)) + 1) / 4);
			nearestNum = 2 * nearestTerm * nearestTerm - nearestTerm + 1;
			int bot = 2 * nearestTerm - Math.abs(term - nearestNum);

			System.out.println("TERM " + term + " IS " + top + "/" + bot);
		}
	}

	/**
	 * Attempt classical solution -> Onotole needs your help, ID 7742 due to TIME LIMIT EXCEEDED
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public static void onotoleNeedsYourHelp () throws NumberFormatException, IOException
	{
		FastReader reader = new FastReader();
		int numInput = reader.nextInt();
		int current = 0;
		while (numInput-- > 0)
			current ^= reader.nextInt();
		
		System.out.println(current);
	}
	
	/**
	 * Solved classical -> Bishops, ID 328
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public static void bishops () throws NumberFormatException, IOException
	{
		Scanner reader = new Scanner(System.in);
		while (reader.hasNextBigInteger())
		{
			BigInteger current = new BigInteger(reader.nextLine());
			if (current.compareTo(BigInteger.ONE) == 0)
				System.out.println(1);
			else
				System.out.println(current.add(current).subtract(new BigInteger("2")));
		}
		
		reader.close();
	}
}