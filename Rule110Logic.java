public class Rule110Logic {

    private static int rowLen;
    private static int colLen;
    private static int stringLenStart;
    private static int stringLenFinish;

    /****
     * This gets the intial start of the board and sets the inital start of the board so that the user will make it work
     * 
     * @param initalString
     * @param initalBoard
     * @return
     */
    public static char[][] getIntialState(String initalString, char[][] initalBoard) {

        int rowLength = initalBoard.length;
        int colLength = initalBoard[0].length;
        int initalStringLength = initalString.length();
        int emptySideLengthInit = (colLength - initalStringLength) / 2;
        int emptySideLengthAfter = emptySideLengthInit + initalStringLength;

        rowLen = rowLength;
        colLen = colLength;
        stringLenStart = emptySideLengthInit;
        stringLenFinish = initalStringLength + emptySideLengthInit;


        /*
        System.out.println("Total Row Length: " + rowLength);
        System.out.println("Total Col Length: " + colLength);
        System.out.println("Inital String Length: " + initalStringLength);
        System.out.println("Empty Side Length 1: " + emptySideLengthInit);
        System.out.println("Empty Side Length 2: " + emptySideLengthAfter);
        */

        for(int i = 0; i < emptySideLengthInit; i++) {

            initalBoard[0][i] = ' ';

        }

        int index = 0;
        for(int i = emptySideLengthInit; i < emptySideLengthAfter; i++) {

            initalBoard[0][i] = initalString.charAt(index);
            index++;
        }

        for(int i = emptySideLengthAfter; i < colLength; i++) {

            initalBoard[0][i] = ' ';

        }


        return initalBoard;
    }


    /***
     * This makes the pyramid by first starting off with the inital state for the pyramid and then going line-by-line to get to the rest of it
     * 
     * @param initalBoard
     * @return
     */
    public static char[][] makePyramid(char[][] initalBoard) {

        initalBoard = getIntialState(Rule110Print.getInitalString(), initalBoard);

        for (int i = 1; i < rowLen; i++) {
            initalBoard[i] = getCharRow(initalBoard[i - 1]);
        }

        return initalBoard;

    }

    /********
     * This makes each of the char rows so that it will go line-by-line to create the pyramid
     * 
     * 
     * @param prevRow
     * @return
     */
    private static char[] getCharRow(char[] prevRow) {

        stringLenStart -= 1;
        stringLenFinish += 1;

        /*
        System.out.println("Len Start " + stringLenStart);
        System.out.println("Len Finish " + stringLenFinish);
        */

        char[] newRow = new char[prevRow.length];

       for(int i = 0; i < stringLenStart; i++) {

            newRow[i] = ' ';

       }

       for(int i = stringLenStart; i < stringLenFinish; i++) {

            newRow[i] = getCharValue(prevRow, i);

       }

       for(int i = stringLenFinish; i < colLen; i++) {

             newRow[i] = ' ';

       }

        return newRow;

    }

    /*****
     * 
     * This function does the logic to find the previous value for each of the char values, and then going to the next needed Char Value to create 
     * the pyramid
     * 
     * @param prevRow
     * @param currentIndex
     * @return
     */
    private static char getCharValue(char[] prevRow, int currentIndex) {

        char value;

        char leftVal;
        char midVal;
        char rightVal;

        //Gets the Left Value
        if(currentIndex - 1 < 0) {
            leftVal = '0';
        } else {
            if(prevRow[currentIndex-1] == ' ' || prevRow[currentIndex-1] == '0') {
                leftVal = '0';
            } else {
                leftVal = '1';
            }
        }

        //Gets Middle Value
        if(prevRow[currentIndex] == ' ' || prevRow[currentIndex] == '0') {
            midVal = '0';
        } else {
            midVal = '1';
        }


        //Gets Right Value
        if(currentIndex + 1 > colLen - 1) {
            rightVal = '0';
        } else {
            if(prevRow[currentIndex + 1] == ' ' || prevRow[currentIndex + 1] == '0') {
                rightVal = '0';
            } else {
                rightVal = '1';
            }
        }

        //Logic for the 8 Cases to figure out which is the value for the next cell
        if(leftVal == '1' && midVal == '1' && rightVal == '1') {
            value = '0';
        } else if (leftVal == '1' && midVal == '0' && rightVal == '0') {
            value = '0';
        } else if (leftVal == '0' && midVal == '0' && rightVal == '0') {
            value = '0';
        } else {
            value = '1';
        }

        //Returns such value
        return value;
    }

}