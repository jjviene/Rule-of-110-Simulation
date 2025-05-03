import java.util.Scanner;

public class Rule110Print {

    private static final Scanner scanner = new Scanner(System.in);

    private static String initalString;
    private static int arrayLength;
    private static char totalArray[][];

    /***
     * This runs the program and starts with the entire output to the terminal!
     * 
     * @param args
     */
    public static void main(String[] args) {

        System.out.println("Hi, welcome to the Rule of 101 simulation");
        System.out.println("The rule of 101 is a Turing Complete Automatum which decides if the value is a 0 or 1 based on the previous function");

        System.out.println("\n\nFirst, to run this program, lets start off with your intial string... what would you like to be your intial string");
        initalString = scanner.nextLine();

        System.out.println("Next to do is to see how many generations you would like to run... How many generations would you like to run?");
        arrayLength = Integer.parseInt(scanner.nextLine());

        System.out.println("\n\nHere is your final Rule 101 Pyramid!");
        totalArray = new char[arrayLength][initalString.length() + ((arrayLength*2))];

        totalArray = Rule110Logic.makePyramid(totalArray);

        printCharPyramid(totalArray);

        closeScanner();

    }


    /********
     * This is a double for-each loop that prints out the Char Pyramid!
     */
    public static void printCharPyramid(char[][] Pyramid) {

        for (char[] row : Pyramid) {
            for (char k : row) {
                System.out.print(k);
            }
            
            System.out.println();
        }
        
    }

    /*******
     * Getter for Inital values
     * 
     * @return
     */
    public static String getInitalString() {
        return initalString;
    }


    /**************
     * Getter for the total board
     * 
     * 
     * @return
     */
    public static char[][] getBoard() {
        return totalArray;
    }
    
    /*************
     * Closes Scanner for me
     */
    private static void closeScanner() {
        scanner.close();
    }

}
