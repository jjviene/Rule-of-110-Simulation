public class Rule110Logic {


    public static char[][] getIntialState(String initalString, char[][] initalBoard) {

        //int rowLength = initalBoard.length;
        int colLength = initalBoard[0].length;
        int initalStringLength = initalString.length();
        int emptySideLengthInit = (colLength - initalStringLength) / 2;
        int emptySideLengthAfter = emptySideLengthInit + initalStringLength;

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

    
    public static char[][] makePyramid(char[][] initalBoard) {

        initalBoard = getIntialState(Rule110Print.getInitalString(), initalBoard);

        


        return initalBoard;

    }

    
    private static int nextValue(int[] prevValues) {




    }

}