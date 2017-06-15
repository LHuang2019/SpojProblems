package spojProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Class which has the solution for basic problems
 * 
 * @author Li Huang
 * @version 12.21.2016
 */
public class BasicsProblems {

    /**
     * Method for Test 1, written for reference
     */
    public static void testOne() {
        Scanner sc = new Scanner(System.in);
        int firstInput = sc.nextInt();
        int secondInput = sc.nextInt();
        System.out.println(firstInput + secondInput);
        sc.close();
    }

    /**
     * Method for Half of the half
     */
    public static void halfOfTheHalf() {
        Scanner sc = new Scanner(System.in);
        int numOfInput = sc.nextInt();
        String currentInput = "";
        String output = "";

        for (int i = 0; i < numOfInput; i++) {
            currentInput = sc.next();
            for (int j = 0; j < currentInput.length() / 2; j += 2)
                output += currentInput.charAt(j);
            System.out.println(output);
            output = "";
        }
        sc.close();
    }

    /**
     * Method for solving Character Patterns Act One
     * 
     * @throws NumberFormatException
     * @throws IOException
     */
    public static void characterPatternsActOne() throws NumberFormatException, IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numOfInput = Integer.parseInt(reader.readLine());

        int[][] array = new int[numOfInput][2];

        for (int x = 0; x < array.length; x++) {
            String[] placeHolder = reader.readLine().split(" ");
            array[x][0] = placeHolder[0] != null ? Integer.parseInt(placeHolder[0]) : 0;
            array[x][1] = placeHolder[1] != null ? Integer.parseInt(placeHolder[1]) : 0;
        }

        char character = '*';

        for (int k = 0; k < array.length; k++) {
            for (int i = 0; i < array[k][0]; i++) {
                character = i % 2 == 1 ? '.' : '*';
                for (int j = 0; j < array[k][1]; j++) {
                    System.out.print(character);
                    character = character == '*' ? '.' : '*';
                }
                System.out.println();
            }
            System.out.println();
            character = '*';
        }
    }
    
    /**
     * Method for solving Character Patterns Act Two
     * @throws NumberFormatException
     * @throws IOException
     */
    public static void characterPatternsActTwo() throws NumberFormatException, IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numOfInput = Integer.parseInt(reader.readLine());

        int[][] array = new int[numOfInput][2];

        for (int x = 0; x < array.length; x++) {
            String[] placeHolder = reader.readLine().split(" ");
            array[x][0] = placeHolder[0] != null ? Integer.parseInt(placeHolder[0]) : 0;
            array[x][1] = placeHolder[1] != null ? Integer.parseInt(placeHolder[1]) : 0;
        }

        char character = '*';

        for (int k = 0; k < array.length; k++) {
            for (int i = 0; i < array[k][0]; i++) {
                for (int j = 0; j < array[k][1]; j++) {
                    character = (i != 0 && i != array[k][0] - 1 && j != 0 && j != array[k][1] - 1) ? '.' : '*';
                    System.out.print(character);
                }
                System.out.println();
            }
            System.out.println();
        }
    }
    
    /**
     * Method for solving Character Patterns Act 3
     * @throws NumberFormatException
     * @throws IOException
     */
    public static void characterPatternsActThree() throws NumberFormatException, IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numOfInput = Integer.parseInt(reader.readLine());

        int[][] array = new int[numOfInput][2];

        for (int x = 0; x < array.length; x++) {
            String[] placeHolder = reader.readLine().split(" ");
            array[x][0] = placeHolder[0] != null ? Integer.parseInt(placeHolder[0]) * 3 + 1 : 0;
            array[x][1] = placeHolder[1] != null ? Integer.parseInt(placeHolder[1]) : 0;
        }

        String character = "*";

        for (int k = 0; k < array.length; k++) {
            for (int i = 0; i < array[k][0]; i++) {
                for (int j = 0; j < array[k][1]; j++) {
                    character = (i % 3 == 0) ? "***" : "*..";
                    System.out.print(character);
                }
                System.out.print("*");
                System.out.println();
            }
            System.out.println();
        }
    }
}