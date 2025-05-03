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

        boolean done = false;

        while(!done) {
                
            System.out.println(
                "\nWelcome to the Rule 110 Cellular Automaton Simulation!\n" +
                "Created by Jayden Viene"
            );
            
            System.out.println(
                "Rule 110 is a one-dimensional cellular automaton known for its simple rules\n" +
                "yet surprisingly complex behavior. Despite having just a few logical cases,\n" +
                "it is Turing complete—capable of performing any computation given the right setup.\n" +
                "Each cell updates to 0 or 1 based on its own value and the values of its two neighbors."
            );
            
            System.out.println(
                "\n\nLet's begin by setting up your Rule 110 simulation.\n" +
                "Please enter the initial binary string (e.g., 1, 101, 1101) to start with:"
            );

            initalString = scanner.nextLine();

            System.out.println(
                "\nNext, let's decide how many generations you want the simulation to run.\n" +
                "How many generations would you like to run?"
            );
            
            System.out.println(
                "Tip: For best results, keep the number below ~80 to avoid formatting issues\n" +
                "in smaller terminal windows."
            );

            arrayLength = Integer.parseInt(scanner.nextLine());

            System.out.println("\n\nHere is your final Rule 101 Pyramid!");
            totalArray = new char[arrayLength + 1][initalString.length() + ((arrayLength*2))];

            totalArray = Rule110Logic.makePyramid(totalArray);

            printCharPyramid(totalArray);

            System.out.println("\n\n\n\n Here is your Pyramid! Would you like to run this program again or quit...");
            System.out.println("Type in q to quit, anything else to continue!");

            String s = scanner.nextLine();

            if(s.equals("q")) {
                done = true;

                closeScanner();
            }
        }

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
     * Getter for # of Rows
     * 
     * @return
     */
    public static int getRows() {
        return arrayLength;
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
