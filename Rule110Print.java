import java.util.Scanner;

/*******************
 * 
 * Jayden Viene
 * 
 * CSE 355 - EC Project
 * 
 * Rule110Print Class
 * 
 * This class is the front-end part of the program. This deals with the User-Interface through terminal and the scanner class.
 * It deals with having the user get asked questions, then uses the back-end to actually run the simulation
 */
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
            
            //Inital Intro
            System.out.println(
                "\nWelcome to the Rule 110 Cellular Automaton Simulation!\n" +
                "Created by Jayden Viene"
            );
            
            //Quick Explanation of the rule of 110.
            System.out.println(
                "Rule 110 is a one-dimensional cellular automaton known for its simple rules\n" +
                "yet surprisingly complex behavior. Although it has only a few logical cases,\n" +
                "it is Turing complete and techinically capable of performing any operation given the correct set-up.\n" +
                "Each cell updates to 0 or 1 based on its own value and the values of its two neighbors above it.\n" +
                "Professor Ben Amor discussed this concept in principle and a little implementation within class, however \n" +
                "this program runs a simulation for it on a wider-scale to show the user it's completeness."
            );
            
            //Asks uses for inital input string
            System.out.println(
                "\n\nLet's begin by setting up your Rule 110 simulation.\n" +
                "Please enter the initial binary string (e.g., 1, 101, 1101) to start with:"
            );

            boolean goodString = false;

            //This makes sure that the string only contains 1's and 0's!
            while(goodString == false) {

                initalString = scanner.nextLine();

                if (initalString.matches("[01]+")) {
                    goodString = true;
                } else {
                    System.out.println("Invalid input! Please enter a string containing only 0s and 1s.");
                }
            }

            //Asks for Number of Iterations
            System.out.println(
                "Next, let's decide how many generations you want the simulation to run.\n" +
                "How many generations would you like to run?"
            );

            System.out.println(
                "Tip: For best results, keep the number below ~60 to avoid formatting issues\n" +
                "in smaller terminal windows."
            );

            arrayLength = Integer.parseInt(scanner.nextLine());

<<<<<<< HEAD
=======
            System.out.println("\n\nHere is your final Rule 110 Pyramid!");
>>>>>>> master
            totalArray = new char[arrayLength + 1][initalString.length() + ((arrayLength*2))];

            //Creates the Char Pyramid
            totalArray = Rule110Logic.makePyramid(totalArray);
            
            System.out.println("");
            
            /*
            for(int i = 0; i < 115; i++) {

<<<<<<< HEAD
                System.out.print("#");

            }

            System.out.println("\nHere comes the Pyramid!\n\n");
            */
            
=======
            //Prints out the Char Pyramid
>>>>>>> master
            printCharPyramid(totalArray);
            
            System.out.println(
                "\n\nHere is your Rule 110 pyramid!\n" +
                "Would you like to run the simulation again or exit?"
            );

<<<<<<< HEAD
            System.out.println("Type 'q' to quit, or press Enter to run again:");
            
=======
            //Shows the Pyramid and asks the user to re-run the simulation or quit
            System.out.println("\n\n\n\n Here is your Pyramid! Would you like to run this program again or quit...");
            System.out.println("Type in q to quit, anything else to continue!");
>>>>>>> master

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
