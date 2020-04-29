import java.util.Scanner;

public class MoveInput {

    public static int[][] processMove(String[] moves){
        int[][] processedMoves = new int[2][2];
        System.out.println(moves[0] + "->" + moves[1]);

        //[1-8][A-H]

        //Subtracts The Ascii A offset 65
        processedMoves[0][0] = moves[0].charAt(0)-65;
        //Subtracts the Ascii 0 offset
        processedMoves[0][1] = moves[0].charAt(1)-49;


        processedMoves[1][0] = moves[1].charAt(0)-65;
        processedMoves[1][1] = moves[1].charAt(1)-49;

        // X,Y -> Y,X
        // Nums need to be flipped

        // X = 7-X

        processedMoves[0][1] = 7 - processedMoves[0][1];
        processedMoves[1][1] = 7 - processedMoves[1][1];

        int swaphold;

        swaphold = processedMoves[0][0];
        processedMoves[0][0] = processedMoves[0][1];
        processedMoves[0][1] = swaphold;

        swaphold = processedMoves[1][0];
        processedMoves[1][0] = processedMoves[1][1];
        processedMoves[1][1] = swaphold;


        return processedMoves;
    }

    public static String[] promptInput(){
        System.out.println("Enter your move: (A-H:1-8)");
        Scanner scnr = new Scanner(System.in);
        String move = scnr.nextLine();
        String[] movesplit = move.split(",");
        return movesplit;
    }

}
